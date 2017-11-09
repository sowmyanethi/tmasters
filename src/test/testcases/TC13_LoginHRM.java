package test.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC13_LoginHRM extends  UserLibrary {

	public static void main(String[] args) {
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://testingmasters.com/hrm/symfony/web/index.php/pim/viewMyDetails");
		driver.findElement(By.id("txtUsername")).sendKeys("user01");
		driver.findElement(By.id("txtPassword")).sendKeys("pass1234");
		driver.findElement(By.id("btnLogin")).click();
		
		

	}

}
