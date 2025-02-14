package com.crud.library.controller;


import com.crud.library.domain.user.User;
import com.crud.library.domain.user.UserDto;
import com.crud.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/library/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "{userId}")
    public UserDto getUser(@PathVariable int userId) {
        return new UserDto(1, "Roman", "Adamczyk", new Date());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        java.sql.Date date = new java.sql.Date(userDto.getAccountCreationDate().getTime());
//        userDto.getAccountCreationDate();

        User user = new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), date);

        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

}
