package com.bikash.springjpa.responsemessage.loginresponse;

import com.sun.net.httpserver.Authenticator;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginResponse {
    private int code;
    private String message;
    private String success;
}
