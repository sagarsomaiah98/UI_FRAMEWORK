package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.NinjaConstants;

public class TestBase {
	
	public static WebDriver driver;
	FileInputStream fis;
	Properties prop;
	
	public void intialize() throws IOException {
		
		 fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\config\\Config.properties");
		
		 prop = new Properties();
		prop.load(fis);
		
		String bname=prop.getProperty("browser");
		
		switch(bname) {
		
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		
		default:
			System.out.println("Invalid browser");
		
		
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(NinjaConstants.timeOut));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(NinjaConstants.pageTimeOut));
		driver.get(prop.getProperty("url"));
	}

}
