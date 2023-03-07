package com.arrisdev.employeeservice.service;

import com.arrisdev.employeeservice.dto.AppResponseDto;
import com.arrisdev.employeeservice.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    AppResponseDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployees();
}
