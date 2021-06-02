package com.example;

import java.io.File;
import java.io.IOException;

import com.example.model.Employee;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIgnoreUnknownFields {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ObjectMapper objMapper = new ObjectMapper();
//		Employee emp = objMapper.readValue(new File("employeeWithLessFields.txt"), Employee.class); // No issues, print role as null, with cities it gave exception in toString
//		System.out.println(emp.toString());
		
		objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Employee emp = objMapper.readValue(new File("employeeWithExtraFields.txt"), Employee.class); //gives error for extra field bydefault 
		System.out.println(emp.toString());
	}

}
