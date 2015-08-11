package com.almabani.common.dto.menu;

import java.io.Serializable;
import java.util.ArrayList;

public class Module  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int moduleNumber;
	private String moduleName;
	
	private ArrayList<SubModule> subModules;

	






	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public int getModuleNumber() {
		return moduleNumber;
	}

	public void setModuleNumber(int moduleNumber) {
		this.moduleNumber = moduleNumber;
	}

	public ArrayList<SubModule> getSubModules() {
		return subModules;
	}

	public void setSubModules(ArrayList<SubModule> subModules) {
		this.subModules = subModules;
	}
	
	
	
	
}
