package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.AdressDto;
import com.masai.dto.ProductDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Orders {

	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    
    
    
    private LocalDate orderDate;
    
    
    private String orderStatus;
    
    
    private Double total;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name="customer_order", joinColumns = @JoinColumn(name="order_id", referencedColumnName = "orderId"))
    private Customer customer;
    
    
    @ElementCollection
    @CollectionTable(name="product_order", joinColumns = @JoinColumn(name ="order_id", referencedColumnName = "orderId"))
    private List<ProductDto> poder = new ArrayList<>();
    
    
    @Embedded
    private AdressDto address;


	public Orders(LocalDate orderDate, String orderStatus, Double total, Customer customer, List<ProductDto> poder,
			AdressDto address) {
		super();
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.total = total;
		this.customer = customer;
		this.poder = poder;
		this.address = address;
	}


	


	
    
    
    
    
}
