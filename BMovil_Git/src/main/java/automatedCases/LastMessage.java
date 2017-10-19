package automatedCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import appiumConfiguration.DriverAppium;
import appiumConfiguration.appiumServer;
import genericCases.CommonFunction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import windowsLibrary.BaseClass;
import windowsLibrary.AppBBVAMovil.PantallaLogIn;
import windowsLibrary.Enrolamiento.HangOuts_SMS;
import windowsLibrary.Enrolamiento.YAATA_SMS;

public class LastMessage {
	static AndroidDriver driver = null;
	static ArrayList<String> comentarios = new ArrayList<>();
	static ArrayList<String> tiempos = new ArrayList<>();
	public static void main(String[] args) {
		try 
		{
			appiumServer.Stop();
			appiumServer.Start();
			driver = DriverAppium.getDriverAndroid("0cd6bda97f5e", "4.4");
			new BaseClass(driver);
			Thread.sleep(5000);
			driver.startActivity("com.google.android.talk", "com.google.android.talk.SigningInActivity");
			Thread.sleep(5000);
			HangOuts_SMS.clickNumeroSMS();
			//HangOuts_SMS.eliminarConversaciónSMS();
			Thread.sleep(5000);
			/*
			driver.startActivity("rpkandrodev.yaata", "rpkandrodev.yaata.activity.ThreadListActivity");
			Thread.sleep(4000);
			//YAATA_SMS.eliminarConversaciónSMS();
			//driver.findElement(By.xpath("//android.widget.TextView[@resource-id='rpkandrodev.yaata:id/badge' and @text='1']/../..")).click();
			//driver.findElement(By.xpath("//android.widget.TextView[@resource-id='rpkandrodev.yaata:id/contact_name' and @text='266845']")).click();
			//Thread.sleep(2000);	
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id='rpkandrodev.yaata:id/contact_name' and @text='38240']")).click();
			String index=YAATA_SMS.getLastIndex();
			driver.findElement(By.xpath("//android.widget.ListView/android.widget.RelativeLayout["+index+"]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")).click();
			driver.startActivity("com.bancomer.mbanking", "com.bancomer.mbanking.SplashViewController");
			Thread.sleep(7000);
			PantallaLogIn.setContrasenia("147258");
			//CommonFunction.scrollDown();
			Thread.sleep(2000);
			//CommonFunction.scrollUp();
			 * 
			 * */
			 driver.quit();
		}catch(Exception e) {
			
		}
	}
}
