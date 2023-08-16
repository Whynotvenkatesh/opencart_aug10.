package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass
{
	
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void logintest(String email,String pswrd,String exp)
	{
		logger.info("** started login test **");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clicklogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setusername(email);
		lp.stepassword(pswrd);
		
		lp.logutbtn();
		
		MyAccount myacc=new MyAccount(driver);
		boolean targetpage =myacc.myaccountpresence();
		
	
		
		if (exp.equals("Valid")) {
			if (targetpage == true) {
				myacc.clickLogout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

		if (exp.equals("Invalid")) {
			if (targetpage == true) {
				MyAccount myaccpage = new MyAccount(driver);
				myaccpage.clickLogout();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}

	} catch (Exception e) {
		Assert.fail();
	}

	logger.info(" Finished TC_003_LoginDataDrivenTest");

}

}

