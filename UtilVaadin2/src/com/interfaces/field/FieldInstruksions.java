package com.interfaces.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IField;

import com.annotation.AForm;

public abstract class FieldInstruksions {

	protected List<IAnnotation> annotations;
	protected IField field;

	public FieldInstruksions(List<IAnnotation> annotations2, IField field2) {
		this.annotations = annotations2;
		this.field = field2;

	}

	public String getMaxLengthInstruksion() {return "" + getTypeField() + ".setMaxLength("
			+ getMaxLength() + ");";}

	public abstract void setTypeField(String typeField);

	public abstract String getTypeField();

	public abstract void setMaxLength(String maxLength);

	public abstract String getMaxLength();

	public abstract String getNullReprezation();

	public String getNullReprezationInstruksion() {return  "" + getTypeField()
			+ ".setNullRepresentation(\"" + getNullReprezation() + "\");";}

	public abstract String getSizeX();

	public abstract String getSizey();

	public abstract String getCaption();

	public abstract String getVarNameIf();

	public abstract String getVarNameElse();

	public String getIfFactoryInstruksion(){return "if(propertyId.equals(\""
			+ getVarNameIf() + "\"))" + "{\n";}

	public String getElseIfFactoryInstruksion (){return  "else if(propertyId.equals(\""
			+ getVarNameElse() + "\"))" + "{\n";}

	public String getCaptionInstruction(){return getTypeField() + ".setCaption(\""
			+ getCaption() + "\");";}

	public String getInitObjectInstruksion (){return getInitObject() + "   "
			+ getTypeField() + "=new" + "   " + getInitObject()+"();";}

	public abstract String getInitObject();
	
	public String getReturnFieldInstruksion(){ return "return  "+getReturnField();}
	
	public abstract String getReturnField();
	
	
	public  String getWidthInstruksion(){
		return getTypeField()+".setWidth(\""+getWidhth()+"\");";
	}
	
	public abstract String getWidhth();
	
	public String getHeightInstruksion(){
		return getTypeField()+".setHeight(\""+getHeight()+"\");";
	}
	
public abstract String getHeight();
}
