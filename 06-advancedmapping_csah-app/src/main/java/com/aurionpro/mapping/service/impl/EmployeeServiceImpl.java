package com.aurionpro.mapping.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.aurionpro.mapping.dto.EmployeeDTO;
import com.aurionpro.mapping.dto.PageResponse;
import com.aurionpro.mapping.entity.Employee;
import com.aurionpro.mapping.repository.EmployeeRepository;
import com.aurionpro.mapping.service.EmployeeService;
import com.aurionpro.mapping.util.EntityToDTOConverter;
import com.aurionpro.mapping.util.DTOToEntityConverter;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(EntityToDTOConverter::convertToEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PageResponse<EmployeeDTO> getEmployees(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Employee> employeesPage = employeeRepository.findAll(pageable);
        List<EmployeeDTO> content = employeesPage.getContent().stream()
                .map(EntityToDTOConverter::convertToEmployeeDTO)
                .collect(Collectors.toList());
        return new PageResponse<>(employeesPage.getTotalPages(), employeesPage.getSize(), employeesPage.getTotalElements(), employeesPage.isLast(), content);
    }

    @Override
    public EmployeeDTO getEmployeeById(int employeeId) {
        return employeeRepository.findById(employeeId)
                .map(EntityToDTOConverter::convertToEmployeeDTO)
                .orElse(null);
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = DTOToEntityConverter.convertToEmployee(employeeDTO);
        return EntityToDTOConverter.convertToEmployeeDTO(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = DTOToEntityConverter.convertToEmployee(employeeDTO);
        return EntityToDTOConverter.convertToEmployeeDTO(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
