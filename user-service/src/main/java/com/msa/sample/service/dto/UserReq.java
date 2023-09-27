package com.msa.sample.service.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserReq {
    private String email;
    private String name;
    private String userId;
    private LocalDate createAt;

    private String encryptedPwd;
    
}
