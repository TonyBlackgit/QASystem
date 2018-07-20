<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%ArrayList<String> detail = (ArrayList) request.getAttribute("detail");%>
<%
			for (int i = 0; i < detail.size(); i++) {
		%>
		<p>
		<%=detail.get(i)%>
		</p>
		<%
			}
		%>

</body>
</html>