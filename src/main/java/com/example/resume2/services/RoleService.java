package com.example.resume2.services;

import com.example.resume2.Models.Role;
import com.example.resume2.Repo.RoleRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public GrantedAuthority getRoleByTitle(String title) throws RoleNotFoundException {
        Role role=roleRepository.findByRoleTitle(title);
        if(role==null){
            throw new RoleNotFoundException("Role is not found...");
        }
        return role;
    }
}
