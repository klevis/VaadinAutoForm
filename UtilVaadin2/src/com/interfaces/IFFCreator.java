package com.interfaces;

import java.util.HashMap;
import java.util.List;

import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IField;

public interface IFFCreator {

String parseAnnotation(HashMap<IField,List<IAnnotation>> hashMap);
void getFormAnnotation(IAnnotation annotation);	

	
}
