package com.example.demo.address;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import com.example.demo.user.User;

@Entity
public class Address {

    // 기본 키를 정의합니다.
    @Id
    // 기본 키의 값이 자동으로 생성되도록 설정합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 주소의 도로명
    private String street;

    // 주소의 도시
    private String city;

    // 주소의 주/도
    private String state;

    // 주소의 우편번호
    private String zipCode;

    // User와의 다대일 관계를 설정합니다.
    @ManyToOne
    // 외래 키를 지정합니다. 이 외래 키는 'user_id'로 설정됩니다.
    @JoinColumn(name = "user_id")
    private User user;

    // 기본 생성자
    public Address() {
    }

    // 모든 필드를 포함하는 데이터 생성용 생성자
    public Address(String street, String city, String state, String zipCode, User user) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.user = user;
    }

    // ID의 getter 메서드
    public Long getId() {
        return id;
    }

    // ID의 setter 메서드
    public void setId(Long id) {
        this.id = id;
    }

    // street의 getter 메서드
    public String getStreet() {
        return street;
    }

    // street의 setter 메서드
    public void setStreet(String street) {
        this.street = street;
    }

    // city의 getter 메서드
    public String getCity() {
        return city;
    }

    // city의 setter 메서드
    public void setCity(String city) {
        this.city = city;
    }

    // state의 getter 메서드
    public String getState() {
        return state;
    }

    // state의 setter 메서드
    public void setState(String state) {
        this.state = state;
    }

    // zipCode의 getter 메서드
    public String getZipCode() {
        return zipCode;
    }

    // zipCode의 setter 메서드
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    // user의 getter 메서드
    public User getUser() {
        return user;
    }

    // user의 setter 메서드
    public void setUser(User user) {
        this.user = user;
    }
}
