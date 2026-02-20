package com.example.jpa.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseEntity {
    private String title;

    @ManyToMany
    @JoinTable(name = "course_authors", joinColumns = @JoinColumn(name = "course_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "author_id", nullable = false))
    private List<Author> authors;

    @OneToMany(mappedBy = "course")
    private List<Section> sections;
}
