package com.msa.sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.msa.sample.domain.User;
import com.msa.sample.repository.UserRepository;
import com.msa.sample.service.dto.OrderRes;
import com.msa.sample.service.dto.UserReq;
import com.msa.sample.service.dto.UserRes;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
    }
    
    @Transactional
    public void userSave(UserReq userReq) {
    	User user = User.builder()
    			.email(userReq.getEmail())
    			.encryptedPwd(passwordEncoder.encode(userReq.getEncryptedPwd()))
    			.userId(userReq.getUserId())
    			.name(userReq.getName())
    			.build();
    	
    	userRepository.save(user);
    }
    
    @Transactional(readOnly = true)
    public Page<UserRes> getUserList(Pageable pageable) {
    	return userRepository.findAll(pageable).map(UserRes::getAllUser);
    }
    
    public UserRes getUser(String userId) {
    	User user = userRepository.findByuserId(userId).orElseThrow(() -> new IllegalArgumentException("user doesn't exist"));
    	
    	List<OrderRes> orders = new ArrayList<>();
    	
    	return UserRes.builder()
    			.userId(user.getUserId())
    			.name(user.getName())
    			.orders(orders)
    			.email(user.getEmail())
    			.build();
    }
    
    
}
