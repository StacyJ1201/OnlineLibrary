package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.Role;

public interface RoleService {
     Role save(Role role);
     Role findById(int roleId);
     List<Role> findAll();
     void deleteById(int roleId);
     
}
