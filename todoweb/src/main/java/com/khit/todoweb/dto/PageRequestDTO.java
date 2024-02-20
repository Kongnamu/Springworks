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
public class PageRequestDTO { //�Ķ����(page, kw) ������ DTO
	
	private int page = 1;
	private int size = 10; //�������� �Խñ� ��
	
	private String[] types; //�˻� ����
	private String keyword; //�˻���
	
	//������ �������� �ѱ�� (����(����))
	public int getSkip() { //���̹�Ƽ������ #{skip}�� ����? 
		return (page - 1) * 10; //1������ : 1��, 2������: 11��
	}
	
	//�˻�����(t, w) üũ�ڽ� üũ
	public boolean checkType(String type) {
		//Ÿ�Կ� üũ�� ������ ��ȯ���� ����
		if(types == null || types.length == 0) {
			return false;
		}
		//Ÿ�Կ� ��ġ�Ǵ� ���� ��ȯ�Ѵ�.
		return Arrays.stream(types).anyMatch(type::equals);
	}
}
