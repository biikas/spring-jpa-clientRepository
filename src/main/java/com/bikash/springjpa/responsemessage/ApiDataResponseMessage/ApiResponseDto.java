package com.bikash.springjpa.responsemessage.ApiDataResponseMessage;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiResponseDto {

    private boolean success;
    private int code;
    private String message;
    private ApiResponse apiResponse;
}
