package com.springproject.demo.ServiceMain.ServiceMainImpl;

import com.springproject.demo.Repository.RoleRepository;
import com.springproject.demo.ServiceMain.RoleService;
import com.springproject.demo.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role getRole(String roleName) {
 Role role =roleRepository.findByRoleName(roleName);
 if(role == null){
     throw new RuntimeException("Role not found");
 }
 return role;

    }
}
