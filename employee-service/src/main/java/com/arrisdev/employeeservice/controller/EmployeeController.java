package com.arrisdev.employeeservice.controller;

import com.arrisdev.employeeservice.dto.AppResponseDto;
import com.arrisdev.employeeservice.dto.EmployeeDto;
import com.arrisdev.employeeservice.service.impl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeServiceImpl impl;

    @PostMapping("/save")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(impl.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppResponseDto> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(impl.getEmployeeById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return ResponseEntity.ok(impl.getAllEmployees());
    }
}
