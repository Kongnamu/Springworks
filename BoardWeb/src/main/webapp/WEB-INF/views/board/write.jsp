<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
</head>
<body>
	<h1>Write</h1>
	<div>
		<form action="/board/write" method="post">
			<p><input type="text" name="btitle" placeholder="글제목"></p>
			<p><input type="text" name="writer" placeholder="작성자"></p>
			<p><textarea rows="4" cols="60" name="bcontent"
							placeholder="내용을 입력해주세요" ></textarea></p>
			<p><input type="submit" value="등록"></p>
		</form>
	</div>
</body>
</html>