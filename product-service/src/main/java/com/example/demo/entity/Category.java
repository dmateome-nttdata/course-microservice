package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_categories")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
	
	
}
