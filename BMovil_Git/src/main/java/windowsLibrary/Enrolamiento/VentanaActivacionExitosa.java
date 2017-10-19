package windowsLibrary.Enrolamiento;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class VentanaActivacionExitosa extends BaseClass{

	public VentanaActivacionExitosa(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static By lblActivacionExitosa1 = By.id("com.bancomer.mbanking:id/lblActivacionExito");//La activación de tus servicios banca móvil y token móvil fue realizada con éxito, - O - Tu contraseña se ha actualizado con éxito.
	static By lblActivacionExitosa2 = By.id("com.bancomer.mbanking:id/lblActivacionExito2");//¡A partir de este momento! puedes utilizar tu servicio de banca móvil. - O - La contratación de tu banca electrónica fue realizada con éxito.
	static By ImgPalomita = By.id("com.bancomer.mbanking:id/imgExitosa");
	
	static By lblDesbloqueoExitoso = By.id("com.bancomer.mbanking:id/lblActivacionExito");
	
	public static boolean existeLblActivacionExitosa1(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<120)
			{
				if(driver.findElements(lblActivacionExitosa1).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: La activación fue exitosa",  driver);
						existeMensaje=true;
						status=true;
						intentos=120;
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
	
	public static boolean existeLblActivacionExitosa2(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<120)
			{
				if(driver.findElements(lblActivacionExitosa2).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: La activación fue exitosa",  driver);
						existeMensaje=true;
						status=true;
						intentos=120;
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
	
	public static boolean existeImgPalomita(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<40)
			{
				if(driver.findElements(ImgPalomita).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: La activación fue exitosa",  driver);
						existeMensaje=true;
						status=true;
						intentos=120;
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
