package windowsLibrary.AppBBVAMovil.MenuPrincipal.RetiroSinTarjeta;

import java.util.List;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import windowsLibrary.BaseClass;

public class MenuRetiroSinTarjeta extends BaseClass{

	public MenuRetiroSinTarjeta(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	static By LblRetiroSinTarj = By.id("com.bancomer.mbanking:id/idTitulo_Retiro");
	static By BtnParaMi = By.xpath("//android.widget.ImageButton[@index='1']");
	static By BtnParaAlguien = By.xpath("//android.widget.ImageButton[@index='2']");
	
	public static boolean existeLblRetiroSinTarj(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<5)
			{
				if(driver.findElements(LblRetiroSinTarj).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra la pantalla Retiro sin tarjeta",  driver);
						existeMensaje=true;
						status=true;
						intentos=5;
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
	
	public static boolean clickBtnParaMi() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnParaMi).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnParaAlguien() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnParaAlguien).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	

}
