package windowsLibrary.Enrolamiento;

import java.util.List;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import windowsLibrary.BaseClass;
import windowsLibrary.AppBBVAMovil.PantallaLogIn;

public class HangOuts_SMS extends BaseClass{

	public HangOuts_SMS(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static By lblMensajeBancomer = By.xpath("//android.view.View[@resource-id='com.google.android.talk:id/conversationName' and @content-desc='Roberto Angel Valdez Hernández']");
	static By lblLigaActivacionBBVA = By.xpath("//android.widget.TextView[contains(@text,'NUNCA REENVIAR Activa BMOVIL')]");
	//static By LblNuevoMensaje = By.xpath("//android.widget.TextView[@resource-id='rpkandrodev.yaata:id/badge' and @text='2']");
	static By BtnMenuMasOpciones = By.xpath("//android.widget.ImageView[@content-desc='Más opciones']");
	static By BtnEliminarConversacion = By.xpath("//android.widget.TextView[@text='Eliminar']");
	static By BtnConfirmaEliminar = By.xpath("//android.widget.Button[@text='Eliminar']");
	
	static By BtnReintentar = By.xpath("//android.view.View[@content-desc='Reintentar']");
	
	public static boolean existMensajeBancomer(){
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		boolean isPresent = false;
		isPresent = driver.findElements(lblMensajeBancomer).size() > 0;
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return isPresent;
	}
	
	public static boolean clickBtnEliminarCoversacion() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnEliminarConversacion).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnConfirmar() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnConfirmaEliminar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static boolean clickNumeroSMS(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<20)
			{
				if(existMensajeBancomer())
				{
					//EvidenceData.capturarPaso(true, "Correcto: Se verifica existencia del SMS",  driver);
					driver.findElement(lblMensajeBancomer).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(HangOuts_SMS.clickSMSActivacion())
					{
						try 
						{
							if(HangOuts_SMS.existeBtnReintentar()) {
								HangOuts_SMS.clickBtnReintentar();
								existeMensaje=true;
								status=true;
								intentos=20;
								Thread.sleep(5000);
							}
							else {
								if (PantallaLogIn.existeTxtContrasenia()) {
									existeMensaje=true;
									status=true;
									intentos=20;
								}
							}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//EvidenceData.capturarPaso(true, "Correcto: Se da click en la liga de activación",  driver);
						
					}
				}
				else
				{
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					intentos++;
				}
			}
		return status;
	}
	
	public static boolean clickSMSActivacion(){
		boolean blnOk = false;
		try
		{
			Thread.sleep(3000);
			//driver.findElement(lblLigaActivacionBBVA).click();
			String index=HangOuts_SMS.getLastIndex();
			driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout["+index+"]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).click();
			blnOk=true;
		}catch(Exception e){
			
		}
		return blnOk;
	}
	
	public static String getLastIndex() {
		List<AndroidElement> mensajesBBVA = driver.findElements(By.id("com.google.android.talk:id/message_root"));
		return String.valueOf(mensajesBBVA.size());
	}
	
	
	
	public static void eliminarConversaciónSMS(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<2)
			{
				if(existMensajeBancomer())
				{
					AndroidElement element = (AndroidElement) driver.findElement(lblMensajeBancomer); 
					TouchAction action = new TouchAction(driver);
					action.longPress(element).release().perform();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					HangOuts_SMS.clickBtnMasOpciones();
					HangOuts_SMS.clickBtnEliminarCoversacion();
					HangOuts_SMS.clickBtnConfirmar();
					
					
				}
				else
				{
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					intentos++;
				}
			}
	}
	
	
	public static boolean existeBtnReintentar(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<4)
			{
				if(driver.findElements(BtnReintentar).size() > 0)
				{
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
	
	public static boolean clickBtnReintentar(){
		boolean blnOk = false;
		try
		{
			driver.findElement(BtnReintentar).click();
			blnOk=true;
		}catch(Exception e){
			
		}
		return blnOk;
	}
	
	public static boolean clickBtnMasOpciones(){
		boolean blnOk = false;
		try
		{
			driver.findElement(BtnMenuMasOpciones).click();
			blnOk=true;
		}catch(Exception e){
			
		}
		return blnOk;
	}
	
}
