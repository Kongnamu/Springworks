package com.khit.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khit.web.dto.BoardDTO;
import com.khit.web.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@RequestMapping("/board")
@Controller
public class BoardController {
	
	private BoardService boardService;
	
	//�۾��� ������
	@GetMapping("/write")
	public String writeForm() {
		return "/board/write";
	}
	
	//�۾��� ó��
	@PostMapping("/write")
	public String write(BoardDTO boardDTO) {
		log.info("boardDTO:" + boardDTO);
		boardService.insert(boardDTO); //void ������ ��ȯ�� ����
		return "redirect:/board/"; //boardlist.jsp�� �̵�
	}
	//�� ���
	@GetMapping("/")
	public String getList(Model model) {
		List<BoardDTO> boardDTOList = boardService.getList();
		model.addAttribute("boardList", boardDTOList);
		return "board/boardlist";
	}
}
