package com.interfaces.field;

public abstract class GroupInstruksion {
	public FieldInstruksions instruksions;

	public GroupInstruksion(FieldInstruksions instruksions) {
		// TODO Auto-generated constructor stub
		this.instruksions = instruksions;
	}

	protected String id = null;
	protected String annName = null;
	public String allGroup;

	protected abstract String mergeCodeInst();

}
