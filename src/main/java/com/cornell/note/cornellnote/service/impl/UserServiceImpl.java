//business logic goes here ex: create, read, update
package com.cornell.note.cornellnote.service.impl;

import com.cornell.note.cornellnote.UserRepository;
import com.cornell.note.cornellnote.io.entity.UserEntity;
import com.cornell.note.cornellnote.service.UserService;
import com.cornell.note.cornellnote.shared.dto.UserDto;
import com.cornell.note.cornellnote.shared.dto.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired // Spring’s dependency injection wires an appropriate bean into the marked class member
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto user) {

        if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists.");

        UserEntity userEntity = new UserEntity(); //create a new userEntity => a new user object to be stored in the database
        BeanUtils.copyProperties(user, userEntity); //copy all UserDTO property over to UserEntity

        String publicUserId = utils.generateUserId(30);
        userEntity.setUserId(publicUserId);

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        UserEntity storedUserDetails = userRepository.save(userEntity); //saving userEntity into the database

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }

    @Override //have spring framework loads user info by username. loadUserByUsername is a spring framework's method
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);

        if(userEntity == null) throw new UsernameNotFoundException(email);

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }
}
