package com.arrisdev.employeeservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppResponseDto {
    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;
}
