<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.dxc.hib.Employ"%>
<%@page import="com.dxc.hib.EmployCrud"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		EmployCrud dao = new EmployCrud();
		Employ[] employs = dao.showEmploy();
	%>
	<table border="3">
		<tr>
			<th>Empno</th>
			<th>Name</th>
			<th>Deartment</th>
			<th>Designation</th>
			<th>Basic</th>
		</tr>
	<%
		for(Employ e : employs) {
	%>
		<tr>
			<td> 
				<%=e.getEmpno() %>
			</td>
			<td>
				<%=e.getName() %>
			</td>
			<td>
				<%=e.getDept() %>
			</td>
			<td>
				<%=e.getDesig() %>
			</td>
			<td>
				<%=e.getBasic() %>
			</td>
		</tr>
	<%
		}
	%>
	</table>
</body>
</html>