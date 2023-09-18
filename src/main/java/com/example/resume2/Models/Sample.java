package com.example.resume2.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String path;
    private String save_type;
    private int step_amount;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "template_templateParts",
            joinColumns = {@JoinColumn(name = "template_id")},
            inverseJoinColumns = {@JoinColumn(name = "template_part_id")}
    )
    private List<TemplatePart> template_parts;

    @OneToMany(mappedBy = "template")
    private List<Resume> resumes;
}
