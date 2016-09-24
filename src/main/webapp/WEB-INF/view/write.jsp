<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기입니다.</title>
</head>
<body>
	<form name="write" method="post" action="/BBS/add" >
		글 제목 : <input type="text" name="title" style="width:500px"/><br/>
		작성자   : <input type="text" name="creator" style="width:100px"/><br/>
		글 내용 : <textarea name="contents" style="width: 500px; height: 300px" ></textarea>
		<input type="submit" value= "글 등록"/>
	</form>

</body>
</html>