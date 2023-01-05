package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	
	@Size(min = 3, max = 10, message = "Street no should be min 3 or max 10")
	private String streetNo;
	
	private String  bulidingName;
	
	@NotNull(message = "City cannot be null")
	@NotBlank(message = "City cannot be blank")
	@NotEmpty(message = "City cannot be null")
	private String city;
	
	@NotNull(message = "State cannot be null")
	@NotBlank(message = "State cannot be blank")
	@NotEmpty(message = "State cannot be null")
	private String state;
	
	
	@NotNull(message = "Country cannot be null")
	@NotBlank(message = "Country cannot be blank")
	@NotEmpty(message = "Country cannot be null")
	private String country;
	
	
	@Size(min = 3, max =6 , message = "Pincode should be min 3 and maximum 6")
	private String pincode;


	public Address(@Size(min = 3, max = 10, message = "Street no should be min 3 or max 10") String streetNo,
			String bulidingName,
			@NotNull(message = "City cannot be null") @NotBlank(message = "City cannot be blank") @NotEmpty(message = "City cannot be null") String city,
			@NotNull(message = "State cannot be null") @NotBlank(message = "State cannot be blank") @NotEmpty(message = "State cannot be null") String state,
			@NotNull(message = "Country cannot be null") @NotBlank(message = "Country cannot be blank") @NotEmpty(message = "Country cannot be null") String country,
			@Size(min = 3, max = 6, message = "Pincode should be min 3 and maximum 6") String pincode) {
		super();
		this.streetNo = streetNo;
		this.bulidingName = bulidingName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}


	
	
	
}
