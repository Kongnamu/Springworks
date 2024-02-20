<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Community List</h2>
	<div>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${board}" var="board">
				<tr>
					<td>${board.id}</td>
					<td><a href="/board?id=${board.id}">${board.btitle}</a></td>
					<td>${board.writer}</td>
					<td>${board.createdDate}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>