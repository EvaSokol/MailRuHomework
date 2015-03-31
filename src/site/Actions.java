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
		login_data("eva.mask", "@mail.ru", "karavan1");
	}
	
	public static void login_data(String name, String domain, String password) {
		
		DriverManager.open();
		
		PageObjects.login_field().sendKeys(name);
		PageObjects.domain_field().sendKeys(domain);
		PageObjects.password_field().sendKeys(password);
		
		if (PageObjects.remember_checkbox_login_page().isSelected()) {
			PageObjects.remember_checkbox_login_page().click();
		}
		
		PageObjects.login_button().click();
	}
	
	public static void login_authorization() {
		
		PageObjects.login_field().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		PageObjects.login_field().sendKeys("eva.mask");
		PageObjects.domain_field().sendKeys("@mail.ru");
		PageObjects.password_field().sendKeys("karavan1");
		
		if (PageObjects.remember_checkbox_auth_form().isSelected()) {
			PageObjects.remember_checkbox_auth_form().click();
		}
		
		PageObjects.login_authorization_button().click();
	}
	
	public static void logout() {
		Actions.wait_by_exit();
		PageObjects.exit().click();
	}
	
	public static boolean Title_check() {
		if (Driver.getTitle() == "Mail.Ru: почта, поиск в интернете, новости, игры")
			return true;
		return false;
	}
	
 	public static void sendMail() {
		send_Mail_with_requisites("eva.mask@mail.ru", "TestLetter");
	}

	public static void send_Mail_with_requisites(String address, String subject) {
		
		PageObjects.write_letter().click();
		PageObjects.input_address().sendKeys(address);
		PageObjects.input_address().click();
		PageObjects.input_subject().click();
		PageObjects.input_subject().sendKeys(subject);
		PageObjects.open_smiles().click();
		PageObjects.dance_smile().click();
		PageObjects.send_button().click();
	}
	
	static void wait_by_wrong_login() {
		_wait.until(ExpectedConditions.visibilityOf(PageObjects.bad_login_or_password())); 
		}
	
	static void wait_by_login_field() {
		_wait.until(ExpectedConditions.elementToBeClickable(PageObjects.login_field())); 
		}
	
	static void wait_by_exit() {
//		WebDriverWait _wait = new WebDriverWait(Driver, 5);
		_wait.until(ExpectedConditions.elementToBeClickable(PageObjects.exit())); 
		}
	
	static void wait_by_delete() {
		WebDriverWait _wait = new WebDriverWait(Driver, 3);
		_wait.until(ExpectedConditions.elementToBeClickable(PageObjects.delete_button())); 
		}
	
	static int get_inbox_letters() {
		if (PageObjects.inbox_numbers_list().size() == 0) {
			return 0;
		}
			
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
	
	static void delete_All() {
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
		PageObjects.clean_trash_confirmation().click();
	}

	static void go_Sent_folder() {
		PageObjects.sent_folder().click();
		
	}

	public static int get_sent_letters() {
		if (PageObjects.sent_numbers_list().size() == 0) {
			return 0;
		}
			
		else {
			WebElement inbox = PageObjects.sent_numbers();
			return Integer.parseInt(inbox.getText());
			}
	}
}
