package windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.Administrar;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import windowsLibrary.BaseClass;

public class PantallaCambioCorreo extends BaseClass{
	public PantallaCambioCorreo(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	static By LblConfigCorreo = By.id("com.bancomer.mbanking:id/title_text");
	static By LblCorreoActual = By.id("com.bancomer.mbanking:id/lblCorreo");
	static By TxtCorreoNuevo = By.id("com.bancomer.mbanking:id/tbNuevoCorreo");
	static By TxtConfirmaCorreo = By.id("com.bancomer.mbanking:id/tbConfirmarCorreo");
	static By BtnContinuar = By.id("com.bancomer.mbanking:id/btnContinuar");
	
	
	static By LblRevisar = By.id("com.bancomer.mbanking:id/lista_datos_titulo");
	static By LblCorreo = By.id("com.bancomer.mbanking:id/lista_celda_2");
	static By TxtContrasenia = By.id("com.bancomer.mbanking:id/confirmacion_contrasena_edittext");
	static By BtnConfirmar = By.id("com.bancomer.mbanking:id/confirmacion_confirmar_button");
	
	
	static By LblOperacionExitosa = By.id("com.bancomer.mbanking:id/resultado_titulo");
	static By BtnMenu = By.id("com.bancomer.mbanking:id/resultados_menu_button");
	
	
	public static boolean existeLblConfigCorreo(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<10)
			{
				if(driver.findElements(LblConfigCorreo).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra ventana para configurar correo",  driver);
						existeMensaje=true;
						status=true;
						intentos=5;
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
	
	public static boolean existeLblRevisar(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<10)
			{
				if(driver.findElements(LblRevisar).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra ventana para confirmar los datos",  driver);
						existeMensaje=true;
						status=true;
						intentos=5;
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
	
	public static boolean existeLblOperacionExitosa(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<10)
			{
				if(driver.findElements(LblOperacionExitosa).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra ventana con mensaje de operación exitosa",  driver);
						existeMensaje=true;
						status=true;
						intentos=10;
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
	
	public static String getTextLblResultadoMensaje() {
		AndroidElement element = (AndroidElement) driver.findElement(LblOperacionExitosa);
		return element.getText();
	}
	
	
	public static boolean SetCorreoNuevo(String correo){
		boolean blnOk = false;
		try{
			driver.findElement(TxtCorreoNuevo).sendKeys(correo);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean SetConfirmaCorreo(String correo){
		boolean blnOk = false;
		try{
			driver.findElement(TxtConfirmaCorreo).sendKeys(correo);
			blnOk = true;
		}catch(Exception e){
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
	
	public static boolean SetContrasenia(String Contrasenia){
		boolean blnOk = false;
		try{
			driver.findElement(TxtContrasenia).sendKeys(Contrasenia);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnConfirmar() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnConfirmar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
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
