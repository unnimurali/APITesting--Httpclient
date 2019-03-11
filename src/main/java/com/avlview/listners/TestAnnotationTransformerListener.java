package com.avlview.listners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class TestAnnotationTransformerListener implements IAnnotationTransformer {

	String runstatus;
	boolean status;

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub

		System.out.println(System.getenv("getvehiclemakesTest"));
		runstatus = System.getenv("getvehiclemakesTest");
		status = Boolean.parseBoolean(runstatus);
		System.out.println(status);

		if (status = true) {
			annotation.setEnabled(true);
			System.out.println("inside true");
		} else {
			annotation.setEnabled(false);
			System.out.println("inside false");
		}

	}

}
