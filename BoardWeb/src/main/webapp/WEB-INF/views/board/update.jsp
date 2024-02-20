<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Detail</title>
<style>
	.content{margin-left: 30px;}
</style>
</head>
<body>
	<div class="content">
		<h2>Update</h2>
		<form action="/board/update" method="post">
		<p>
			<label>번호</label>
			<input type="text" name="id" value="${board.id}" readonly>
		</p>
		<p>
			<label>제목</label>
			<input type="text" name="btitle" value="${board.btitle}" >
		</p>
		<p>	
			<label>작성자</label>
			<input type="text" name="writer" value="${board.writer}" readonly>
		</p>
		<p>	
			<textarea rows="5" cols="50" name="bcontent">${board.bcontent}</textarea>
		</p>
		<p>	
			작성일: ${board.createdDate}
		</p>
		<p>
			<button type="submit">수정하기</button>
			<a href="/board/list"><button>목록</button></a>
		</p>
		</form>
	</div>
</body>
</html>