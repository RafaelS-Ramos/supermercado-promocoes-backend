package com.iiw.supermercado.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.iiw.supermercado.dto.employee.EmployeeCreateDTO;
import com.iiw.supermercado.dto.employee.EmployeeResponseDTO;
import com.iiw.supermercado.dto.employee.EmployeeUpdateDTO;
import com.iiw.supermercado.service.EmployeeService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponseDTO create(@RequestBody @Valid EmployeeCreateDTO dto) {
        return employeeService.create(dto);
    }
    
    @GetMapping
    public List<EmployeeResponseDTO> findAll() {
        return employeeService.findAll();
    }
    
    @GetMapping("/{id}")
    public EmployeeResponseDTO findById(@PathVariable String id) {
        return employeeService.findById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDTO update(@PathVariable String id, @RequestBody @Valid EmployeeUpdateDTO dto) {
        return employeeService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        employeeService.delete(id);
    }
}
