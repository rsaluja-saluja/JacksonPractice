package com.example;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.model.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDateFormatExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Transaction tran = new Transaction("transaction", new Date());
		
		ObjectMapper objMapper = new ObjectMapper();
		String str = objMapper.writeValueAsString(tran);
		System.out.println(str); // bydefault it convert date into no of milliseconds since Jan 1 1970
		
		ObjectMapper objMapper1 = new ObjectMapper();
		objMapper1.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		String str1 = objMapper1.writeValueAsString(tran);
		System.out.println(str1); 
				
	}

}
