package com.ssafy.board.jwt.test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTest {
	public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
		String token = Jwts.builder()
		.setHeaderParam("alg", "HS256")
		.setHeaderParam("typ", "JWT") //헤더완료
		.claim("userId", "ssafy")
		.setExpiration(new Date(System.currentTimeMillis()+3000)) //페이로드 완료
		.signWith(SignatureAlgorithm.HS256, "SSAFIT".getBytes("UTF-8")) //서명완료
		.compact();

//		1분 1000*60
//		1시간 1000*60*60
//		1일 1000*60*60*24
//		1년 1000*60*60*24*365
		
		System.out.println(token);
		///
		System.out.println(new String(Base64.getDecoder().decode(token.split("\\.")[1])));
		
		//3초만 유효하다고 했으니 강제로 시스템을 4초 딜레이 시키고 유효성검사를 해보자.
		Thread.sleep(4000);
		
		//유효성 검사 
		Jws<Claims> claims = Jwts.parser().setSigningKey("SSAFIT".getBytes("UTF-8")).parseClaimsJws(token);
		System.out.println(claims);
		
	}
}
