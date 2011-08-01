package com.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.enumerations.LayoutType;
@Retention(RetentionPolicy.RUNTIME)
public @interface AForm {

String caption() default "";
ALayout layout() default @ALayout( layoutType = LayoutType.FormLayout);
boolean imediate() default true;
Class<?> clazz() default String.class;
GenerateStrategy generateStrategy() default @GenerateStrategy();

	
}
