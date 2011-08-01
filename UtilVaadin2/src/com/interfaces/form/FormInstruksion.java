package com.interfaces.form;

import java.util.List;

import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IField;

import com.annotation.AForm;

public abstract class FormInstruksion {

	protected List<IAnnotation> annotations;
	protected IField field;

	public FormInstruksion(List<IAnnotation> annotations2, IField field2) {
		this.annotations = annotations2;
		this.field = field2;

	}

	public String getLayoutInstruksion() {
		return getLayout() + "  " + getLayoutVarName() + "=new " + getLayout()
				+ "();";
	}

	public abstract void configureFormIntrkusion(IAnnotation aForm);

	public abstract String buildFormIntrkusion();

	public abstract String getLayout();

	public abstract String getLayoutVarName();

	public abstract String getGridLayoutDimens();

	public abstract String getOneDimensLayout();

	public abstract String getColumnsLayout();

	public abstract String getRowsLayout();

	public String setLayoutInstruksion() {

		return "this.setLayout(" + getLayoutVarName() + ");";
	}

	public String setFormFieldFactoryInstruksion() {
		return "this.setFormFieldFactory(" + getFactoryVarName() + ");";
	}

	public abstract String getFactoryName();

	public abstract String getFactoryVarName();

	public String getFactoryObjectInstruksion() {
		return getFactoryName() + "  " + getFactoryVarName() + "=new  "
				+ getFactoryName() + "();";
	}

	public abstract String getDatasource();

	public String getIfFactoryInstruksion() {
		return "if(propertyId.equals(\"" + getVarNameIf() + "\"))" + "{\n";
	}

	public String getElseIfFactoryInstruksion() {
		return "else if(propertyId.equals(\"" + getVarNameElse() + "\"))"
				+ "{\n";
	}

	public abstract String getVarNameIf();

	public abstract String getVarNameElse();

	public String getAttachFieldInstruksion2Dimens() {
		return "gridLayout.addComponent(field," + getColumn() + "," + getRows()
				+ ");";
	}

	public String getAttachFieldInstruksion1Dimens() {
		return getLayoutVarName() + ".addComponent(field,"
				+ getOneDimensLayout() + ");";
	}

	public abstract String getColumn();

	public abstract String getRows();

	public abstract String toGetColumn();

	public abstract String toGetRows();

	public abstract String getCaption();

	public String getAttachFieldInstruksion4Dimens() {
		return "gridLayout.addComponent(field," + getColumn() + "," + getRows()
				+ "," + toGetColumn() + "," + toGetRows() + ");";
	}

	public String getFormCaptionInstruksion() {
		return "this.setCaption(" + "\"" + getCaption() + "\"" + ");";
	}

	public abstract String getFormVarName();

	public String getConstructorInstruksion() {

		return "public  " + getFormName() + "(){";
	}

	public abstract String getFormName();

	public String getName() {
		return "" + getFormName().substring(0, getFormName().indexOf("Form"));
	}

	public String getVarName() {
		char[] character = getName().toString().toCharArray();
		Character character2 = Character.valueOf(character[0]);
		character[0] = character2.toLowerCase(character[0]);
		return String.valueOf(character);
	}

	public String getDatasourceInstruksion() {
		return getName() + "    " + getVarName() + "=new    " + getName()
				+ "();";
	}

	public String getVarDatasource() {
		return getVarName() + "Datasource";
	}

	public String getBeanItemDatasourceInstrksion() {
		return "BeanItem<" + getName() + ">   " + getVarDatasource()
				+ "=new   " + "BeanItem<" + getName() + ">   (" + getVarName()
				+ ");";

	}

	public String setDatasourceInstruksion() {

		return "this.setItemDataSource(" + getVarDatasource() + ");";
	}
	
	
}
