package com.example.demo.entity;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_products")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty(message = "Name wouldn't be empty")
	private String name;
	private String description;
	@Positive(message = "the stock would be >0")
	private double stock;
	private double price;
	private String status;
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@NotNull(message = "category couldn't be empty")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Category category;
}
