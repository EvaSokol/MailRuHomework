package site;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;
import org.openqa.selenium.Keys;

public class TestsMail {

	@BeforeClass
	public static void StartBrowser() {
		DriverManager.open();
	}
	
	@Before
	public void CheckLoginPage() {
		Actions.wait_by_login_field();
	}
	
	@Test
	public void testLoginLogout() {
		
		Actions.login();
		
		Actions.wait_by_exit();
		
		assert(PageObjects.inbox().isDisplayed());

	}
	
	@Test
	public void testSendMail() {
		
		Actions.login();
		
		int letters_before = Actions.get_inbox_letters();
		
		Actions.sendMail();
		
		assert(PageObjects.check_go_to_inbox().isDisplayed());
		
		int letters_after = Actions.get_inbox_letters();
		
		assert(letters_before + 1 == letters_after);
	}
	
	@Test
	public void testDeleteLastLetter() {
			
		Actions.login();

		if (Actions.get_inbox_letters() == 0) {
			Actions.sendMail();
			Actions.goInbox();
		}

		int letters_before = Actions.get_inbox_letters();

		PageObjects.last_letter().click();

		PageObjects.delete_button().click();

		int letters_after = Actions.get_inbox_letters();

		assert(letters_before - 1 == letters_after);
	}
	
	@Test
	public void cleanSentFolder() {
		
		Actions.login();
		System.out.println("1");
		PageObjects.sent_folder().click();
		System.out.println("2");
		PageObjects.check_all_page().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		
		System.out.println("3");
		PageObjects.check_all_page().sendKeys(Keys.DELETE);
//		PageObjects.delete_button().click();
		System.out.println("4");
		assert(Actions.get_inbox_letters() == 0);
	}
	
	@After
	public void Logout() {
		Actions.wait_by_exit();
		PageObjects.exit().click();
	}
	
	@AfterClass
	public static void StopBrowser() {
		DriverManager.finish();
	}

}
