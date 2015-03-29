package site;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Actions {
	static WebDriver Driver = DriverManager.getDriver();
	static WebDriverWait _wait = new WebDriverWait(Driver, 3);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DriverManager.open();
		
		login();
		
		markAllUnread();
	
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
		_wait.until(ExpectedConditions.elementToBeClickable(PageObjects.login_field())); 
		}
	
	static void wait_by_exit() {
		WebDriverWait _wait = new WebDriverWait(Driver, 5);
		_wait.until(ExpectedConditions.elementToBeClickable(PageObjects.exit())); 
		}
	
	static void wait_by_delete() {
		WebDriverWait _wait = new WebDriverWait(Driver, 3);
		_wait.until(ExpectedConditions.elementToBeClickable(PageObjects.delete_button())); 
		}
	
	static int get_inbox_letters() {
		if (PageObjects.inbox_numbers_list().size() == 0)
			return 0;
		else {
			WebElement inbox = PageObjects.inbox_numbers();
			return Integer.parseInt(inbox.getText());
			}
		}
	
	static void goInbox() {
		PageObjects.inbox().click();
		}
	
	static void goTrash() {
		PageObjects.trash_folder().click();
		}
	
	static void markAllUnread() {
		PageObjects.check_all_page().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		PageObjects.check_all_page().sendKeys("u");
		PageObjects.check_all_page().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		}
	
	static void deleteAll() {
		PageObjects.check_all_page().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		PageObjects.check_all_page().sendKeys(Keys.DELETE);
		}

	static void delete_last_letter() {
		goInbox();
		if (get_inbox_letters() == 0) {
			sendMail();
			goInbox();
		}
		PageObjects.last_letter_checkbox().click();
		PageObjects.delete_button().click();
		}
	
	static boolean true_if_trash_empty() {
		if (PageObjects.trash_empty().size() == 0)
			return false;
		else 
			return true;
	}
	
	static void cleanTrash() {
		PageObjects.clean_trash_folder_button().click();
//		PageObjects.clean_trash_confirmation_button().submit();
//		_wait.until(ExpectedConditions.elementToBeClickable(PageObjects.clean_trash_confirmation_button())); 
		PageObjects.clean_trash_confirmation().click();
	}
}
