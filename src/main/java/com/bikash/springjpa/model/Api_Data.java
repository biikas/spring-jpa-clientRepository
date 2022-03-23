package com.bikash.springjpa.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="api_data")
public class Api_Data {
    //id as primary key
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="api_name")
    private String api_name;

    @Column(name="api_data")
    private String api_data;

    @OneToOne
    @JoinColumn(name="client_id")
    private Client client;

}
