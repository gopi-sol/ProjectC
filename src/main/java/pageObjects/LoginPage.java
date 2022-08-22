package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage() 
	{
	PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(id="lgPlanner_UserName")
	private WebElement UserName;
	
	@FindBy(id="lgPlanner_Password")
	private WebElement Password;
	
	@FindBy(id="lgPlanner_LoginButton")
	private WebElement Submit;
	
	@FindBy(id="lgPlanner_hypForgetPwd")
	private WebElement ForgotPassword;
	
	@FindBy(xpath="//*[@id=\"lgPlanner\"]/tbody/tr/td/table/tbody/tr[11]/td[1]/img")
	private WebElement SolImage;
	
	@FindBy(xpath="//td[@class='error_msg']")
	private WebElement InvalidUsPwdText;
	
	@FindBy(xpath="//div[@id='lgPlanner_vsLogin']")
	private WebElement WarningText;
	
	
	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getSubmit() {
		return Submit;
	}

	public WebElement getForgotPassword() {
		return ForgotPassword;
	}

	public WebElement getSolImage() {
		return SolImage;
	}

	public WebElement getInvalidUsPwdText() {
		return InvalidUsPwdText;
	}

	public WebElement getWarningText() {
		return WarningText;
	}
public void LoginPageTest(String un,String pwd) throws InterruptedException, IOException {
		
		UserName.sendKeys(un);
		Password.sendKeys(pwd);
		Submit.click();
		Thread.sleep(2000);
		
	}
	
	public void ClearUsPwd() {
		
		UserName.clear();
		Password.clear();

	}
	
	public  void LoginPageScenario(String un,String pwd) 
			throws InterruptedException, IOException {
	
		UserName.sendKeys(un);
		Password.sendKeys(pwd);
		Submit.click();
		Thread.sleep(2000);

		try {
		driver.switchTo().frame(driver.findElement(By.id("kop")));
		
//		homePage.Logout();
		
		}
		catch(Exception e) {
			try{
				
				System.out.println(getInvalidUsPwdText().getText());
				
			}
			catch (Exception noSuchElementException) {
				
				System.out.println(getWarningText().getText());
			}
	    }
		
	}
	
	public void InvalidTextCheck() {
		
		String text = InvalidUsPwdText.getText();
		Assert.assertEquals("Ongeldige gebruikersnaam of wachtwoord.", text);
		
	}
	
	public void login(String un,String pwd) throws InterruptedException {
		
		UserName.sendKeys(un);
		Password.sendKeys(pwd);
		Submit.click();
		Thread.sleep(2000);
		
	}
	
	public void loginPageCheck() {
		String title = driver.getTitle();
		
		if (title.equals("Login pagina")) {
			System.out.println("Login Successful");
		} else {
			System.out.println("Login Unsuccessful");
		}

	}


}
