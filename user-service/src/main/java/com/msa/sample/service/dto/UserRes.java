package com.msa.sample.service.dto;

import java.util.List;

import com.msa.sample.domain.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRes {
    private String email;
    private String name;
    private String userId;
    
    private List<OrderRes> orders;
    
    public static UserRes getAllUser(User user) {
    	return UserRes.builder()
    			.email(user.getEmail())
    			.name(user.getName())
    			.userId(user.getUserId())
    			.build();
    }
}
