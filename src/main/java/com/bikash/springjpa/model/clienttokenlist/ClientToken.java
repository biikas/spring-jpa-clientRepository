package com.bikash.springjpa.model.clienttokenlist;


import com.bikash.springjpa.model.Client;
import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "clientToken")
public class ClientToken {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String token;

    @OneToOne
    @JoinColumn(name="client_id")
    private Client client;

    @Column(name="status")
    private char active;

}
