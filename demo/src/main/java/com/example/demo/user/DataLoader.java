package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.address.Address;
import com.example.demo.address.AddressRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 주소 생성
        Address address1 = new Address("123 Elm St", "Springfield", "IL", "62701");
        Address address2 = new Address("456 Oak St", "Springfield", "IL", "62702");
        Address address3 = new Address("789 Maple St", "Springfield", "IL", "62703");

        // 주소 저장
        addressRepository.save(address1);
        addressRepository.save(address2);
        addressRepository.save(address3);

        // 사용자 생성
        User user1 = new User("Alice Johnson", "alice.johnson@example.com");
        User user2 = new User("Bob Smith", "bob.smith@example.com");

        // 주소를 사용자와 연결
        user1.setAddresses(new HashSet<>(Set.of(address1, address2)));
        user2.setAddresses(new HashSet<>(Set.of(address2, address3)));

        // 주소에 사용자 추가
        address1.setUsers(new HashSet<>(Set.of(user1)));
        address2.setUsers(new HashSet<>(Set.of(user1, user2)));
        address3.setUsers(new HashSet<>(Set.of(user2)));

        // 사용자 저장
        userRepository.save(user1);
        userRepository.save(user2);
    }
}
