package com.cybertek;

import java.util.HashMap;
import java.util.Map;

public class DataStroge {
	
	static Map<String,String> f = new HashMap<>();
	
	public static void addData(String key, String data) {
		f.put(key, data);
		
	}
	public String getData(String key) {
		return f.get(key);
		
		
	}
	public static void main (String[] args) {
		addData("A", "sfdgdf");
		addData("B", "dgfdfgh");
		addData("C", "hgjbdfgngnffg");
		System.out.println(f);
	}

		
	}
	
	


