package com.example.laboratorio3.controller;

import com.example.laboratorio3.entity.Employee;
import com.example.laboratorio3.repository.EmployeesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    final EmployeesRepository employeesRepository;

    public EmployeeController(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @GetMapping("/listar")
    public String listaEmployee(Model model){
        List<Employee> employeeList = employeesRepository.findAll();

        model.addAttribute("listaEmpleados", employeeList);

        return "employee/lista";
    }

    @GetMapping("/new")
    public String nuevoEmployeeForm( ) {
        return "employee/newFrm";
    }

    @PostMapping("/guardar")
    public String guardarEmployee(Employee employee) {
        employeesRepository.save(employee);
        return "redirect:/employee/listar";
    }


    @GetMapping("/editar")
    public String editarEmployee(Model model,
                                 @RequestParam("id") int id) {
        Optional<Employee> optionalEmployee = employeesRepository.findById(id);

        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            model.addAttribute("empleador", employee);
            return "employee/editFrm";
        } else{
            return "redirect:/employee/listar";
        }

    }

    @GetMapping("/borrar")
    public String borrarEmpleado(Model model,
                                 @RequestParam("id") int id) {

        Optional<Employee> optionalEmployee = employeesRepository.findById(id);

        if(optionalEmployee.isPresent()){
            employeesRepository.deleteById(id);
        }
        return "redirect:/employee/listar";

    }

    //COMPLETAR

}
