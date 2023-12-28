package org.khit.myapp.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor //생성자 주입(new 한것과 같음)
@ToString
@Component
public class Company {
	
	private Employee employee;
}
