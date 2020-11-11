package com.java.practm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.java.practices.domain.Student;
import com.java.practices.util.HibernateUtil;





public class Main1 {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Student");
		query.setFirstResult(1);
		query.setMaxResults(3);
		List<Student> student = (List<Student>)  query.list();

		session.getTransaction().commit();
		session.close();
		for(Student s : student) {
			System.out.println(s.getStudent_name());
		}
		
		
		
	}

}
