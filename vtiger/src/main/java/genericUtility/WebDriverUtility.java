package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {

	public void waitForElementToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstant.IMPLICIT_WAIT));
	}
	
	public void maximizeTheWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void waitForElementtoBeClickable(WebDriver driver, WebElement elementToClick) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.IMPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(elementToClick));	
	}
	public void selectFromADropdown(WebElement dropdown, int index) {
		Select select=new Select(dropdown);
		select.selectByIndex(index);
	}
	public void javaScriptClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(IPathConstant.JAVASCRIPT_COMMAND_FOR_CLICK, element);
	}
	public void javaScriptEnterValue(WebDriver driver, WebElement element,String value) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value="+value+"", element);
	}
	public void takeAScreenshot(WebDriver driver,String filePath) throws WebDriverException, IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		Files.copy(ts.getScreenshotAs(OutputType.FILE), new File(filePath));
	}
	public void mouseHoverOnAnElement(WebDriver driver,WebElement element) {
		new Actions(driver).moveToElement(element).perform();
	}
	public void selectOKInAlertPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void selectCancelInAlertPopup(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void switchToChildBrowser(WebDriver driver,String partialWindowTitle) {
		Set<String> allIDs = driver.getWindowHandles();
		
		for(String id:allIDs) {
			driver.switchTo().window(id);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}
	public void switchToFrame(WebDriver driver,WebElement frameElement ) {
		driver.switchTo().frame(frameElement);
	}
}
