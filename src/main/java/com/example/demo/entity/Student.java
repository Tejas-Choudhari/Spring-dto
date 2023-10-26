package com.example.demo.entity;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data 
@Entity
@Table(name="StudentData")
public class Student {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotNull
	@Column(name="name")
	@Size(min=3, max=15,message = "Enter valid name , size should be more then 3 char")
	private String name;
	
	@NotNull
	@Size(min=6,max=15, message = "Invalid UserName , size should be more then 6 char")
	@Column(name="username")
	private String username;
	
	@NotNull
	@Column(name="pass")
	@Size(min =8, max =15, message = "Enter valid Password")
	private String password;
	
	 
	
//	@Size(min=10, max =11, message = "Enter valid Mobile Number")
	@Pattern(regexp = "^[0-9]{10}$",message ="Enter valid mobile number " )
	@Column(name="Mobile Number")
	private String mobileNum;

	
}
