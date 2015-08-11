package com.almabani.common.enums;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class EnumTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args){
				
		Class[] enums = {Active.class, DocumentType.class, 
						EmployeeContractType.class, EmployeeType.class,
						Gender.class, MaritalStatus.class};
		
		Map memoryEnumBundle = new HashMap<String, String>();
		
		for(Class clazz: enums){
			addKeysAndValues(clazz, memoryEnumBundle);
		}
		
		Iterator entries = memoryEnumBundle.entrySet().iterator();
		while (entries.hasNext()) {
		  Entry thisEntry = (Entry) entries.next();
		  Object key = thisEntry.getKey();
		  Object value = thisEntry.getValue();
		  System.out.println("key: " + key + " value: " + value);
		}
		
	}
	
	public static <T extends Enumable, S extends Map<String, String>> S addKeysAndValues(Class<T> type, S bundle) {
        for (T t : type.getEnumConstants()) {
        	bundle.put(t.getKey(), t.getValue());
        }
        return bundle;
    }
}
