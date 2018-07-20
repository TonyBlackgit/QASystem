<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show page</title>
</head>
<body>
	<div>
		<%
			ArrayList<String> title = (ArrayList) request.getAttribute("titles");
			ArrayList<String> id = (ArrayList) request.getAttribute("ids");
			String catagory = (String)request.getAttribute("catagory");
		%>
		<%
			for (int i = 0; i < title.size(); i++) {
		%>
		<p>
		<a href="Details?id=<%= id.get(i) %>&catagory=<%=catagory %>"> <%=title.get(i)%> </a>
		</p>
		<%
			}
		%>
	</div>
</body>
</html>