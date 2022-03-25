package com.bikash.springjpa.responsemessage.ApiDataResponseMessage;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiBaseRespons {
    private boolean success;
    private String message;
    private int code;
    private List<ApiResponse> apiDetails;
}
