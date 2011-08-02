package com.interfaces.field.implementations;

import com.interfaces.field.FieldInstruksions;
import com.interfaces.field.GroupInstruksion;

public class ImplementGroupIntruksion extends GroupInstruksion {

	public ImplementGroupIntruksion(FieldInstruksions instruksions) {
		// TODO Auto-generated constructor stub
		super(instruksions);

		mergeCodeInst();
	}

	@Override
	protected String mergeCodeInst() {

		id = "emriPerson";
		annName = "field";
		if (instruksions.getSizeX() != null && instruksions.getSizey() != null) {
			allGroup = instruksions.getInitObjectInstruksion() + "\n"
					+ instruksions.getHeightInstruksion() + "\n" + instruksions.getWidthInstruksion()
					+ "\n";
		} else if (instruksions.getSizeX() != null
				&& instruksions.getSizey() == null) {
			allGroup = instruksions.getInitObjectInstruksion() + "\n"
					+ instruksions.getWidthInstruksion() + "\n" ;
		} else if (instruksions.getSizeX() == null
				&& instruksions.getSizey() != null) {
			allGroup = instruksions.getInitObjectInstruksion() + "\n"
					+ instruksions.getHeightInstruksion() + "\n";
		} else if (instruksions.getSizeX() == null
				&& instruksions.getSizey() == null) {
			allGroup = instruksions.getInitObjectInstruksion() + "\n";
		}
		
		if (instruksions.getMaxLength().equals("-1") == false&&instruksions.getTypeField().equals("select")==false) {
			allGroup = allGroup + instruksions.getMaxLengthInstruksion() + "\n";
		}
		if (instruksions.getNullReprezation() != null&&instruksions.getTypeField().equals("select")==false) {
			allGroup = allGroup + instruksions.getNullReprezationInstruksion()
					+ "\n";
		}
		
		if (instruksions.getCaption() != null) {
			allGroup = allGroup + instruksions.getCaptionInstruction() + "\n";
		}
		
		allGroup=allGroup+"\n"+instruksions.getReturnFieldInstruksion()+";"+"\n"+"}";
		
		return allGroup;
	}

}
