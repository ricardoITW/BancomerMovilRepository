package windowsLibrary.Enrolamiento;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class VentanaBienvenida extends BaseClass{

	public VentanaBienvenida(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static By txtNumCelular = By.id("com.bancomer.mbanking:id/LoginLogInput");
	static By btnIngresar = By.id("com.bancomer.mbanking:id/btnIngresar");
	static By btnContinuarTeclado = By.id("com.bancomer.mbanking:id/btn_continuar");
	//com.bancomer.mbanking:id/bienvenido
	//com.bancomer.mbanking:id/LoginLogInput
	public static boolean ClickBtnIngresar(){
		boolean blnOk = false;
		try{
			driver.findElement(btnContinuarTeclado).click();
			blnOk = true;
		}catch(Exception e){
			driver.findElement(btnIngresar).click();
			blnOk = true;
		}
		return blnOk;
	}
	
	public static boolean SetNumCelular(String numCelular){
		boolean blnOk = false;
		try{
			driver.findElement(txtNumCelular).sendKeys(numCelular);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean existetxtNumCelular() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 10) {
			if (driver.findElements(txtNumCelular).size() > 0) {
				EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla", driver);
				existeMensaje = true;
				status = true;
				intentos = 60;
			} else {
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

}

