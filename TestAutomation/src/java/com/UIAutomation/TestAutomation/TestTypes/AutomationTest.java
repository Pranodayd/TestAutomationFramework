package com.UIAutomation.TestAutomation.TestTypes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//public interface AutomationTest 
public abstract class AutomationTest {

	public enum Coordinates {

		X, Y;

	}

	public enum Dimensions {

		WIDTH, HEIGHT;

	}

	public static RemoteWebDriver Driver;

	public abstract void SetupTest(String Port, String UDID);

	public void ClickElement(WebElement E) {
		E.click();

	}

	public void EnterText(WebElement E, String value) {

		E.sendKeys(value);

	}

	public void ClearElement(WebElement Element) {
		Element.clear();
	}

	public String GetWebElementText(WebElement Element) {

		return Element.getText();
	}

	public void ExplicitWaitTillElmentFound(WebElement Element, int Time) {
		WebDriverWait wait = new WebDriverWait(Driver, Time);
		wait.until(ExpectedConditions.visibilityOf(Element));
	}

	public void ImplicitWaitTillElementFound(int TimeOut) {
		Driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);

	}

	public void StopTest(String Port, String UDID) {

		Driver.close();
	}

	public int GetCoordinates(WebElement E, Coordinates Cord) {
		int Coordinates = 0;
		switch (Cord) {
		case X:
			Coordinates = E.getLocation().x;
			break;
		case Y:
			Coordinates = E.getLocation().y;
			break;
		}
		return Coordinates;
	}

	public int GetDimensions(WebElement E, Dimensions Dimension) {
		int dimension = 0;
		switch (Dimension) {
		case HEIGHT:
			dimension = E.getSize().height;
			break;
		case WIDTH:
			dimension = E.getSize().width;
			break;

		}
		return dimension;
	}

	public boolean IsElementFound(String LocatorStratergy, String Locator) {
		List<WebElement> ElementTobeSearched = null;
		WebDriverWait wait = new WebDriverWait(Driver, 5);

		try {
			switch (LocatorStratergy) {

			case "BY_CLASS_NAME":
				wait.until(ExpectedConditions.presenceOfElementLocated(By.className(Locator)));
				ElementTobeSearched = Driver.findElementsByClassName(Locator);

				break;
			case "BY_ID":
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Locator)));
				ElementTobeSearched = Driver.findElementsById(Locator);
				break;
			case "BY_XPATH":
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locator)));
				ElementTobeSearched = Driver.findElementsByXPath(Locator);
				break;
			}

		}

		catch (TimeoutException E) {
			return false;

		}

		if (ElementTobeSearched.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public String GetPageTitle() {
		return Driver.getTitle();

	}

	public void WaitTillElementFound(String LocatorStratergy, String Locator) {
		List<WebElement> ElementTobeSearched = null;

		do {
			switch (LocatorStratergy) {
			case "BY_CLASS_NAME":
				ElementTobeSearched = Driver.findElementsByClassName(Locator);
				break;
			case "BY_ID":
				ElementTobeSearched = Driver.findElementsById(Locator);
				break;
			case "BY_XPATH":
				ElementTobeSearched = Driver.findElementsByXPath(Locator);
				break;
			case "BY_NAME":
				ElementTobeSearched = Driver.findElementsByName(Locator);
				break;

			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (ElementTobeSearched.size() == 0);

	}
}
