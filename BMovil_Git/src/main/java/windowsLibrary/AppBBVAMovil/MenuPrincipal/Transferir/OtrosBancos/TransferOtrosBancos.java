package windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrosBancos;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class TransferOtrosBancos extends BaseClass{

	public TransferOtrosBancos(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static By LblOtrosBancos = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/title_text' and @text='Otras cuentas BBVA Bancomer']");
	static By TxtBuscar = By.id("com.bancomer.mbanking:id/txtFiltro");
	static By BtnBuscar = By.id("com.bancomer.mbanking:id/btnBorrar");
	static By BtnRegistrarCuenta = By.id("com.bancomer.mbanking:id/transfer_view_controller_btn_cuenta_nueva");
	
	
	public static boolean existeLblOtrosBancos(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<60)
			{
				if(driver.findElements(LblOtrosBancos).size() > 0)
				{	
					EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla de Otras Cuentas BBVA",  driver);
						existeMensaje=true;
						status=true;
						intentos=60;
				}
				else
				{
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
	
	public static boolean SetTxtBuscar(String OperacionFrecuente) {
		boolean blnOk = false;
		try {
			driver.findElement(TxtBuscar).sendKeys(OperacionFrecuente);
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnBuscar() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnBuscar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}

	
	public static boolean clickBtnRegistrarCuenta() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnRegistrarCuenta).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}

}
