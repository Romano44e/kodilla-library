package com.crud.library.domain.loans;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class BorrowResponseDto {

    private int copyOfBookId;
    private int userId;
    private LocalDate borrowDate;

}
