package com.sarje;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.sarje.model.Course;
import com.sarje.model.Subject;

public class Main {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		ssrb.applySettings(cfg.getProperties());
		StandardServiceRegistry ssr = ssrb.build();
		SessionFactory sf = cfg.buildSessionFactory(ssr);
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Course c10 = new Course(10, "A");
		Course c20 = new Course(20, "B");
		
		Subject s1 = new Subject(1, "c");
		Subject s2 = new Subject(2, "c++");
		Subject s3 = new Subject(3, "java");
		
		
		c10.getSubjects().add(s1);
		c10.getSubjects().add(s2);
		
		c20.getSubjects().add(s2);
		c20.getSubjects().add(s3);
		
		s1.getCourses().add(c10);
		
		s2.getCourses().add(c10);
		s2.getCourses().add(c20);
		
		s3.getCourses().add(c20);
		
		s.save(c10);
		s.save(c20);
		s.save(s1);
		s.save(s2);
		s.save(s3);
				
		t.commit();
		s.close();
		sf.close();
		System.out.println("done");
	}

}
