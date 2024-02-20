package com.khit.boards.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardDTO {
	
	private Integer id;
	private String btitle;
	private String writer;
	private String bcontent;
	private Timestamp createdDate;
}
