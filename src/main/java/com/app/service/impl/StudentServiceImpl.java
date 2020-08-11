package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Student;
import com.app.repo.StudentRepository;
import com.app.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository repo;

	@Override
	public Integer saveStudent(Student student) {
		Student save = repo.save(student);
		return save.getStdId();
	}

	@Override
	public void updateStudent(Student student) {
		repo.save(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Student> getStudent(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	@Override
	public boolean isStudentExist(Integer id) {
		return repo.existsById(id);
	}

}
