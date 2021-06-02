package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonToMap {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Map<String, String> dataMap = new HashMap<String,String>();
		ObjectMapper objMapper = new ObjectMapper();
		
		objMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		byte[] data = Files.readAllBytes(Paths.get("data.txt"));
		dataMap = objMapper.readValue(data, HashMap.class);
		System.out.println("Map using HashMap: "+dataMap);
		
		dataMap = objMapper.readValue(data, new TypeReference<HashMap<String,String>>() {});
		System.out.println("Map using TypeRefernce: "+dataMap);

	}

}
