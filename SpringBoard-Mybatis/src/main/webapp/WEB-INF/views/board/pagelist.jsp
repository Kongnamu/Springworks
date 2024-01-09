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
					<td><a href="/board?id=${board.id}&page=${paging.page}">${board.boardTitle}</a></td>
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
		<!-- 페이지 처리 영역 -->
		<div class="pagination">
		<!-- 이전 페이지 -->
		<c:choose>
			<c:when test="${paging.page <= 1}"> <!-- 1페이지보다 이전으로 갈경우 -->
				<span>[이전]</span> <!-- 링크가 걸리지 않음 -->
			</c:when>
			<c:otherwise>
				<a href="/board/paging?page=${paging.page - 1}">[이전]</a>
			</c:otherwise>
		</c:choose>
		
		<!-- 현재 페이지 -->
		<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
			<c:choose>
				<c:when test="${paging.page eq i}">
					<span class="current_page">${i}</span>
				</c:when>
				<c:otherwise>
					<a href="/board/paging?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<!-- 다음 페이지 -->
		<c:choose>
			<c:when test="${paging.page >= paging.maxPage}"> <!-- 1페이지보다 이전으로 갈경우 -->
				<span>[다음]</span> <!-- 링크가 걸리지 않음 -->
			</c:when>
			<c:otherwise>
				<a href="/board/paging?page=${paging.page + 1}">[다음]</a>
			</c:otherwise>
		</c:choose>
		</div>
		<!-- 글쓰기 버튼 -->
		<div>
			<a href="/board/write"><button>글쓰기</button></a>
		</div>
	</div>
	<jsp:include page="../layout/footer.jsp"/>
</body>
</html>