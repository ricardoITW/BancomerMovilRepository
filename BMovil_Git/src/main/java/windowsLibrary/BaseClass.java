package windowsLibrary;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass {
	@SuppressWarnings("rawtypes")
	public static AndroidDriver driver;
	 
	public static boolean bResult;
 
	public  BaseClass(@SuppressWarnings("rawtypes") AndroidDriver driver){
		BaseClass.driver = driver;
		BaseClass.bResult = true;
 
	}
}
