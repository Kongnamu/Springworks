package org.khit.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //컴포넌트(@component 상속)
public class HomeController {
	
	//http://localhost:8080/
	@RequestMapping("/")
	public String home() { //파일 이름 변환(보내줌)
		
		return "index"; //home.jsp
	}
	
	// '/'경로에서 404에러 발생시
		@GetMapping("Favicon.ico")
		@ResponseBody // json또는 문자 데이터를 반환
		public void returnNoFavicon() {
			
		}
	
}
