package com.spring.Dao;


import java.util.List;

import com.spring.JDBC.Student;

public interface StudentDao {
	public int insert(Student student);
	public int change (Student student);
	public int delete(int i);
	public Student getStudent(int StudentId);
	public List<Student> getAllStudents();
	
	
	

}