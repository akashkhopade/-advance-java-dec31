package com.sarje;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.sarje.model.Clerk;
import com.sarje.model.Employee;
import com.sarje.model.Manager;

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
		Manager m = new Manager(103, "shiv", 9090.90f, 789.5f, 987.60f);
		Clerk c = new Clerk(104, "shiva", 9876.50f, 9087.55f);
		
		s.save(m);
		s.save(c);
				
		t.commit();
		s.close();
		sf.close();
		System.out.println("done");
	}

}
