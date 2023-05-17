package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	public WebElement myAccount;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	public WebElement loginMenu;
	
	@FindBy(xpath="//input[@id='input-email']")
	public WebElement email;
	
	@FindBy(xpath="//input[@id='input-password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	public WebElement loginButton;
	
	

	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void login(String uname, String pwd) throws InterruptedException {
		
		myAccount.click();
		loginMenu.click();
		email.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
	}


}
