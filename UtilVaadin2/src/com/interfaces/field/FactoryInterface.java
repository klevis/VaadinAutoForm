package com.interfaces.field;

import java.util.HashMap;
import java.util.List;

import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.IField;

public abstract class FactoryInterface {
	HashMap<IField, List<IAnnotation>> hashMap;
	public FactoryInterface(HashMap<IField, List<IAnnotation>> hashMap) {
		// TODO Auto-generated constructor stub
	this.hashMap=hashMap;}
	
public abstract String buildFactory();	
}
