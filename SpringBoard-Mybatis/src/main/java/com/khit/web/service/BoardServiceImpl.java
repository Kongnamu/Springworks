package com.khit.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khit.web.dto.BoardDTO;
import com.khit.web.dto.PageDTO;
import com.khit.web.mapper.BoardMapper;

import lombok.AllArgsConstructor;

//@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;
		
	@Override //재정의
	public void insert(BoardDTO boardDTO) {
		boardMapper.insert(boardDTO);
	}

	@Override
	public List<BoardDTO> getList() {
		return boardMapper.getList();
	}

	@Override
	public BoardDTO findById(Long id) {
		return boardMapper.findById(id);
	}

	@Override
	public void updateHit(Long id) {
		boardMapper.updateHit(id);
	}

	@Override
	public void delete(Long id) {
		boardMapper.delete(id);
	}

	@Override
	public void update(BoardDTO boardDTO) {
		boardMapper.update(boardDTO);
		
	}
	
	int pageLimit = 10; //페이지당 게시글 수
	int blockLimit = 5; //하단에 보여줄 페이지 번호 개수
	
	@Override
	public List<BoardDTO> pagingList(int page) {
		/* 
		  -- 1페이지: 0부터 / 2페이지: 5부터 / 3페이지: 10부터
			select * from boards order by id desc limit 0, 5;
		 */
		 
		int pageStart = (page - 1) * pageLimit; //페이지 시작 번호
		Map<String, Integer> pagingParam = new HashMap<>(); //map자료구조로 넘겨준다
		pagingParam.put("start", pageStart);
		pagingParam.put("limit", pageLimit);
		
		List<BoardDTO> pagingList = boardMapper.pagingList(pagingParam);
		return pagingList;
	}

	@Override
	public PageDTO pagingParam(int page) {
		//하단에 보여줄 페이지 블럭 계산
		int totalRow = boardMapper.boardCount(); // 전체 게시글 수
		//전체 페이지 개수 : 반올림 사용 (Math.ceil) 43/10 = 4.3 -> 실제 페이지 개수는 5
		//4.3인데 ceil 하여 5.3으로 나오기 때문에 (int) 형변환 필요함
		int maxPage = (int)(Math.ceil((double)totalRow / pageLimit));
		//하단에 보여줄 시작 페이지값 계산 - 예) 5개씩 보임
		int startPage = (((int)(Math.ceil((double)page / blockLimit))) - 1) * blockLimit + 1;
		//하단에 보여줄 마지막 페이지값 계산 - 예) 5, 10, 15, 20
		int endPage = startPage + blockLimit -1;
		if(endPage > maxPage)
			endPage = maxPage;
		//PageDTO 객체를 생성해서 값을 세팅해주고 반환함
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPage(page);
		pageDTO.setMaxPage(maxPage);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		return pageDTO;
	}
}
