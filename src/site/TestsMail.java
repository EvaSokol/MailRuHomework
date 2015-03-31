package site;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;

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
	public void test_LoginLogout() {
		
		Actions.login();
		
		assert(PageObjects.inbox().isDisplayed());

	}
	
	@Test
	public void test_SendMail() {
		
		Actions.login();
		
		Actions.markAllUnread();
		
		int letters_before = Actions.get_inbox_letters();
		
		Actions.sendMail();
		
		assert(PageObjects.check_go_to_inbox().isDisplayed());
		
		int letters_after = Actions.get_inbox_letters();
		
		assert(letters_before + 1 == letters_after);
	}
	
	@Test
	public void test_DeleteLastLetter() {
			
		Actions.login();
		
		Actions.markAllUnread();

		if (Actions.get_inbox_letters() == 0) {
			Actions.sendMail();
			Actions.goInbox();
		}

		int letters_before = Actions.get_inbox_letters();

		Actions.delete_last_letter();

		int letters_after = Actions.get_inbox_letters();

		assert(letters_before - 1 == letters_after);
	}
	
	@Test
	public void test_CleanSentFolder() {
		
		Actions.login();

		Actions.go_Sent_folder();
		Actions.markAllUnread();
		
		if (Actions.get_sent_letters() == 0) {
			Actions.sendMail();
			Actions.go_Sent_folder();
		}
		
		Actions.markAllUnread();
		
		Actions.delete_All();
		
		assert(Actions.get_sent_letters() == 0);
	}
	
	@Test
	public void test_CleanTrashFolder() {
		
		Actions.login();

		Actions.goTrash();
		
		if (Actions.true_if_trash_empty()) {
			Actions.delete_last_letter();
			}
		
		Actions.goTrash();
		
		Actions.cleanTrash();
				
		assert(Actions.true_if_trash_empty());
	}
	
	@After
 	public void Logout() {
		Actions.logout();
	}
	
	@AfterClass
	public static void StopBrowser() {
		DriverManager.finish();
	}

}


