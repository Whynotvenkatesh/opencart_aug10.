package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{

	public LoginPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement logout;
	
	public void setusername(String user)
	{
		username.sendKeys(user);
	}
	
	public void stepassword(String pwrd)
	{
		password.sendKeys(pwrd);
	}
	
	public void logutbtn()
	{
		logout.click();
	}
	
	

}
