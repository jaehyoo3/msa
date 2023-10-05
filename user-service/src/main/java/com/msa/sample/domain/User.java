package com.msa.sample.domain;

import lombok.*;
import java.time.LocalDate;
import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false, unique = true)
    private String encryptedPwd;
    
    private LocalDate createDate;

    @Builder
	public User(String email, String name, String userId, String encryptedPwd) {
    	this.email = email;
    	this.name = name;
    	this.userId = userId;
    	this.encryptedPwd = encryptedPwd;
    	this.createDate = LocalDate.now();
	}    
}
