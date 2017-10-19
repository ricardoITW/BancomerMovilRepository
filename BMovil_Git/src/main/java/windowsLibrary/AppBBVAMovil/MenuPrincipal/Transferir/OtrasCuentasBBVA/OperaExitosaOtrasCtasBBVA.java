package windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrasCuentasBBVA;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class OperaExitosaOtrasCtasBBVA extends BaseClass{

	public OperaExitosaOtrasCtasBBVA(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static By LblOperacionExitosa = By.id("com.bancomer.mbanking:id/resultado_texto_tabla");
	static By BtnAgregarFrecuente = By.id("com.bancomer.mbanking:id/agregar_frecuente");
	static By BtnCompartir = By.id("com.bancomer.mbanking:id/compartir_resultados");
	static By BtnRegresarMenu = By.id("com.bancomer.mbanking:id/resultados_menu_button");
	
	public static boolean existeLblOperacionExitosa(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<60)
			{
				if(driver.findElements(LblOperacionExitosa).size() > 0)
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
