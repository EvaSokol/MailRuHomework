package site;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG_Mail {
  
//	@Test(dataProvider = "dp")
//  public void f(Integer n, String s) {
//  }
  
	@Test
	public void test_LoginLogout() {
		
		Actions.login();
		
		assert(Actions.inbox_Title_check());
		
		Actions.logout();
		
		assert(Actions.main_Title_check());

	}
	
	@Test
	public void test_SendMail() {
		
		Actions.login();
		
		Actions.markAllUnread();
		
		int letters_before = Actions.get_inbox_letters();

		Actions.sendMail();
		
		assert(Actions.inbox_Title_check());
		
		int letters_after = Actions.get_inbox_letters();
		
		assert(letters_before + 1 == letters_after);
		
		Actions.logout();
		
		assert(Actions.main_Title_check());
	}
	
	@Test
	public void test_DeleteLastLetter() {
		
		Actions.login();
		
		Actions.inbox_Title_check();
		
		Actions.markAllUnread();

		if (Actions.get_inbox_letters() == 0) {
			Actions.sendMail();
			Actions.goInbox();
		}

		int letters_before = Actions.get_inbox_letters();

		Actions.delete_last_letter();

		int letters_after = Actions.get_inbox_letters();

		assert(letters_before - 1 == letters_after);
		
		Actions.logout();
		
		assert(Actions.main_Title_check());
	}
	
	@Test
	public void test_CleanSentFolder() {
		
		Actions.login();

		Actions.go_Sent_folder();
		
		assert(Actions.sentFolder_Title_check());
		
		Actions.markAllUnread();
		
		if (Actions.get_sent_letters() == 0) {
			Actions.sendMail();
			Actions.go_Sent_folder();
		}
		
		Actions.markAllUnread();
		
		Actions.delete_All();
		
		assert(Actions.get_sent_letters() == 0);
		
		Actions.logout();
		
		assert(Actions.main_Title_check());
	}
	
	@Test
	public void test_CleanTrashFolder() {
		
		Actions.login();
		
		assert(Actions.inbox_Title_check());

		Actions.goTrash();
		
		if (Actions.true_if_trash_empty()) {
			Actions.delete_last_letter();
			}
		
		Actions.goTrash();
		
		assert(Actions.trash_Title_check());
		
		Actions.cleanTrash();
				
		assert(Actions.true_if_trash_empty());
		
		Actions.logout();
		
		assert(Actions.main_Title_check());
	}
	
	@Test
	public void test_WrongPassword() {
		Actions.login_data("eva.mask", "@mail.ru", "123");
		
		Actions.wait_by_wrong_login();
		
		assert (PageObjects.bad_login_or_password().isDisplayed());
		
		Actions.login_authorization();
		
		assert(Actions.inbox_Title_check());
		
		Actions.logout();
		
		assert(Actions.main_Title_check());
	}
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

//  @DataProvider
//  public Object[][] dp() {
//    return new Object[][] {
//      new Object[] { 1, "a" },
//      new Object[] { 2, "b" },
//    };
//  }
  
  @BeforeClass
  public static void StartBrowser() {
		DriverManager.open();
	}

  @AfterClass
  public static void StopBrowser() {
		DriverManager.finish();
  	}

  @BeforeTest
  public void Check_Logged_Out() {
		Actions.logout_forse();
	}

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
