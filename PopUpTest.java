package week2.day2;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpTest {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\TestLeaf [Selenium Library]\\Softwares\\drivers\\chromedriver.exe");
		ChromeDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("http://popuptest.com/");
		d.findElementByXPath("/html/body/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[1]/font[2]/b/a").click();
		System.out.println("URL after Clicking PopUp test2:: " +d.getCurrentUrl());
		String parentHandle = d.getWindowHandle();
		System.out.println("parentHandle::"+parentHandle);
		System.out.println("Current Title:: " +d.getTitle());
		System.out.println();
		System.out.println();
		Set<String> winHandles = d.getWindowHandles();
		for (String currentHandle : winHandles) 
		{
			d.switchTo().window(currentHandle);
			System.out.println("Current Title::"+d.getTitle());
			System.out.println("Current Pop-UP URL::"+d.getCurrentUrl());
			System.out.println("currentHandle::::::::"+currentHandle);
			if(!(currentHandle.equals(parentHandle)))
			{
				System.out.println("CLOSING CURRENT HANDLE");
				System.out.println();
				d.close();
			}			
			//.switchTo().defaultContent();
		}
		d.switchTo().window(parentHandle);
		d.findElementByXPath("/html/body/table[2]/tbody/tr/td/form/input").click();
		Thread.sleep(5000);
		System.out.println();
		System.out.println();
		System.out.println("         ALL Of THE BELOW HAPPENS AFTER CLICKING ON BACK BUTTON         ");
		Set<String> handlesAfterBackButton = d.getWindowHandles();
		for (String winHandl : handlesAfterBackButton) 
		{
			d.switchTo().window(winHandl);
			System.out.println("Current Title::"+d.getTitle());
			System.out.println("Current Pop-UP URL::"+d.getCurrentUrl());
			System.out.println("currentHandle::::::::"+winHandl);
			if(!(winHandl.equals(parentHandle)))
			{
				System.out.println("CLOSING CURRENT HANDLE");
				System.out.println();
				d.close();
			}
			else
			{
				System.out.println("      NOT      CLOSING CURRENT HANDLE");
			}
		}
		//d.switchTo().defaultContent();
		//System.out.println("handleAfterPopUpClose::"+handleAfterPopUpClose);
		d.switchTo().window(parentHandle);
		System.out.println("Current Title:: " +d.getTitle());
		System.out.println("Parent window Title::"+d.getTitle());
	}

}
