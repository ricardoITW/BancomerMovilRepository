package windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.DineroMovil;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class DineroMovil extends BaseClass{

	public DineroMovil(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	static By LblMensaje = By.xpath("//android.widget.TextView[contains(@text,'Se ha unificado Dinero móvil')]");
	static By BtnRetiroSinTarj = By.id("com.bancomer.mbanking:id/unificacion_boton_retiro_sin_tarjeta");
	
	public static boolean existeLblMensaje(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<60)
			{
				if(driver.findElements(LblMensaje).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra mensaje de combinacion de dinero movil con retiro sin tarjeta",  driver);
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
	
	public static boolean clickBtnRetiroSinTarj() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnRetiroSinTarj).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}

}

