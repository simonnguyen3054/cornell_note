package com.cornell.note.cornellnote.io.repositories;

import com.cornell.note.cornellnote.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //gives us access to methods and query to manipulate the data
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    //create a new method to find user by email
    UserEntity findByEmail(String email);
}
