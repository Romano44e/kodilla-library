package com.crud.library.repository.user;

import com.crud.library.domain.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserRepositoryTestSuite {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testUserRepositorySave() {
        //Given
        Date date = new Date(2025, 2, 15);

        User user = new User();

        user.setFirstName("Piotr");
        user.setLastName("Nowak");
        user.setAccountCreationDate(date);

        //When
        userRepository.save(user);
        int id = user.getId();
        //Then
        assertEquals(2, id);
        //CleanUp
        userRepository.deleteById(3);

    }

}
