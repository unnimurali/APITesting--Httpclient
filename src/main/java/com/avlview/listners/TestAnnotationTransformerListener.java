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

		if (testMethod.getName().equals("getvehiclemakes") && System.getenv("getvehiclemakes").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getvehiclemodels") && System.getenv("getvehiclemodels").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getdevices") && System.getenv("getdevices").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getvehicletypes") && System.getenv("getvehicletypes").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("gettimezones") && System.getenv("gettimezones").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getvehiclegroups") && System.getenv("getvehiclegroups").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getdrivers") && System.getenv("getdrivers").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getvehiclesubscriptions")
				&& System.getenv("getvehiclesubscriptions").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getavlcountrylist") && System.getenv("getavlcountrylist").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getplans") && System.getenv("getplans").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getvehicles") && System.getenv("getvehicles").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getvehicleoverview")
				&& System.getenv("getvehicleoverview").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getvehiclesnapshotinaccount")
				&& System.getenv("getvehiclesnapshotinaccount").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getstoppedvehicles")
				&& System.getenv("getstoppedvehicles").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getmovingvehicles") && System.getenv("getmovingvehicles").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getdisconnectedVehicles")
				&& System.getenv("getdisconnectedVehicles").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getvehiclesoutofnetwork")
				&& System.getenv("getvehiclesoutofnetwork").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getTransportationAlerts")
				&& System.getenv("getTransportationAlerts").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getVehicleRawDetails")
				&& System.getenv("getVehicleRawDetails").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getDealerVehicleSnapshot")
				&& System.getenv("getDealerVehicleSnapshot").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getorgunits") && System.getenv("getorgunits").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getAllDriversDispatchModule")
				&& System.getenv("getAllDriversDispatchModule").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getAllDriverDispatchTasks")
				&& System.getenv("getAllDriverDispatchTasks").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("removeTask") && System.getenv("removeTask").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("updateodometer") && System.getenv("updateodometer").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		/*
		 * if (testMethod.getName().equals("getapnlistbycountryid") &&
		 * System.getenv("getapnlistbycountryidTest").contains("false")) {
		 * System.out.println("Disable " + testMethod.getName());
		 * annotation.setEnabled(false); }
		 */

		if (System.getenv("All").contains("true")) {

			annotation.setEnabled(true);
		}

	}

}
