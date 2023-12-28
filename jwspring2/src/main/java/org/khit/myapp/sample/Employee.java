package org.khit.myapp.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@AllArgsConstructor //매개변수가 있는 생성자
@ToString
@NoArgsConstructor //기본 생성자(매개변수 없음)
@Component //@Controller, @Repository, @Service 이 셋의 부모가 Component
public class Employee {
	
}
