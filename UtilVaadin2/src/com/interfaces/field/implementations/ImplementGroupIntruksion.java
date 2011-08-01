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
					+ instruksions.getMaxLengthInstruksion() + "\n"
					+ instruksions.getNullReprezationInstruksion ()+ "\n"
					+ instruksions.getCaptionInstruction() + "\n"
					+ instruksions.getHeightInstruksion() + "\n" + instruksions.getWidthInstruksion()
					+ "\n";
		} else if (instruksions.getSizeX() != null
				&& instruksions.getSizey() == null) {
			allGroup = instruksions.getInitObjectInstruksion() + "\n"
					+ instruksions.getMaxLengthInstruksion() + "\n"
					+ instruksions.getNullReprezationInstruksion () + "\n"
					+ instruksions.getCaptionInstruction() + "\n"
					+ instruksions.getWidthInstruksion() + "\n" ;
		} else if (instruksions.getSizeX() == null
				&& instruksions.getSizey() != null) {
			allGroup = instruksions.getInitObjectInstruksion() + "\n"
					+ instruksions.getMaxLengthInstruksion() + "\n"
					+ instruksions.getNullReprezationInstruksion () + "\n"
					+ instruksions.getCaptionInstruction() + "\n"
					+ instruksions.getHeightInstruksion() + "\n";
		} else if (instruksions.getSizeX() == null
				&& instruksions.getSizey() == null) {
			allGroup = instruksions.getInitObjectInstruksion() + "\n"
					+ instruksions.getMaxLengthInstruksion() + "\n"
					+ instruksions.getNullReprezationInstruksion () + "\n"
					+ instruksions.getCaptionInstruction() + "\n" ;
		}
		
		
		allGroup=allGroup+"\n"+instruksions.getReturnFieldInstruksion()+";"+"\n"+"}";
		
		return allGroup;
	}

}
