package com.bikash.springjpa.model;


import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "SUBJECT")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ACTIVE")
    private Character active;

    @Column(name = "NAME", length = 50)
    private String name;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="STUDENT_ID")
    private Student student;



}
