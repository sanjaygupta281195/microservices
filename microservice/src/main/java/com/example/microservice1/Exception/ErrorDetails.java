package com.example.microservice1.Exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class ErrorDetails {

    private String errMsg;
    private String errCode;
    private Date timeStamp;
}
