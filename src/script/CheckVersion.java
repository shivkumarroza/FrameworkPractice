package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.ETTPage;
import page.LoginPage;

public class CheckVersion extends BaseTest {
	@Test(priority=3)
	public void testCheckVersion()
	{
		String loginPageTitle=Excel.getData(XL_PATH, "CheckVersion", 1, 0);
		String un=Excel.getData(XL_PATH, "CheckVersion", 1, 1);
		String pw=Excel.getData(XL_PATH, "CheckVersion", 1, 2);
		String homePageTitle=Excel.getData(XL_PATH, "CheckVersion", 1, 3);
		String version=Excel.getData(XL_PATH, "CheckVersion", 1, 4);
		
		LoginPage l=new LoginPage(driver);
		l.verifyPageIsDisplayed(driver, loginPageTitle);
		l.setUserName(un);
		l.setPassword(pw);
		l.clickLoginBTN();
		l.verifyPageIsDisplayed(driver, homePageTitle);
		
		ETTPage et=new ETTPage(driver);
		et.clickHelpBTN(driver);
		et.clickaboutActiTime(driver);
		et.verifyVersion(driver, version);
		
	}

}
