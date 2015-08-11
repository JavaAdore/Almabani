package com.almabani.common.comprator;

import java.util.Comparator;

import com.almabani.common.entity.schema.admincor.Country;

public class CountryNameComprator implements Comparator<Country> {

	@Override
	public int compare(Country o1, Country o2) {
//		if(Utils.isNotNull(o1) && Utils.isNotNull(o2)){
//		return o1.getCountryName().compareToIgnoreCase(o2.getCountryName());
//		}  
		return 0;
	}

}
