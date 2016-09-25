<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BBSList</title>
</head>
<body>
	<h1>게시판 입니다.</h1>
		<hr/>
	<table style="width:100%; border-collapse: collapse; border: 1px solid #000000 ">
		<tr style="width: 300px; height: 30px; border: 1px solid #000000 ">
			<th>ID</th>
			<th>Title</th>
			<th>Hit Count</th>
			<th>Recommend Count</th>
			<th>Creator Name</th>
			<th>Create Date</th>
		</tr>
		<c:forEach items="${boardSystems}" var="list" >
		<tr style="width: 300px; height: 30px; border: 1px solid #000000; text-align:center">
			<td>${list.getId()}</td>
			<td><a href="/BBS/detail?Id=${list.getId()}">${list.getTitle()}</a></td>
			<td>${list.getHitCount()}</td>
			<td>${list.getRecommendConunt()}</td>
			<td>${list.getCreatorName()}</td>
			<td>${list.getCreateDate()}</td>
		</tr>	
		</c:forEach>
	</table>
	<a href="/BBS/write">글쓰기</a> <form name="saechForm" method="post" action="/BBS/search" >
	검색하기<input name="saerch" type="text" style="width:100px" /><input type="submit" value="검색" /></form>
</body>
</html>