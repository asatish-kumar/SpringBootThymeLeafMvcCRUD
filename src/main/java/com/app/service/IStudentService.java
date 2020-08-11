package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.model.Student;

public interface IStudentService {
	public Integer saveStudent(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(Integer id);
	public Optional<Student> getStudent(Integer id);
	public List<Student> getAllStudents();
	public boolean isStudentExist(Integer id);

}
