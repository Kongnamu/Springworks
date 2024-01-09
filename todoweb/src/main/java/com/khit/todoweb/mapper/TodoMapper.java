package com.khit.todoweb.mapper;

import java.util.List;

import com.khit.todoweb.dto.PageRequestDTO;
import com.khit.todoweb.vo.TodoVO;

public interface TodoMapper {
	
	public String getTime(); //���� �ð� �׽�Ʈ
	
	public void insert(TodoVO todoVO); //����ϱ�

	public List<TodoVO> findAll(); //��� ����
	
	//��Ϻ��� (������, �˻�)
	List<TodoVO> pagingList(PageRequestDTO pageRequestDTO);

	public TodoVO findById(Long tno);

	public void delete(Long tno);

	public void update(TodoVO todoVO);
	
	public int todoCount();
	
	
}