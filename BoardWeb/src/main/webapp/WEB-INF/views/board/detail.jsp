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
		<h2>Community Detail</h2>
		<p>
			<label>번호</label>
			<input type="text" name="id" value="${board.id}" readonly>
		</p>
		<p>
			<label>제목</label>
			<input type="text" name="btitle" value="${board.btitle}" readonly>
		</p>
		<p>	
			<label>작성자</label>
			<input type="text" name="writer" value="${board.writer}" readonly>
		</p>
		<p>	
			<textarea rows="5" cols="50" name="writer">${board.bcontent}</textarea>
		</p>
		<p>	
			작성일: ${board.createdDate}
		</p>
		<p>
			<a href="/board/update?id=${board.id}">
                        <button>수정</button>
            </a>
			<a href="/board/list">
				<button type="button">목록</button>
			</a>
			<a href="/board/delete?id=${board.id}"
                        onclick="return confirm('정말로 삭제하시겠습니까?')">
                        <button>삭제</button>
            </a>
		</p>
	</div>
</body>
</html>