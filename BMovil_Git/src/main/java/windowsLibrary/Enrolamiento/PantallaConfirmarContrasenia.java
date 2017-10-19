package windowsLibrary.Enrolamiento;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class PantallaConfirmarContrasenia extends BaseClass{

	public PantallaConfirmarContrasenia(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	static By BtnSuperiorAtras = By.id("com.bancomer.mbanking:id/btnAtras");
	static By LblTituloPantallaContrasenia = By.xpath("//android.widget.TextView[@text='CONTRASEÑA']");
	static By LblMensajeAyuda = By.id("com.bancomer.mbanking:id/tv_ayuda");//Crea la contraseña que utilizarás en la aplicación. Recuerda que tu información es confidencial, personal e intransferible.
	static By TxtContrasenia = By.id("com.bancomer.mbanking:id/txtPass");
	static By TxtContrasenia2 = By.id("com.bancomer.mbanking:id/txtPass2");
	static By LblAyudaPass1 = By.id("com.bancomer.mbanking:id/txtAyudaPass1");
	static By LblAyudaPass2 = By.id("com.bancomer.mbanking:id/txtAyudaPass2");
	
	static By BtnAnterior = By.id("com.bancomer.mbanking:id/btn_anterior");
	static By BtnContinuar = By.id("com.bancomer.mbanking:id/btn_continuar");
	
	public static boolean clickBtnSuperiorAtras() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnSuperiorAtras).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean existeLblTituloPantallaContrasenia() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 70) {
			if (driver.findElements(LblTituloPantallaContrasenia).size() > 0) {
				EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla Contrasenia", driver);
				existeMensaje = true;
				status = true;
				intentos = 60;
			} else {
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
	
	
	public static boolean setTxtContrasenia(String Contrasenia) {
		boolean blnOk = false;
		try {
			driver.findElement(TxtContrasenia).sendKeys(Contrasenia);
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static boolean setTxtContrasenia2(String Contrasenia) {
		boolean blnOk = false;
		try {
			driver.findElement(TxtContrasenia2).sendKeys(Contrasenia);
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	
	public static boolean clickBtnAnterior() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnAnterior).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnContinuar() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnContinuar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}


}
