package com.ssafy.board.model.dto;

//실제로 우리의 User 테이블은 더많은 정보를 가지고 있다!!!!!!
//지금 심플 실제로는 deep 하게 만들어 볼것
public class User {
	private String id;
	private String password;
	
	public User() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + "]";
	}
}