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
		// runstatus = System.getenv("getvehiclemakesTest");
		// status = Boolean.parseBoolean(runstatus);
		// System.out.println(status);

		if (testMethod.getName().equals("getvehiclemakes") && System.getenv("getvehiclemakesTest").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		} else if (testMethod.getName().equals("getapnlistbycountryid")
				&& System.getenv("getapnlistbycountryidTest").contains("false")) {
			System.out.println("set data provider for " + testMethod.getName());
			annotation.setEnabled(false);
		} else if (System.getenv("All").contains("false")) {
			annotation.setEnabled(false);
		}

	}

}
