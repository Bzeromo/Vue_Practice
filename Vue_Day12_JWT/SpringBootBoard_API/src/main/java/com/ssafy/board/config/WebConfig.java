package com.ssafy.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.board.interceptor.JwtInterceptor;

//Web과 관련 설정을 위한 파일
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private JwtInterceptor jwtInterceptor;

	// 해당 위치에서 일치하는 것이 있다면 미리 찾기
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

		registry.addResourceHandler("/swagger-ui/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");

	}

	// CORS 에러를 해결하기 위해서 컨트롤러에 각각 작성을 할수도 있지만 공통처리(전역처리)라면 요기다 한방에 가넝
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("POST", "GET", "PUT", "DELETE");
	}

	// 등록할 인터셉터가 있다면...
	// 필드를 통해 의존성을 주입 받고
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor).addPathPatterns("/**").excludePathPatterns("/api/login",
				"/swagger-resources/**", "/swagger-ui/**", "/v2/api-docs");
	}

}