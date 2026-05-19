package com.project.fitness.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    @CreationTimestamp
    private LocalDateTime createAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;

    @OneToMany(mappedBy="user" , cascade = CascadeType.ALL,orphanRemoval = true)// when user remove form DB ,then all activity remove form DB(TRUE)
    @JsonIgnore
    private List<Activity> activities=new ArrayList<>();


     @OneToMany(mappedBy="user" , cascade = CascadeType.ALL,orphanRemoval = true)// when user remove form DB ,then all activity remove form DB(TRUE)
     @JsonIgnore
    private List<Recommendation> recommendations=new ArrayList<>();
}
