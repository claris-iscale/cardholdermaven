package CardholderMavenProject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver= new ChromeDriver();
	public  WebDriver driverProgram,driverRegister;
	public  WebDriverWait wait;
	public  String User = "G00003@100002.com";
	public  String Pass = "@Password123";
	public  String EUUser = "lea.eu.cholder@gmail.com";
	public  String EUPass = "Testing123!-!";
	public  String NonEUUser = "lea.noneu2.cholder@gmail.com";
	public  String NonEUPass = "Testing123!-!";
	public  String userProgram = "dev_program";
	public  String passProgram = "Testing1234!!";
	public  String newPasswordTest = "@Password1234";
	public static String PIN =  "1234";
	public static String nPIN = "9999";
	
	public static String cPIN = "9999";
	public static String asd = "Test"; 
	public static String cardNumberCC = "4000000000000002";
	public static String securityNumber = "123";
	public static String testEmail = "lea@iscale-solutuions.com";
	
	DateFormat dateFormat = new SimpleDateFormat("MM-dd-YYYY HH:mm:ss");
	DateFormat timeFormat = new SimpleDateFormat("dd-HHmmss");
	Date date = new Date();
	
	@BeforeClass
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Iscale Dev 1\\git\\cardholderMaven\\chromedriver.exe");
//		   driver = new ChromeDriver();
	}
	
	
	@Test(priority = settings.loginTest , alwaysRun = true)
	  public void Login() {
		System.out.println("Now on loginTest");
		settings testSettings = new settings();
		 if(testSettings.skipTest("loginTest")){
			 
			//** FOR FIREFOX BROWSER **//
			   //driver = new firefoxDriver();
			//********************************** //	 
				
			//** FOR CHROME BROWSER ** //
			   System.setProperty("webdriver.chrome.driver","resources\\chromedriver.exe");
//			   driver = new ChromeDriver();
			//**********************************//	   
			   
			   wait = new WebDriverWait(driver, 20);   
			   
			   driver.manage().window().maximize();
			   driver.get("https://dev.cardholder.an-other.co.uk/");
			   
				WebElement LoginLogo = driver.findElement (By.cssSelector("img[class='login-logo']"));
				Assert.assertTrue(LoginLogo.isDisplayed());
				WebElement forgotPassword = driver.findElement (By.xpath("//a[@href='/user/recovery/request']"));
				forgotPassword.click();
				WebElement ForgotPassword = driver.findElement (By.cssSelector("h3[class='panel-title'"));
				WebElement Sumbit = driver.findElement(By.cssSelector ("button[class='btn btn-primary btn-block']"));
				if (ForgotPassword.isDisplayed()  &&  Sumbit.isDisplayed() )
				{ 
					
				}
				else
				{
					System.out.println("ERROR");
				}
				
			//Navigate Back
				driver.navigate().back();
				
			//Didn't receive confirmation message?
				driver.findElement(By.xpath("//*[@id=\"login-panel\"]/div/p/a")).click();
				WebElement EmailText = driver.findElement(By.xpath("//*[@id=\"resendform-email\"]"));
				WebElement ConfirmButton = driver.findElement(By.xpath("//*[@id=\"ResendForm\"]/button"));
				if (EmailText.isDisplayed()  &&  ConfirmButton.isDisplayed())
				{ 
					
				}
				else
				{
					System.out.println("ERROR");
				}
				
			//Navigate Back
				driver.navigate().back();
				
			//Tick "Remember me next time"
				WebElement Remember = driver.findElement(By.xpath("//*[@id=\"loginform-rememberme\"]"));
				Remember.click();
				Assert.assertTrue(Remember.isSelected());
				
				
			   WebElement SignIn1 = driver.findElement(By.xpath("//*[@id=\"LoginForm\"]/button"));
			   WebElement Username1 = driver.findElement(By.xpath("//*[@id=\"loginform-login\"]"));
			   Username1.sendKeys(User);
			   WebElement Password1 = driver.findElement(By.xpath("//*[@id=\"loginform-password\"]"));
			   Password1.sendKeys(Pass);
			   SignIn1.click();
			   
			   wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='btn btn-primary']"))).click();
			   
			 //LoginPage User
			 	String AccountVisible;
			 	String Verification;
			 			
			 	
			 	AccountVisible = driver.findElement(By.cssSelector("a[href='/user/settings/profile']")).getAttribute("innerHTML");
			 	Verification = driver.findElement(By.cssSelector("span[class='card-status verified']")).getAttribute("innerHTML");
			 	if (Verification.equals("Verified") && AccountVisible.equals(User))
			 	{
			 		
			 	}
			 	else
			 	{
			 		System.out.println("ERROR");
			 	}
		}else{
			throw new SkipException("Skipping LoginTest case. ");
		}
		 driver.quit();
	}
	
}
