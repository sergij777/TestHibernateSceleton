package org.itstep;

import java.util.Date;

import org.hibernate.Session;
import org.itstep.model.Account;
//import org.itstep.util.HiberPropertiesUtil;
import org.itstep.util.HibernateUtil;

/**
 * @author Alex Ignatenko
 */
public class App {
 public static void main(String[] args) {
  
  Account account = new Account("ignatenko22071", "1234561", "Alex1", "Ignatenko1", new Date(82, 7, 22).getTime());

  Account account2 = new Account("kjdshgfks1", "skgfbshj1", "skjdhbfkjsfv1", "jshgfhjsf1", 123456789L);
  HibernateUtil hUtil = new HibernateUtil();
  
  Session session = hUtil.getSessionFactory().openSession();

  session.getTransaction().begin();  //open session

  session.save(account);
  session.save(account2);
  session.save(new Account("sfsgsrg", "wfrasgsrg", "swrfgsr", "sedfeafswf", 125874L));  

  session.getTransaction().commit();
  session.close();
  
  
  Session session2 = hUtil.getSessionFactory().openSession();
  session2.getTransaction().begin();
  
 // session2.update(new Account("ignatenko22071", "1234561", "Alex1", "Ignatenko1", new Date(82, 7, 22).getTime());
  
  session2.delete(account2);
  session2.getTransaction().commit();
  session2.close();
  

  System.out.println("Transactions completed!");
 }
}
