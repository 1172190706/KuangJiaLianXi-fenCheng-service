package org.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pojo.Dept;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDao {

	@Resource
	private SessionFactory sf;

	public List<Dept> selectAllDept(String sqlDept) {
		System.out.println("DeptDao:selectAllDept");
		Session session = sf.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sqlDept);
		sqlQuery.addEntity(Dept.class);
		List<Dept> dept = sqlQuery.list();
		return dept;
	}
	
	
	
}
