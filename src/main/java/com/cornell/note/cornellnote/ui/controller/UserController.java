package com.cornell.note.cornellnote.ui.controller;

import com.cornell.note.cornellnote.service.UserService;
import com.cornell.note.cornellnote.shared.dto.UserDto;
import com.cornell.note.cornellnote.ui.model.request.UserDetailsRequestModel;
import com.cornell.note.cornellnote.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") //mapping web requests onto methods in request-handling. ex: /users
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser() {
        return "get user";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {

        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto); //controller will call the method from UserService to create the user
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue; //we return only the fields from UserRest model
    }

    @PutMapping
    public String updateUser() {
        return "update user";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user";
    }

}
