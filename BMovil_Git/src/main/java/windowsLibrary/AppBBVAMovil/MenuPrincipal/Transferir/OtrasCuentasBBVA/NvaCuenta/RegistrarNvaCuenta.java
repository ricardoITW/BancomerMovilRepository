package windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrasCuentasBBVA.NvaCuenta;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import windowsLibrary.BaseClass;

public class RegistrarNvaCuenta extends BaseClass{

	public RegistrarNvaCuenta(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static By LblTipoCta = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/accountTypeSelectorTitle'and @text='Tipo de cuenta']");
	static By BtnSeleccionaTipoCta = By.id("com.bancomer.mbanking:id/accountTypeSelector");
	static By TxtNumDestino = By.id("com.bancomer.mbanking:id/transferir_otrosBBVA_destino");
	static By TxtImporte = By.id("com.bancomer.mbanking:id/transferir_otrosBBVA_importe");
	static By TxtMotivo = By.id("com.bancomer.mbanking:id/transferir_otrosBBVA_concepto");
	static By BtnContinuar = By.id("com.bancomer.mbanking:id/transferir_otrosBBVA_continuar");
	static By BtnModalNumCuenta = By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Número de cuenta/ tarjeta']");
	static By BtnModalNumCel = By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Número celular']");
	static By LblFechaOperacion = By.id("com.bancomer.mbanking:id/transferir_otrosBBVA_fecha_operacion");
	static By LblOtrasCtasBBVA = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/title_text' and @text='Otras cuentas BBVA Bancomer']");
	
	public static boolean existeLblTipoCta(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<60)
			{
				if(driver.findElements(LblTipoCta).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla para registrar nueva cuenta",  driver);
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
	
	public static boolean clickBtnSeleccionaTipoCta() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnSeleccionaTipoCta).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean SetNumDestino(String NumDestino){
		boolean blnOk = false;
		try{
			driver.findElement(TxtNumDestino).sendKeys(NumDestino);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean SetImporte(String Importe){
		boolean blnOk = false;
		try{
			driver.findElement(TxtImporte).sendKeys(Importe);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}

	public static boolean SetMotivo(String Motivo){
		boolean blnOk = false;
		try{
			driver.findElement(TxtMotivo).sendKeys(Motivo);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
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

	public static boolean clickBtnModalNumCuenta() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnModalNumCuenta).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}

	public static boolean clickBtnModalNumCel() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnModalNumCel).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static String getTextLblFechaOperacion() {
		AndroidElement element = (AndroidElement) driver.findElement(LblFechaOperacion);
		return element.getText();
	}
	
	public static boolean clickLblOtrasCtasBBVA() {
		boolean blnOk = false;
		try {
			driver.findElement(LblOtrasCtasBBVA).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
}
