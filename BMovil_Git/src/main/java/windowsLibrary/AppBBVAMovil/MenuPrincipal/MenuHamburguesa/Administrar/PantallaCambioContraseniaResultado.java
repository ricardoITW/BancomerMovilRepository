package windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.Administrar;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import windowsLibrary.BaseClass;

public class PantallaCambioContraseniaResultado extends BaseClass{

	public PantallaCambioContraseniaResultado(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static By LblTituloCambiarContrasenia = By.xpath("//android.widget.TextView[@text='Cambiar contraseña']");
	static By LblResultadoCambio = By.id("com.bancomer.mbanking:id/cambiar_password_resultado_operacion_exitosa_label");
	static By LblResultadoMensaje = By.id("com.bancomer.mbanking:id/cambiar_password_resultado_mensaje_label");
	static By LblFolioTexto = By.xpath("//android.widget.TextView[@text='Folio de la operación']");
	static By LblFolioNumero = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/lista_celda_2']");
	static By BtnMenu = By.id("com.bancomer.mbanking:id/cambio_contrasena_resultado_boton_menu");
	
	public static boolean existeLblTituloCambiarContrasenia() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 60) {
			if (driver.findElements(LblTituloCambiarContrasenia).size() > 0) {
				EvidenceData.capturarPaso(true, "Correcto: Se muestra Ventana Resultado Cambio de contraseña", driver);
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
	
	public static String getTextLblResultadoCambio() {
		AndroidElement element = (AndroidElement) driver.findElement(LblResultadoCambio);
		return element.getText();
	}
	
	public static boolean existeLblResultadoMensaje() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 15) {
			if (driver.findElements(LblResultadoMensaje).size() > 0) {
				EvidenceData.capturarPaso(true, "Correcto: Se muestra etiqueta de cambio de contraseña ", driver);
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
	
	public static String getTextLblResultadoMensaje() {
		AndroidElement element = (AndroidElement) driver.findElement(LblResultadoMensaje);
		return element.getText();
	}
	
	public static String getTextLblFolioNumero() {
		AndroidElement element = (AndroidElement) driver.findElement(LblFolioNumero);
		return element.getText();
	}
	
	public static boolean clickBtnMenu() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnMenu).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	

}
