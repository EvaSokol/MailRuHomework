package site;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class Actions {
	static WebDriver Driver = DriverManager.getDriver();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DriverManager.open();
		
		PageObjects.login_field().sendKeys("eva.mask");
		PageObjects.domain_field().sendKeys("@mail.ru");
		PageObjects.password_field().sendKeys("karavan1");
		if (PageObjects.remember_checkbox().isSelected()) {
			PageObjects.remember_checkbox().click();
		}
		
		PageObjects.login_button().click();
		
		PageObjects.write_letter().click();
		
		PageObjects.input_address().sendKeys("eva.mask@mail.ru");
		
		PageObjects.input_address().click();
		
		PageObjects.input_subject().click();
		
		PageObjects.input_subject().sendKeys("TestLetter");
		
		PageObjects.input_text().click();
		PageObjects.input_text().clear();
		PageObjects.input_text().sendKeys("Test Text Letter");
		
		PageObjects.send_button().click();
		
		assert(PageObjects.check_go_to_inbox().isDisplayed());
		
		PageObjects.inbox().click();
		
//		PageObjects.wait_by_exit();
//
//	
//		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		PageObjects.exit().click();
//		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		DriverManager.finish();
		
		}
	
}
