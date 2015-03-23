package site;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestsMail {

	@Test
	public void testLoginLogout() {
		
		DriverManager.open();
		
		PageObjects.login_field().sendKeys("eva.mask");
		PageObjects.domain_field().sendKeys("@mail.ru");
		PageObjects.password_field().sendKeys("karavan1");
		if (PageObjects.remember_checkbox().isSelected()) {
			PageObjects.remember_checkbox().click();
		}
		
		PageObjects.login_button().click();
		PageObjects.wait_by_exit();
		
		assert(PageObjects.inbox().isDisplayed());
		
		PageObjects.exit().click();
				
		DriverManager.finish();
	}

}
