package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChooseDJPage {
	
	public ChooseDJPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="tt_action_bar_right_action")
	private WebElement skipbuttonid;
	
	
	public WebElement getSkipButtonElement()
	{
		return skipbuttonid;
	}
	
	@AndroidFindBy(id="setup_continue_button")
	private WebElement DJElementsContinueid;
	
	public WebElement getDJElementsContinueButton()
	{
		return DJElementsContinueid;
	}
}
