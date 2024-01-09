package com.khit.web.service;

import java.util.List;

import com.khit.web.dto.BoardDTO;
import com.khit.web.dto.PageDTO;

public interface BoardService {

	void insert(BoardDTO boardDTO);

	List<BoardDTO> getList();

	BoardDTO findById(Long id);

	void delete(Long id);

	void update(BoardDTO boardDTO);

	void updateHit(Long id);

	List<BoardDTO> pagingList(int page);

	PageDTO pagingParam(int page);

}
