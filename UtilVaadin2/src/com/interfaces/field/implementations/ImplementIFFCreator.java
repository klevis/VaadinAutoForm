package com.interfaces.field.implementations;

import java.util.HashMap;
import java.util.List;

import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.JavaModelException;

import com.interfaces.field.IFFCreator;
import com.interfaces.form.implementations.ImplementFormInstruksion;

public class ImplementIFFCreator implements IFFCreator {
	ImplementFormInstruksion impl;
	HashMap<IField, List<IAnnotation>> hashMap;
	public String parseAnnotation(HashMap<IField, List<IAnnotation>> hashMap) {
		// TODO Auto-generated method stub

		ImplementBuildFactory implementBuildFactory = new ImplementBuildFactory(
				hashMap);
		this.hashMap=hashMap;
		return implementBuildFactory.getFactory();
	}

	public String parseFormConstructor(IAnnotation annotation) {
		// TODO Auto-generated method stub
		
		try {
			impl=new ImplementFormInstruksion(this.hashMap);
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		impl.configureFormIntrkusion(annotation);
return		impl.buildFormIntrkusion();
		

	}

	public String parseAttachField(HashMap<IField, List<IAnnotation>> hashMap) {
		// TODO Auto-generated method stub
	
		try {
			return impl.buildAttachField();
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}
