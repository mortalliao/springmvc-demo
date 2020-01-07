package com.springmvc.demo.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class User {
	
	private Long id;
	
	private String name;
	
	private String password;
	
	private boolean gender;
	
	private Integer age;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

}
