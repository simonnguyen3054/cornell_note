//use to convert incoming JSON formatted data into Java class
package com.cornell.note.cornellnote.ui.model.request;

import lombok.Data;

@Data
public class UserDetailsRequestModel { //this is a request model => what we need from the front end

    private String firstName;
    private String lastName;
    private String email;
    private String password;


}
