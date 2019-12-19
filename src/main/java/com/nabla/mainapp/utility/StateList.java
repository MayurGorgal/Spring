package com.nabla.mainapp.utility;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class StateList 
{
	
	public Map<String,String> getAllStateList()
	{
		
		LinkedHashMap<String, String>stateList=new LinkedHashMap<String, String>();
		stateList.put("MH","Maharashtra");
		stateList.put("GA","GOA");
		stateList.put("RAJ","Rajasthan");
		stateList.put("KA", "Karnataka");
		return stateList;
	}
}
