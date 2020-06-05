package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BarPage {

	public BarPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="com.touchtunes.android:id/widget_item_round_image")
	private WebElement roundimage;
	
	
	public WebElement getRoundImage()
	{
		return roundimage;
	}
	
	
	@AndroidFindBy(id="widget_item_round_title")
	private WebElement roundimagestitle;
	
	
	public WebElement getRoundImageTitle()
	{
		return roundimagestitle;
	}
	
	@AndroidFindBy(className="androidx.recyclerview.widget.RecyclerView")
	private WebElement swipeleft;
	
	
	public WebElement getSwipeLeft()
	{
		return swipeleft;
	}
	
	@AndroidFindBy(id="com.touchtunes.android:id/home_row_title")
	private WebElement resid;
	
	
	public WebElement getResId()
	{
		return resid;
	}
	
}
