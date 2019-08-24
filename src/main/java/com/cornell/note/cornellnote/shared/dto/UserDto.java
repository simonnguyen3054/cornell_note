package com.cornell.note.cornellnote.shared.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = -6064508903786457907L;
    private String id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String encryptedPassword;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus = false;

}


//Note about DTO
//DTO is an object that carries data between processes.
// When you're working with a remote interface, each call it is expensive.
// As a result you need to reduce the number of calls.
// The solution is to create a Data Transfer Object that can hold all the data for the call.
// It needs to be serializable to go across the connection.
// Usually an assembler is used on the server side to transfer data between the DTO and any domain objects.
// It's often little more than a bunch of fields and the getters and setters for them.