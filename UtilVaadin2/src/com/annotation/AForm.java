package com.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.enumerations.LayoutType;
@Retention(RetentionPolicy.RUNTIME)
public @interface AForm {

String caption() default "";
ALayout layout() default @ALayout( layoutType = LayoutType.FormLayout);
boolean imediate() default true;
Class<?> clazz() ;
GenerateStrategy generateStrategy() default @GenerateStrategy();
ASize size() default @ASize(setX = "-1");

	
}
