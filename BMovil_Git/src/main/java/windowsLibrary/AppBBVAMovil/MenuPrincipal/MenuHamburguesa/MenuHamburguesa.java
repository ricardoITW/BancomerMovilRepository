package windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class MenuHamburguesa extends BaseClass{

	public MenuHamburguesa(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	static By LblNombreUsuarioPerfil = By.id("com.bancomer.mbanking:id/usuarioPerfil");
	static By LblAdministrar = By.xpath("//android.widget.TextView[@text='Administrar']");
	static By LblAdministrarAlertas = By.xpath("//android.widget.TextView[@text='Administrar Alertas']");
	static By LblMasAplicaciones = By.xpath("//android.widget.TextView[@text='Más aplicaciones']");
	static By LblNotificaciones = By.xpath("//android.widget.TextView[@text='Notificaciones']");
	static By LblContactanos = By.xpath("//android.widget.TextView[@text='Contáctanos']");
	static By LblCompartir = By.xpath("//android.widget.TextView[@text='Compartir']");
	static By LblValorar = By.xpath("//android.widget.TextView[@text='Valorar']");
	static By LblAcercade = By.xpath("//android.widget.TextView[@text='Acerca de']");
	
	public static boolean existeLblNombreUsuarioPerfil() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 60) {
			if (driver.findElements(LblNombreUsuarioPerfil).size() > 0) {
				EvidenceData.capturarPaso(true, "Correcto: Se muestra Menu Hamburguesa", driver);
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
	
	
	public static boolean clickLblAdministrar() {
		boolean blnOk = false;
		try {
			driver.findElement(LblAdministrar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static boolean clickLblAdministrarAlertas() {
		boolean blnOk = false;
		try {
			driver.findElement(LblAdministrarAlertas).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static boolean clickLblMasAplicaciones() {
		boolean blnOk = false;
		try {
			driver.findElement(LblMasAplicaciones).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static boolean clickLblNotificaciones() {
		boolean blnOk = false;
		try {
			driver.findElement(LblNotificaciones).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickLblContactanos() {
		boolean blnOk = false;
		try {
			driver.findElement(LblContactanos).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static boolean clickLblCompartir() {
		boolean blnOk = false;
		try {
			driver.findElement(LblCompartir).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	
	public static boolean clickLblValorar() {
		boolean blnOk = false;
		try {
			driver.findElement(LblValorar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickLblAcercade() {
		boolean blnOk = false;
		try {
			driver.findElement(LblAcercade).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
}
