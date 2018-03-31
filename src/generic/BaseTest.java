package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConst {
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	public WebDriver driver;
	
	@BeforeMethod
	public void openApplication()
	{
		String appURL=AutoUtil.getProperty(CONFIG_PATH, "appURL");
		String sITO=AutoUtil.getProperty(CONFIG_PATH, "ITO");
		long ITO=Long.parseLong(sITO);
		driver=new ChromeDriver();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeApplication(ITestResult result)
	{
		String testName=result.getName();
		int status=result.getStatus();
		if(status==2)
		{
			AutoUtil.getPhoto(driver, PHOTO_PATH, testName);
		}
		driver.close();
	}
}
