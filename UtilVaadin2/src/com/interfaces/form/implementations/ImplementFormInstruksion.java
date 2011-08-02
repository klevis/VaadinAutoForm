package com.interfaces.form.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.management.RuntimeErrorException;
import javax.print.attribute.standard.MediaSize.Other;

import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IMemberValuePair;
import org.eclipse.jdt.core.JavaModelException;

import com.annotation.AForm;
import com.interfaces.form.FormInstruksion;

public class

ImplementFormInstruksion extends FormInstruksion {

	String groupAttachInstruksion = "@Override" + "\n"
			+ "protected void attachField(Object propertyId, Field field){"
			+ "\n";
	IField iField;

	public int controlDimensPosition() {

		boolean enterRegularX = false;
		boolean enterRegularY = false;

		int size = 0;
		if (positionX != -1) {
			enterRegularX = true;

			size++;
		}
		if (positionY != -1 && enterRegularX == true) {
			size++;
			enterRegularY = true;
		}
		if (enterRegularX == true && enterRegularY == true) {
			if (positionX1 != -1 && positionY1 != -1) {
				size = size + 2;
			}
		}

		return size;
	}

	public ImplementFormInstruksion(HashMap<IField, List<IAnnotation>> hashMap)
			throws JavaModelException {

		super(hashMap);

	}

	public String buildAttachField() throws JavaModelException {
		Set<IField> keySet = this.hashMap.keySet();
		int index = 0;
		if (isOtherLayout == false) {
			for (IField iField : keySet) {
				List<IAnnotation> listAnnotation = (List<IAnnotation>) this.hashMap
						.get(iField);
				this.iField = iField;
				for (IAnnotation iAnnotation : listAnnotation) {

					IMemberValuePair[] memberValuePairs = iAnnotation
							.getMemberValuePairs();
					isAnyPosition = false;
					for (IMemberValuePair iMemberValuePair : memberValuePairs) {

						if (iMemberValuePair.getMemberName().equals("position")) {
							this.positionX = -1;
							this.positionX1 = -1;
							this.positionY = -1;
							this.positionY1 = -1;
							isAnyPosition = true;
							IAnnotation positionAnnotation = (IAnnotation) iMemberValuePair
									.getValue();
							IMemberValuePair[] memberValuePairs2 = positionAnnotation
									.getMemberValuePairs();
							for (IMemberValuePair iMemberValuePair2 : memberValuePairs2) {
								if (iMemberValuePair2.getMemberName().equals(
										"setX")) {
									this.positionX = (Integer) iMemberValuePair2
											.getValue();
								} else if (iMemberValuePair2.getMemberName()
										.equals("setY")) {
									this.positionY = (Integer) iMemberValuePair2
											.getValue();
								} else if (iMemberValuePair2.getMemberName()
										.equals("setX1")) {
									this.positionX1 = (Integer) iMemberValuePair2
											.getValue();
								} else if (iMemberValuePair2.getMemberName()
										.equals("setY1")) {
									this.positionY1 = (Integer) iMemberValuePair2
											.getValue();

								}

							}
						}

					}
					if (isAnyPosition == false) {
						this.positionX = -1;
						this.positionX1 = -1;
						this.positionY = -1;
						this.positionY1 = -1;
					}

				}
				boolean exitWithError = false;
				String attach = null;
				int sizeDimens = controlDimensPosition();
				if (isGridLayout == true) {

					System.out.println("Layout Dimens" + sizeDimens);

					if (sizeDimens == 2) {

						attach = getAttachFieldInstruksion2Dimens();
					} else if (sizeDimens == 4) {
						attach = getAttachFieldInstruksion4Dimens();
					} else if (sizeDimens == 1 || sizeDimens == 3
							|| sizeDimens > 4) {
						throw (new RuntimeException(
								"GridLayout is two or four dimensional"));
					}
				} else if (isFormLayout) {
					if (sizeDimens == 1) {
						attach = getAttachFieldInstruksion1Dimens();
					} else {
						exitWithError = true;
						throw (new RuntimeException(
								"FormLayout is one dimensional"));
					}
				} else if (isFormLayout == false && isGridLayout == false
						&& isOtherLayout == false) {

					attach = "";
					isAnyPosition = true;
					isDefaultLayout = true;

				}

				if (isAnyPosition == false) {
					attach = "//Nuk keni dhene pozicion per kete element";
				}
				if (exitWithError == true) {
					attach = "";
				}
				if (isDefaultLayout == false) {
					if (index > 0) {
						groupAttachInstruksion = groupAttachInstruksion
								+ getElseIfFactoryInstruksion() + attach + "\n"
								+ "}\n";
					} else {
						groupAttachInstruksion = groupAttachInstruksion
								+ getIfFactoryInstruksion() + attach + "\n"
								+ "}\n";

					}
				}

				index++;
			}
		}

		groupAttachInstruksion = groupAttachInstruksion + "\n" + "}";
		if (isOtherLayout == true) {
			groupAttachInstruksion = "";
		}
		if (isDefaultLayout == true) {
			groupAttachInstruksion = "";
		}

		return String.valueOf(groupAttachInstruksion);
	}

	public ImplementFormInstruksion() {
		// TODO Auto-generated constructor stub
		super(null);
	}

	String caption;
	String formName;
	String varFormName;
	String layoutName;
	String layoutVarName;

	public String getDimensionLayout() {

		if (layoutTypeDimens == false) {
			return getLayoutVarName() + ".setRows(" + getRowsSize() + ");"
					+ "\n" + getLayoutVarName() + ".setColumns("
					+ getColumnSize() + ");";
		} else
			return null;
	}

	int positionX = -1, positionY = -1, positionX1 = -1, positionY1 = -1;
	String x = "-1", y = "-1";
	String factoryName;
	String factoryVar;
	boolean isGridLayout = false;
	boolean isFormLayout = false;
	boolean isOtherLayout = false;
	boolean layoutTypeDimens = false;
	boolean isAnyPosition = false;
	boolean isDefaultLayout = false;

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
		return iField.getElementName();
	}

	@Override
	public String getVarNameElse() {
		// TODO Auto-generated method stub
		return iField.getElementName();
	}

	@Override
	public String getColumn() {
		// TODO Auto-generated method stub
		return String.valueOf(this.positionX);
	}

	@Override
	public String getRows() {
		// TODO Auto-generated method stub
		return String.valueOf(this.positionY);
	}

	@Override
	public String toGetColumn() {
		// TODO Auto-generated method stub
		return String.valueOf(this.positionX1);
	}

	@Override
	public String toGetRows() {
		// TODO Auto-generated method stub
		return String.valueOf(this.positionY1);
	}

	@Override
	public String getOneDimensLayout() {
		// TODO Auto-generated method stub
		return String.valueOf(this.positionX);
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

				} else if (iMemberValuePair.getMemberName().equals("size")) {
					IAnnotation iAnnotation3 = (IAnnotation) iMemberValuePair
							.getValue();

					IMemberValuePair[] memberValuePairs3 = iAnnotation3
							.getMemberValuePairs();
					for (IMemberValuePair iMemberValuePair3 : memberValuePairs3) {
						System.out.println("Jemi tek Asizw"
								+ iMemberValuePair3.getMemberName());
						if (iMemberValuePair3.getMemberName().equals("setX")) {
							this.x = (String) iMemberValuePair3.getValue();
							System.err.println("Vlera" + this.x);
						} else if (iMemberValuePair3.getMemberName().equals(
								"setY")) {
							System.err.println("Vlera " + this.y);
							this.y = (String) iMemberValuePair3.getValue();
						} else if (iMemberValuePair3.getMemberName().equals(
								"setX1")) {
							this.positionX1 = (Integer) iMemberValuePair3
									.getValue();
						} else if (iMemberValuePair3.getMemberName().equals(
								"setY1")) {
							this.positionY1 = (Integer) iMemberValuePair3
									.getValue();
						}

					}

				}

				else if (iMemberValuePair.getMemberName().equals(
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
								layoutTypeDimens = false;
								isGridLayout = true;
								isFormLayout = false;
								isOtherLayout = false;
							} else if (s.equals("FormLayout")
									|| s.equals("HorizontalLayout")
									|| s.equals("VerticalLayout")) {

								if (s.equals("FormLayout")) {
									isGridLayout = false;
									isFormLayout = true;
									isOtherLayout = false;
								} else {
									isGridLayout = false;
									isFormLayout = false;
									isOtherLayout = true;
								}
								layoutTypeDimens = true;

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

		if (getLayout() == null) {

			layoutName = "FormLayout";
			layoutVarName = lowerCase(layoutName);
		}
		constructor = getLayoutInstruksion() + "\n\n\n";
		constructor = constructor + getFactoryObjectInstruksion() + "\n\n";
		constructor = constructor + getDatasourceInstruksion() + "\n\n";
		constructor = constructor + getBeanItemDatasourceInstrksion() + "\n\n";

		constructor = constructor + getConstructorInstruksion() + "\n";

		if (this.x.equals("-1") == false && this.y.equals("-1") == false
				&& getGridLayoutDimens() != null) {
			if (getLayout().equals("FormLayout")) {
				throw new RuntimeException("FormLayout dosen't have size");
			}
			constructor = constructor + getGridLayoutDimens() + "\n";
		}

		constructor = constructor + setLayoutInstruksion() + "\n";
		if (getCaption() != null)
			constructor = constructor + getFormCaptionInstruksion() + "\n\n";
		constructor = constructor + setFormFieldFactoryInstruksion() + "\n";
		constructor = constructor + setDatasourceInstruksion() + "\n";
		constructor = constructor + "}";
		System.out.println(constructor);

		return constructor;
	}

	@Override
	public String getFactoryVarName() {
		// TODO Auto-generated method stub
		return factoryVar;
	}

	@Override
	public String getColumnSize() {
		// TODO Auto-generated method stub
		return String.valueOf(this.y);
	}

	@Override
	public String getRowsSize() {
		// TODO Auto-generated method stub
		return String.valueOf(this.x);
	}

}
