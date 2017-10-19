package windowsLibrary.Enrolamiento;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import genericCases.CommonFunction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import windowsLibrary.BaseClass;

public class VentanaActivacion extends BaseClass{

	public VentanaActivacion(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
																			
	static By lblTituloActivacion = By.xpath("//android.widget.TextView[@text='ACTIVACIÓN']");
	static By lblMensajeEnvíodeSMS = By.xpath("//android.widget.TextView[contains(@text,'En breve recibirás un mensaje de texto, selecciona la url o link para aceptar y activar tu servicio.')]");
	static By urlNoRecibiSMS = By.xpath("//android.widget.TextView[contains(@text,'No recibí el código, envíame otro')]");
	static By LblMensaje = By.xpath("//android.widget.TextView[contains(@text,'No recibí el código, envíame otro')]");
	
	static By LblModalAviso = By.id("android:id/alertTitle");
	static By BtnModalSi = By.id("android:id/button1");
	static By BtnModalNo = By.id("android:id/button2");
	
	static By LblModal = By.id("android:id/message");
	static By BtnOkModal = By.id("android:id/button1");
	
	static By LblBarraProgreso = By.id("com.bancomer.mbanking:id/progressBarActivate");
	
	public static boolean existeTituloActivacion(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<50)
			{
				if(existeLblMensajeEnvioSMS())
				{
					EvidenceData.capturarPaso(true, "Correcto: Se ha envíado un SMS con liga de activación",  driver);
					existeMensaje=true;
					status=true;
					intentos=20;
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
	
	
	public static boolean existeTituloActiv(){
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		boolean isPresent = false;
		isPresent = driver.findElements(lblTituloActivacion).size() > 0;
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return isPresent;
	}
	
	
	public static boolean existeLblMensajeEnvioSMS(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<20)
			{
				if(driver.findElements(lblTituloActivacion).size() >0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra ventana de Activación",  driver);
					existeMensaje=true;
					status=true;
					intentos=20;
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
	
	public static boolean existeUrlNoRecibiMensaje(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<120)
			{
				if(driver.findElements(urlNoRecibiSMS).size() >0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra link para reenvio",  driver);
					existeMensaje=true;
					status=true;
					intentos=120;
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
			while(existeMensaje==false && intentos<2)
			{
				if(driver.findElements(LblModalAviso).size() >0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra Modal de Aviso",  driver);
					existeMensaje=true;
					status=true;
					intentos=2;
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
	
	public static boolean existeLblModal(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<2)
			{
				if(driver.findElements(LblModal).size() >0)
				{	
					CommonFunction.evidenciaError(true, "Se muestra Modal "+VentanaActivacion.getTextModal()+"");
					existeMensaje=true;
					status=true;
					intentos=2;
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
	
	public static boolean existeLblBarraProgreso(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<10)
			{
				if(driver.findElements(LblBarraProgreso).size() >0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra ventana de Activación",  driver);
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
	
	public static boolean clickUrlNoRecibiMensaje(){
		boolean blnOk = false;
		try
		{
			driver.findElement(urlNoRecibiSMS).click();
			blnOk=true;
		}catch(Exception e){
			
		}
		return blnOk;
	}

	public static boolean clickBtnModalSi() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnModalSi).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}

	public static boolean clickBtnModalNo() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnModalNo).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnOkModal() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnOkModal).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}

	public static String getTextModal() {
		AndroidElement element = (AndroidElement) driver.findElement(LblModal); 
		return element.getText();
	}
}
