package com.example.demo.user;

// 필요한 패키지를 임포트합니다.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.address.Address;
import com.example.demo.address.AddressRepository;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;

import java.util.Arrays;

@Component // 이 클래스는 Spring Boot 애플리케이션 시작 시 실행됩니다.
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository; // User 엔티티를 처리하는 레포지토리

    @Autowired
    private AddressRepository addressRepository; // Address 엔티티를 처리하는 레포지토리

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 사용자(User) 인스턴스를 생성합니다.
        User user1 = new User("Alice Johnson", "alice.johnson@example.com");
        User user2 = new User("Bob Smith", "bob.smith@example.com");

        // 주소(Address) 인스턴스를 생성하고, 각각의 주소가 어느 사용자에 속하는지 설정합니다.
        Address address1 = new Address("123 Elm St", "Springfield", "IL", "62701", user1);
        Address address2 = new Address("456 Oak St", "Springfield", "IL", "62702", user1);
        Address address3 = new Address("789 Maple St", "Springfield", "IL", "62703", user2);

        // 각 사용자(User)와 관련된 주소(Address) 리스트를 설정합니다.
        user1.setAddresses(Arrays.asList(address1, address2));
        user2.setAddresses(Arrays.asList(address3));

        // 사용자와 주소를 데이터베이스에 저장합니다.
        // 먼저 주소를 저장하지 않고, 사용자(User) 엔티티를 저장하는 이유는 
        // 사용자(User) 저장 시, 자동으로 관련된 주소(Address)가 저장되기 때문입니다.
        userRepository.save(user1);
        userRepository.save(user2);
    }
}
