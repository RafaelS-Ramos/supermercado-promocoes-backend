package com.iiw.supermercado.security;

import com.iiw.supermercado.model.Employee;
import com.iiw.supermercado.repository.EmployeeRepository;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsService implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    public EmployeeDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("Funcionário não encontrado com email " + email));

        return new User(
            employee.getEmail(),
            employee.getPassword(), 
            List.of(new SimpleGrantedAuthority("Função_" + employee.getRole()))
        );
    }
}
