package windowsLibrary.Enrolamiento;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class VentanaPrincipal extends BaseClass{

	public VentanaPrincipal(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
static By btnEntrar = By.id("com.bancomer.mbanking:id/boton_dos");
static By lblHola = By.xpath("//android.widget.TextView[@text='Hola']");
	
	public static boolean ClickBtnEntrar(){
		boolean blnOk = false;
		try{
			driver.findElement(btnEntrar).click();
			Thread.sleep(700);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean existeLblHola(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<10)
			{
				if(driver.findElements(lblHola).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra Pantalla Hola",  driver);
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
	
}
