package windowsLibrary.Enrolamiento;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class PantallaTerminosyCondiciones extends BaseClass{

	public PantallaTerminosyCondiciones(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static By BtnSuperiorAtras = By.id("com.bancomer.mbanking:id/btnAtras");
	static By LblTituloTerminosyCondiciones = By.xpath("//android.widget.TextView[@text='TÉRMINOS Y CONDICIONES']");
	static By LblAyuda = By.id("com.bancomer.mbanking:id/tv_ayuda");//La contratación de los servicios digitales no tiene costo.
	static By LblTerminosyCondiciones = By.id("com.bancomer.mbanking:id/labelTerminos");//He leído el Contrato Único Digital y documentos anexos. Manifiesto que entiendo y acepto el contenido y alcance legal de los mismos.
	static By SwithSiNo = By.id("com.bancomer.mbanking:id/toggleSwitch");
	static By LayoutFirma = By.id("com.bancomer.mbanking:id/firma");
	static By ImagenTocaAqui = By.xpath("//android.widget.ImageView[@index='0']");
	static By BtnContratar = By.id("com.bancomer.mbanking:id/btnContinuarAzul");
	
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
	
	
	public static boolean existeLblTituloTerminosyCondiciones() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 70) {
			if (driver.findElements(LblTituloTerminosyCondiciones).size() > 0) {
				EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla", driver);
				existeMensaje = true;
				status = true;
				intentos = 70;
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
	
	public static boolean clickSwithSiNo() {
		boolean blnOk = false;
		try {
			driver.findElement(SwithSiNo).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickLayoutFirma() {
		boolean blnOk = false;
		try {
			driver.findElement(LayoutFirma).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickImagenTocaAqui() {
		boolean blnOk = false;
		try {
			driver.findElement(ImagenTocaAqui).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static boolean clickBtnContratar() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnContratar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
}
