package com.example.demo;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class EmployeeSerializer extends JsonSerializer<Employee> {
    @Override
    public void serialize(Employee employee, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeStartObject();

        // Write properties in the desired order
        jsonGenerator.writeStringField("FirstName", employee.getFirstName());
        jsonGenerator.writeStringField("LastName", employee.getLastName());
        jsonGenerator.writeStringField("EmployeeID", employee.getEmployeeID());
        jsonGenerator.writeStringField("Designation", employee.getDesignation());
        jsonGenerator.writeObjectField("knownLanguages", employee.getKnownLanguages());

        jsonGenerator.writeEndObject();
    }
}

