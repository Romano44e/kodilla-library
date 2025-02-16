package com.crud.library.repository.user;

import com.crud.library.domain.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> getAllByFirstName(String firstName);

    User save(User user);

    User getUserByNickName(String nickName);

}
