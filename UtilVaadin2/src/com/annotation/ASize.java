package com.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ASize {

	String setX() default "-1";
	String setY() default "-1";
	
	
}
