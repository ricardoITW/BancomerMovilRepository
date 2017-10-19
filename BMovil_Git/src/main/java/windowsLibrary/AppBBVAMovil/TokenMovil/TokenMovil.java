package windowsLibrary.AppBBVAMovil.TokenMovil;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import windowsLibrary.BaseClass;

public class TokenMovil extends BaseClass{

	public TokenMovil(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	static By LblTituloTokenMovil = By.id("com.bancomer.mbanking:id/imgTituloACTIVACION");
	static By BtnAtras = By.id("com.bancomer.mbanking:id/btnAtras");
	static By BtnGenerarCodigo = By.id("com.bancomer.mbanking:id/btnGenerar");
	static By BtnLectorOptico = By.id("com.bancomer.mbanking:id/btnReadQRCode");
	
	
	static By LblCodigoSegurida = By.id("com.bancomer.mbanking:id/imgTituloACTIVACION");
	static By LblMensajeInfo = By.id("com.bancomer.mbanking:id/lblOtp");
	static By TxtOptGenerada = By.id("com.bancomer.mbanking:id/tbOtp");
	
	public static boolean existeLblTituloTokenMovil() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 60) {
			if (driver.findElements(LblTituloTokenMovil).size() > 0) {
				EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla Token Movil", driver);
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

	
	public static boolean clickBtnAtras() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnAtras).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	
	public static boolean clickBtnGenerarCodigo() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnGenerarCodigo).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	
	public static boolean clickBtnLectorOptico() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnLectorOptico).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	
	public static boolean existeLblCodigoSegurida() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 60) {
			if (driver.findElements(LblCodigoSegurida).size() > 0) {
				EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla Código de Seguridad", driver);
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

	
	public static boolean existeLblMensajeInfo() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 60) {
			if (driver.findElements(LblMensajeInfo).size() > 0) {
				EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla", driver);
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

	
	
	public static String getTextOPT() {
		AndroidElement element = (AndroidElement) driver.findElement(TxtOptGenerada); 
		return element.getText();
	}
	
	
	public static void espera30Segundos() {
		boolean existeMensaje = true;
		int intentos = 0;
		try 
		{
			while (existeMensaje == true && intentos <= 33) {
				if (driver.findElements(LblTituloTokenMovil).size() > 0) {
					existeMensaje = true;
					intentos++;
					Thread.sleep(1000);
				} 
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
