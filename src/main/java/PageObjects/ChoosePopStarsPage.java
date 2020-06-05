package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChoosePopStarsPage {

	public ChoosePopStarsPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.touchtunes.android:id/setup_done_button")
	private WebElement PopStarsdonebuttonid;
	
	
	public WebElement getPopStarsdoneButton()
	{
		return PopStarsdonebuttonid;
	}
	
}
