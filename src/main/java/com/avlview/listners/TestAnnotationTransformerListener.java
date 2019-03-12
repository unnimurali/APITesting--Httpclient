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

		if (testMethod.getName().equals("getvehiclemakes") && System.getenv("getvehiclemakesTest").contains("false")) {
			// System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getapnlistbycountryid")
				&& System.getenv("getapnlistbycountryidTest").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (System.getenv("All").contains("true")) {
			System.out.println("inside all");
			System.setProperty("getvehiclemakesTest", "true");
			System.setProperty("getapnlistbycountryid", "true");
			annotation.setEnabled(true);

		}

	}

}
