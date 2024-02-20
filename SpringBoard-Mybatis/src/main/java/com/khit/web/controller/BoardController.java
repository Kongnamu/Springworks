package com.khit.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khit.web.dto.BoardDTO;
import com.khit.web.dto.PageDTO;
import com.khit.web.dto.ReplyDTO;
import com.khit.web.service.BoardService;
import com.khit.web.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@AllArgsConstructor
@Slf4j
@RequestMapping("/board")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private ReplyService replyService;
	
	//글쓰기 페이지
	@GetMapping("/write")
	public String writeForm() {
		return "/board/write";
	}
	
	//글쓰기 처리
	@PostMapping("/write")
	public String write(BoardDTO boardDTO) {
		log.info("boardDTO:" + boardDTO);
		boardService.insert(boardDTO); //void 형으로 반환값 없음
		return "redirect:/board/paging";
	}
	//글 목록
	// /board/
	@GetMapping("/")
	public String getList(Model model) {
		List<BoardDTO> boardDTOList = boardService.getList();
		model.addAttribute("boardList", boardDTOList);
		return "board/boardlist";
	}
	
	//글 목록의 페이지처리
	// /board/paging?page=
	// @RequestParam(required=true)는 반드시 있어야함, true가 false면 필수가 아님을 뜻함
	@GetMapping("/paging")
	public String getPageList(@RequestParam(value="page", required=false,
			defaultValue="1") int page, Model model) {
		log.info("page=" + page);
		//페이지와 글 개수 구현된 목록 보기
		List<BoardDTO> pagingList = boardService.pagingList(page);
		log.info("pagingList=" + pagingList);
		model.addAttribute("boardList", pagingList);
		
	//화면 하단에 페이지 구현
		PageDTO pageDTO = boardService.pagingParam(page);
		model.addAttribute("paging", pageDTO);
		return "/board/pagelist";
	}
	//글 상세보기
	// /board?id=
	@GetMapping
	public String getBoard(@RequestParam("id") Long id,
			@RequestParam(value="page", required=false,
			defaultValue="1") int page,
				Model model) {
		//조회수 증가
		boardService.updateHit(id);
		//글 상세보기
		BoardDTO boardDTO = boardService.findById(id);
		//댓글 상세보기
		List<ReplyDTO> replyDTOList = replyService.getReplyList(id);
		model.addAttribute("board", boardDTO);
		model.addAttribute("replyList", replyDTOList);
		model.addAttribute("page", page);
		return "/board/detail"; //detail.jsp
	}
	//글 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		boardService.delete(id);
		return "redirect:/board/";
	}
	//글 수정 페이지
	@GetMapping("/update")
	public String update(Model model, Long id) {
		BoardDTO boardDTO = boardService.findById(id);
		model.addAttribute("board", boardDTO);
		return "/board/update";
	}
	
	//글 수정처리
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDTO boardDTO) {
		//수정해서 다시 저장함 (객체 DTO로 저장)
		boardService.update(boardDTO);
		return "redirect:/board?id=" + boardDTO.getId();
	}
	
}
