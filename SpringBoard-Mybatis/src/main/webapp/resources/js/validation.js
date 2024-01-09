

let checkUser = function(){
		//alert("가입 완료");
		//아이디는 4자이상 15자까지 입력
		//비밀번호는 영문자, 숫자, 특수문자 포함 8자 이상 입력
		//이름은 한글만 입력
		//나이는 숫자로 입력
		
		let form = document.userform;
		let userId = document.getElementById("userId").value;
		let userName = document.getElementById("userName").value;
		let userPw = document.getElementById("userPasswd").value;
		let userAge = document.getElementById("userAge").value;
		
		//정규 표현식
		let regPw1 = /[0-9]+/ 	  			  //숫자
		let regPw2 = /[a-zA-Z]+/ 	   		  //영문자
		let regPw3 = /[~!@#$%^&*()\-=]+/ 	  //특수문자
		let regName = /^[가-힣]+$/ 			  //한글만
		
		if(userId.length < 4 || userId.length > 15){
			alert("아이디는 4자이상 15자까리 입력 가능합니다.");
			document.getElementById("userId").select(); //입력하지 않거나 4자 이하로 입력할 경우(?)
			return false;
		}else if(userPw.length < 8 || !regPw1.test(userPw) || !regPw2.test(userPw) || !regPw3.test(userPw)){
			alert("비밀번호는 영문자, 숫자, 특수문자 포함 8자 이상 입력해주세요");
			document.getElementById("userPasswd").select(); //입력하지 않거나 4자 이하로 입력할 경우(?)
			return false;
		}else if(!regName.test(userName)){ //한글 정규식에 일치하지 않으면
			alert("이름은 한글로 입력해주세요");
			document.getElementById("userName").select(); //입력하지 않거나 4자 이하로 입력할 경우(?)
			return false;
		}else if(isNaN(userAge) || userAge == ""){ //숫자가 아니면, 비어있으면
			alert("나이는 숫자로 입력해주세요");
			document.getElementById("userAge").select(); //입력하지 않거나 4자 이하로 입력할 경우(?)
			return false;
		}else{
			form.submit(); //검사가 끝나면 (유효하면) 폼에 전송
		}
	}
	
	//id 중복검사 순
	let checkId = function(){
		//alert("중복검사");
		//1. 아이디 입력값 가져오기
		let userId = document.getElementById("userId").value;
		let checkResult = document.getElementById("check-result");
		console.log(userId);
		
		//2. 입력값을 서버에 전송하고 중복된 아이디가 있는지 확인
		//요청방식 : post, url: /user/checkuserid, 데이터 : userId
		if(userId != ""){
		$.ajax({
			type: "post",
			url: "/user/checkuserid",
			data: {"userId": userId},
			//성공, 실패로 서버에서 응답함
			success: function(response){
				console.log(response);
				if(response == "usable"){
					checkResult.innerHTML = "사용 가능한 아이디입니다.";
					checkResult.style.color = "blue";
				}else{
					checkResult.innerHTML = "이미 사용중인 아이디입니다.";
					checkResult.style.color = "red";
				}
			},
			error: function(error){
				console.log("에러발생", error)
			}
		});
		}
	}