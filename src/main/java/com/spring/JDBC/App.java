package com.spring.JDBC;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.Dao.StudentDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("start vayoooo   !!!");
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
        //insertion 
        
        Student student = new Student();
//        student.setId(31);
//        student.setName("sunita");
//        student.setCity("bhaktapur");
//        
//        int result = studentDao.insert(student);
//        System.out.println("student added "+result);
        
//        student.setId(26);
//        student.setName("namaraj");
//        student.setCity("kirtipur-10");
       // Student student  = studentDao.getStudent(23);
//        
//        System.out.println(student);
        //row mapper -> class banayera imp
        List<Student> students = studentDao.getAllStudents();
        for(Student s :students) {
        	System.out.println(s);
        }
        // impldao(interface)-> hibernateTemplate -> sessionFactory(interface) <- LocalSessionFactory
        //-> datasoure(url , username , password ), hibernate properties , annotation class 
        
    }
}
