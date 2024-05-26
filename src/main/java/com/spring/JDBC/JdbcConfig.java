package com.spring.JDBC;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.Dao.StudentDao;
import com.spring.Dao.StudentDaoimpl;


@Configuration
//@ComponentScan(basePackages = {"com.spring.Dao"})
public class JdbcConfig {
	
	@Bean(name= {"ds"})
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("Bijay@123");
		return ds;
		
	}
	@Bean(name= {"jdbcTemplate"})
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	@Bean(name= {"studentDao"})
	public StudentDao getStudentDao() {
		StudentDaoimpl studentDao = new StudentDaoimpl();
		studentDao.setJdbcTemplate(getTemplate());
		return studentDao;
		}


}
