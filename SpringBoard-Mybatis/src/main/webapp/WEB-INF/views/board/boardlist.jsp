<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
</head>
<body>
	<div id="content">
		<h2>글목록</h2>
		<table>
		
			<tr>
				<td>글번호</td>
				<td>글제목</td>
				<td>작성자</td>
				<td>글내용</td>
				<td>조회수</td>
				<td>작성일</td>
			</tr>
			<c:forEach items="${boardList}" var="board">
			<tr>
			
				<td>${board.id}</td>
				<td>${board.boardTitle}</td>
				<td>${board.boardWriter}</td>
				<td>${board.boardContent}</td>
				<td>${board.hit}</td>
				<td>${board.createdTime}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>