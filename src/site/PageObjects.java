package site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjects {

	static WebDriver Driver = DriverManager.getDriver();
	
	static WebElement login_field() {
		return Driver.findElement(By.xpath(".//input[@id='mailbox__login']"));
		}
	
	static WebElement password_field() {
		return Driver.findElement(By.xpath(".//input[@id='mailbox__password']"));
		}
	
	static WebElement domain_field() {
		return Driver.findElement(By.xpath(".//select[@id='mailbox__login__domain']"));
		}
	
	static WebElement login_button() {
		return Driver.findElement(By.xpath(".//input[@id='mailbox__auth__button']"));
		}
	
	static WebElement remember_checkbox() {
		return Driver.findElement(By.xpath(".//input[@id='mailbox__auth__remember__checkbox']"));
		}
	
	static void wait_by_exit() {
		WebDriverWait _wait = new WebDriverWait(Driver, 3);
		_wait.until(ExpectedConditions.elementToBeClickable(exit())); 
		}
	
	static WebElement exit() {
		return Driver.findElement(By.xpath(".//a[@id='PH_logoutLink']"));
		}
	
	static WebElement inbox() {
		return Driver.findElement(By.xpath(".//i[@class='ico ico_folder ico ico_folder_inbox']"));
		}
	
	static WebElement write_letter() {
		return Driver.findElement(By.xpath(".//span[@class='b-toolbar__btn__text b-toolbar__btn__text_pad']"));
		}
	
	static WebElement input_address() {
		return Driver.findElement(By.xpath(".//textarea[@class='js-input compose__labels__input']"));
		}
	
	static WebElement input_subject() {
		return Driver.findElement(By.xpath(".//input[@name='Subject']"));
		}
	
	static WebElement input_text() {
		return Driver.findElement(By.xpath(".//body[@class='mceContentBody']"));
		}
	
	static WebElement send_button() {
		return Driver.findElement(By.xpath(".//span[@class='b-toolbar__btn__text']"));
		}
	
	static WebElement check_go_to_inbox() {
		return Driver.findElement(By.xpath(".//a[@class='message-sent__title__link']"));
		}
}
