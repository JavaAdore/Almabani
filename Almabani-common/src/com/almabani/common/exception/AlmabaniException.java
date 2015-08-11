package com.almabani.common.exception;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

public class AlmabaniException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String key;
	
	public Set<String> getParameters() {
		return parameters;
	}

	public void setParameters(Set<String> parameters) {
		this.parameters = parameters;
	}

	private Set<String> parameters;

	public AlmabaniException() {
	}

	public AlmabaniException(String key) {
		this.key = key;
	}

	public AlmabaniException(Throwable cause, String key) {
		super(cause);
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public void attachParameter(String param)
	{
		if(parameters==null)
		{
			parameters = new LinkedHashSet<String>();
		}
		parameters.add(param);
	}

}
