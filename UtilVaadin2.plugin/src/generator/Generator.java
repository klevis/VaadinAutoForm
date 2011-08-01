package generator;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

import com.interfaces.field.IFFCreator;
import com.interfaces.field.implementations.ImplementIFFCreator;


public class Generator implements IGenerator{

	private static IAnnotation formAnnotation;
	IFFCreator iffcreator = new ImplementIFFCreator();
	private List<Annotation> list;
	
	@Override
	public void generateForm(Class daoClass, ICompilationUnit cu) {
		
	}

	@Override
	public void generateFF(IType daoClass, ICompilationUnit cu) {
		
		String lowLevel = "\nPjesa e Kalit\n";
		
					
		
		
		String method = null;
		IField[] fields;
		try {
			fields = daoClass.getFields();
//			Generator.setFormAnnotation(daoClass.getAnnotations()[0]);
			iffcreator.getFormAnnotation(daoClass.getAnnotations()[0]); 
			
		HashMap<IField, List<IAnnotation>> hashMap = new HashMap<IField,List<IAnnotation>>();
		for (IField field : fields) {
			IAnnotation[] annotations = field.getAnnotations();
			List<IAnnotation> asList = Arrays.asList(annotations);
			System.out.println(field.toString()+"SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
			System.out.println(asList.toString()+"KKKKKKKKKKKKKKKKK");
			System.out.println(asList.isEmpty()?"BOSH!!!!!!!!!!":"Plot+_+++++++++++++++++++++++++++++");
			hashMap.put(field, asList);
		}
		
		lowLevel = iffcreator.parseAnnotation(hashMap);
		
		
		method = "public Field createField(Item item, Object propertyId,Component uiContext){\n"+lowLevel+"\n return null; \n}";

		} catch (JavaModelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			IPackageFragment parent = (IPackageFragment) cu.getParent();
			IPackageFragmentRoot parent2 = (IPackageFragmentRoot) parent.getParent();
			IPackageFragment genPackage = parent2.createPackageFragment("generated", true,null);
			ICompilationUnit genCU = genPackage.createCompilationUnit("Form"+cu.getElementName()	,"public class Form"+cu.getTypes()[0].getElementName()+" implements FormFieldFactory \n{\n \n};", true, null);
			genCU.createPackageDeclaration(genPackage.getElementName(), null);
			genCU.createImport("com.vaadin.data.*", null, null);
			genCU.createImport("com.vaadin.ui.*", null, null);
			IType iType = genCU.getTypes()[0];
			IMethod meth = iType.createMethod(method, null	, true, null);
//			AnnotationUtils.
			
			
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	

}
