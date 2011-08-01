package handler;

import generator.Generator;
import generator.IGenerator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

public class HandleGeneration extends AbstractHandler{
	
	
	IGenerator generator = new Generator();

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		
		ICompilationUnit cu = (ICompilationUnit) selection.getFirstElement();
//		Class<?> clazz = null;
//		try {
//			IType iType = cu.getTypes()[0];
//			
//			String emri = iType.getFullyQualifiedName();
//			
//			 clazz = Class.forName(emri);
//			 clazz.newInstance();
//			
//			
//		} catch (JavaModelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		IType itype = null;
		try {
			itype = cu.getTypes()[0];
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		generator.generateFF(itype
				, cu);
		
		return null;
	}

}
