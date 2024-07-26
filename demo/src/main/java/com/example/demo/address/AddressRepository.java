package com.example.demo.address;

import org.springframework.data.jpa.repository.JpaRepository;

// Address 엔티티에 대한 CRUD 연산을 처리하는 레포지토리 인터페이스입니다.
// JpaRepository를 확장하여 기본적인 CRUD 연산과 추가적인 쿼리 메서드를 사용할 수 있습니다.
public interface AddressRepository extends JpaRepository<Address, Long> {
}
