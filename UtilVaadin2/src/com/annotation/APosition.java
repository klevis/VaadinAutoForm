package com.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface APosition {
	int setX();
	int setY() default -1;
	int setX1() default -1;
	int setY1() default -1;
}
