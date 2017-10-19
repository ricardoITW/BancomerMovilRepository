package windowsLibrary.Enrolamiento;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class VentanaSeguridad extends BaseClass{

	public VentanaSeguridad(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static By LblHeaderSeguridad = By.id("com.bancomer.mbanking:id/title_text");
	static By LblOTP = By.id("com.bancomer.mbanking:id/txtOTP");
	static By BtnAceptar = By.id("com.bancomer.mbanking:id/btnAceptar");
	static By BtnSuperiorAtras = By.id("com.bancomer.mbanking:id/btnAtras");
	
	public static boolean existeLblHeaderSeguridad(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<10)
			{
				if(driver.findElements(LblHeaderSeguridad).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra la ventana de codigo de seguridad",  driver);
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

	public static boolean clickBtnAceptar() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnAceptar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}

}
