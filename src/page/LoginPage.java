package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import generic.BasePage;

public class LoginPage extends BasePage{
	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement pwTB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;
	
	@FindBy(className="errormsg")
	private WebElement errorMSG;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String un)
	{
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pw)
	{
		pwTB.sendKeys(pw);
	}
	
	public void clickLoginBTN()
	{
		loginBTN.click();
	}
	
	public void verifyErrorMSG(WebDriver driver,String msgText)
	{
		waitForElement(driver, errorMSG);
		verifyText(errorMSG, msgText);
		Reporter.log("Error msg "+msgText+" is Displayed",true);
	}

}
