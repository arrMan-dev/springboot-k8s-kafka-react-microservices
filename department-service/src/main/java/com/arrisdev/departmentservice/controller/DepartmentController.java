package com.arrisdev.departmentservice.controller;

import com.arrisdev.departmentservice.dto.DepartmentDto;
import com.arrisdev.departmentservice.service.impl.DepartmentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentServiceImpl impl;

    @PostMapping("/save")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(impl.saveDepartment(departmentDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable Long id){
        return ResponseEntity.ok(impl.getDepartmentById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DepartmentDto>> getAllEmployees(){
        return ResponseEntity.ok(impl.getAllDepartments());
    }

}
