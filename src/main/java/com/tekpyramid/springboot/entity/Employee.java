package com.tekpyramid.springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    @NotBlank(message = "please enter employee name")
    private String employeeName;
    @NotNull(message = "please enter D.O.B")
    private LocalDate dateOfBirth;
    @NotBlank(message = "please fill the gender")
    private String gender;
    @Email(message = "please enter proper email")
    private String email;
    @NotNull(message = "please enter phone number")
    private long phone;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee",fetch = FetchType.LAZY)
    private List<Address> address;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "employee_technology",
    joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "tech_id")
    )
    private List<Technology> technologies;




}
