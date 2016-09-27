<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기입니다.</title>
<script type="text/javascript">
	function writeFormSubmit(){
		var title = document.getElementById("title");
			if(title.value==""){
				alert("제목을 적어주세요");
				title.focus();
				return;
			}
		var creator = document.getElementById("creator");
			if(creator.value==""){
				alert("작성자를 적어주세요");
				creator.focus();
				return;
			}
		var contents = document.getElementById("contents");
			if(contents.value==""){
				alert("내용을 적어주세요");
				contents.focus();
				return;
			}
		var write = document.getElementById("write");
			write.method= "post";
			write.action="/BBS/add";
			write.submit();
		
	}
</script>
</head>
<body>
	<form id="write" name="write">
		글제목 : <input type="text" id="title" name="title" style="width:500px"/><br/>
		작성자 : <input type="text" id="creator" name="creator" style="width:100px"/><br/>
		글내용 : <textarea id="contents" name="contents" style="width: 500px; height: 300px" ></textarea>
		<input type="button" value="글 등록" onclick="writeFormSubmit()"/>
	</form>

</body>
</html>