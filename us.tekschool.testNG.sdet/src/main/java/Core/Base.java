package Core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;
	private String propertyPath = ".\\src\\test\\resourses\\Properties\\ProjectProperty.properties";
	
	public Base() {
	    try {
	    	BufferedReader reader;
	    	reader = new BufferedReader(new FileReader(propertyPath));
	    	properties = new Properties();
	    	try {
	    		properties.load(reader);
	    		reader.close();
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();
	    }
	    logger = logger.getLogger("Logger_file");
	    PropertyConfigurator.configure(".\\src\\test\\resourses\\Properties\\log4j.properties");
	}
	public static String getBrowserName() {
		String browserName = properties.getProperty("browserName");
		return browserName;
	}
	public static String getURL() {
		String url = properties.getProperty("url");
		return url;
	}
	public static Long getPageLoadTime() {
		String pageLoadTime = properties.getProperty("pageloadtieme");
		return Long.parseLong(pageLoadTime);
	}
	public static Long getImplicitlyTime() {
		String pimplicitlyWaitTime = properties.getProperty("implicitWait");
		return Long.parseLong(pimplicitlyWaitTime);
	}
	public static String getUserName() {
		String userName = properties.getProperty("userName");
		return userName;
	}
	public static String getPassword() {
		String password = properties.getProperty("password");
		return password;
	}
	public static void initializeDriver() {
		if(Base.getBrowserName().equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	} else if (Base.getBrowserName().equalsIgnoreCase("edgedriver")) {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
    } else if (Base.getBrowserName().equalsIgnoreCase("ff")) {
    	WebDriverManager.firefoxdriver().setup();
    	driver = new FirefoxDriver();
    } else {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    }
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Base.getPageLoadTime(), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Base.getImplicitlyTime(), TimeUnit.SECONDS);
		driver.get(Base.getURL());
		
	}
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
