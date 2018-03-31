package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import generic.BasePage;

public class ETTPage  extends BasePage{
	@FindBy(xpath="(//div[@class='popup_menu_label'])[3]")
	private WebElement helpBTN;
	
	@FindBy(xpath="//a[.='About your actiTIME']")
	private WebElement aboutActi;
	
	@FindBy(xpath="//td[@class='infoTitle']/../td[2]/span")
	private WebElement version;
	
	public ETTPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickHelpBTN(WebDriver driver)
	{
		waitForElement(driver, helpBTN);
		helpBTN.click();
	}
	
	public void clickaboutActiTime(WebDriver driver)
	{
		waitForElement(driver, aboutActi);
		aboutActi.click();
	}
	
	public void verifyVersion(WebDriver driver,String versionText)
	{
		waitForElement(driver, version);
		verifyText(version, versionText);
		Reporter.log("Pass : Expected Version "+versionText+" is Displayed",true);
	}

}
