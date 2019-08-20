//use to convert incoming JSON formatted data into Java class
package com.cornell.note.cornellnote.ui.model.request;

import lombok.Data;

@Data
public class UserDetailsRequestModel {

    private String firstName;
    private String lastName;
    private String email;
    private String password;


}
