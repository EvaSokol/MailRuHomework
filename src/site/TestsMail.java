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

		if (Actions.true_if_inbox_zero()) {
			Actions.sendMail();
			Actions.goInbox();
		}
		System.out.println("1");
		int letters_before = Actions.get_inbox_letters();
		System.out.println("2");
		PageObjects.last_letter().click();
		System.out.println("3");
		PageObjects.delete_button().click();
		System.out.println("4");
		int letters_after = 0;
		if (! (Actions.true_if_inbox_empty())) 
			letters_after = Actions.get_inbox_letters();
		System.out.println("5");
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
