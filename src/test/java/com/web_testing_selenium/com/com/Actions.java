package com.web_testing_selenium.com.com;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import java.sql.DriverManager;


public class Actions {
	static WebDriver Driver = DriverManager.getDriver();
	static WebDriverWait _wait = new WebDriverWait(Driver, 3);
	
// ****************** COMMON ******************
	public static void logout() {
//		Actions.wait_by_exit();
		PageObjects.exit().click();
	}
	
	static void wait_by_exit() {
		_wait.until(ExpectedConditions.elementToBeClickable(PageObjects.exit()));
		}
	
	static void wait_by_delete() {
		WebDriverWait _wait = new WebDriverWait(Driver, 3);
		_wait.until(ExpectedConditions.elementToBeClickable(PageObjects.delete_button())); 
		}
	
	public static void goInbox() {
		PageObjects.inbox().click();
		}
	
	public static void goTrash() {
		PageObjects.trash_folder().click();
		}
	
	public static void markAllUnread() {
		PageObjects.check_all_page().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		PageObjects.check_all_page().sendKeys("u");
		PageObjects.check_all_page().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		}
	
	public static void delete_All() {
		PageObjects.check_all_page().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		PageObjects.check_all_page().sendKeys(Keys.DELETE);
		}
	
	public static void go_Sent_folder() {
		PageObjects.sent_folder().click();	
	}
// __________________ COMMON __________________

// ****************** MAIN page ******************

	public static void main(String[] args) {

		DriverManager.open();
		
		login();
		
		sendMail();

		DriverManager.finish();
		
		}
	
	public static void login() {

		login_data("eva.mask", "@mail.ru", "karavan1");
	}
	
	public static void login_data(String name, String domain, String password) {
		DriverManager.open();
		wait_by_login_field();
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
	
	public static boolean main_Title_check() {
//		if (Driver.getTitle() == "Mail.Ru: �����, ����� � ���������, �������, ����")
//			return true;
//		return false;
		if (PageObjects.main_authorized().isDisplayed() || PageObjects.main_nonAuthorized().isDisplayed())
			return true;
		return false;
	}
	
	public static void wait_by_wrong_login() {
		_wait.until(ExpectedConditions.visibilityOf(PageObjects.bad_login_or_password())); 
		}
	
	static void wait_by_login_field() {
		_wait.until(ExpectedConditions.elementToBeClickable(PageObjects.login_field())); 
		}
	
	public static void logout_forse() {
		if (PageObjects.main_logout().isDisplayed()) {
			PageObjects.main_logout().click();
		}
		else 
			return;
	}
// __________________ MAIN page __________________
	
// ****************** INBOX PAGE ******************
	public static boolean inboxCheck() {
		if (PageObjects.inbox().isDisplayed())
			return true;
		return false;
	}
	
	public static int get_inbox_letters() {
		if (PageObjects.inbox_numbers_list().size() == 0) {
			return 0;
		}
			
		else {
			WebElement inbox = PageObjects.inbox_numbers();
			return Integer.parseInt(inbox.getText());
			}
		}
	
	public static void delete_last_letter() {
		goInbox();
		if (get_inbox_letters() == 0) {
			sendMail();
			goInbox();
		}
		PageObjects.last_letter_checkbox().click();
		PageObjects.delete_button().click();
		}
// __________________ INBOX PAGE __________________
	
// ****************** SEND MAIL ******************
	public static boolean sendMail_Title_check() {
		String titleString = Driver.getTitle();
		CharSequence s = "����� ������";
		if (titleString.contains(s))
			return true;
		return false;
	}
	
 	public static void sendMail() {
		send_Mail_with_requisites("eva.mask@mail.ru", "TestLetter");
	}

	public static void send_Mail_with_requisites(String address, String subject) {
		PageObjects.write_letter().click();
//		assert sendMail_Title_check();
		wait_by_input_address();
		PageObjects.input_address().sendKeys(address);
		PageObjects.input_address().click();
		PageObjects.input_subject().click();
		PageObjects.input_subject().sendKeys(subject);
		PageObjects.open_smiles().click();
		PageObjects.dance_smile().click();
		PageObjects.send_button().click();
		PageObjects.inbox().click();
	}
	
	static void wait_by_input_address() {
		_wait.until(ExpectedConditions.visibilityOf(PageObjects.input_address())); 
		}
	
// __________________ SEND MAIL __________________

// ****************** SENT folder ******************
	public static boolean sentFolder_Title_check() {
		String titleString = Driver.getTitle();
		CharSequence s = "������������";
		if (titleString.contains(s))
			return true;
		return false;
	}
	
	public static int get_sent_letters() {
		if (PageObjects.sent_numbers_list().size() == 0) 
			return 0;	
		else {
			WebElement inbox = PageObjects.sent_numbers();
			return Integer.parseInt(inbox.getText());
		}
	}
// __________________ SENT folder __________________	
	
// ****************** TRASH ******************
	public static boolean trash_Title_check() {
		String titleString = Driver.getTitle();
		CharSequence s = "�������";
		if (titleString.contains(s))
			return true;
		return false;
	}

	public static boolean true_if_trash_empty() {
		if (PageObjects.trash_empty().size() == 0)
			return false;
		else 
			return true;
	}
	
	public static void cleanTrash() {
		PageObjects.clean_trash_folder_button().click();
		PageObjects.clean_trash_confirmation().click();
	}
// __________________ TRASH __________________
	
}

