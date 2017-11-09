package test.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import test.resources.generic.WebLibrary;

/* ######################################################################################################
 * Class Name: UserLib
 * Description: Contains the methods which are used for the common functionalities of the application
 * Author: Testing Masters
 * Date Created: 14-Feb-2016
 * ######################################################################################################
 */
public class UserLibrary extends WebLibrary 
{
	/*
	 * ######################################################################################################
	 *  Method Name: Login
	 *  Description: To Login to a HRM Application,Based on UID,Password
	 *  Input Parameters:URL,UID,Password
	 *  Output: True/False 
	 *  Author: Veerendra
	 *  Date Created:21-Aug-2016
	 * ######################################################################################################
	 */
	public static boolean Login(String URL, String UID, String Password) 
	{
		boolean loginstatus = true;
		boolean status;

		status = OpenUrl(URL);
		if (status)
			LogEventWithScreeshot("info", "Application is Up and Running");
		else
			LogEventWithScreeshot("fail", "Unable to Launch HRM Application");

		status = SetText(test.testcases.ElementProp.Login.UserName, UID);
		if (status)
			LogEventWithScreeshot("info", "Entered UserName");
		else
			LogEventWithScreeshot("fail", "Unable to Enter UserName");

		status = SetText(test.testcases.ElementProp.Login.Password, Password);
		if (status)
			LogEventWithScreeshot("info", "Entered Password");
		else
			LogEventWithScreeshot("fail", "Unable to Enter Password");

		status = ClickElement(test.testcases.ElementProp.Login.btnLogin);
		if (status)
			LogEventWithScreeshot("info", "Clicked on Login");
		else
			LogEvent("fail", "Unable to Click on login");

		wait(2);
		status = Exist("//a[contains(text(),'Welcome')]");
		if(status==false)
		{
			loginstatus =  false;
		}

		return loginstatus;
	}
//=======================================================
	
	public static boolean Logout() 
	{
		Boolean status;
		ClickElement("//a[contains(text(),'Welcome')]");
		status = ClickElement("//a[text()='Logout']");
		if (status)
			LogEventWithScreeshot("info", "Clicked on Logout");
		else
			LogEventWithScreeshot("fail", "Unable to clickon Clicked on Logout");

		status = Exist("//input[@id='txtUsername']");
		if (status)
			LogEventWithScreeshot("pass", "Logout is successful");
		else
			LogEventWithScreeshot("fail", "Logout is Not successful");
		return status;
	}
	
	//=======================================================
		
	public static boolean NavigateMyinfo()
	{
		ClickElement(test.testcases.ElementProp.Home.Myinfo);
		
		boolean status = Exist("//*[@id='pdMainContainer']/div[1]/h1");		
		
		return status;
	}
	
	
	//=======================================================
	
	public static boolean registration(String URL, String UID, String Password,String email,String mobno) 
	{
		boolean regstatus = true;
		boolean status;
		
		status = SetText("//input[@id='txtUsername']", UID);
		if (status)
			LogEventWithScreeshot("info", "Entered UserName");
		else
			LogEventWithScreeshot("fail", "Unable to Enter UserName");

		status = SetText("//input[@id='txtPassword']", Password);
		if (status)
			LogEventWithScreeshot("info", "Entered Password");
		else
			LogEventWithScreeshot("fail", "Unable to Enter Password");
	
		status = SetText("//input[@id='txtRePassword']", Password);
		if (status)
			LogEventWithScreeshot("info", "Entered Password");
		else
			LogEventWithScreeshot("fail", "Unable to Enter Password");
		
		email="adfd";
		status = SetText("//input[@id='txtEmail']", email);
		if (status)
			LogEventWithScreeshot("info", "Entered email");
		else
			LogEventWithScreeshot("fail", "Unable to Enter email");
		
		mobno="9632587412";
		status = SetText("//input[@id='txtMobno']", mobno);
		if (status)
			LogEventWithScreeshot("info", "Entered Mobile No");
		else
			LogEventWithScreeshot("fail", "Unable to Enter Mobile No");
		
		status = ClickElement("//input[@name='Submit']");
		if (status)
			LogEventWithScreeshot("info", "Clicked on Login");
		else
			LogEvent("fail", "Unable to Click on login");

		wait(2);
		status = Exist("//a[contains(text(),'Welcome')]");
		if (status)
			LogEventWithScreeshot("pass", "Login is sucessful");
		else {
			LogEventWithScreeshot("fail", "Login is not sucessful");
			regstatus = false;
		}

		return regstatus;
	}
	
	//=======================================================
	
	public static boolean NavigateMyLeave()
	{
		boolean stepstatus = true;
		
		try
		{	
			wait(3);
			
			WebElement Leave = driver.findElement(By.id("menu_leave_viewLeaveModule"));
			
			Actions obj = new Actions(driver);
			
			obj.moveToElement(Leave).build().perform();
			
			driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
		}
		
		catch(Exception e)
		{
			stepstatus = false;
		}
		
		return stepstatus;
	}
	
	//=======================================================
	
	void TC14_AddLogin()
	{
		
				FirefoxDriver driver=new FirefoxDriver();
				driver.get("http://testingmasters.com/hrm/symfony/web/index.php/pim/viewMyDetails");
				driver.findElement(By.id("txtUsername")).sendKeys("user01");
				driver.findElement(By.id("txtPassword")).sendKeys("pass1234");
				driver.findElement(By.id("btnLogin")).click();
				
				

			}

		
	}
	


