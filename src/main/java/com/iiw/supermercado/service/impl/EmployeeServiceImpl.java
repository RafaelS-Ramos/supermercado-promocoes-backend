package com.iiw.supermercado.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iiw.supermercado.dto.employee.EmployeeCreateDTO;
import com.iiw.supermercado.dto.employee.EmployeeResponseDTO;
import com.iiw.supermercado.dto.employee.EmployeeUpdateDTO;
import com.iiw.supermercado.service.EmployeeService;
import com.iiw.supermercado.exception.ResourceNotFoundException;
import com.iiw.supermercado.model.Employee;
import com.iiw.supermercado.repository.EmployeeRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public EmployeeResponseDTO create(EmployeeCreateDTO dto) {
        Employee employee = new Employee();
        employee.setName(dto.name());
        employee.setCpf(dto.cpf());
        employee.setEmail(dto.email());
        employee.setPassword(passwordEncoder.encode(dto.password()));
        employee.setRole(dto.role());

        Employee savedEmployee = employeeRepository.save(employee);
        return toReponseDTO(savedEmployee);
    }

    @Override
    public List<EmployeeResponseDTO> findAll() {
        return employeeRepository
        .findAll()
        .stream()
        .map(this::toReponseDTO)
        .toList();
    }

    @Override
    public EmployeeResponseDTO findById(String id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado com o id: " + id));

        return toReponseDTO(employee);
    }

    @Override
    public EmployeeResponseDTO update(String id, EmployeeUpdateDTO dto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado com o id: " + id));

        employee.setName(dto.name());
        employee.setCpf(dto.cpf());
        employee.setEmail(dto.email());
        employee.setPassword(passwordEncoder.encode(dto.password()));
        employee.setRole(dto.role());

        Employee updateEmployee = employeeRepository.save(employee);
        return toReponseDTO(updateEmployee);
    }

    @Override
    public void delete(String id) {
        Employee employee = employeeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado com o id: " + id));

        employeeRepository.delete(employee);
    }

    private EmployeeResponseDTO toReponseDTO(Employee employee) {
        return new EmployeeResponseDTO(
            employee.getId(),
            employee.getName(),
            employee.getCpf(),
            employee.getEmail(),
            employee.getRole()
        );
    }
}