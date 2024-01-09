<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
	<div id="container">
		<h2>회원 가입</h2>
		<form action="/user/join" method="post" name="userform">
			<table>
				<tr>
					<td>
						<label>아이디</label>
						<input type="text" name="userId" id="userId"
								 placeholder="아이디" onblur="checkId()"> <!-- onblur : 마우스를 땟을때 지정한 효과 발생 -->
						<p id="check-result"></p>
					</td>
				</tr>
				<tr>
					<td>
						<label>비밀번호</label>
						<input type="password" name="userPasswd" id="userPasswd"
								placeholder="비밀번호" required>
					</td>
				</tr>
				<tr>
					<td>
						<label>이름</label>
						<input type="text" name="userName" id="userName" placeholder="이름">
					</td>
				</tr>
				<tr>
					<td>
						<label>나이</label>
						<input type="text" name="userAge" id="userAge" placeholder="나이">
					</td>
				</tr>
				<tr>	
					<td>
						<input type="button" value="등록" onclick="checkUser()">
						<input type="reset" value="취소">
					</td>
				</tr>
			</table>
		</form>
	</div>
<jsp:include page="../layout/footer.jsp"/>
<script src="/resources/js/validation.js"></script>
</body>
</html>