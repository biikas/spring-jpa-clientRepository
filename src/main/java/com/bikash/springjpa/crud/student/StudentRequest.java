package com.bikash.springjpa.crud.student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String contactNumber;
    private String subjectName;
    private String email;
    private Character active;
}
