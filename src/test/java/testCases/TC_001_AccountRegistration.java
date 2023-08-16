package testCases;
import PageObjects.HomePage;


import testBase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountRegistration;

public class TC_001_AccountRegistration extends BaseClass
{
	@Test(groups= {"Regression","Master"})
	public void Test_accountRegistration()
	{ 
		logger.debug("Application logs..");
		logger.info("** Starting Tec_001_AccountRegistration ***");
		try
		{
		HomePage hp=new HomePage(driver);
		logger.info("Clicked on my account");
		hp.clickMyAccount();
		
		logger.info("Clicked on Registor");
		hp.clickRegister();
		
		AccountRegistration regpage=new AccountRegistration(driver);
		
		logger.info("Providing customer data");
		
		regpage.setFirstName(randomeString().toUpperCase());
		
		regpage.setLastName(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		logger.info("Clicked on Privacy");
		regpage.setPrivacyPolicy();
		
		logger.info("Clicked on continue");
		regpage.clickContinue();
		
		logger.info("Validating expected message");
		String confmsg=regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!","test is failed");
		}
		catch(Exception e)
		{
			logger.error("Test is faield");
			Assert.fail();
		}
	}
	
	
}