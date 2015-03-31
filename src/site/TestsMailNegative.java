package site;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;

public class TestsMailNegative {

	@BeforeClass
	public static void StartBrowser() {
		DriverManager.open();
	}
	
	@Before
	public void CheckLoginPage() {
		Actions.wait_by_login_field();
	}
			
	@Test
	public void test_wrong_password() {
		Actions.login_data("eva.mask", "@mail.ru", "123");
		System.out.println("1");
		
		Actions.wait_by_wrong_login();
		System.out.println("2");
		
		assert (PageObjects.bad_login_or_password().isDisplayed());
		System.out.println("3");
		
		Actions.login_authorization();
		System.out.println("4");
		
		Actions.wait_by_exit();
		System.out.println("5");
		
		assert(PageObjects.inbox().isDisplayed());
		System.out.println("6");
		
		Actions.logout();
		System.out.println("7");

		System.out.println("8");
		
		assert(Actions.Title_check());
		System.out.println("9");
	}
	
	@AfterClass
	public static void StopBrowser() {
		DriverManager.finish();
	}

}
