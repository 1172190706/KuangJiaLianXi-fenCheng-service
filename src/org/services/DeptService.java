package org.services;

import java.util.List;

import javax.annotation.Resource;

import org.dao.DeptDao;
import org.pojo.Dept;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeptService {
	
	@Resource
	private DeptDao dd;

	public List<Dept> selecteAllDept(String sqlDept) {
		
		List<Dept> el = dd.selectAllDept(sqlDept);
		
		return el;
	}

}
