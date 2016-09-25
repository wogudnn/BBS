<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search</title>
</head>
<body>
<h1>검색결과</h1>
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
		<c:forEach items="${boardSystemVO}" var="result" >
		<tr style="width: 300px; height: 30px; border: 1px solid #000000 ">
			<td>${result.getId()}</td>
			<td><a href="/BBS/detail?Id=${result.getId()}">${result.getTitle()}</a></td>
			<td>${result.getHitCount()}</td>
			<td>${result.getRecommendConunt()}</td>
			<td>${result.getCreatorName()}</td>
			<td>${result.getCreateDate()}</td>
		</tr>	
		</c:forEach>
	</table>
	<a href="/BBS/write">글쓰기</a> 검색하기<form name="saechForm" method="post" action="/BBS/search" >
	<input name="saerch" type="text" style="width:40px" /><input type="submit" value="검색" /></form>

</body>
</html>