package com.arrisdev.departmentservice.service.impl;

import com.arrisdev.departmentservice.dto.DepartmentDto;
import com.arrisdev.departmentservice.mapper.AutoMapper;
import com.arrisdev.departmentservice.model.Department;
import com.arrisdev.departmentservice.repository.DepartmentRepository;
import com.arrisdev.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository repository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
  //      Optional<Department> departmentExist = repository.findById(departmentDto.getId());
 //       if (departmentExist.isPresent()) throw new EmailExistException("Email already Exists for User: " + userDto.getId());
        Department department = AutoMapper.MAPPER.mapToDepartment(departmentDto);
        Department savedDepartment = repository.save(department);
        DepartmentDto dto = AutoMapper.MAPPER.mapToDepartmentDto(savedDepartment);
        return dto;
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Optional<Department> optionalDepartment = repository.findById(id);
        if (optionalDepartment.isPresent())
            return AutoMapper.MAPPER.mapToDepartmentDto(optionalDepartment.get());
        else return null;
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = repository.findAll();
        return departments.stream().map(AutoMapper.MAPPER::mapToDepartmentDto)
                .collect(Collectors.toList());
    }
}


