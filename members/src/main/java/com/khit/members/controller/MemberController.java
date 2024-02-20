package com.khit.members.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khit.members.dto.MemberDTO;
import com.khit.members.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor //������ ���� 
@Slf4j
@RequestMapping("/member")
@Controller
public class MemberController {
	
	private MemberService memberService;
	
	@GetMapping("/join")
	public String join() {
		return "/member/join";
	}
	@PostMapping("/join")
		public String join(@ModelAttribute MemberDTO memberDTO) {
			log.info("memberDTO : " + memberDTO);
			//ȸ�� ���� ó��
			memberService.insert(memberDTO);
			return "/member/login";
	}
	//�α��� ȭ��
	@GetMapping("/login")
	public String loginForm() {
		return "/member/login";
	}
	//�α��� ó��
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO,
			HttpSession session) {
		MemberDTO loginMember = memberService.login(memberDTO);
		if(loginMember != null) { //�α��ε� ��ü�� ������ ���� �߱�
			session.setAttribute("sessionEmail", memberDTO.getEmail());
			return "main";
		}else {
			return "/member/login";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //��� ���� ����
		return "redirect:/";
	}
	//ȸ�� ���
	@GetMapping("/")
	public String getMemberList(Model model) {
		List<MemberDTO> MemberDTOList = memberService.findAll();
		model.addAttribute("memberList", MemberDTOList);
		return "/member/list";
	}
	//ȸ�� ��
	@GetMapping
	public String getMember(@RequestParam("id") Long id,
			Model model) {
		MemberDTO memberDTO = memberService.finById(id);
		model.addAttribute("member", memberDTO);
		return "/member/detail";
	}
	//ȸ�� ����
	@GetMapping("/delete")
	public String deleteMember(@RequestParam("id") Long id,
			HttpSession session) {
		memberService.delete(id);
		session.invalidate();
		return "redirect:/member/";
	}
	//ȸ�� ����
	@GetMapping("/update")
	//�����Ҷ� id�� �ƴ� session(�̸���)���� ã��
	public String updateForm(HttpSession session,
			Model model) {
		//������ �����ͼ� ȸ���� �̸���(����)�� �˻� : findByEmail() �޼��� ����
		String email = (String)session.getAttribute("sessionEmail");
		MemberDTO memberDTO = memberService.findByEmail(email);
		model.addAttribute("member", memberDTO);
		return "/member/update";
	}
	//ȸ�� ���� ó��
	@PostMapping("/update")
	public String update(@ModelAttribute MemberDTO memberDTO) {
		memberService.update(memberDTO);
		return "redirect:/member/";
	}
	//�̸��� �ߺ��˻�
	@PostMapping("/checkemail")
	public @ResponseBody String checkEmail(
			@RequestParam("email") String email) {
		String resultText = memberService.checkEmail(email);
		return resultText; //OK Ȥ�� NO�� ��ȯ��
	}
	
}
