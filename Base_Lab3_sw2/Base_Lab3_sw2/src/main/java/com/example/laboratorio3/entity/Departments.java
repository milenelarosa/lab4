package com.example.laboratorio3.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter
    @Column(name="department_id", nullable = false)
    private Integer departmentid;

    @Getter @Setter @Column(name="department_name", nullable = false, length = 40)
    private String nombredepartamento;

}
