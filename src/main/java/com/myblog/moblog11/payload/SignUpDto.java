package com.myblog.moblog11.payload;

import lombok.Data;

@Data
public class SignUpDto {
    private String user;
    private String username;
    private String email;
    private String password;
}
