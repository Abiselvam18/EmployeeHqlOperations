package com.edu;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainApp {

	public static void main(String[] args) {
		Configuration conn=new Configuration().configure().addAnnotatedClass(EmployeeHql.class);	
        ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(conn.getProperties()).buildServiceRegistry();
        SessionFactory sf=conn.buildSessionFactory(reg);
        Session sess=sf.openSession();
        Transaction tx=sess.beginTransaction();
       
        EmployeeHql e1=new EmployeeHql(1,"Meera",10000.23f,"Chennai",100);
        sess.save(e1);
        EmployeeHql e2=new EmployeeHql(2,"Janu",67798.23f,"Pondy",101);
        sess.save(e2);
        EmployeeHql e3=new EmployeeHql(3,"vijay",23000.50f,"Banglore",102);
        sess.save(e3);
        EmployeeHql e4=new EmployeeHql(4,"Sham",76889.45f,"Chennai",103);
        sess.save(e4);
        EmployeeHql e5=new EmployeeHql(5,"Vinoth",80000.12f,"Mumbai",104);
        sess.save(e5);
        
        //get record based on id
        /*EmployeeHql r=(EmployeeHql) sess.get(EmployeeHql.class,1);
        //System.out.println(r);
        System.out.println("emp_id="+r.getEid()+"name="+r.getName()+"salary"+r.getSalary()+"address"+r.getAddress()+"deptno="+r.getDeptno());
        */
        
        //retrieve all records
      /*Query q=sess.createQuery("from EmployeeHql");
        List l=q.list();
        System.out.println(l);
        Iterator<EmployeeHql> it=l.iterator();
        while(it.hasNext()) {
        	EmployeeHql r=it.next();
        	System.out.println("emp_id="+r.getEid()+"name="+r.getName()+"salary"+r.getSalary()+"address"+r.getAddress()+"deptno="+r.getDeptno());
        }*/
        
        //update record
        /*Query q=sess.createQuery("update EmployeeHql set name=:n where eid=:i");
        q.setParameter("n", "Manju");
        q.setParameter("i", 1);
        
        int i=q.executeUpdate();
        if(i>0) {
        	System.out.println("Record is updated");
        }else {
        	System.out.println("Not inserted");
        }*/
        
       /* org.hibernate.Query q=sess.createQuery("delete EmployeeHql  where eid=:i");
		
		q.setParameter("i",5);
		
		int i=q.executeUpdate();
		if(i>0) {
			System.out.println("Record is delete");
		}
		else {
			 System.out.println("not delete");
		}*/
        
        //sum,max,min,avg
        /*Query s=sess.createQuery("select sum(salary) from EmployeeHql");
        List sl=s.list();
        System.out.println("Total sal="+sl.get(0));
        
        Query s1=sess.createQuery("select min(salary) from EmployeeHql");
        List sl1=s1.list();
        System.out.println("Total sal="+sl1.get(0));
        
        Query s2=sess.createQuery("select max(salary) from EmployeeHql");
        List sl2=s2.list();
        System.out.println("Total sal="+sl2.get(0));
        */
        
        // total number of employees
        Query s3=sess.createQuery("select count(eid) from EmployeeHql");
        List sl3=s3.list();
        System.out.println("Total sal="+sl3.get(0));
        
        tx.commit();
        sess.close();

	}

}
