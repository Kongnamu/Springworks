package org.khit.myapp.controller;

import java.util.List;

import org.khit.myapp.dto.BoardDTO;
import org.khit.myapp.repository.BoardRepository;
import org.khit.myapp.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor //매개변수가 있는 생성자
@Slf4j
@RequestMapping("/board")
@Controller //bean 객체로 등록
public class BoardController {
	
	//생성자 주입 (new 하는 것)
	private BoardService boardService;
	
	//글쓰기 폼
	@GetMapping("/write")
	public String writeForm() {
		return "/board/write"; // /board/write.jsp
	}
	//글쓰기 처리
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDTO boardDTO) {
		//@RequestParam("boardTitle") String boardTitle
		log.info("boardDTO=" + boardDTO);
		boardService.save(boardDTO);
		return "redirect:/board/list"; //response.sendRedirect() 와 같음
	}
	//글 목록
	@GetMapping("/list")
	public String getListAll(Model model) {
		List<BoardDTO> boardDTOList = boardService.getListAll();
		model.addAttribute("boardList", boardDTOList);
		return "/board/list";
	}
	//글 상세보기
	@GetMapping
	public String getBoard(@RequestParam("id") Long id, Model model) { //@RequestParam : 특정한 값 1개 받을때
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);
		return "/board/detail";
	}
	//글 삭제처리
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		boardService.delete(id);
		return "redirect:/board/list";
	}
	//글 수정페이지
	@GetMapping("/update")
	public String update(@RequestParam("id") Long id, Model model) {
		//수정할 해당 글 가져오기
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);
		return "/board/update"; //update.jsp
	}
	
	//글 수정처리
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDTO boardDTO) {
		boardService.update(boardDTO);
		return "redirect:/board/list";
	}
}
