package com.project.employees.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention( RetentionPolicy.RUNTIME )
public @interface AuthType {

	  final static String AUTH_SIMPLE = "AUTH_SIMPLE";
	  final static String AUTH_ANOTHER_TYPE_TO_QUTH = "AUTH_ANOTHER_TYPE_TO_QUTH";
	  String [] value();
	  
}
