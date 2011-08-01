package com.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.enumerations.LayoutType;
@Retention(RetentionPolicy.RUNTIME)
public @interface ALayout {


LayoutType layoutType();
APosition position() default @APosition(setX = -1) ;

}
