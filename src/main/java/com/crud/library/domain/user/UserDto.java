package com.crud.library.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class UserDto {

    private int id;
    private String firstName;
    private String lastName;
    private Date accountCreationDate;
    private String nickName;


}
