package com.khit.boards.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khit.boards.dto.BoardDTO;
import com.khit.boards.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {
	
	 /* private final BoardService boardService;
	
	//글쓰기 페이지
	@GetMapping("/write")
	public String writeForm() {
		return "/board/write";
	}
	
	//글쓰기 처리
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDTO boardDTO) {
		System.out.println(boardDTO);
		boardService.insert(boardDTO);
		return"redirect:/";
	}
	//글 목록
	@GetMapping("/list")
	public String list(Model model) {
		List<BoardDTO> boardDTOList = boardService.findAll();
		model.addAttribute("board", boardDTOList);
		return "/board/list";
	}
	//글 상세보기
	@GetMapping
	public String getBoard(@RequestParam("id") int id, Model model) {
		BoardDTO boardDTOList = boardService.findById(id);
		model.addAttribute("board", boardDTOList);
		return "/board/detail";
	}
	//글 삭제
	@GetMapping("/delete")
	public String deleteBoard(@RequestParam("id") int id) {
		boardService.delete(id);
		return "redirect:/board/list";
	}
	//수정 화면
	@GetMapping("/update")
	public String updateForm(@RequestParam("id") int id,
			Model model) {
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);
		return "/board/update";
	}
	
	//수정 처리
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDTO boardDTO) {
		boardService.update(boardDTO);
		return "redirect:/board?id=" + boardDTO.getId();
	} */
	
	private final BoardService boardService;
	
	//글쓰기 화면
	@GetMapping("/write")
	public String writeForm() {
		return "/board/write";
	}
	
	//글쓰기 처리
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDTO boardDTO) {
		System.out.println(boardDTO);
		boardService.insert(boardDTO);
		return "redirect:/";
	}
	//글목록
	@GetMapping("/list")
	public String getBoard(Model model) {
		List<BoardDTO> boardDTOList = boardService.findAll();
		model.addAttribute("board", boardDTOList);
		return "/board/list";
	}
	//글 상세보기
	@GetMapping
	public String getBoard(@RequestParam("id") int id, Model model) {
		BoardDTO boardDTOdetail = boardService.findById(id);
		model.addAttribute("board", boardDTOdetail);
		return "/board/detail";
	}
	//글 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		boardService.delete(id);
		return "redirect:/board/list";
	}
	
	//글 수정 화면
	@GetMapping("/update")
	public String updateForm(@RequestParam("id") int id, Model model) {
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);
		return "/board/update";
	}
	//수정 처리
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDTO boardDTO) {
		boardService.update(boardDTO);
		return "redirect:/board?id="  + boardDTO.getId();
	}
}
