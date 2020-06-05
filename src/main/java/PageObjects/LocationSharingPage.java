package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LocationSharingPage {

	public LocationSharingPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="location_access_got_it_button")
	private WebElement currentlocationid;
	
	public WebElement getCurrentLocationButton()
	{
		return currentlocationid;
	}
	
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement foregroundbuttonid;
	
	public WebElement getForegroundButton()
	{
		return foregroundbuttonid;
	}

}
