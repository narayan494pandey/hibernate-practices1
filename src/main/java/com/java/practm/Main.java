package com.java.practm;

import org.hibernate.Session;

import com.java.practices.domain.Student;
import com.java.practices.util.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		/*Student student = new Student();
		student.setStudent_name("Ram");*/
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		session1.beginTransaction();
		
		Student student = (Student) session1.get(Student.class,2);
	     /*student.setStudent_name("sita before save");
		session.save(student);*/
		/*System.out.println("Name of student" +student.getStudent_name());
		student.setStudent_name("Bharat after fetch");
		System.out.println("Name of student" +student.getStudent_name());*/

		session1.getTransaction().commit();
		session1.close();
		student.setStudent_name("sita detached state");
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
	    session2.update(student);
		session2.getTransaction().commit();
		session2.close();
		
		
	}

}
