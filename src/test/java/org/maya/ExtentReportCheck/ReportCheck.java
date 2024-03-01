package org.maya.ExtentReportCheck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportCheck {
	ExtentReports extents;
	@Test
	public void Test1() {
		ExtentTest test =  extents.createTest("My First Test");
		System.setProperty("webdriver.chrome.driver", "C:\\JarsForTestAut\\driver6\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setBinary("C:\\JarsForTestAut\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase("Selenium, API Testing, Software Testing & More QA Tutorials | Rahul Shetty Academ")) {
			test.pass("Passed");
		}else
			test.fail("Failed");
		extents.flush();
	}
	
	@BeforeTest
	public void initReport() {
		String reportPath = System.getProperty("user.dir")+"\\Report\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Maya Test");
		reporter.config().setDocumentTitle("Maya Test Results");
		extents = new ExtentReports();
		extents.attachReporter(reporter);
		extents.setSystemInfo("Tester", "MayaTru");
	}
}
