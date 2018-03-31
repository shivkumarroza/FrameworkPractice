package generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements IAutoConst {
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	public WebDriver driver;
	
	@Parameters({"browser","ip"})
	@BeforeMethod
	public void openApplication(@Optional("chrome") String browser, String ip)
	{
		String appURL=AutoUtil.getProperty(CONFIG_PATH, "appURL");
		String sITO=AutoUtil.getProperty(CONFIG_PATH, "ITO");
		long ITO=Long.parseLong(sITO);
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setBrowserName(browser);
		try {
			driver=new RemoteWebDriver(new URL("http://"+ip+":4444/wd/hub"),capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
