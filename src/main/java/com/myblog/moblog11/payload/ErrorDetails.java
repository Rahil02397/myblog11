package com.myblog.moblog11.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorDetails {

    private String message;
    private Date date;

    private String uri;
}
