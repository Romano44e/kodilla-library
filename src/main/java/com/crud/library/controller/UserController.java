package com.crud.library.controller;


import com.crud.library.domain.user.User;
import com.crud.library.domain.user.UserDto;
import com.crud.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/library/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {

        User user = new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), LocalDate.now(), userDto.getNickName());

        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

}
