package windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrasCuentasBBVA;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class AltaFrecuentes extends BaseClass{

	public AltaFrecuentes(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	static By TxtNombreFrecuente = By.id("com.bancomer.mbanking:id/alta_frecuente_nombre_corto_edittext");
	static By TxtCorreoFrecuente = By.id("com.bancomer.mbanking:id/alta_frecuente_correo_electronico_edittext");
	static By BtnConfirmar = By.id("com.bancomer.mbanking:id/btn_confirmar");
	static By LblAltaFrecuentes = By.id("com.bancomer.mbanking:id/title_text");
	static By LblAviso = By.id("android:id/alertTitle");
	static By BtnOkAviso = By.id("android:id/button1");
	
	public static boolean existeLblAltaFrecuentes(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<60)
			{
				if(driver.findElements(LblAltaFrecuentes).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla para dar de alta un frecuente",  driver);
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
	
	public static boolean ClickBtnConfirmar() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnConfirmar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean setTxtNombreFrecuente(String NombreFrecuente) {
		boolean blnOk = false;
		try {
			driver.findElement(TxtNombreFrecuente).sendKeys(NombreFrecuente);
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean setTxtCorreoFrecuente(String correoFrecuente) {
		boolean blnOk = false;
		try {
			driver.findElement(TxtCorreoFrecuente).sendKeys(correoFrecuente);
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}

	public static boolean clickLblAltaFrecuentes() {
		boolean blnOk = false;
		try {
			driver.findElement(LblAltaFrecuentes).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean existeLblAviso() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 60) {
			if (driver.findElements(LblAviso).size() > 0) {
				EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla con mensaje confirmación de alta de frecuente", driver);
				existeMensaje = true;
				status = true;
				intentos = 60;
			} else {
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
	
	public static boolean clickBtnOkAviso() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnOkAviso).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
}
