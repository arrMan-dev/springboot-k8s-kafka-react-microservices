package com.arrisdev.departmentservice.service;

import com.arrisdev.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(Long id);
    List<DepartmentDto> getAllDepartments();
}
