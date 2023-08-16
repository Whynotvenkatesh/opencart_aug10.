package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccount;

public class TC_002_LoginTest extends BaseClass
{

	@Test(groups= {"Sanity","Master"})
	public void logintest()
	{
		logger.info("** started login test **");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clicklogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setusername(rb.getString("email"));
		lp.stepassword(rb.getString("password"));
		
		lp.logutbtn();
		
		MyAccount myacc=new MyAccount(driver);
		boolean targetpage =myacc.myaccountpresence();
		
		Assert.assertEquals(targetpage,true);
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		logger.info("** testing is completed **");
		
	}
}
