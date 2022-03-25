package com.bikash.springjpa.responsemessage.ApiDataResponseMessage;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiResponse {
    private String apiName;
    private String apiData;
    private int id;
}
