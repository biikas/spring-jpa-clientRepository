package com.bikash.springjpa.model;

import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "client")
public class Client {

    //Id as primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "active")
    private Character active;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "username", length = 100, nullable = false)
    private String username;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="recorded_date",nullable = false)
    private Date recorded_date;

}
