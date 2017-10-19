package windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.Administrar;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class PantallaCambioContrasenia extends BaseClass {

	public PantallaCambioContrasenia(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	static By LblTituloCambiarContrasenia = By.xpath("//android.widget.TextView[@text='Cambiar contraseña']");
	static By LblContraseniaActual = By.id("com.bancomer.mbanking:id/cambio_contrasena_contrasenaActual_label");
	static By LblContraseniaNueva = By.id("com.bancomer.mbanking:id/cambio_contrasena_contrasenaNueva_label");
	static By LblContraseniaNuevaConf = By.id("com.bancomer.mbanking:id/cambio_contrasena_contrasenaConfirmacion_label");
	
	static By TxtContraseniaActual = By.id("com.bancomer.mbanking:id/cambio_contrasena_contrasenaActual_text");
	static By TxtContraseniaNueva = By.id("com.bancomer.mbanking:id/cambio_contrasena_contrasenaNueva_text");
	static By TxtContraseniaNuevaConf = By.id("com.bancomer.mbanking:id/cambio_contrasena_contrasenaConfirmacion_text");
	
	static By btnConfirmar = By.id("com.bancomer.mbanking:id/cambio_contrasena_boton_confirmar");
	
	
	public static boolean existeLblTituloCambiarContrasenia() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 10) {
			if (driver.findElements(LblTituloCambiarContrasenia).size() > 0) {
				EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla Cambiar Contrasenia", driver);
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
	
	
	public static boolean setTxtContraseniaActual(String contraseniaActual) {
		boolean blnOk = false;
		try {
			driver.findElement(TxtContraseniaActual).sendKeys(contraseniaActual);
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean setTxtContraseniaNueva(String contraseniaNueva) {
		boolean blnOk = false;
		try {
			driver.findElement(TxtContraseniaNueva).sendKeys(contraseniaNueva);
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}

	
	public static boolean setTxtContraseniaNuevaConf(String contraseniaNueva) {
		boolean blnOk = false;
		try {
			driver.findElement(TxtContraseniaNuevaConf).sendKeys(contraseniaNueva);
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static boolean clickbtnConfirmar() {
		boolean blnOk = false;
		try {
			driver.findElement(btnConfirmar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}

}
