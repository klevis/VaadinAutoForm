package com.interfaces.field;

import java.util.HashMap;
import java.util.List;

import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IField;

public interface IFFCreator {

String parseAnnotation(HashMap<IField,List<IAnnotation>> hashMap);	
String parseFormConstructor(IAnnotation annotation);	

String parseAttachField(HashMap<IField,List<IAnnotation>> hashMap);

	
}
