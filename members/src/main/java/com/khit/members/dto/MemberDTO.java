package com.khit.members.dto;

import lombok.Data;

@Data
public class MemberDTO {
	private Long id;
	private String email;
	private String name;
	private String password;
	private int age;

}
