package org.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.pojo.Emp;
import org.springframework.stereotype.Repository;
@Repository
public class EmpDao {
	
	@Resource
	private SessionFactory sf;

	public List<Emp> selectAllEmp(String sqlEmp) {
		System.out.println("EmpDao:selectAllEmp");
		Session session = sf.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sqlEmp);
		sqlQuery.addEntity(Emp.class);
		List emp = sqlQuery.list();
		return emp;
	}

	public void add(Emp emp) {
		
		System.out.println("EmpDao:add");
		Session session = sf.openSession();//自己手动开启一个session,需要开事物,这种方法不推荐
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(emp);//还有一种方法是继承HibernateDaoSupport
		tx.commit();
	}

	public void del(Integer eid) {
		Session session = sf.getCurrentSession();//获取spring管理的session
		Emp emp = session.get(Emp.class, eid);
		session.delete(emp);
	}

	public Emp update(Integer eid) {
		System.out.println("EmpDao:update");
		Session session = sf.getCurrentSession();
		Emp emp = session.get(Emp.class, eid);
		return emp;
		
	}

}
