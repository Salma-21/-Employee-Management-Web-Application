package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Employee.KnownLanguage;
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
    public ResponseEntity<String> addEmployee(@RequestParam("EmployeeID") int EmployeeID,
            @RequestParam(name = "FirstName") String FirstName,
            @RequestParam(name = "LastName") String LastName,
            @RequestParam(name = "Designation") String Designation,
            @RequestParam(name = "languageName1") String languageName1,
            @RequestParam(name = "languageName2") String languageName2,
            @RequestParam(name = "languageName3") String languageName3,
            @RequestParam(name = "scoreOutof1001") String scoreOutof1001,
            @RequestParam(name = "scoreOutof1002") String scoreOutof1002,
            @RequestParam(name = "scoreOutof1003") String scoreOutof1003) {

        Employee employee = new Employee();
        employee.setEmployeeID(Integer.toString(EmployeeID));
        employee.setFirstName(FirstName);
        employee.setLastName(LastName);
        employee.setDesignation(Designation);

        List<KnownLanguage> knownLanguages = new ArrayList<>();

        KnownLanguage l1 = new KnownLanguage();
        l1.setLanguageName(languageName1);
        l1.setScoreOutof100(Integer.parseInt(scoreOutof1001));
        KnownLanguage l2 = new KnownLanguage();
        l2.setLanguageName(languageName2);
        l2.setScoreOutof100(Integer.parseInt(scoreOutof1002));
        KnownLanguage l3 = new KnownLanguage();
        l3.setLanguageName(languageName3);
        l3.setScoreOutof100(Integer.parseInt(scoreOutof1003));
        knownLanguages.add(l1);
        knownLanguages.add(l2);
        knownLanguages.add(l3);

        employee.setKnownLanguages(knownLanguages);

        employees.add(employee);
        saveEmployeesToJsonFile();

        return ResponseEntity.ok("Employee added successfully");
    }


}