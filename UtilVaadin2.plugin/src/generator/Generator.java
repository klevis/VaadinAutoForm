package generator;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

import com.interfaces.field.IFFCreator;
import com.interfaces.field.implementations.ImplementIFFCreator;

public class Generator implements IGenerator {

	private static IAnnotation formAnnotation;
	IFFCreator iffcreator = new ImplementIFFCreator();
	private List<Annotation> list;

	@Override
	public void generateForm(Class daoClass, ICompilationUnit cu) {

	}

	@Override
	public void generateFF(IType daoClass, ICompilationUnit cu) {

		recursiveGeneration(daoClass, cu);

	}

	private void recursiveGeneration(IType daoClass, ICompilationUnit cu) {
		String lowLevel = "\nPjesa e Kalit\n";
//		System.out.println(cu.getElementName()+"77777777777777777777777777777777777777777777777777777");
		String method = null;
		IField[] fields;
		HashMap<IField, List<IAnnotation>> hashMap = new HashMap<IField, List<IAnnotation>>();
		try {
			fields = daoClass.getFields();
			// Generator.setFormAnnotation(daoClass.getAnnotations()[0]);
			// iffcreator.parseFormConstructor(daoClass.getAnnotations()[0]);

		
			for (IField field : fields) {
				IAnnotation[] annotations = field.getAnnotations();
				for (IAnnotation iAnnotation : annotations) {
					
					if (iAnnotation.getElementName().equals("SubForm")){
						
						
						String strCUName = (String) iAnnotation.getMemberValuePairs()[0].getValue();
						ICompilationUnit icu = findCompilationUnit(cu,strCUName+".java");
						recursiveGeneration(icu.getTypes()[0],icu );
					}
					
				}
				List<IAnnotation> asList = Arrays.asList(annotations);
				hashMap.put(field, asList);
			}
			
//			ICompilationUnit oldGenCu = findCompilationUnit(cu, daoClass.getElementName()+"FormFactory.java");
//			IType iType = oldGenCu.getTypes()[0];
//			String signature = iType.getMethods()[0].getSignature();
//			IMethod method2 = iType.getMethod("createField", new String[] {"Item","Object","Component"});
//			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n"+signature+"\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			
			lowLevel = iffcreator.parseAnnotation(hashMap);

			method = "public Field createField(Item item, Object propertyId,Component uiContext){\n"
					+ lowLevel + "\n return null; \n}";

		} catch (JavaModelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			IPackageFragment parent = (IPackageFragment) cu.getParent();
			IPackageFragmentRoot parent2 = (IPackageFragmentRoot) parent
					.getParent();
			IPackageFragment genPackage = parent2.createPackageFragment(
					"generated", true, null);

			String name = cu.getElementName();

			String name5 = name.substring(0, name.indexOf(".java"));
			String name1 = name5 + "FormFactory.java";
			String name2 = name5 + "FormFactory";

			ICompilationUnit genCU = genPackage.createCompilationUnit(name1,
					"public class " + name2
							+ " implements FormFieldFactory\n{\n" + " \n};",
					true, null);
			genCU.createPackageDeclaration(genPackage.getElementName(), null);
			genCU.createImport("com.vaadin.data.*", null, null);
			genCU.createImport("com.vaadin.ui.*", null, null);
			IType iType = genCU.getTypes()[0];
			IMethod meth = iType.createMethod(method, null, true, null);

			// genPackage.createCompilationUnit("Forms"+cu.getElementName(),
			// contents, force, monitor)
			// AnnotationUtils.

			String name3 = name5 + "Form.java";
			String name4 = name5 + "Form";

			String constructorString = iffcreator.parseFormConstructor(daoClass
					.getAnnotations()[0]);
			String parseAttachField = iffcreator.parseAttachField(hashMap);
			
			
			
			ICompilationUnit genCU2 = genPackage.createCompilationUnit(name3,
					"public class " + name4 + " extends Form\n{"
							+ constructorString +"\n"+ parseAttachField+"\n \n}\n", true, null);
			genCU2.createPackageDeclaration(genPackage.getElementName(), null);
			genCU2.createImport("com.vaadin.data.*", null, null);
			genCU2.createImport("com.vaadin.data.util.*", null, null);
			genCU2.createImport("com.vaadin.ui.*", null, null);
			genCU2.createImport(parent.getElementName() + "." + name5, null,
					null);

		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		  catch (RuntimeException re){
			  JOptionPane.showConfirmDialog(null, re.getMessage());
		  }
	}

	private ICompilationUnit findCompilationUnit(ICompilationUnit cu, String cuName) {
//		System.out.println("555555555555555555555555555555555555555INSIDE");
		try {
			IPackageFragment[] packages = cu.getJavaProject().getPackageFragments();
//			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1"+packages.length);
			for (IPackageFragment iPackageFragment : packages) {
//				System.out.println("6666666666666666666666666666666666666"+iPackageFragment.getElementName());
				ICompilationUnit[] cus = iPackageFragment.getCompilationUnits();
				for (ICompilationUnit iCompilationUnit : cus) {
//					System.out.println("888888888888888888888888888888888888888888"+iCompilationUnit.getElementName());
					if (iCompilationUnit.getElementName().equals(cuName)){
//						System.out.println("U GJET NE: "+iPackageFragment.getElementName());
							return iCompilationUnit;
					}
				}
			}
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

}
