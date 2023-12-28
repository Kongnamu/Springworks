<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="content">
		<h2>글 수정</h2>
		<form action="/board/update" method="post">
		<input type="hidden" name="id" value="${board.id}"> <!-- 수정위해 필요 -->
			<table>
				<tr>
					<td>
						<label>글 제목</label>
						<input type="text" name="boardTitle" 
							    value="${board.boardTitle}">
					</td>
				</tr>
				<tr>
					<td>
						<label>작성자</label>
						<input type="text" name="boardWriter"
							   readonly value="${board.boardWriter}">
					</td>
				</tr>
				<tr>	
					<td>
						<label>글 내용</label>
						<textarea rows="5" cols="50" name="boardContent" >
							   ${board.boardContent}</textarea>
					</td>
				</tr>
				<tr>	
					<td>
						<button type="submit">수정하기</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
