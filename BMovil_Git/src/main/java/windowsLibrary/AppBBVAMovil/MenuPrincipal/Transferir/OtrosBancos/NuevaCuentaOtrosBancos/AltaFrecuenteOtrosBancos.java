package windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrosBancos.NuevaCuentaOtrosBancos;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class AltaFrecuenteOtrosBancos extends BaseClass{

	public AltaFrecuenteOtrosBancos(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static By LblAlta = By.id("com.bancomer.mbanking:id/title_text");
	static By TxtNombre = By.id("com.bancomer.mbanking:id/alta_frecuente_nombre_corto_edittext");
	static By TxtCorreo = By.id("com.bancomer.mbanking:id/alta_frecuente_correo_electronico_edittext");
	static By BtnConfirmar = By.id("com.bancomer.mbanking:id/btn_confirmar");
	
	public static boolean existeLblAlta(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<60)
			{
				if(driver.findElements(LblAlta).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla de Alta de Frecuentes",  driver);
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
	
	public static boolean SetTxtNombre(String Nombre){
		boolean blnOk = false;
		try{
			driver.findElement(TxtNombre).sendKeys(Nombre);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean SetTxtCorreo(String Correo){
		boolean blnOk = false;
		try{
			driver.findElement(TxtCorreo).sendKeys(Correo);
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
	
}
