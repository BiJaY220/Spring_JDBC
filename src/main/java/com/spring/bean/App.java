package com.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.JDBC.JdbcConfig;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/bean/Config.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		String query = "insert into student(id,name,city) values(?,?,?)";
		
		int result = template.update(query, 23, "jonney", "jamall");
		System.out.println("number of record inserted "+result);
		
	}

}
