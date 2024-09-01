package com.aurionpro.mapping.service;

import java.util.List;
import com.aurionpro.mapping.dto.EmployeeDTO;
import com.aurionpro.mapping.dto.PageResponse;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    PageResponse<EmployeeDTO> getEmployees(int pageNo, int pageSize);
    EmployeeDTO getEmployeeById(int employeeId);
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
    void deleteEmployee(int employeeId);
}
