package com.interfaces.field.implementations;

import java.lang.annotation.Annotation;
import java.util.List;

import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IMemberValuePair;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.util.IEnclosingMethodAttribute;

import com.annotation.AField;
import com.annotation.ASize;
import com.annotation.GenerateNot;
import com.annotation.GenerateThis;
import com.enumerations.FieldType;
import com.interfaces.field.FieldInstruksions;

public class ImplementInstruksion extends FieldInstruksions {
	String caption;
	int maxLengthX;
	String nullReprezetantion;
	String type;
	String x, y;

	public ImplementInstruksion(List<IAnnotation> annotations, IField field) {
		super(annotations, field);
		for (int i = 0; i < this.annotations.size(); i++) {
			System.out.println(annotations.get(i).getClass().getCanonicalName()
					+ "");
			if (this.annotations.get(i) instanceof IAnnotation) {
				getInformationFromField(this.annotations, i);

			} else if (this.annotations.get(i) instanceof GenerateNot) {

			} else if (this.annotations.get(i) instanceof GenerateThis) {
				getInformationFromField(this.annotations, i);
			}
		}

	}

	private void getInformationFromField(List<IAnnotation> annotations, int i) {
		IAnnotation ann = annotations.get(i);
		try {

			IMemberValuePair[] arr = ann.getMemberValuePairs();
			for (IMemberValuePair iMemberValuePair : arr) {

				System.out.println("LLoji fushave Emri>>>>"
						+ iMemberValuePair.getMemberName());
				System.out.println("LLoji fushave Value Kind>>>> "
						+ iMemberValuePair.getValueKind());
				System.out.println("Llohi fushave Value>>>> "
						+ iMemberValuePair.getValue());

				if (iMemberValuePair.getMemberName().equals("caption")) {
					caption = (String) iMemberValuePair.getValue();
				} else if (iMemberValuePair.getMemberName().equals(
						"nullReprezetantion")) {
					this.nullReprezetantion = (String) iMemberValuePair
							.getValue();
				} else if (iMemberValuePair.getMemberName().equals("size")) {
					IAnnotation aSize = (IAnnotation) iMemberValuePair
							.getValue();

					IMemberValuePair[] memberValuePairs = aSize
							.getMemberValuePairs();
					for (IMemberValuePair iMemberValuePair2 : memberValuePairs) {

						if (iMemberValuePair2.getMemberName().equals("setX")) {
							x = (String) iMemberValuePair2.getValue();

							if (x.equals("-1")) {
								x = null;
							}

						} else if (iMemberValuePair2.getMemberName().equals(
								"setY")) {

							y = (String) iMemberValuePair2.getValue();

							if (y.equals("-1")) {
								y = null;
							}
						}
					}

				} else if (iMemberValuePair.getMemberName().equals("typeField")) {
					String s = (String) iMemberValuePair.getValue();
					type = s.substring(10);
				}else if(iMemberValuePair.getMemberName().equals("maxLength")){
					this.maxLengthX=(Integer) iMemberValuePair.getValue();
				}

			}

		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void setTypeField(String typeField) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTypeField() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	public void setMaxLength(String maxLength) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getMaxLength() {
		// TODO Auto-generated method stub
		String s = String.valueOf(this.maxLengthX);
		return s;
	}

	@Override
	public String getNullReprezation() {
		// TODO Auto-generated method stub
		return this.nullReprezetantion;
	}

	@Override
	public String getVarNameElse() {
		// TODO Auto-generated method stub
		if (field == null) {
			return null;
		} else
			return this.field.getElementName();
	}

	@Override
	public String getVarNameIf() {
		// TODO Auto-generated method stub

		if (field == null) {
			return null;
		} else
			return this.field.getElementName();
	}

	@Override
	public String getSizeX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public String getSizey() {
		// TODO Auto-generated method stub
		return this.y;
	}

	@Override
	public String getCaption() {
		// TODO Auto-generated method stub
		return this.caption;
	}

	@Override
	public String getInitObject() {

		if (type == null)
			return null;
		else {
			char[] character = this.type.toString().toCharArray();
			Character character2 = Character.valueOf(character[0]);
			character[0] = character2.toUpperCase(character[0]);

			return String.valueOf(character);
		}
	}

	@Override
	public String getReturnField() {
		// TODO Auto-generated method stub

		return this.type;
	}

	@Override
	public String getWidhth() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public String getHeight() {
		// TODO Auto-generated method stub
		return this.y;
	}

	
	
	
}
