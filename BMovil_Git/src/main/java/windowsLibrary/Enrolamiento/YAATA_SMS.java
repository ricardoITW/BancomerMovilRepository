package windowsLibrary.Enrolamiento;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import configurationData.XlsData;
import evidence.EvidenceData;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import windowsLibrary.BaseClass;

public class YAATA_SMS extends BaseClass{

	public YAATA_SMS(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static By lblMensajeBancomer = By.xpath("//android.widget.TextView[@resource-id='rpkandrodev.yaata:id/contact_name' and @text='266845']");
	static By lblMensajeBancomerTest = By.xpath("//android.widget.TextView[@resource-id='rpkandrodev.yaata:id/contact_name' and @text='38240']");
	static By lblLigaActivacionBBVA = By.xpath("//android.widget.TextView[contains(@text,'NUNCA REENVIAR Activa BMOVIL')]");
	static By LblNuevoMensaje = By.xpath("//android.widget.TextView[@resource-id='rpkandrodev.yaata:id/badge' and @text='2']");
	
	static By LblTextPreview = By.xpath("//android.widget.TextView[contains(@text,'NUNCA REENVIAR Activa BMOVIL') and resource-id='rpkandrodev.yaata:id/text_preview']");
	
	static By BtnEliminarCoversacion = By.id("rpkandrodev.yaata:id/cab_templates_delete");
	static By BtnConfirmar = By.id("rpkandrodev.yaata:id/md_buttonDefaultPositive");
	static String XpathLastMessageBBVA = "//";
	public static boolean existMensajeBancomer(){
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		boolean isPresent = false;
		if (XlsData.getAmbiente().toUpperCase().equals("PRODUCCION")) {
			isPresent = driver.findElements(lblMensajeBancomer).size() > 0;
		} 
		else if(XlsData.getAmbiente().toUpperCase().equals("TEST")) {
			isPresent = driver.findElements(lblMensajeBancomerTest).size() > 0;
		}
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return isPresent;
	}
	
	public static boolean clickBtnEliminarCoversacion() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnEliminarCoversacion).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnConfirmar() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnConfirmar).click();
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
					if (XlsData.getAmbiente().toUpperCase().equals("PRODUCCION")) {
						driver.findElement(lblMensajeBancomer).click();
					} 
					else if(XlsData.getAmbiente().toUpperCase().equals("TEST")){
						driver.findElement(lblMensajeBancomerTest).click();
					}
					
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(YAATA_SMS.clickSMSActivacion())
					{
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//EvidenceData.capturarPaso(true, "Correcto: Se da click en la liga de activación",  driver);
						existeMensaje=true;
						status=true;
						intentos=20;
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
			String index=YAATA_SMS.getLastIndex();
			driver.findElement(By.xpath("//android.widget.ListView/android.widget.RelativeLayout["+index+"]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")).click();
			blnOk=true;
		}catch(Exception e){
			
		}
		return blnOk;
	}
	
	public static String getLastIndex() {
		List<AndroidElement> mensajesBBVA = driver.findElements(By.id("rpkandrodev.yaata:id/item_view"));
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
					AndroidElement element = null;
					if (XlsData.getAmbiente().toUpperCase().equals("PRODUCCION")) {
						element = (AndroidElement) driver.findElement(lblMensajeBancomer); 
					} 
					else if(XlsData.getAmbiente().toUpperCase().equals("TEST")){
						element = (AndroidElement) driver.findElement(lblMensajeBancomerTest); 
					}
					
					
					TouchAction action = new TouchAction(driver);
					action.longPress(element).release().perform();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					YAATA_SMS.clickBtnEliminarCoversacion();
					YAATA_SMS.clickBtnConfirmar();
					
					
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
	
	
	public static boolean clickNumeroSMSbyTextPreview(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<20)
			{
				if(existMensajeBancomer())
				{
					EvidenceData.capturarPaso(true, "Correcto: Se verifica existencia del SMS",  driver);
					driver.findElement(LblTextPreview).click();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(YAATA_SMS.clickSMSActivacion())
					{
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						EvidenceData.capturarPaso(true, "Correcto: Se da click en la liga de activación",  driver);
						existeMensaje=true;
						status=true;
						intentos=20;
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
}
