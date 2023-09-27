package com.msa.sample.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.msa.sample.domain.User;
import com.msa.sample.repository.UserRepository;
import com.msa.sample.service.dto.UserReq;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
    }
    
    public void userSave(UserReq userReq) {
    	User user = User.builder()
    			.email(userReq.getEmail())
    			.encryptedPwd(passwordEncoder.encode(userReq.getEncryptedPwd()))
    			.userId(userReq.getEmail())
    			.name(userReq.getName())
    			.build();
    	
    	userRepository.save(user);
    }
}
