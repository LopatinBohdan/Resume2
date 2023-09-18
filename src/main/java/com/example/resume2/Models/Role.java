package com.example.resume2.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String title;
    @Transient
    @ManyToMany(mappedBy = "roles")
    List<User> users;

    public Role(Long id){
        this.id = id;
    }

    public Role(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String getAuthority() {
        return null;
    }

}
