package genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.WelcomePage;

//It is used for write pre condition and post condition
public class baseClass {
	public WebDriver driver;
	public static ExtentReports extReport;
	public static ExtentTest test;
	public javaUtility jLib = new javaUtility();
	public fileUtility fLib = new fileUtility();
	public WelcomePage wp;
	public LoginPage lp;
	public HomePage hp;

	@BeforeSuite
	public void reportConfig() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_reports/" + jLib.getSystemTime() + ".html");
		extReport = new ExtentReports();
		extReport.attachReporter(spark);
	}

	@Parameters("Browser")
	@BeforeClass 
	public void launchBrowser(@Optional("chrome") String browserName) throws IOException {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(fLib.getDataFromproperty("url"));

	}

	@BeforeMethod
	public void login() throws IOException {
		wp = new WelcomePage(driver);
		wp.getLoninLink().click();
		lp = new LoginPage(driver);
		lp.getEmailTextField().sendKeys(fLib.getDataFromproperty("email"));
		lp.getPasswordTextField().sendKeys(fLib.getDataFromproperty("password"));
		lp.getLoginButton().click();
	}

	@AfterMethod
	public void logout() {
		hp = new HomePage(driver);
		hp.getLogoutLink();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite
	public void reportBackup() {
		extReport.flush();
	}

}
