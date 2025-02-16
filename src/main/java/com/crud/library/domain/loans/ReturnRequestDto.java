package com.crud.library.domain.loans;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReturnRequestDto {

    private int signature;
    private String nickName;

}
