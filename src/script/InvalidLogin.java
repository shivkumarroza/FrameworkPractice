package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class InvalidLogin extends BaseTest {
	@Test(priority=2)
	public void testInvalidLogin()
	{
		String loginPageTitle=Excel.getData(XL_PATH, "InvalidLogin", 1, 0);
		String un=Excel.getData(XL_PATH, "InvalidLogin", 1, 1);
		String pw=Excel.getData(XL_PATH, "InvalidLogin", 1, 2);
		String errmsg=Excel.getData(XL_PATH, "InvalidLogin", 1, 3);

		LoginPage l=new LoginPage(driver);
		l.verifyPageIsDisplayed(driver, loginPageTitle);
		l.setUserName(un);
		l.setPassword(pw);
		l.clickLoginBTN();
		l.verifyErrorMSG(driver, errmsg);

	}

}
