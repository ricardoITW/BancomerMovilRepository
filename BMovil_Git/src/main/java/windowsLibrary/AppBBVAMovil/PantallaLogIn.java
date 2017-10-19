package windowsLibrary.AppBBVAMovil;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import windowsLibrary.BaseClass;

public class PantallaLogIn extends BaseClass{

	public PantallaLogIn(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	static By lblNumeroCelular = By.id("com.bancomer.mbanking:id/txtNum");
	static By txtContrasenia = By.id("com.bancomer.mbanking:id/LoginPassInput");
	static By btnEntrar = By.id("com.bancomer.mbanking:id/LoginEnterBtn");
	static By lblOlvidoContrasenia = By.id("com.bancomer.mbanking:id/txtOlvidastePass");
	static By btnTokenMovil = By.id("com.bancomer.mbanking:id/LoginTokenMovilBtn");
	static By lblVersionApp = By.id("com.bancomer.mbanking:id/txtVersion");
	static By LblModalAviso = By.id("android:id/alertTitle");
	static By LblModalText = By.id("android:id/message");
	static By BtnModalOk = By.id("android:id/button1");
	
	public static boolean existeTxtContrasenia(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<10)
			{
				if(driver.findElements(txtContrasenia).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla de Log in",  driver);
						existeMensaje=true;
						status=true;
						intentos=60;
				}
				else
				{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					intentos++;
				}
			}
		return status;
	}
	
	public static boolean existeLblModalAviso(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<10)
			{
				if(driver.findElements(LblModalAviso).size() > 0)
				{
					//EvidenceData.capturarPaso(true, "Correcto: Modal con mensaje ",  driver);
						existeMensaje=true;
						status=true;
						intentos=60;
				}
				else
				{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					intentos++;
				}
			}
		return status;
	}
	
	public static String getTextLblNumeroCelular(){
		AndroidElement element = (AndroidElement) driver.findElement(lblNumeroCelular); 
		return element.getText();
	}
	
	public static boolean setContrasenia(String contrasenia){
		boolean blnOk = false;
		try{
			driver.findElement(txtContrasenia).sendKeys(contrasenia);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean ClickBtnEntrar(){
		boolean blnOk = false;
		try{
			driver.findElement(btnEntrar).click();
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean ClickLigaOlvidoContrasenia(){
		boolean blnOk = false;
		try{
			driver.findElement(lblOlvidoContrasenia).click();
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean ClickTokenMovil(){
		boolean blnOk = false;
		try{
			driver.findElement(btnTokenMovil).click();
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static String getTextVersionApp(){
		AndroidElement element = (AndroidElement) driver.findElement(lblVersionApp); 
		return element.getText();
	}
	
	public static boolean clickBtnModalOk() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnModalOk).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}

	
	public static String getTextModal() {
		AndroidElement element = (AndroidElement) driver.findElement(LblModalText); 
		return element.getText();
	}
	
}
