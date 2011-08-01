package com.interfaces.field.implementations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.vaadin.ui.TextField;

public class Prov {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
//ImplementInstruksion im=new ImplementInstruksion(); 
//ImplementInstr2 im2=new ImplementInstr2();
//ImplIn3 im3=new ImplIn3();
//
//
//ImplementGroupIntruksion gr=new ImplementGroupIntruksion(im);
//GroupClass2 gr2=new GroupClass2(im2);
//GroupClass2 gr3=new GroupClass2(im3);
////System.out.println(gr.allGroup);
////System.out.println(gr2.allGroup);
//
//GroupInstruksion []grI = null;
//
//List<GroupInstruksion> list=new ArrayList<GroupInstruksion>();
//list.add(gr);
//list.add(gr2);
//list.add(gr3);
//ImplementBuildFactory implementBuildFactory=new ImplementBuildFactory(list);
//
//System.out.println(implementBuildFactory.factory);
		
	ImplementIFFCreator implementIFFCreator=new ImplementIFFCreator();
//	System.out.println(implementIFFCreator
//			.parseAnnotation(new HashMap<Field, List<Annotation>>()));
	}

}
