package com.almabani.common.annotataion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Bundle {

	boolean display() default true;
	String key();
	
}
