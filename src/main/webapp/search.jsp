<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Page</title>
</head>
<body>
	<form action="Search" method="post">
		请输入： <input type="text" name="query" value=""><br>
		<input type="radio" name="catagory" value="bio_literature" checked="checked">bio
		<input type="radio" name="catagory" value="geo_literature">geo
		<input type="radio" name="catagory" value="reviews">reviews<br>
		<input type="submit" name="search" value="查询"><br><br>
	</form>
</body>
</html>