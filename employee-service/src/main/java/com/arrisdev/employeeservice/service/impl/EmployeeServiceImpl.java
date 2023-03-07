package com.arrisdev.employeeservice.service.impl;

import com.arrisdev.employeeservice.dto.AppResponseDto;
import com.arrisdev.employeeservice.dto.DepartmentDto;
import com.arrisdev.employeeservice.dto.EmployeeDto;
import com.arrisdev.employeeservice.exception.ResourceNotFoundException;
import com.arrisdev.employeeservice.mapper.AutoMapper;
import com.arrisdev.employeeservice.model.Employee;
import com.arrisdev.employeeservice.repository.EmployeeRepository;
import com.arrisdev.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;
    private RestTemplate template;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
//        Optional<Employee> emailExist = repository.findByEmail(userDto.getEmail());
//        if (emailExist.isPresent()) throw new EmailExistException("Email already Exists for User: " + userDto.getId());
        Employee employee = AutoMapper.MAPPER.mapToDepartment(employeeDto);
        Employee savedEmployee = repository.save(employee);
        EmployeeDto dto = AutoMapper.MAPPER.mapToDepartmentDto(savedEmployee);
        return dto;
    }

    @Override
    public AppResponseDto getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = repository.findById(id);
        if (optionalEmployee.isPresent()) {
            EmployeeDto dto = AutoMapper.MAPPER.mapToDepartmentDto(optionalEmployee.get());
          ResponseEntity<DepartmentDto> departmentDto = template.getForEntity("http://localhost:9000/api/departments/" + optionalEmployee.get().getId(), DepartmentDto.class);
//            DepartmentDto departmentDto = webClient.get().uri("http://localhost:9000/api/departments/" + optionalEmployee.get().getId())
//                    .retrieve()
//                    .bodyToMono(DepartmentDto.class).block();
            AppResponseDto response = new AppResponseDto();
            response.setEmployeeDto(dto);
            response.setDepartmentDto(departmentDto.getBody());
            return response;
            //return AutoMapper.MAPPER.mapToDepartmentDto(optionalEmployee.get());
        }
        else throw new ResourceNotFoundException("User", "id", id);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = repository.findAll();
        return employees.stream().map(AutoMapper.MAPPER::mapToDepartmentDto)
                .collect(Collectors.toList());
    }
}
