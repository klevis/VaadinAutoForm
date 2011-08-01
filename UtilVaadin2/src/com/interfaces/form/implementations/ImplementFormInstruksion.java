package com.interfaces.form.implementations;

import java.util.List;

import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IMemberValuePair;
import org.eclipse.jdt.core.JavaModelException;

import com.annotation.AForm;
import com.interfaces.form.FormInstruksion;

public class

ImplementFormInstruksion extends FormInstruksion {

	String caption;
	String formName;
	String varFormName;
	String layoutName;
	String layoutVarName;

	boolean b = false;

	public String getDimensionLayout() {

		if (b == false) {
			return getLayoutVarName() + ".setRows(" + getRows() + ");" + "\n"
					+ getLayoutVarName() + ".setColumns(" + getColumn() + ");";
		} else
			return null;
	}

	int x = -1, y = -1, x1 = -1, y1 = -1;
	String factoryName;
	String factoryVar;

	public ImplementFormInstruksion() {
		// TODO Auto-generated constructor stub
		super(null, null);
	}

	public ImplementFormInstruksion(List<IAnnotation> annotations2,
			IField field2) {
		super(annotations2, field2);
		// TODO Auto-generated constructor stub

	}

	private String lowerCase(String formName) {
		char[] character = formName.toString().toCharArray();
		Character character2 = Character.valueOf(character[0]);
		character[0] = character2.toLowerCase(character[0]);
		return String.valueOf(character);
	}

	@Override
	public String getColumnsLayout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRowsLayout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFactoryName() {
		// TODO Auto-generated method stub
		return factoryName;
	}

	@Override
	public String getDatasource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getVarNameIf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getVarNameElse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumn() {
		// TODO Auto-generated method stub
		return String.valueOf(this.x);
	}

	@Override
	public String getRows() {
		// TODO Auto-generated method stub
		return String.valueOf(this.y);
	}

	@Override
	public String toGetColumn() {
		// TODO Auto-generated method stub
		return String.valueOf(this.x1);
	}

	@Override
	public String toGetRows() {
		// TODO Auto-generated method stub
		return String.valueOf(this.y);
	}

	@Override
	public String getOneDimensLayout() {
		// TODO Auto-generated method stub
		return String.valueOf(this.x);
	}

	@Override
	public String getCaption() {
		// TODO Auto-generated method stub
		return this.caption;
	}

	@Override
	public String getFormVarName() {
		// TODO Auto-generated method stub
		return this.varFormName;
	}

	@Override
	public String getFormName() {
		// TODO Auto-generated method stub
		return this.formName;
	}

	@Override
	public String getLayout() {
		// TODO Auto-generated method stub
		return this.layoutName;
	}

	@Override
	public String getLayoutVarName() {
		// TODO Auto-generated method stub
		return this.layoutVarName;
	}

	@Override
	public String getGridLayoutDimens() {
		// TODO Auto-generated method stub
		return this.getDimensionLayout();
	}

	@Override
	public void configureFormIntrkusion(IAnnotation aForm) {
		// TODO Auto-generated method stub
		try {
			IMemberValuePair[] memberValuePairs = aForm.getMemberValuePairs();
			for (IMemberValuePair iMemberValuePair : memberValuePairs) {

				if (iMemberValuePair.getMemberName().equals("caption")) {
					caption = (String) iMemberValuePair.getValue();

				} else if (iMemberValuePair.getMemberName().equals(
						"generateStrategy")) {

				} else if (iMemberValuePair.getMemberName().equals("imediate")) {

				} else if (iMemberValuePair.getMemberName().equals("clazz")) {

					formName = (String) iMemberValuePair.getValue();
					formName = formName + "Form";
					varFormName = lowerCase(formName);
					factoryName = formName + "Factory";
					factoryVar = lowerCase(factoryName);

				} else if (iMemberValuePair.getMemberName().equals(
						" generateStrategy")) {

				} else if (iMemberValuePair.getMemberName().equals("layout")) {

					IAnnotation iAnnotation2 = (IAnnotation) iMemberValuePair
							.getValue();

					IMemberValuePair[] memberValuePairs2 = iAnnotation2
							.getMemberValuePairs();
					for (IMemberValuePair iMemberValuePair2 : memberValuePairs2) {

						if (iMemberValuePair2.getMemberName().equals(
								"layoutType")) {
							String s = (String) iMemberValuePair2.getValue();

							s = s.substring(11);

							layoutName = s;
							layoutVarName = lowerCase(layoutName);

							if (s.equals("GridLayout")) {
								b=false;
								System.out.println("Hym ne cikel");
							} else if (s.equals("FormLayout")
									|| s.equals("HorizontalLayout")
									|| s.equals("VerticalLayout")) {

								b=true;
							}

						} else if (iMemberValuePair2.getMemberName().equals(
								"position")) {
							IAnnotation iAnnotation3 = (IAnnotation) iMemberValuePair2
									.getValue();

							IMemberValuePair[] memberValuePairs3 = iAnnotation3
									.getMemberValuePairs();
							for (IMemberValuePair iMemberValuePair3 : memberValuePairs3) {

								if (iMemberValuePair3.getMemberName().equals(
										"setX")) {
									this.x = (Integer) iMemberValuePair3
											.getValue();
									System.out.println("Hyme ne cikel");

								} else if (iMemberValuePair3.getMemberName()
										.equals("setY")) {
									this.y = (Integer) iMemberValuePair3
											.getValue();
								} else if (iMemberValuePair3.getMemberName()
										.equals("setX1")) {
									this.x1 = (Integer) iMemberValuePair3
											.getValue();
								} else if (iMemberValuePair3.getMemberName()
										.equals("setY1")) {
									this.y1 = (Integer) iMemberValuePair3
											.getValue();
								}

							}

						}
					}

				}
			}

		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String constructor;

	@Override
	public String buildFormIntrkusion() {
		// TODO Auto-generated method stub
		constructor = getLayoutInstruksion() + "\n\n\n";
		constructor = constructor + getFactoryObjectInstruksion() + "\n\n\n";
		constructor=constructor+getDatasourceInstruksion()+"\n\n\n";
		constructor=constructor+getBeanItemDatasourceInstrksion()+"\n\n\n";
		
		constructor = constructor + getConstructorInstruksion() + "\n";
		

		System.out.println("xcxcxcxcxcxcxcx" + getGridLayoutDimens());
		if (this.x != -1 && this.y != -1 && getGridLayoutDimens() != null) {
			constructor = constructor + getGridLayoutDimens() + "\n";
		}
		constructor = constructor + getFormCaptionInstruksion() + "\n\n";
		constructor = constructor + setFormFieldFactoryInstruksion() + "\n";
		constructor=constructor+setDatasourceInstruksion()+"\n";		
		constructor = constructor + "}";
		System.out.println(constructor);

		return constructor;
	}

	@Override
	public String getFactoryVarName() {
		// TODO Auto-generated method stub
		return factoryVar;
	}

}
