package appiumConfiguration;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;

import io.appium.java_client.android.AndroidDriver;

public class DriverAppium {
	@SuppressWarnings("rawtypes")
	private static AndroidDriver driverAndroid;

	@SuppressWarnings("rawtypes")
	public static AndroidDriver getDriverAndroid(String deviceName, String Version)  {
		try {
			
			//*************** Lineas de codigo que se usaran si se cuenta con el APK ****************
			//final File classpathRoot = new File(System.getProperty("user.dir"));
			//final File appDir = new File("/Users/itworkers/Documents/Bancomer/Wallet_Bancomer/App/Apk");
			//final File app = new File(appDir, "com.bancomer.mbanking_2016-09-26.apk");
			//***************************************************************************************
			
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability("platformVersion", Version);
			capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("app", app.getAbsolutePath());
			//rpkandrodev.yaata.activity.ThreadListActivity
			//com.bancomer.mbanking.SplashViewController
			capabilities.setCapability("appPackage", "com.bancomer.mbanking");
			capabilities.setCapability("appActivity", "com.bancomer.mbanking.SplashViewController");
			
			driverAndroid = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driverAndroid.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			System.out.println("Se ha iniciado correctamente la aplicación");
			Thread.sleep(1000);
		} catch (SessionNotCreatedException e) {
			System.out.println("No se pudo iniciar la sesión " + e);
		} catch (UnreachableBrowserException e) {
			System.out.println("No iniciaste appium " + e);
		} catch (IOException e) {
			System.out.println("Error en las imágenes " + e);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driverAndroid;
	}
}
