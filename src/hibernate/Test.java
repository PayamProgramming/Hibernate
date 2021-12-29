/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author intel one
 */

@ComponentScan
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        hibernate m = (hibernate) ctx.getBean("type");
        
        
        // hibernate m = new hibernate();
        m.setId(1);
        System.out.println("Type Youre Name");
        String name = input.next();
        m.setName(name);
        System.out.println("Type Youre Family");
        String family = input.next();
        m.setFamily(family);
        System.out.println("Type Youre Country");
        String Country = input.next();
        m.setCountry(Country);
        
        
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(m);
        tx.commit();
        session.close();
        
        ShowData shd = new ShowData();
        shd.show();
        System.out.println(m.toString());
        
        
    }
    
}
