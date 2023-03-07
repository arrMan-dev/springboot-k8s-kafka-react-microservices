package com.arrisdev.employeeservice.mapper;

import com.arrisdev.employeeservice.dto.EmployeeDto;
import com.arrisdev.employeeservice.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoMapper {

    AutoMapper MAPPER = Mappers.getMapper(AutoMapper.class);
    EmployeeDto mapToDepartmentDto(Employee employee);
    Employee mapToDepartment(EmployeeDto employeeDto);
}
