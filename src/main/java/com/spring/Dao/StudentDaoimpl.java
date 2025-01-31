package com.spring.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.JDBC.Student;

//@Component("studentDao")
public class StudentDaoimpl implements StudentDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public int insert (Student student) {
		//insert query
		String query = "insert into student(id,name,city) values(?,?,?)";
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
		
	}
	public int change(Student student) {
		//  update query
		String query ="update student set name=? , city=? where id =?";
		int r= this.jdbcTemplate.update(query, student.getName(),student.getCity(),student.getId());
		return r;
	}

	
	public int delete(int studentId) {
		String query = "delete from student where id =?";
		int r = this.jdbcTemplate.update(query, studentId);
		
		return r;
	}
	public Student getStudent(int StudentId) {
		//to get the detail from data base 
		String query = "select * from student where id =?";
		RowMapper<Student> rowMapper  = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query,rowMapper,StudentId);
		
		return student;
	}
	public List<Student> getAllStudents() {
		String query = "select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		
		return students;
	}
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	//@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		
		// TODO Auto-generated method stub
		this.jdbcTemplate= jdbcTemplate;
	}


	






}
