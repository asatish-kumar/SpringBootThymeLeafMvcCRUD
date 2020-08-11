package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Student;
import com.app.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private IStudentService service;

	// 1. Show Register Page
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("student", new Student());
		return "StudentRegister";
	}

	// 2. Save Student
	@PostMapping("/save")
	public String save(@ModelAttribute("student") Student student, Model model) {
		Integer saveStudent = service.saveStudent(student);
		model.addAttribute("message", "Student Saved Successfully with id" + saveStudent);
		model.addAttribute("student", new Student());
		return "StudentRegister";
	}

	// 3. Display All Student
	@GetMapping("/all")
	public String showAll(Model model) {
		List<Student> list = service.getAllStudents();
		model.addAttribute("list", list);
		return "StudentData";
	}

	// 4. Delete One Student
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Integer id, Model model) {
		String message = null;
		if (service.isStudentExist(id)) {
			service.deleteStudent(id);
			message = "Student '" + id + "'Deleted";
		} else {
			message = "Student '" + id + "'Not Exist";
		}
		model.addAttribute("message", message);
		List<Student> list = service.getAllStudents();
		model.addAttribute("list", list);
		return "StudentData";
	}

	// 5. Show Edit Page
	@GetMapping("/edit")
	public String showEdit(@RequestParam("id") Integer id, Model model) {
		String page = null;
		Optional<Student> student = service.getStudent(id);
		if (student.isPresent()) {
			model.addAttribute("student", student.get());
			page = "StudentEdit";
		} else {
			page = "redirect:all";
		}
		return page;
	}

	// 6. Do update
	@PostMapping("/update")
	public String update(@ModelAttribute("student") Student student, Model model) {
		Integer stdId = student.getStdId();
		String message = null;
		if (stdId != null) {
			service.updateStudent(student);
			message = "Student updated Successfully";
		} else {
			message = "Student update UnSuccessfully";
		}
		model.addAttribute("message", message);
		List<Student> list = service.getAllStudents();
		model.addAttribute("list", list);
		return "StudentData";
	}
}
