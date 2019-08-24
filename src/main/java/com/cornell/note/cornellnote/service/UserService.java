package com.cornell.note.cornellnote.service;

import com.cornell.note.cornellnote.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user); //this method creates a user and return the UserDTO
}

//Note about Service
//Service objects are doing the work that the application needs to do for the domain you're working with.
// It involves calculations based on inputs and stored data,
// validation of any data that comes in from the presentation,
// and figuring out exactly what data source logic to dispatch,
// depending on commands received from the presentation.
