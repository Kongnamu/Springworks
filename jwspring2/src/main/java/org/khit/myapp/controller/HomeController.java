package org.khit.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //������Ʈ(@component ���)
public class HomeController {
	
	//http://localhost:8080/
	@RequestMapping("/")
	public String home() { //���� �̸� ��ȯ(������)
		
		return "index"; //home.jsp
	}
	
	// '/'��ο��� 404���� �߻���
		@GetMapping("Favicon.ico")
		@ResponseBody // json�Ǵ� ���� �����͸� ��ȯ
		public void returnNoFavicon() {
			
		}
	
}
