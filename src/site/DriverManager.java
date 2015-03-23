package site;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {

	static String BaseUrl = "https://mail.ru/";
	static WebDriver Driver = new FirefoxDriver();
		
	static {
		Driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	static void open() {
		
		Driver.get(BaseUrl);
	}
	
	void open(String url) {
		Driver.get(url);
	}
		
	static WebDriver getDriver() {
		return Driver;
	}
	
	static void finish() {
		DriverManager.Driver.quit();
	}

}
