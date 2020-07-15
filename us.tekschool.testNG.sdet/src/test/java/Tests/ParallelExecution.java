package Tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import Core.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExecution extends Base {
	
	@Test
	public void chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://tek-school.com/hotel/");
		logger.info("This Title is from Chrome Execution: " + driver.getTitle());
	}
	@Test
	public void fireFoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://tek-school.com/hotel/");
		logger.info("This Title is from Firefox Execution: " + driver.getTitle());
	}
	@Test
	public void edgeBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("http://tek-school.com/hotel/");
		logger.info("This Title is from IE Execution: " + driver.getTitle());
	}
	@Test
	@Ignore
	public void internetExpBrowser1() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		driver.get("http://tek-school.com/hotel/");
		logger.info("This Title is from IE Execution: " + driver.getTitle());
		
	}

}
