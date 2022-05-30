package com.bikash.springjpa.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ACTIVE")
    private Character active;

    @Column(name = "FIRST_NAME", length = 100, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 100, nullable = false)
    private String lastName;

    @Column(name = "ADDRESS", length = 50)
    private String address;


    @Column(name="EMAIL", length =50 )
    private String email;

    @Column(name="CONTACT_NUMBER",length =50)
    private String contactNumber;

    @Column(name="SUBJECT")
    private String subject;

}
