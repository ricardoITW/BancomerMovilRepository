package windowsLibrary.Enrolamiento;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class VentanaFirma extends BaseClass{

	public VentanaFirma(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	static By AreaParaFirma = By.id("com.bancomer.mbanking:id/contenSignature");
	static By AreaYaFirmada = By.xpath("//android.view.View[@index='0']");
	static By BtnBorrar = By.id("com.bancomer.mbanking:id/button_clear_signature");
	static By BtnCerrar = By.id("com.bancomer.mbanking:id/cancel_firma_autografa");
	static By BtnAceptarFirma = By.id("com.bancomer.mbanking:id/button_save_signature");
	
	public static boolean ExisteAreaParaFirma(){
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while(existeMensaje==false && intentos<10)
		{
			if(driver.findElements(AreaParaFirma).size() > 0)
			{
				EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla de Firma",  driver);
					existeMensaje=true;
					status=true;
					intentos=10;
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
		return status;
	}
	
	public static boolean clickBtnBorrar() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnBorrar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnCerrar() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnCerrar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnAceptarFirma() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnAceptarFirma).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}

}
