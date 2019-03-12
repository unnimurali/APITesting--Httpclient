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

		// post

		if (testMethod.getName().equals("getapnlistbycountryid")
				&& System.getenv("getapnlistbycountryid").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getapnlistbyvehicleid")
				&& System.getenv("getapnlistbyvehicleid").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getvehiclesbyplan") && System.getenv("getvehiclesbyplan").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getvehiclecurrentlocation")
				&& System.getenv("getvehiclecurrentlocation").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getvehicleoverviewbyplan")
				&& System.getenv("getvehicleoverviewbyplan").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getvehiclesnapshotinaccountbyplan")
				&& System.getenv("getvehiclesnapshotinaccountbyplan").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getvehiclesnapshot")
				&& System.getenv("getvehiclesnapshot").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getstoppedvehiclesbyplan")
				&& System.getenv("getstoppedvehiclesbyplan").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getmovingvehiclesbyplan")
				&& System.getenv("getmovingvehiclesbyplan").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getvehiclesoutofnetworkbyplan")
				&& System.getenv("getvehiclesoutofnetworkbyplan").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getdisconnectedvehiclesbyplan")
				&& System.getenv("getdisconnectedvehiclesbyplan").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getvehiclesnapshotbydate")
				&& System.getenv("getvehiclesnapshotbydate").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getvehiclehistory") && System.getenv("getvehiclehistory").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getnearbyvehicles") && System.getenv("getnearbyvehicles").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getnearbyvehiclesbyplan")
				&& System.getenv("getnearbyvehiclesbyplan").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getstoppagedetails")
				&& System.getenv("getstoppagedetails").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getvehiclesnapshotinaccountSG")
				&& System.getenv("getvehiclesnapshotinaccountSG").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getWaypoints") && System.getenv("getWaypoints").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getAlertDetail") && System.getenv("getAlertDetail").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getTripDetails") && System.getenv("getTripDetails").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getidlereport") && System.getenv("getidlereport").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getdailysummaryreport")
				&& System.getenv("getdailysummaryreport").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getSummaryReport") && System.getenv("getSummaryReport").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getRawDataInTimeRange")
				&& System.getenv("getRawDataInTimeRange").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getactivevehiclesnapshotinaccountSG")
				&& System.getenv("getactivevehiclesnapshotinaccountSG").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("gettripdetailsSG") && System.getenv("gettripdetailsSG").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("getvehiclehistorySG")
				&& System.getenv("getvehiclehistorySG").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("addgroup") && System.getenv("addgroup").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("adddriver") && System.getenv("adddriver").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("saveFenceZone") && System.getenv("saveFenceZone").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("addorgunit") && System.getenv("addorgunit").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("createDriverDispatchTask")
				&& System.getenv("createDriverDispatchTask").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (testMethod.getName().equals("addvehicle") && System.getenv("addvehicle").contains("false")) {
			System.out.println("Disable " + testMethod.getName());
			annotation.setEnabled(false);
		}

		if (System.getenv("All").contains("true")) {

			annotation.setEnabled(true);
		}

	}

}
