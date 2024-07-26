package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // ID로 사용자 검색을 위한 메서드
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        // 사용자 ID로 사용자를 검색합니다.
        Optional<User> user = userService.findUserById(id);

        // 사용자가 존재하는지 확인합니다.
        if (user.isPresent()) {
            // 사용자가 존재하면 해당 사용자를 반환합니다.
            return user.get();
        } else {
            // 사용자가 존재하지 않으면 예외를 던집니다.
            throw new RuntimeException("User not found with id " + id);
        }
    }
}
