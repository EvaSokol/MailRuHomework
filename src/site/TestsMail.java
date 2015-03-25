package site;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;
import org.openqa.selenium.interactions.Action;

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

		if (Actions.true_if_inbox_empty()) {
			Actions.sendMail();
			Actions.goInbox();
		}
		
		int letters_before = Actions.get_inbox_letters();
		
		PageObjects.last_letter().click();
		
		PageObjects.delete_button().click();
		
		int letters_after;
		if (Actions.true_if_inbox_empty()) 
			letters_after = 0;
		else
			letters_after = Actions.get_inbox_letters();
		
		assert(letters_before - 1 == letters_after);
	}
	
//	@Test
//	public void cleanSentFolder() {
//		
//		Actions.login();
//		
//		Action action = new Action(DriverManager.getDriver());
//		PageObjects.sent_folder().sendKeys(Ri);
//	}
	
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
