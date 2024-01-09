package com.khit.todoweb.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.khit.todoweb.dto.PageRequestDTO;
import com.khit.todoweb.dto.PageResponseDTO;
import com.khit.todoweb.dto.TodoDTO;
import com.khit.todoweb.vo.TodoVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
public class TodoMapperTest {
	
	@Autowired //�ڵ� ���� - todoMapper�� ��ü�� �� (new �ѰͰ� ����)
	private TodoMapper todoMapper;
	
	@Test
	public void testGetTime() {
		log.info(todoMapper.getTime());
		
	}
	
	/*@Test
	public void testInsert() {*/
		//������ 1�� ���� : ���� setter ������ builder()���
		  //TodoVO todoVO = new TodoVO(); 
		  //todoVO.setTno(1L);
		  //todoVO.setTitle("12�� ���� ����"); 
		  //todoVO.setWriter("�ᳪ��");
		  //todoVO.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		 
		/*
		 * TodoVO todoVO = TodoVO.builder() .title("20�� ��ϱ�") .writer("�ᳪ��") .build();
		 * 
		 * todoMapper.insert(todoVO);
		 */
		
	@Test
	public void testFindAll() {
		//db�� �ִ� ������ �����ϱ�(�˻�)
		List<TodoVO> todoList = todoMapper.findAll();
		/*
		 * for(TodoVO todo : todoList) { log.info(todo); }
		 */
		//todoList.forEach(todo -> log.info(todo));
	}
	@Test
	public void testFindById() {
		//db���� 1(1Long)�� ������ �˻�
		TodoVO todoVO = todoMapper.findById(1L);
		log.info(todoVO);
	}
	/* @Test
	public void testDelete() {
		todoMapper.delete(1L);
		log.info("�����Ϸ�");
	} */
	
	/* @Test
	public void testUpdate() {
		TodoVO todoVO = todoMapper.findById(8L);
		todoVO.setTno(8L);
		todoVO.setTitle("test ����");
		todoVO.setWriter("tester ����");
		
		todoMapper.update(todoVO);
	} */
	@Test
	public void testSelectSearch() {
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
				.page(1)
				.size(10)
				.types(new String[] {"t", "w"})
				.keyword("�����ڱ�")
				.build();
		List<TodoVO> voList = todoMapper.pagingList(pageRequestDTO);
		for(TodoVO todoVO : voList) {
			log.info(todoVO);
		}
	}
}
