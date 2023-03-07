package com.arrisdev.departmentservice.mapper;

import com.arrisdev.departmentservice.dto.DepartmentDto;
import com.arrisdev.departmentservice.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoMapper {

    AutoMapper MAPPER = Mappers.getMapper(AutoMapper.class);
    DepartmentDto mapToDepartmentDto(Department department);
    Department mapToDepartment(DepartmentDto departmentDto);
}
