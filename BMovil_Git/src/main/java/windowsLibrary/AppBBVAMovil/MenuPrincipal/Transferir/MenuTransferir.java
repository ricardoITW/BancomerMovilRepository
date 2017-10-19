package windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class MenuTransferir extends BaseClass {

	public MenuTransferir(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static By LblTransfer = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/title_text']");
	static By BtnMisCuentas = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/lista_celda_1' and @text='Mis cuentas']");
	static By BtnOtrasCtasBBVA = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/lista_celda_1' and @text='Otras cuentas BBVA Bancomer']");
	static By BtnOtrosBancos = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/lista_celda_1' and @text='Otros bancos']");
	static By BtnDineroMovil = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/lista_celda_1' and @text='Dinero móvil']");
	
	public static boolean existeLblTransfer(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<60)
			{
				if(driver.findElements(LblTransfer).size() > 0)
				{	
					EvidenceData.capturarPaso(true, "Correcto: Se muestra Ventana de Menú de Transferencias",  driver);
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
	
	public static boolean clickBtnMisCuentas() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnMisCuentas).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean ClickBtnOtrasCtasBBVA(){
		boolean blnOk = false;
		try{
			driver.findElement(BtnOtrasCtasBBVA).click();
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean ClickBtnOtrosBancos(){
		boolean blnOk = false;
		try{
			driver.findElement(BtnOtrosBancos).click();
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean ClickBtnDineroMovil(){
		boolean blnOk = false;
		try{
			driver.findElement(BtnDineroMovil).click();
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
}
