package org.services;

import java.util.List;

import javax.annotation.Resource;

import org.dao.EmpDao;
import org.pojo.Emp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmpService {

	@Resource
	private EmpDao ed;

	public List<Emp> selectAllEmp(String sqlEmp) {
		
		return ed.selectAllEmp(sqlEmp);
	}

	public void add(Emp emp) {
		
		ed.add(emp);
		
	}

	public void del(Integer eid) {
		ed.del(eid);
	}

	public Emp update(Integer eid) {
		Emp emp = ed.update(eid);
		return emp;
		
	}



	
}
