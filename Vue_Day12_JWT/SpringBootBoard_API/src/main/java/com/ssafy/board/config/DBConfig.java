package com.ssafy.board.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

//MyBatis에서 구현체로 만들어줄 DAO를 스캔하기 위한 파일 
//main 함수가 있는 클래스파일에 작성해도 상관 x (구분을 위해 나누어 놓은 것)
@Configuration
@MapperScan(basePackages = "com.ssafy.board.model.dao")
public class DBConfig {

}