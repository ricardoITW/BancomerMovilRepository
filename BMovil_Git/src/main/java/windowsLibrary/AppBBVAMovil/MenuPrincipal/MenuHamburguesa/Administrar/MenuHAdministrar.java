package windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.Administrar;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class MenuHAdministrar extends BaseClass {

	public MenuHAdministrar(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	static By HeaderBancomer = By.id("com.bancomer.mbanking:id/header_layout");
	static By LblTituloAdministrar = By.id("com.bancomer.mbanking:id/title_text");
	static By BtnCambiarContrasenia = By.xpath("//android.widget.TextView[@text='Cambiar contraseña']");
	static By BtnConfMontosOp = By.xpath("//android.widget.TextView[@text='Configurar montos de operación']");
	static By BtnConfCorreoElec = By.xpath("//android.widget.TextView[@text='Configurar correo electrónico']");
	static By BtnActualizarCuentas = By.xpath("//android.widget.TextView[@text='Actualizar cuentas']");
	static By BtnConsultarContrato = By.xpath("//android.widget.TextView[@text='Consultar contrato de tu servicio']");
	static By BtnCancelarSuspender = By.xpath("//android.widget.TextView[@text='Cancelar o suspender tu servicio']");
	static By BtnUsarNumeroCel = By.xpath("//android.widget.TextView[@text='Usar tu número celular como tu cuenta']");
	
	
	public static boolean existeLblTituloAdministrar() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 10) {
			if (driver.findElements(LblTituloAdministrar).size() > 0) {
				EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla Menu Administrar", driver);
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
	
	
	
	public static boolean clickBtnCambiarContrasenia() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnCambiarContrasenia).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}

	
	public static boolean clickBtnConfMontosOp() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnConfMontosOp).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	
	
	public static boolean clickBtnConfCorreoElec() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnConfCorreoElec).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	
	public static boolean clickBtnActualizarCuentas() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnActualizarCuentas).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static boolean clickBtnConsultarContrato() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnConsultarContrato).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	
	public static boolean clickBtnCancelarSuspender() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnCancelarSuspender).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static boolean clickBtnUsarNumeroCel() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnUsarNumeroCel).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
}
