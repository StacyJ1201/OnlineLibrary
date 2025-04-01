package com.synergisticit.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class User {
	
	@Id   //Specifies the primary key of an entity. 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer  userId;
	
	private String  username;
	
	private String  password;
	
	private String  email;
	
	@ManyToMany
	@JoinTable(name="user_role",
		joinColumns= {@JoinColumn(name="user_id")},
		inverseJoinColumns= {@JoinColumn(name="role_id")}
	)
	List<Role> roles = new ArrayList<>();

}
