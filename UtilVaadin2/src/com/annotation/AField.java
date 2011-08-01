package com.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.enumerations.FieldType;
@Retention(RetentionPolicy.RUNTIME)
public @interface AField {

String caption() default "-1";
int maxLength() default 255;
String nullReprezetantion() default "";
ASize size() default @ASize(setX = "-1");
FieldType typeField() default FieldType.textArea;
APosition position() default @APosition(setX = -1);

}
