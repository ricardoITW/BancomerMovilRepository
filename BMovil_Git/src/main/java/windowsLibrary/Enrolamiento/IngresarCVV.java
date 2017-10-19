package windowsLibrary.Enrolamiento;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;

public class IngresarCVV extends BaseClass{

	public IngresarCVV(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	static By txtCVV = By.id("com.bancomer.mbanking:id/txt_cvv");
	static By txtNIP = By.id("com.bancomer.mbanking:id/txt_nip");
	static By TxtNipCambioContrasenia = By.id("com.bancomer.mbanking:id/txtNIP");
	static By btnContinuar = By.id("com.bancomer.mbanking:id/btn_continuar");	
	
	public static boolean existeTxtCVV(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<30)
			{
				if(driver.findElements(txtCVV).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla NIP y CVV",  driver);
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
	
	public static boolean SetCVV(String cvv){
		boolean blnOk = false;
		try{
			driver.findElement(txtCVV).sendKeys(cvv);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean SetNIP(String nip){
		boolean blnOk = false;
		try{
			driver.findElement(txtNIP).sendKeys(nip);
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
	
	public static boolean existeTxtNipCambioContrasenia(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<30)
			{
				if(driver.findElements(TxtNipCambioContrasenia).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla NIP",  driver);
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
	
	public static boolean SetNipCambioContrasenia(String nip){
		boolean blnOk = false;
		try{
			driver.findElement(TxtNipCambioContrasenia).sendKeys(nip);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
}