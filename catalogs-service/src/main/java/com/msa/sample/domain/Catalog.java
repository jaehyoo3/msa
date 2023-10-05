package com.msa.sample.domain;

import java.io.Serializable;
import lombok.*;
import java.time.LocalDateTime;

import javax.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Table(name = "catalog")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Catalog implements Serializable  {
	  private static final long serialVersionUID = 1L;
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;
	  
	  @Column(nullable = false, unique = true)
	  private String productId;

	  private String productName;
	  
	  private Integer stock;
	  
	  private Integer unitPrice;
	  
	  @CreatedDate
	  private LocalDateTime createdAt;
	  

}
