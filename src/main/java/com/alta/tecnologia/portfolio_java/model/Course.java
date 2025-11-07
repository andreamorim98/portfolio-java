package com.alta.tecnologia.portfolio_java.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@SQLDelete(sql = "UPDATE Course SET status = 'inactive' WHERE id = ?")
@Where(clause = "status = 'active'")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotNull(message = "name must not be null")
    @NotBlank(message = "name must not be blank")
    // @Length(min=5, max = 100, message = "name must be between 5 and 100 characters")
    @Size(max = 100, message = "name must be at most 100 characters")
    private String name;
    
    @Column(length = 10, nullable = false)
    @NotNull(message = "category must not be null")
    @NotBlank(message = "category must not be blank")
    @Size(max = 10, message = "category must be at most 10 characters")
    // @Length(max = 10, message = "category must be at most 10 characters")
    @Pattern(regexp = "front-end|back-end", message = "category must be one of the following: front-end, back-end")
    private String category;

       
    @Column(length = 10, nullable = false)
    @NotNull(message = "status must not be null")
    @NotBlank(message = "status must not be blank")
    @Size(max = 10, message = "status must be at most 10 characters")
    @Pattern(regexp = "active|inactive", message = "status must be one of the following: active, inactive")
    @JsonIgnore
    private String status = "active";

}
