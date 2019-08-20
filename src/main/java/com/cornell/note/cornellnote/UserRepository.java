package com.cornell.note.cornellnote;

import com.cornell.note.cornellnote.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    //create a new method to find user by email
    UserEntity findByEmail(String email);
}
