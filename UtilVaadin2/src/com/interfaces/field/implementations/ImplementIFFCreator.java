package com.interfaces.field.implementations;

import java.util.HashMap;
import java.util.List;

import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IField;

import com.interfaces.field.IFFCreator;
import com.interfaces.form.implementations.ImplementFormInstruksion;

public class ImplementIFFCreator implements IFFCreator {

	public String parseAnnotation(HashMap<IField, List<IAnnotation>> hashMap) {
		// TODO Auto-generated method stub

		ImplementBuildFactory implementBuildFactory = new ImplementBuildFactory(
				hashMap);
		return implementBuildFactory.getFactory();
	}

	public void getFormAnnotation(IAnnotation annotation) {
		// TODO Auto-generated method stub
		
		ImplementFormInstruksion impl=new ImplementFormInstruksion();
		impl.configureFormIntrkusion(annotation);
		impl.buildFormIntrkusion();
	}

}
