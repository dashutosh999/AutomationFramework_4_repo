package genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author dashu
 */

public class webdriverUtility {
	/**
	 * THis method will switch the driver control to frame based on index passed
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * THis method will switch the driver control to frame based on name or id present iframe tag
	 * @param driver
	 * @param nameOrId
	 */
	public void swithchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	public void swithchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void rightClick(WebDriver driver)
	{
	 Actions act = new Actions(driver);
	 act.contextClick();
	}
	
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void dragAndDrop()
	{
		
	}
	public void doubleClick()
	{
		
	}
	

}
