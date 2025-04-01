package com.synergisticit.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Role {
	
	@Id   //Specifies the primary key of an entity. 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer  roleId;
	
	@NonNull
	private String  rolename;
	
	
	@ManyToMany(mappedBy="roles")
	List<User>  users = new ArrayList<>();
}
