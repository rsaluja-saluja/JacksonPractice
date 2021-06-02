package com.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonTreeExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		byte[] jsonData = Files
				.readAllBytes(Paths.get("employee.txt"));

		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		//JsonNode rootNode = objectMapper.readTree(jsonData);
		JsonNode rootNode = objectMapper.readTree(new File("employee.txt"));
		System.out.println(rootNode);
		System.out.println("---id---");
		JsonNode idNode = rootNode.get("id");
		System.out.println(idNode.asInt()); // 123
		JsonNode id = rootNode.path("id");
		System.out.println(id.asInt()); // 123

		System.out.println("---PhoneNumbers---");

		JsonNode phoneNums = rootNode.path("phoneNumbers");
		System.out.println(phoneNums); // [123456,987654]
		System.out.println("1st no:"+phoneNums.get(0).asLong());

		Iterator<JsonNode> phoneNodes = phoneNums.elements();
		while (phoneNodes.hasNext()) {
			JsonNode num = phoneNodes.next();
			System.out.println(num.asLong());
		}

		System.out.println("---Address---");

		JsonNode address = rootNode.path("address");
		System.out.println(address);
		System.out.println(address.get("street").asText());
		System.out.println(address.get("city").asText());
		System.out.println(address.get("zipcode").asText());

		System.out.println("---properties---");

		JsonNode properties = rootNode.get("properties");
		System.out.println(properties);
		
		System.out.println(properties.get("age").asText());
		System.out.println(properties.get("salary").asText());


		// Modifying JSON file data
		
		//update JSON data
		((ObjectNode) rootNode).put("id", 500);
		//add new key value
		((ObjectNode) rootNode).put("test", "test value");
		//remove existing key
		((ObjectNode) rootNode).remove("role");
		((ObjectNode) rootNode).remove("properties");
		
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		objectMapper.writeValue(new File("updated_emp.txt"), rootNode);
	}

}
