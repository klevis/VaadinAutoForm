package generator;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;

public interface IGenerator {
	
	void generateForm(Class daoClass, ICompilationUnit cu);
	void generateFF(IType daoClass, ICompilationUnit cu);

}
