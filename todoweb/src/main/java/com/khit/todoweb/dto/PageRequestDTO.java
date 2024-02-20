package com.khit.todoweb.dto;

import java.util.Arrays;

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
	
	//페이지 다음으로 넘기기 (간격(범위))
	public int getSkip() { //마이바티스에선 #{skip}과 같다? 
		return (page - 1) * 10; //1페이지 : 1번, 2페이지: 11번
	}
	
	//검색유형(t, w) 체크박스 체크
	public boolean checkType(String type) {
		//타입에 체크가 없으면 반환값이 없다
		if(types == null || types.length == 0) {
			return false;
		}
		//타입에 일치되는 것을 반환한다.
		return Arrays.stream(types).anyMatch(type::equals);
	}
}
