package sweetiq.touchtunes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.ChooseDJPage;
import PageObjects.ChoosePopStarsPage;
import PageObjects.LocationSharingPage;
import PageObjects.LocationTryAgainPage;


public class TouchTunesTest extends Base{

	@Test
	public void testValidation() throws IOException, InterruptedException {
		
		List<String> RoundImageNames = new ArrayList<>();
		List<String> HotArtistsList = new ArrayList<>();
		
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/sweetiq/touchtunes/global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		 File appDir = new File("src");
	     File appName = new File(appDir, (String) prop.get("appName"));
	     String deviceName = (String) prop.get("deviceName");
	     String platformName = (String) prop.get("platformName");
	     String platformVersion = (String) prop.get("platformVersion");
	     String noReset = (String) prop.get("noReset");
	     String AndroidUrl = (String) prop.get("AndroidUrl");
	     int maxSwipeLeftSteps = Integer.parseInt((String) prop.get("maxSwipeLeftSteps"));
	     String EndoflistPopStar = (String) prop.get("EndoflistPopStar");
	     String SelectedBar = (String) prop.get("SelectedBar");
	     String LastArtistName = (String) prop.get("LastArtistName");
	     String favoritetype = (String) prop.get("favoritetype");
	     String DJXpathstart = (String) prop.get("DJXpathstart");
	     String DJXpathend = (String) prop.get("DJXpathend");
	     String singersxpathstart = (String) prop.get("singersxpathstart");
	     String singersxpathend = (String) prop.get("singersxpathend");
	     String leadingText = (String) prop.get("leadingText");
	     String[] mySelection = {"Disco", "Pop", "Rock"};
		 String[] singersSelection = {"Rihanna", "Céline Dion","The Rolling Stones"};
	 	
	 	
	 	driver = setCapabilities(deviceName, platformName, platformVersion, appName.getAbsolutePath(), noReset, AndroidUrl);
	 	ChooseDJPage chooseDJPage = new ChooseDJPage(driver);
	 	ChoosePopStarsPage choosePopStarsPage = new ChoosePopStarsPage(driver);
	 	LocationSharingPage locationSharingPage = new LocationSharingPage(driver);
	 	LocationTryAgainPage locationTryAgainPage = new LocationTryAgainPage(driver);
	 	Utilities u=new Utilities(driver);
	 	
	      try {
	    	  if(chooseDJPage.getSkipButtonElement() != null) {
	     		 u.chooseDJTypes(mySelection, DJXpathstart, DJXpathend);
	     		 chooseDJPage.getDJElementsContinueButton().click();
	     		 Thread.sleep(3000);
	     		 u.choosePopStars(singersSelection,EndoflistPopStar,singersxpathstart,singersxpathend);
	     		 choosePopStarsPage.getPopStarsdoneButton().click();
	     		 Thread.sleep(2000);
	     	 }
	      }catch (Exception e) {
	 			System.out.println("skip element is not found");
	 		}
	      
	      
	      
	      try {
	    	  if(locationSharingPage.getCurrentLocationButton() != null) {
	     		locationSharingPage.getCurrentLocationButton().click();
	     		locationSharingPage.getForegroundButton().click();
	         	 Thread.sleep(3000);
	     	 }
	      } catch (Exception e) {
	     	 System.out.println("No need to share your location - it will get from the cache");
	      }
	      
	    
	      try {
	     	 if(locationTryAgainPage.getLocationTryAgainButton() != null) {
	     		 throw new Exception("Location Access got denied - Please provide access in your emulator");
	     	 }
	     	 
	      } catch (Exception e) {
	 			System.out.println("No Need to Reset your connection settings - Everything looks good");
	 		}
	      
	 		
	      try {
	     	 u.selectFavoriteBar(SelectedBar);
	     	 Thread.sleep(3000);
	     	 RoundImageNames = u.ListRoundImagesNames(RoundImageNames, maxSwipeLeftSteps);
	     	 Thread.sleep(3000);
	     	 u.scrollDowntoBarHot(SelectedBar, leadingText);
	     	 Thread.sleep(1000);
	     	 u.clickOnHotArtistLink(favoritetype);
	     	 Thread.sleep(3000);
	     	 HotArtistsList = u.ListHotArtists(HotArtistsList,LastArtistName);
	     	 u.isArtistsSame(HotArtistsList,RoundImageNames);
	     	 
	      } catch (Exception e) {
	     	 System.out.println(e.getMessage());
	      }
	 		
	      System.out.println("Printing the List of Round Images with a total size of : "+ RoundImageNames.size());
	      u.printList(RoundImageNames);

	 		
	 	 System.out.println("Printing the List of Hot Artists with a total size of : "+ HotArtistsList.size());
	 	 u.printList(HotArtistsList);
		
		
Assert.assertEquals(HotArtistsList.size(),RoundImageNames.size());  

	}
}
