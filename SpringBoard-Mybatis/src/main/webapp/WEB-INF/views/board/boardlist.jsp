<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
	<div id="container">
		<h2>글목록</h2>
		<table>
			<thead>
				<tr>
					<td>글번호</td>
					<td>글제목</td>
					<td>작성자</td>
					<td>조회수</td>
					<td>작성일</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList}" var="board">
				<tr>
					<td>${board.id}</td>
					<td><a href="/board?id=${board.id}">${board.boardTitle}</a></td>
					<td>${board.userId}</td>
					<td>${board.hit}</td>
					<!-- 수정일이 있는 경우 표시, 없는경우 작성일만 표시 -->
					<td>
						<c:choose>
							<c:when test="${not empty board.updatedTime}">
								<fmt:formatDate value="${board.updatedTime}"
									pattern="yyyy-MM-dd HH:mm:ss"/>
							</c:when>
							<c:otherwise>
								<fmt:formatDate value="${board.createdTime}"
									pattern="yyyy-MM-dd HH:mm:ss"/>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 글쓰기 버튼 -->
		<div>
			<a href="/board/write"><button>글쓰기</button></a>
		</div>
	</div>
	<jsp:include page="../layout/footer.jsp"/>
</body>
</html>