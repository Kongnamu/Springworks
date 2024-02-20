<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세보기</title>
<style>
	.content{margin-left: 30px;}
</style>
</head>
<body>
	<div class="content">
		<h2>회원 상세보기</h2>
		<p>
			<label>번호</label>
			<input type="text" name="id" value="${member.id}" readonly>
		</p>
		<p>
			<label>이메일</label>
			<input type="text" name="email" value="${member.email}" readonly>
		</p>
		<p>
			<label>비밀번호</label>
			<input type="password" name="password" value="${member.password}" readonly>
		</p>
		<p>
			<label>이름</label>
			<input type="text" name="name" value="${member.name}" readonly>
		</p>
		<p>	
			<label>나이</label>
			<input type="text" name="age" value="${member.age}" readonly>
		</p>
		<p>
			<button type="button" onclick="list('${member.id}')">목록</button>
			<button type="button" onclick="deletemember('${member.id}')">삭제</button>
		</p>
	</div>
<script type="text/javascript">
//목록 보기 버튼
const list = function(mid){
	location.href = "/member/" + mid;
}

const deletemember = function(mid){
	if(confirm("정말로 삭제하시겠습니까?")){
		location.href = "/member/delete?id=" + mid;
	}
}
</script>	
</body>
</html>