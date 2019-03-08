//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html

package com.avlview.ExtentReporterListner;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;

	private ExtentManager() {
	}

	public static ExtentReports getInstance() {
		if (extent == null) {
			// Date d= new Date();
			// String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			// extent = new
			// ExtentReports(System.getProperty("user.dir")+File.separator+fileName, true,
			// DisplayOrder.OLDEST_FIRST);

			// extent.loadConfig(new File(System.getProperty("user.dir") +
			// "//src//test//resources//extentconfig//ReportsConfig.xml"));
			// optional
			// extent.addSystemInfo("Selenium Version", "2.53.1").addSystemInfo(
			// "Environment", "PROD");
			extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
			extent.addSystemInfo("Host Name", "Murali");
			extent.addSystemInfo("User Name", "mkrishnan");
			extent.addSystemInfo("Environment", "QA");

		}
		return extent;
	}
}
