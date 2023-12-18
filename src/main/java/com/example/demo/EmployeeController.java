package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;

@Controller
@RequestMapping("/")
public class EmployeeController {
    private static final String JSON_FILE_PATH = "employees.json";
    private List<Employee> employees = new ArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping
    public ModelAndView showForm() {
        return new ModelAndView("Home");
    }

    @GetMapping("/Home")
    public ModelAndView showhome() {
        return new ModelAndView("Home");
    }

    @GetMapping("/Add")
    public ModelAndView Add() {
        return new ModelAndView("index");
    }

    public EmployeeController() {
        loadEmployeesFromJsonFile();
    }

    private void loadEmployeesFromJsonFile() {
        try {
            File file = new File(JSON_FILE_PATH);
            CollectionType typeReference = objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, Employee.class);
            employees = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveEmployeesToJsonFile() {
        try {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(JSON_FILE_PATH), employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        //employees.add(employee);
        //saveEmployeesToJsonFile();

        return ResponseEntity.ok(employee.getDesignation());
    }

}