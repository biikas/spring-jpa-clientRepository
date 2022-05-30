package com.bikash.springjpa.model;


import lombok.*;

import javax.persistence.*;

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

    @OneToOne
    @JoinColumn(name="STUDENT_ID")
    private Student student;

}
