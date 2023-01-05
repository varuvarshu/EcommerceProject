package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.masai.dto.ProductDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id",referencedColumnName = "customerId")
	private Customer customer;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "carts_products", joinColumns = @JoinColumn(name ="cart_id", referencedColumnName = "cartId"))
	private List<ProductDto> products = new ArrayList<>();
	
	
	
}
