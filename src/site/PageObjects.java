package site;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjects {

	static WebDriver Driver = DriverManager.getDriver();
	
// ****************** Mail.ru MAIN page ******************
	
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
// __________________ Mail.ru MAIN page __________________
	
// ****************** INBOX ******************
	
	static WebElement exit() {
		return Driver.findElement(By.xpath(".//a[@id='PH_logoutLink']"));
		}
	
	static WebElement inbox() {
		return Driver.findElement(By.xpath(".//i[@class='ico ico_folder ico ico_folder_inbox']"));
		}
	
	static WebElement write_letter() {
		return Driver.findElement(By.xpath(".//span[@class='b-toolbar__btn__text b-toolbar__btn__text_pad']"));
		}
	
	static List<WebElement> inbox_numbers_list() {
		return Driver.findElements(By.xpath(".//span[@class='b-nav__item__count']"));
		}
	
	static WebElement inbox_numbers() {
		return Driver.findElement(By.xpath(".//span[@class='b-nav__item__count']"));
		}
	
	static WebElement last_letter_checkbox() {
		return Driver.findElements(By.xpath(".//div[@class='js-item-cbx b-datalist__item__cbx']")).get(0);
		}
	
	static WebElement delete_button() {
		return Driver.findElement(By.xpath(".//div[@data-name='remove']"));
		}
	
	static WebElement delete_button2() {
		return Driver.findElement(By.xpath(".//div[@data-shortcut-title='del']"));
		}

	static WebElement sent_folder() {
		return Driver.findElement(By.xpath(".//i[@class='ico ico_folder ico ico_folder_send']"));
		}
	
	static WebElement trash_folder() {
		return Driver.findElement(By.xpath(".//i[@class='ico ico_folder ico ico_folder_trash']"));
		}
// __________________ INBOX __________________	
	
// ****************** WRITE LETTER ******************
	
	static WebElement input_address() {
		return Driver.findElement(By.xpath(".//textarea[@class='js-input compose__labels__input']"));
		}
	
	static WebElement input_subject() {
		return Driver.findElement(By.xpath(".//input[@name='Subject']"));
		}
	
	static WebElement input_text() {
		return Driver.findElement(By.xpath(".//body[@class='mceContentBody']"));
		}
	
	static WebElement open_smiles() {
		return Driver.findElement(By.xpath(".//span[@class='mceAction mce_emotions']"));
		}
	
	static WebElement dance_smile() {
		return Driver.findElement(By.xpath(".//img[@class='dance']"));
		}
	
	static WebElement send_button() {
		return Driver.findElement(By.xpath(".//span[@class='b-toolbar__btn__text']"));
		}
// __________________ WRITE LETTER __________________
	
// ****************** LETTER is SENT ******************

	static WebElement check_go_to_inbox() {
		return Driver.findElement(By.xpath(".//a[@class='message-sent__title__link']"));
		}
// __________________ LETTER is SENT __________________	

// ****************** SENT PAGE ******************
	static WebElement check_all_letters() {
		return Driver.findElement(By.xpath(".//div[@class='cbx__checkmark']"));
		}
	
	static WebElement check_all_page() {
		return Driver.findElement(By.xpath(".//div[@class='b-layout']"));
		}
	
	static List<WebElement> sent_numbers_list() {
		return Driver.findElements(By.xpath(".//span[@class='b-nav__item__count']"));
		}
	
	static WebElement sent_numbers() {
		return Driver.findElement(By.xpath(".//span[@class='b-nav__item__count']"));
		}
// __________________ SENT PAGE __________________

// ****************** TRASH Folder PAGE ******************
	static WebElement clean_trash_folder_button() {
		return Driver.findElement(By.xpath(".//button[@data-name='clearFolder']"));
		}
	
	static WebElement clean_trash_confirmation_button() {
		return Driver.findElement(By.xpath(".//span[@class='btn__text']"));
		}
	
	static WebElement clean_trash_confirmation() {
		return Driver.findElement(By.xpath(".//div[@class='is-clearFolderConfirm_in']/form/div[2]/button[2]"));
		}
	
	static List<WebElement> trash_empty() {
		return Driver.findElements(By.xpath(".//div[@class='b-datalist__empty__icon b-datalist__empty__icon_trash']"));
		}
		
// __________________ TRASH Folder PAGE __________________	

// ****************** NEW PAGE ******************
// __________________ NEW PAGE __________________
	

	
}
