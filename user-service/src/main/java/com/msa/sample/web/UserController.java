package com.msa.sample.web;

import org.springframework.web.bind.annotation.*;

import com.msa.sample.service.UserService;
import com.msa.sample.service.dto.UserReq;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
    @PostMapping("/users")
    public void createUser(@RequestBody UserReq user){
    	userService.userSave(user);
    }
}
