package com.crud.library.repository.user;

import com.crud.library.domain.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserRepositoryTestSuite {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testUserRepositorySave() {
        //Given
        LocalDate date = LocalDate.of(2025,2,15);

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

    @Test
    void testGetUserByNickName() {
        //Given
        //When
        User user = userRepository.getUserByNickName("narciarz_99");

        //Then
        assertEquals("Małysz", user.getLastName());
    }

}
