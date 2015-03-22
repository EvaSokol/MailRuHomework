package site;

import org.openqa.selenium.WebDriver;


public class Actions {
	static WebDriver Driver = DriverManager.getDriver();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DriverManager.open();
		
		PageObjects.login_field().sendKeys("***");
		PageObjects.domain_field().sendKeys("@mail.ru");
		PageObjects.password_field().sendKeys("***");
		if (PageObjects.remember_checkbox().isSelected()) {
			PageObjects.remember_checkbox().click();
		}
		
		PageObjects.login_button().click();
//		PageObjects.wait_by_exit();

	
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PageObjects.exit().click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DriverManager.finish();
		
		}
	
}
