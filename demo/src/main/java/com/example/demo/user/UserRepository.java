package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository를 확장하여 User 엔티티에 대한 CRUD 작업을 수행할 수 있는 레포지토리 인터페이스
public interface UserRepository extends JpaRepository<User, Long> {
    // 기본 CRUD 메서드는 JpaRepository에서 제공하므로 별도로 정의할 필요 없음
    // 예를 들어, save(), findById(), findAll(), deleteById() 등의 메서드가 자동으로 제공됨
}
