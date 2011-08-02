package com.enumerations;

public enum FieldType {

	textArea("textArea"),
	textField("textField"),
	select("select"),
	checkBox("checkBox");
	private String type;

	private FieldType(String type) {
		// TODO Auto-generated constructor stub

		setType(type);
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return getType();
	}
}
