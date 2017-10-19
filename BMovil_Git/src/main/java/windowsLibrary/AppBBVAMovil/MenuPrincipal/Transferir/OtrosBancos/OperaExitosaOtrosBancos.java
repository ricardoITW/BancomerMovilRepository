package windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrosBancos;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class OperaExitosaOtrosBancos extends BaseClass{

	public OperaExitosaOtrosBancos(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	static By LblEstatusOperacion = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/resultado_texto_tabla' and @text='Transferencia en proceso de validación y aplicación']");
	static By BtnAgregarFrecuente = By.id("com.bancomer.mbanking:id/agregar_frecuente");
	static By BtnCompartir = By.id("com.bancomer.mbanking:id/compartir_resultados");
	static By BtnRegresarMenu = By.id("com.bancomer.mbanking:id/resultados_menu_button");
	static By LblClaveRastreo = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/cyr_lista_celda_1']");
	
	public static boolean existeLblEstatusOperacion(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<60)
			{
				if(driver.findElements(LblEstatusOperacion).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla Operacion Exitosa",  driver);
						existeMensaje=true;
						status=true;
						intentos=60;
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
	
	public static boolean clickBtnAgregarFrecuente() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnAgregarFrecuente).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnCompartir() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnCompartir).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnRegresarMenu() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnRegresarMenu).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
}
