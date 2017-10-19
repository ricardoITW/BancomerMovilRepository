package windowsLibrary.AppBBVAMovil.MenuPrincipal;

import org.openqa.selenium.By;

import ch.qos.logback.core.joran.conditional.ElseAction;
import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class MenuPrincipal extends BaseClass{

	public MenuPrincipal(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static By lblTituloHeader = By.id("com.bancomer.mbanking:id/principal_header_content");
	static By MenuHamburgesa = By.id("com.bancomer.mbanking:id/bmovil_menu_hamburguesa");
	static By BtnMisCuentas = By.id("com.bancomer.mbanking:id/btn_miscuentas_superior");
	static By BtnTransferencias = By.id("com.bancomer.mbanking:id/bmovil_menu_option_transferir");
	static By BtnRetiroSinTarjeta = By.id("com.bancomer.mbanking:id/bmovil_menu_option_retiro_sin_tarjeta");
	static By BtnPagar = By.id("com.bancomer.mbanking:id/bmovil_menu_option_pagar");
	static By BtnComprarContratar = By.id("com.bancomer.mbanking:id/bmovil_menu_option_comprar");
	static By BtnConsultar = By.id("com.bancomer.mbanking:id/bmovil_menu_option_consultar");
	static By BtnCorazon = By.id("com.bancomer.mbanking:id/gif");
	
	public static boolean existelblTituloHeader() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 10) {
			if (driver.findElements(lblTituloHeader).size() > 0) {
				EvidenceData.capturarPaso(true, "Correcto: Se muestra la pantalla Dashboard", driver);
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

	
	
	public static boolean clickMenuHamburgesa() {
		boolean blnOk = false;
		try {
			driver.findElement(MenuHamburgesa).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static boolean clickBtnMisCuentas() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnMisCuentas).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static boolean clickBtnTransferencias() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnTransferencias).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnRetiroSinTarjeta() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnRetiroSinTarjeta).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnPagar() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnPagar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnComprarContratar() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnComprarContratar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnConsultar() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnConsultar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static boolean clickBtnCorazon() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnCorazon).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
}
