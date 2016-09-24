<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>detail</title>
</head>
<body>
	<h1>${boardSystemVO.getTitle()}</h1>
	<hr/>
	<h4>작성자 : ${boardSystemVO.getCreatorName()}</h4><br/>
	<h4>작성시간 : ${boardSystemVO.getCreateDate()}</h4><br/>
	<h4>조회수: ${boardSystemVO.getHitCount()}</h4><br/>
	<p>${boardSystemVO.getContents()}</p><br/>
	<a href="/BBS/list">처음으로</a>
	<a href="/BBS/recommend?Id=${boardSystemVO.getId()}">추천하기</a>
	<a href="/BBS/delete?Id=${boardSystemVO.getId()}">삭제하기</a>
	
</body>
</html>