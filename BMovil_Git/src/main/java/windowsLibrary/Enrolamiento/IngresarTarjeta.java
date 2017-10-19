package windowsLibrary.Enrolamiento;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class IngresarTarjeta extends BaseClass{

	public IngresarTarjeta(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	static By txtNumTarjeta = By.id("com.bancomer.mbanking:id/rootLayout");
	static By  txtTarjeta= By.id("com.bancomer.mbanking:id/textNumTarjeta");
	static By btnContinuar = By.id("com.bancomer.mbanking:id/btn_continuar");
	
	public static boolean SetNumTarjeta(String numTarjeta){
		boolean blnOk = false;
		try{
			driver.findElement(txtTarjeta).sendKeys(numTarjeta);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean existeTxtTarjeta(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<40)
			{
				if(driver.findElements(txtNumTarjeta).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla Tarjeta",  driver);
						existeMensaje=true;
						status=true;
						intentos=40;
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
	
	public static boolean existeTxtNumTarjeta(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<40)
			{
				if(driver.findElements(txtTarjeta).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla Tarjeta",  driver);
						existeMensaje=true;
						status=true;
						intentos=40;
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
	
	public static boolean SetTarjeta(String numTarjeta){
		boolean blnOk = false;
		try{
			driver.findElement(txtTarjeta).sendKeys(numTarjeta);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean ClickBtnContinuar(){
		boolean blnOk = false;
		try{
			driver.findElement(btnContinuar).click();
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;	
	}
	
}
