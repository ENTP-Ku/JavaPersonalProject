package com.example.demo.user; // 패키지 선언, 해당 클래스가 속한 패키지입니다.

import org.springframework.beans.factory.annotation.Autowired; // Spring의 의존성 주입 기능을 사용하는 어노테이션입니다.
import org.springframework.stereotype.Service; // 이 클래스가 Spring의 서비스 컴포넌트임을 나타내는 어노테이션입니다.

import java.util.Optional; // Java 8의 Optional 클래스를 임포트합니다. 데이터가 없을 수 있는 상황을 처리할 때 유용합니다.

@Service // 이 클래스가 서비스 계층의 컴포넌트임을 나타내는 어노테이션입니다. Spring의 컴포넌트 스캔에 의해 인식됩니다.
public class UserService {

    @Autowired // Spring이 이 필드에 UserRepository의 인스턴스를 자동으로 주입해줍니다.
    private UserRepository userRepository; // UserRepository를 주입받아 데이터베이스와 상호작용을 합니다.

    // 사용자 ID로 사용자 검색
    public Optional<User> findUserById(Long id) {
        // UserRepository의 findById 메서드를 호출하여 ID로 사용자를 조회합니다.
        // 반환값은 Optional로 감싸져 있어서, 사용자가 존재하지 않을 경우를 안전하게 처리할 수 있습니다.
        return userRepository.findById(id);
    }
}
