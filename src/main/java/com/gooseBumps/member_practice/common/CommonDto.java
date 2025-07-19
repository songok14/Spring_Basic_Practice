package com.gooseBumps.member_practice.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CommonDto {
    private Object result;
    private int statusCode;
    private String statusMessage;
}