package windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrasCuentasBBVA.NvaCuenta;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class ConfirmarNvaCuenta extends BaseClass{

	public ConfirmarNvaCuenta(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//static By LblCtaRetiro = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/cyr_lista_celda_2' and @text='"+ctaRetiro+"']");
	//static By LblctaDestino = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/cyr_lista_celda_2' and @text='"+ctaDestino+"']");
	//static By LblBeneficiario = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/cyr_lista_celda_2' and @text='"+Beneficiario+"']");
	static By LblLeyendaSeguridad = By.id("com.bancomer.mbanking:id/cyr_registrar_op_asm_instrucciones_label");
	static By BtnContinuar = By.id("com.bancomer.mbanking:id/cyr_registrar_op_confirmar_button");
	
	public static boolean existeLeyendaSeguridad(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<60)
			{
				if(driver.findElements(LblLeyendaSeguridad).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla para confirmar Datos de Transferencia",  driver);
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
	
	public static boolean clickBtnContinuar() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnContinuar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}


}
