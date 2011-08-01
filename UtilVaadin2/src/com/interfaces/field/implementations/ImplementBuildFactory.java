package com.interfaces.field.implementations;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IField;

import com.interfaces.field.FactoryInterface;

public class ImplementBuildFactory extends FactoryInterface {
	List<ImplementGroupIntruksion> group = new ArrayList<ImplementGroupIntruksion>();
	private String factory;

	public ImplementBuildFactory(HashMap<IField, List<IAnnotation>> hashMap) {
		super(hashMap);
		Set<IField> keySet = hashMap.keySet();
		
//			System.out.println(iField.getElementName());
		
		int index = 0;
		int size = keySet.size();
		System.out.println(size+" YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
		
		ImplementInstruksion[] implementInstruksions = new ImplementInstruksion[size];
		int length = implementInstruksions.length;
		System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZ"+length);
		ImplementGroupIntruksion[] implementGroupIntruksions = new ImplementGroupIntruksion[size];
		if (keySet.isEmpty())System.out.println("BOSH KeySet KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
//		Iterator<IField> iterator = keySet.iterator();
		for (IField iField : keySet) {

			IField nextField = iField;
			System.out.println(nextField.getElementName()+"IIIITERATORIII");
//			System.out.println((nextField.getElementName()+" FIELLLLLLLLLLLLLLLLLLLD"));
//			if (nextField==null) System.out.println("NUL KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
			List<IAnnotation> listAnotaion = hashMap.get(nextField);
//			System.out.println(listAnotaion.toString()+" KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
			if (index>size-1) break;
			
			System.out.println("BRENDAAAAA");
			implementInstruksions[index] = new ImplementInstruksion(
					listAnotaion, nextField);
			System.out.println(implementInstruksions[index].caption);
//			System.out.println(implementInstruksions[index].captionInstrkusion);
			System.out.println(implementInstruksions[index].getVarNameIf()+"   SDFGHJKL");
			implementGroupIntruksions[index] = new ImplementGroupIntruksion(
					implementInstruksions[index]);
			
			group.add(implementGroupIntruksions[index]);

			index++;

		}
		setFactory("" + group.get(0).instruksions.getIfFactoryInstruksion());

		buildFactory();
	}



	public String buildFactory() {
		for (int i = 0; i < group.size(); i++) {
			if (i == group.size() - 1) {
				setFactory(getFactory() + group.get(i).allGroup + "\n");
			} else
				setFactory(getFactory()
						+ group.get(i).allGroup
						+ "\n"
						+ group.get(i + 1).instruksions.getElseIfFactoryInstruksion());
		}

		return getFactory();
	}



	public void setFactory(String factory) {
		this.factory = factory;
	}



	public String getFactory() {
		return factory;
	}

}
