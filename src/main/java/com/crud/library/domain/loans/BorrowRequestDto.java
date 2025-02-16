package com.crud.library.domain.loans;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BorrowRequestDto {

    private String title;
    private String nickName;

}
