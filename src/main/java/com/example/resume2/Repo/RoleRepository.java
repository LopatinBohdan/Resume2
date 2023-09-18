package com.example.resume2.Repo;

import com.example.resume2.Models.Role;
import com.example.resume2.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleTitle(String title);
}
