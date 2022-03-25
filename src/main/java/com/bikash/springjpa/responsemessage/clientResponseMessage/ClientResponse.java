package com.bikash.springjpa.responsemessage.clientResponseMessage;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientResponse {
    private String name;
    private String dateCreated;

}
