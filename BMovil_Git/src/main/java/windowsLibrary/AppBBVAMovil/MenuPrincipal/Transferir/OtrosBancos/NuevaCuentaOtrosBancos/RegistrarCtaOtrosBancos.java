package windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrosBancos.NuevaCuentaOtrosBancos;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import windowsLibrary.BaseClass;

public class RegistrarCtaOtrosBancos extends BaseClass{

	public RegistrarCtaOtrosBancos(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static By LblTipoCta = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/transfer_interbancario_tipo_cuenta'and @text='Tipo de cuenta']");
	static By BtnSeleccionaTipoCta = By.id("com.bancomer.mbanking:id/transfer_interbancario_tipo_cuenta_txt");
	
	static By BtnModalTipoCtaDebito = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/lista_celda_1'and @text='Débito']");
	static By BtnModalTipoCtaCredito = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/lista_celda_1'and @text='Crédito']");
	static By BtnModalTipoCtaCLABE = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/lista_celda_1'and @text='Clabe']");
	static By BtnModalTipoCtaCelular = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/lista_celda_1'and @text='Celular']");
	
	static By BtnBancoDestino = By.id("com.bancomer.mbanking:id/transfer_interbancario_banco_destino_txt");
	
	static By BtnModalBancoDestino = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/lista_celda_1' and @text='']");
	
	static By TxtNumCuenta = By.id("com.bancomer.mbanking:id/transfer_interbancario_numero_tarjeta_txt");
	static By TxtBeneficiario = By.id("com.bancomer.mbanking:id/transfer_interbancario_beneficiario_txt");
	static By TxtImporte = By.id("com.bancomer.mbanking:id/transfer_interbancario_importe_txt");
	static By TxtReferencia = By.id("com.bancomer.mbanking:id/transfer_interbancario_referencia_txt");
	static By TxtConcepto = By.id("com.bancomer.mbanking:id/transfer_interbancario_concepto_txt");
	static By BtnContinuar = By.id("com.bancomer.mbanking:id/transfer_interbancario_boton_continuar");
	static By LblFechaOperacion = By.id("com.bancomer.mbanking:id/transfer_interbancario_fecha_operacion_text");
	
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
	
	public static boolean SetNumCuenta(String NumDestino){
		boolean blnOk = false;
		try{
			driver.findElement(TxtNumCuenta).sendKeys(NumDestino);
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

	public static boolean SetConcepto(String Motivo){
		boolean blnOk = false;
		try{
			driver.findElement(TxtConcepto).sendKeys(Motivo);
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

	public static boolean clickBtnModalTipoCtaDebito() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnModalTipoCtaDebito).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}

	public static boolean clickBtnModalTipoCtaCredito() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnModalTipoCtaCredito).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnModalTipoCtaCLABE() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnModalTipoCtaCLABE).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnModalTipoCtaCelular() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnModalTipoCtaCelular).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnModalBancoDestino() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnModalBancoDestino).click();
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

}
