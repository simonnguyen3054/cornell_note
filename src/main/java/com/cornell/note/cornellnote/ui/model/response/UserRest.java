//used to convert java object outgoing into json response
package com.cornell.note.cornellnote.ui.model.response;

import lombok.Data;

@Data
public class UserRest { //this is a response model, what we'll send to the client
    private  String userId;
    private String firstName;
    private String lastName;
    private String email;
}
