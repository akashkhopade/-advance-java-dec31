package com.sarje;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.sarje.model.Category;
import com.sarje.model.Product;

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
		Category c = new Category(3, "home appliances");
		Product p1 = new Product(50, "iron");
		Product p2 = new Product(60, "mixer");
		
		c.getProducts().add(p1);
		c.getProducts().add(p2);
		
		s.save(c);
		s.save(p1);
		s.save(p2);
				
		t.commit();
		s.close();
		sf.close();
		System.out.println("done");
	}

}
