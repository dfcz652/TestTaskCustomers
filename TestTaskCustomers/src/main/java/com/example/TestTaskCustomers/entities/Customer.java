package com.example.TestTaskCustomers.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Builder
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    @Length(min = 2, max = 50)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @Length(min = 2, max = 100)
    private String email;

    @Column(name = "phone")
    @Pattern(regexp = "\\+[0-9]{5,13}")
    private String phone;

    @Column(name = "is_active", nullable = false)
    @JsonIgnore
    private Boolean isActive;
}
