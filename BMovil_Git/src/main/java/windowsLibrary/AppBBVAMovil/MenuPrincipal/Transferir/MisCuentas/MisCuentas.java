package windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.MisCuentas;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class MisCuentas extends BaseClass{

	public MisCuentas(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	static By LblAviso = By.xpath("//android.widget.TextView[@resourse-id='android:id/alertTitle'] and @text='Aviso'");
	static By BtnOkAviso = By.xpath("//android.widget.Button[@resource-id='android:id/button1' and @text='OK']");
	
	
	public static boolean existeLblAviso(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<60)
			{
				if(driver.findElements(LblAviso).size() > 0)
				{	
					EvidenceData.capturarPaso(true, "Correcto: Se muestra Ventana Emergente, No es posible hacer transferencia con una sola cuenta",  driver);
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
	
	
	public static boolean clickBtnOkAviso() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnOkAviso).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
}
