package com.ssafy.board.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.util.JwtUtil;

@RestController
@RequestMapping("/api")
public class UserRestController {
	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	// UserService 생성해서 촥촥 해야하지만 ... 시간 관계상 생략

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
		Map<String, Object> result = new HashMap<String, Object>();

		// User Service -> DAO -> DB //실제 유저인지 아닌지 확인 등등등....

		HttpStatus status = null;

		// User의 id가 Null이 아니거나 뭔가 작성이 되어있다면 로그인 성공 이라고 가정
		// 로그인 성공!
		try {
			if (user.getId() != null && user.getId().length() > 0) {
				System.out.println(user);
				result.put("access-token", jwtUtil.createToken("id", user.getId()));
				result.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}else {
				result.put("message", FAIL);
				status = HttpStatus.NO_CONTENT;
			}
		} catch (UnsupportedEncodingException e) {
			result.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		
		return new ResponseEntity<Map<String,Object>>(result, status);
	}

}
