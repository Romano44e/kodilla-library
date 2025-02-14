package com.crud.library.service;

import com.crud.library.domain.user.User;
import com.crud.library.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

}
