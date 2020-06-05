package sweetiq.touchtunes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {
     AndroidDriver<AndroidElement> driver;
     
     public Utilities(AndroidDriver<AndroidElement> driver) {
 		this.driver=driver;
 	}
	 	
 	public void chooseDJTypes(String[] mySelection, String DJXpathstart,String DJXpathend) throws InterruptedException {

			for(int p=0; p<mySelection.length; p++) {
				String selectDJ = DJXpathstart+mySelection[p]+DJXpathend;
				driver.findElement(By.xpath(selectDJ)).click();
			}

	}
 	
   public void choosePopStars(String[] singersSelection,String EndoflistPopStar, String singersxpathstart, String singersxpathend) throws InterruptedException {
		
		ScrollUptoTextContains(true, EndoflistPopStar, 0);
		Thread.sleep(3000);
				
		for(int p=0; p<singersSelection.length; p++) {
			String singersinfo = singersxpathstart+singersSelection[p]+singersxpathend;
			driver.findElement(By.xpath(singersinfo)).click();
		}
		
	 }

   public void selectFavoriteBar(String SelectedBar) throws InterruptedException {
		ScrollUptoTextContains(true, SelectedBar, 0);
		Thread.sleep(1000);
		clickonSelectedText(SelectedBar);
    }

   public List<String> ListRoundImagesNames(List<String> RoundImageNames, int maxSwipeLeftSteps) throws InterruptedException {
		
		String roundimage = "com.touchtunes.android:id/widget_item_round_image";
		ScrollUptoTextContains(true, roundimage, 0);
		for(int k=0; k<=maxSwipeLeftSteps; k++) {
		Thread.sleep(3000);
		RoundImageNames = ReturnList(RoundImageNames);
		if(k!=maxSwipeLeftSteps) {
		swipeOneStepLeft();
		  }
		}
		
	return RoundImageNames;
  }
 
   public List<String> ReturnList(List<String> RoundImageNames) throws InterruptedException {
		
		String roundimagestitle = "widget_item_round_title";
		List<AndroidElement> HotBarList = driver.findElements(By.id(roundimagestitle));
		RoundImageNames = getArtistsList(HotBarList, RoundImageNames);
		
		return RoundImageNames;
	}

   public void swipeOneStepLeft() {
		String swipeleft = "androidx.recyclerview.widget.RecyclerView";
		swipeOneStepLeftAction(true, swipeleft,1);
	}

   public void scrollDowntoBarHot(String SelectedBar, String leadingText) throws InterruptedException {
		String resid = "com.touchtunes.android:id/home_row_title";
		ScrollUptoTextContains(false, resid, 3);
		Thread.sleep(1000);
		SelectedBar = leadingText +" "+ SelectedBar;
		clickonSelectedText(SelectedBar);
   }


   public void clickOnHotArtistLink(String favoritetype) {
		clickonSelectedText(favoritetype);
	}

   public List<String> ListHotArtists(List<String> HotArtistsList, String LastArtistName) throws InterruptedException {
		//Getting the singers list
			for(int p=0; p<=1; p++) {
				HotArtistsList = ReturnListHotArtists(HotArtistsList);
				if(p!=1) {
				ScrollUptoTextContains(true, LastArtistName, 0);
				}
			}
			
		return HotArtistsList;
	}

   public List<String> ReturnListHotArtists(List<String> HotArtistsList) throws InterruptedException {
		
		String artistslistid = "item_artist_view_name";
		List<AndroidElement> HotBarArtists = driver.findElements(By.id(artistslistid));
		HotArtistsList = getArtistsList(HotBarArtists, HotArtistsList);
		return HotArtistsList;
	}

   public List<String> getArtistsList(List<AndroidElement> ElementsList, List<String> ArtistsList) {
		
		for ( WebElement we: ElementsList) { 
			if(!ArtistsList.contains(we.getText())) {
				ArtistsList.add(we.getText());
			}
		}
		 return ArtistsList;
	}

   public void printList(List<String> ListData) {
		for(String s : ListData) {
		System.out.println(s.toString());
	   }
	}

   public void isArtistsSame(List<String> HotArtistsList, List<String> RoundImageNames) {
		if(HotArtistsList.size() == RoundImageNames.size()) {
			System.out.println("Both Lists are equal");
		} else {
			System.out.println("Both Lists are Not equal");
		}
	}

   public void clickonSelectedText(String selectedText) {
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\""+selectedText+"\")").click();
	}


   public void swipeOneStepLeftAction(Boolean isScrollable,String swipeleft, int instancevalue) {
		try {
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable("+isScrollable+")."+ "className(\""+swipeleft+"\").instance(+instancevalue+))"+ ".setAsHorizontalList().scrollToEnd(1)");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
 	
   public void ScrollUptoTextContains(Boolean isScrollable, String textdata, int instancevalue) {
	   try {
	   driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable("+isScrollable+").instance(0)).scrollIntoView(new UiSelector().textContains(\""+textdata+"\").instance("+instancevalue+"))");
	   } catch(Exception e) {
			System.out.println(e.getMessage());
		}
	   }
 	
 	
//    public void chooseCurrentLocation() throws InterruptedException {
//		
//		String currentlocationid = "location_access_got_it_button";
//		String foregroundbuttonid = "com.android.permissioncontroller:id/permission_allow_foreground_only_button";
//		
//		driver.findElement(By.id(currentlocationid)).click();
//		Thread.sleep(2000);
//		driver.findElement(By.id(foregroundbuttonid)).click();
//	}
 	
}
