package org.web;

import java.util.List;

import javax.annotation.Resource;

import org.pojo.Dept;
import org.pojo.Emp;
import org.services.DeptService;
import org.services.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")
public class FirstController {
	
	@Resource
	private DeptService ds;
	@Resource
	private EmpService es;
	/**
	 * 查询全部
	 * @param emp
	 * @param map
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Emp emp,ModelMap map){
		String sqlEmp = "select * from emp where 1=1 ";
		//按员工姓名查询
		if(emp!=null&&emp.getEname()!=null&&!"".equals(emp.getEname().trim())){
			sqlEmp+=" and ename like '%"+emp.getEname()+"%'";
		}
		// 按照部门查询员工
		if (emp != null && emp.getDept() != null && emp.getDept().getDid() != null) {
			sqlEmp += " and did = " + emp.getDept().getDid();
			}
		List<Emp> el= es.selectAllEmp(sqlEmp);
		String sqlDept="select * from dept";
	    List<Dept> dl=	ds.selecteAllDept(sqlDept);
		map.put("dept", dl);
		map.put("emp", el);
		return "list";
	}
	
	/**
	 * 添加
	 * @param emp
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Emp emp) {
		es.add(emp);
		return "redirect:list";
	}
	
	/**
	 * 删除
	 * @param eid
	 * @return
	 */
	@RequestMapping("/del")
	public String del(Integer eid) {
		es.del(eid);
		return "redirect:list";
	} 
	
	/**
	 * 修改时，先查出来，跳转到update.jsp
	 * @param eid
	 * @param map
	 * @return
	 */
	@RequestMapping("/update")
	public String update(Integer eid,ModelMap map) {
		Emp emp = es.update(eid);
		System.out.println("controller:"+emp);
		String sqlDept="select * from dept";
	    List<Dept> dl=	ds.selecteAllDept(sqlDept);
		map.put("emp", emp);
		map.put("dl", dl);
		return "update";
	}
}
