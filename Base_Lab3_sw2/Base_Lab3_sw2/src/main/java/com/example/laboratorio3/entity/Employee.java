package com.example.laboratorio3.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name="employee_id", nullable = false)
    private Integer idemployee;

    @Getter @Setter @Column(name="first_name", nullable = false, length = 40)
    private String nombreempleado;

    @Getter @Setter @Column(name="last_name", nullable = false, length = 40)
    private String apellidoempleado;

    @Getter @Setter @Column(name="email", nullable = false, length = 40)
    private String email;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departments;


}