package windowsLibrary.AppBBVAMovil.MenuPrincipal.RetiroSinTarjeta;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class PantallaTransferenciaExitosa extends BaseClass{

	public PantallaTransferenciaExitosa(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	static By ImagenPaloma = By.xpath("//android.widget.ImageView[@index='1']");
	static By LbltFelicidaddes = By.xpath("//android.widget.TextView[@text='Felicidades']");
	static By LblTuRetiro = By.xpath("//android.widget.TextView[@text='Tu retiro sin tarjeta']");
	static By LblYaSeEncuentra = By.xpath("//android.widget.TextView[@text='ya se encuentra disponible']");
	
	public static boolean existeLbltFelicidaddes() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 60) {
			if (driver.findElements(LbltFelicidaddes).size() > 0) {
				EvidenceData.capturarPaso(true, "Correcto: Se muestra la pantalla Felicidades", driver);
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
