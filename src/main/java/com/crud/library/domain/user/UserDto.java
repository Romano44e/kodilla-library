package com.crud.library.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserDto {

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate accountCreationDate;
    private String nickName;


}
