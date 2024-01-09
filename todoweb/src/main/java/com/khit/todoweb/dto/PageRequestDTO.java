package com.khit.todoweb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageRequestDTO { //파라미터(page, kw) 수집용 DTO
	
	private int page = 1;
	private int size = 10; //페이지당 게시글 수
	
	private String[] types; //검색 유형
	private String keyword; //검색어
	
	public int getSkip() { //마이바티스에선 #{skip}과 같다? 
		return (page - 1) * 10; //1페이지 : 1번, 2페이지: 11번
	}
}
