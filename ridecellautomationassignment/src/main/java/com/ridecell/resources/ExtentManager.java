package com.ridecell.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	  private static final ExtentReports extentReports = new ExtentReports();

	    public synchronized static ExtentReports getExtentReports() {
	        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
	        reporter.config().setReportName("Ride Cell Automation Report");
	        extentReports.attachReporter(reporter);
	        return extentReports;
	    }

}
