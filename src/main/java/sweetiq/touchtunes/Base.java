package sweetiq.touchtunes;


import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.io.IOException;


import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import java.net.ServerSocket;


public class Base {
	  public static AppiumDriverLocalService service;
	  public static AndroidDriver<AndroidElement>  driver;
	

		public static AndroidDriver<AndroidElement> setCapabilities(String deviceName, String platformName, String platformVersion, String app_path, String noReset, String AndroidUrl) throws IOException, InterruptedException {

			try {
				
				DesiredCapabilities caps = new DesiredCapabilities();		
				caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
				caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
				caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
				caps.setCapability(MobileCapabilityType.APP,app_path);
//				caps.setCapability(MobileCapabilityType.NO_RESET, "false");
				
				driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(6000);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return driver;
		}
	
//		public AppiumDriverLocalService startServer() {
//
//		boolean flag = checkIfServerIsRunnning(4723);
//		if(!flag) {
//			service=AppiumDriverLocalService.buildDefaultService();
//			service.start();
//		}
//			return service;
//		}
		
//		public static boolean checkIfServerIsRunnning(int port) {
//			
//			boolean isServerRunning = false;
//			ServerSocket serverSocket;
//			try {
//				serverSocket = new ServerSocket(port);
//				serverSocket.close();
//			} catch (IOException e) {
//				isServerRunning = true;
//			} finally {
//				serverSocket = null;
//			}
//			return isServerRunning;
//		}
		
//		public static void startEmulator() throws IOException, InterruptedException {
//
//			Runtime.getRuntime().exec(System.getProperty("user.dir")+"/src/main/java/Resources/StartEmulator.sh");
//			Thread.sleep(6000);
//		}
	
}
