package com.example.demo.user;

import javax.persistence.*;
import com.example.demo.address.Address;
import java.util.List;

/**
 * User 엔티티 클래스.
 * 이 클래스는 'users' 테이블과 매핑됩니다.
 */
@Entity
@Table(name = "users")  // 'users' 테이블과 매핑됨을 나타냅니다.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 증가 전략을 사용하여 기본 키 값을 생성합니다.
    private Long id;  // 사용자 ID (기본 키)

    private String name;  // 사용자 이름
    private String email;  // 사용자 이메일

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;  // 이 사용자가 가진 주소 리스트. 'Address' 엔티티와 일대다 관계를 맺습니다.

    // 기본 생성자
    public User() {
    }

    // 데이터 생성에 사용할 생성자
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // 사용자 ID getter
    public Long getId() {
        return id;
    }

    // 사용자 ID setter
    public void setId(Long id) {
        this.id = id;
    }

    // 사용자 이름 getter
    public String getName() {
        return name;
    }

    // 사용자 이름 setter
    public void setName(String name) {
        this.name = name;
    }

    // 사용자 이메일 getter
    public String getEmail() {
        return email;
    }

    // 사용자 이메일 setter
    public void setEmail(String email) {
        this.email = email;
    }

    // 주소 리스트 getter
    public List<Address> getAddresses() {
        return addresses;
    }

    // 주소 리스트 setter
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
