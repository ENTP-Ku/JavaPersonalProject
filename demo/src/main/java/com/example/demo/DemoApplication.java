package com.example.demo; // 현재 패키지 선언, 보통 프로젝트의 구조에 따라 변경될 수 있음

import org.springframework.boot.SpringApplication; // Spring Boot 애플리케이션을 시작하기 위한 클래스
import org.springframework.boot.autoconfigure.SpringBootApplication; // Spring Boot의 자동 구성을 활성화하는 어노테이션

/**
 * Spring Boot 애플리케이션의 진입점 클래스입니다.
 * @SpringBootApplication 어노테이션은 이 클래스가 Spring Boot 애플리케이션의 시작점을 나타냄을 의미합니다.
 */
@SpringBootApplication
public class DemoApplication {

    /**
     * 애플리케이션의 메인 메서드입니다.
     * SpringApplication.run() 메서드를 호출하여 Spring Boot 애플리케이션을 시작합니다.
     * @param args 커맨드 라인 인수로 애플리케이션에 전달될 수 있음
     */
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args); // Spring Boot 애플리케이션을 실행
    }

}
