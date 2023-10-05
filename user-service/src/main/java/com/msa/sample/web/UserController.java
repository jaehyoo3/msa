package com.msa.sample.web;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.msa.sample.service.UserService;
import com.msa.sample.service.dto.UserReq;
import com.msa.sample.service.dto.UserRes;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	//회원가입
    @PostMapping("/join")
    public void createUser(@RequestBody UserReq user){
    	userService.userSave(user);
    }
    
    //유저리스트
    @GetMapping("/list")
    public List<UserRes> getUesrList(Pageable page) {
    	return userService.getUserList(page).getContent();
    }
    
    //유저아이디
    @GetMapping("/{userId}")
    public UserRes getUser(@PathVariable("userId") String userId) {
    	return userService.getUser(userId);
    }
}
