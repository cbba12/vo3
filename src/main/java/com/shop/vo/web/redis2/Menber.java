package com.shop.vo.web.redis2;

import java.io.Serializable;

public class Menber implements Serializable {
	
	private static final long serialVersionUID = -212832608428535270L;
	
	private String id;
	private String name;
	private Integer age;
	
	/////////////////////////////
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
