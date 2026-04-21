package com.iiw.supermercado.service;

import com.iiw.supermercado.dto.employee.EmployeeResponseDTO;
import com.iiw.supermercado.dto.employee.EmployeeUpdateDTO;
import com.iiw.supermercado.dto.employee.EmployeeCreateDTO;
import java.util.List;

public interface EmployeeService {
    EmployeeResponseDTO create(EmployeeCreateDTO dto);

    List<EmployeeResponseDTO> findAll();

    EmployeeResponseDTO findById(String id);

    EmployeeResponseDTO update(String id, EmployeeUpdateDTO dto);

    void delete(String id);
}
