<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/css/bootstrap.css"/>

<script type="text/javascript" 
src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

<script type="text/javascript" 
src="${pageContext.request.contextPath}/js/bootstrap.js"></script>

    <style>
			body{font: "微软雅黑"; font-size: large;}
			
		</style>
</head>
<body>

<form action="list">
模糊查询：姓名：<input type="text" name="ename">
部门：<select name=dept.did>
<option value="">--请选择--</option>
<c:forEach items="${dept}" var="dept">
<option value="${dept.did}">${dept.dname}</option>
</c:forEach>
</select>
<input type="submit" value="查询">
</form>

<div id="addDiv" style="display: none;">
<form action="add">
姓名：<input type="text" name="ename">
性别：<input type="radio" name="sex" value="男">男
<input type="radio" name="sex" value="女">女
工资：<input type="text" name="sar">
部门：<select name=dept.did>
<c:forEach items="${dept}" var="dept">
<option value="${dept.did}">${dept.dname}</option>
</c:forEach>
</select>
<input type="submit" value="添加">
</form>
</div>

<button  class="btn btn-primary">添加</button>
<table class="table table-bordered" id=""tab>
<tr>
<td>编号</td>
<td>姓名</td>
<td>性别</td>
<td>工资</td>
<td>部门</td>
<td>操作</td>
</tr>
<c:forEach items="${emp}" var="emp">
<tr>
<td>${emp.eid}</td>
<td>${emp.ename}</td>
<td>${emp.sex}</td>
<td>${emp.sar}</td>
<td>${emp.dept.dname}</td>
<td><button  class="btn btn-danger" onclick="del(${emp.eid})">删除</button>
<button class="btn btn-warning" onclick="update(${emp.eid})">修改</button>
</td>
</tr>
</c:forEach>
</table>
<script type="text/javascript">

function del(eid){
	//alert(eid);
	location="del?eid="+eid;
};

function update(eid){
	location="update?eid="+eid;
}

$(function(){
	
	$("button:contains('添加')").on("click",function(){
		$("#addDiv").removeAttr("style");
	    
		
	});
	
	
});
</script>
</body>
</html>