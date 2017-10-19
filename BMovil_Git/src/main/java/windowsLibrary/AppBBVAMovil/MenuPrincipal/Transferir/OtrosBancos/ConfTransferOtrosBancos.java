package windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrosBancos;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class ConfTransferOtrosBancos extends BaseClass{

	public ConfTransferOtrosBancos(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	static By LblDatosOperacion = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/con_lista_datos_titulo' and @text='Datos de la operación']");
	static By LblLeyendaSeguridad = By.id("com.bancomer.mbanking:id/cyr_confirmacion_asm_instrucciones_label");
	static By BtnContinuar = By.id("com.bancomer.mbanking:id/cyr_confirmacion_confirmar_button");
	
	public static boolean existeLblDatosOperacion(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<60)
			{
				if(driver.findElements(LblDatosOperacion).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra PAntalla de confirmacion de operación",  driver);
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
}
