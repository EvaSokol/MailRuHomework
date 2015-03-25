package site;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Actions {
	static WebDriver Driver = DriverManager.getDriver();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DriverManager.open();
		
		login();
		
//		int letters_before = get_inbox_letters();
//		
//		PageObjects.last_letter().click();
//		
//		PageObjects.delete_button().click();
//		
//		int letters_after = get_inbox_letters();
//		
	
		PageObjects.exit().click();

		DriverManager.finish();
		
		}
	
	public static void login() {
		
		DriverManager.open();
		
		PageObjects.login_field().sendKeys("eva.mask");
		PageObjects.domain_field().sendKeys("@mail.ru");
		PageObjects.password_field().sendKeys("karavan1");
		
		if (PageObjects.remember_checkbox().isSelected()) {
			PageObjects.remember_checkbox().click();
		}
		
		PageObjects.login_button().click();
	}
	
	public static void sendMail() {
		
		PageObjects.write_letter().click();
		PageObjects.input_address().sendKeys("eva.mask@mail.ru");
		PageObjects.input_address().click();
		PageObjects.input_subject().click();
		PageObjects.input_subject().sendKeys("TestLetter");
		PageObjects.open_smiles().click();
		PageObjects.dance_smile().click();
		PageObjects.send_button().click();
	}
	
	static void wait_by_login_field() {
		WebDriverWait _wait = new WebDriverWait(Driver, 3);
		_wait.until(ExpectedConditions.elementToBeClickable(PageObjects.login_field())); 
		}
	
	static void wait_by_exit() {
		WebDriverWait _wait = new WebDriverWait(Driver, 3);
		_wait.until(ExpectedConditions.elementToBeClickable(PageObjects.exit())); 
		}
	
	static int get_inbox_letters() {
		WebElement inbox = PageObjects.inbox_numbers();
		return Integer.parseInt(inbox.getText());
		}
	
	static boolean true_if_inbox_empty() {
		if (PageObjects.inbox_empty().isDisplayed()) 
			return true;
		else
			return false;
	}
	
	static void goInbox() {
		PageObjects.inbox().click();
	}
}
