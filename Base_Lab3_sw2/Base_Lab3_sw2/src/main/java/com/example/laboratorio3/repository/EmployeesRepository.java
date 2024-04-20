package com.example.laboratorio3.repository;


import com.example.laboratorio3.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeesRepository extends JpaRepository<Employee,Integer> {


}
