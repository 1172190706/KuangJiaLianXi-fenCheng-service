<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 修改完成后跳转到添加页面，调用saveOrUpdate（）方法，添加或修改 -->
<form action="add">
<input type="hidden" name="eid" value="${emp.eid}">
姓名：<input type="text" name="ename" value="${emp.ename}">
性别：<input type="radio" name="sex" value="男" ${emp.sex=='男'?"checked":""}>男
<input type="radio" name="sex" value="女" ${emp.sex=='女'?"checked":""}>女
工资：<input type="text" name="sar" value="${emp.sar}">
部门：<select name="dept.did">
 <c:forEach items="${dl}" var="d">
    <option value="${d.did}" ${d.did==emp.dept.did?"selected":""}>${d.dname}</option>
  </c:forEach>
</select>
<input type="submit" value="修改">
</form>
</body>
</html>