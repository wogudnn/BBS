<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BBSList</title>
<link rel="stylesheet" type="text/css" href="/BBS/css/listcss.css">
</head>
<body>
	<h1>게시판 입니다.</h1>
	<hr/>
		<div id="wrapper">
			<c:forEach items="${boardSystems}" var="boardSystem">
				<div class="posting">
					<div class="top">
						<div class="id">${boardSystem.id}</div>
						<div class="title"><a href="/BBS/detail?Id=${boardSystem.id}"> ${boardSystem.title}</a></div>
					</div>
					<div class="mid">
						<div class="creator">작성자 : ${boardSystem.getCreatorName()}</div>
						<div class="hitcount">조회수 : ${boardSystem.hitCount}</div>
						<div class="recommend">추천수 : ${boardSystem.recommendConunt}</div>
						<div class="createdate">작성시간 : ${boardSystem.getCreateDate()}</div>
					</div>
						<div class="content">
							<c:choose>
								<c:when test="${fn:length(boardSystem.contents)>50}">
									${fn:substring(boardSystem.contents, 0, 50)}...
								</c:when>
								<c:otherwise>
									${boardSystem.contents}
								</c:otherwise>
							</c:choose>
						</div>
				</div>
			</c:forEach>
			<div id="write">
				<input type="button" value="글쓰기" onclick="location.href='/BBS/write'" />
			</div>
		</div>
</body>
</html>