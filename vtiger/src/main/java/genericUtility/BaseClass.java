package genericUtility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import pomRepository.HomePage;
import pomRepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
  public FileUtility futils=new FileUtility();
  public ExcelUtility eutils=new ExcelUtility();
  public JavaUtility jutils=new JavaUtility();
  public WebDriverUtility wutils=new WebDriverUtility();
  public DataBaseUtility dutils=new DataBaseUtility();
  
  public static WebDriver sDriver;
  public Connection connection;	
  
@BeforeSuite(groups= {"smoke","regression"})
public void bsConfig() throws SQLException {
	Driver dataBaseDriver = new Driver();
	//JDBC register with My Sql
	DriverManager.registerDriver(dataBaseDriver);
	//Connection Establish
	connection = DriverManager.getConnection(IPathConstant.DATABASE_URL, IPathConstant.DATABASE_USERNAME, IPathConstant.DATABASE_PASSWORD);
	System.out.println("Database connection achieved");
}
@BeforeClass(groups= {"smoke","regression"})
public void bcConfig() throws IOException {
	
	 String browser = futils.fetchDataFromPropertyFile("browser");
	 String url = futils.fetchDataFromPropertyFile("url");
	if(browser.equals("chrome")) {
		driver=new ChromeDriver();
	}
	else if(browser.equals("firefox")) {
		driver=new FirefoxDriver();
	}
	else if(browser.equals("Edge")) {
		driver=new EdgeDriver();
	}
	System.out.println("The browser is launched");
	sDriver=driver;
	wutils.maximizeTheWindow(driver);
	wutils.waitForElementToLoad(driver);
	driver.get(url);
	System.out.println("The url is navigated");
}
@BeforeMethod(groups= {"smoke","regression"})
public void bmConfig() throws IOException {
	
	String username = futils.fetchDataFromPropertyFile("username");
	String password = futils.fetchDataFromPropertyFile("password");
	
	LoginPage login=new LoginPage(driver);
	login.loginAction(username, password);
	System.out.println("Login into Application");
}
@AfterMethod(groups= {"smoke","regression"})
public void amConfig() {
	
	HomePage homepage = new HomePage(driver);
	homepage.signoutAction();
	System.out.println("Signout from the application");
}

@AfterClass(groups= {"smoke","regression"})
public void acConfig() {
	driver.quit();
	System.out.println("The browser is closed");
}

@AfterSuite(groups= {"smoke","regression"})
public void asConfig() throws SQLException {
	connection.close();
	System.out.println("Database connection is closed");
}
}
