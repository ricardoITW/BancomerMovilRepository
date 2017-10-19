package windowsLibrary.AppBBVAMovil.MenuPrincipal.RetiroSinTarjeta;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import windowsLibrary.BaseClass;

public class RetiroParaMi extends BaseClass{

	public RetiroParaMi(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	static By Header = By.id("com.bancomer.mbanking:id/principal_header_content");
	static By LblParaMi = By.id("com.bancomer.mbanking:id/texto_titulo");
	static By Btn100 = By.id("com.bancomer.mbanking:id/b100");
	static By Btn200 = By.id("com.bancomer.mbanking:id/b200");
	static By Btn300 = By.id("com.bancomer.mbanking:id/b300");
	static By Btn500 = By.id("com.bancomer.mbanking:id/b500");
	static By Btn1000 = By.id("com.bancomer.mbanking:id/b1000");
	static By Btn1500 = By.id("com.bancomer.mbanking:id/b1500");
	static By TxtOtraCantidad = By.id("com.bancomer.mbanking:id/textOtroImporte_retirosintar");
	static By BtnAgregarConcepto = By.id("com.bancomer.mbanking:id/btn_agregar_concepto");
	static By BtnContinuar = By.id("com.bancomer.mbanking:id/btnContinuar_retirosintar");
	static By TxtConcepto = By.id("com.bancomer.mbanking:id/textConcepto_retirosintar");
	
	//**********************************************************************************
	//***************Ventana de Confirmar***********************************************
	//**********************************************************************************
	
	static By LblImporte = By.xpath("//android.widget.TextView[@texto='Importe']");
	static By LblLeyenda = By.id("com.bancomer.mbanking:id/confirmacion_asm_instrucciones_label");
	static By BtnConfirmar = By.id("com.bancomer.mbanking:id/confirmacion_confirmar_button");
	
	//**********************************************************************************
	//***************Ventana Clave Retiro***********************************************
	//**********************************************************************************	
	static By LblValorImporte = By.id("com.bancomer.mbanking:id/valor_importe");
	static By LblClaveRetiro12D = By.id("com.bancomer.mbanking:id/label_descripcion_clave_retiro");
	static By LblCodigoSeguridad4D = By.xpath("//android.widget.TextView[@text='Código de seguridad 4 dígitos']");
	static By BtnMasDetalle = By.id("com.bancomer.mbanking:id/boton_detalle");
	
	//**********************************************************************************
	//***************Ventana Mas Detalle***********************************************
	//**********************************************************************************	
	static By LblCuentaRetiro = By.id("com.bancomer.mbanking:id/valor_cuenta_retiro");
	static By LblNumeroCelular = By.id("com.bancomer.mbanking:id/valor_numero_celular");
	static By LblConcepto = By.id("com.bancomer.mbanking:id/valor_concepto");
	static By LblDiaVencimiento = By.id("com.bancomer.mbanking:id/valor_vencimiento");
	static By LblFolio = By.id("com.bancomer.mbanking:id/valor_folio");
	
	static By LblBtnMenu = By.id("com.bancomer.mbanking:id/confirmacion_confirmar_button");
	
	
	public static boolean clickHeader() {
		boolean blnOk = false;
		try {
			driver.findElement(Header).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static boolean existeLblParaMi(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<5)
			{
				if(driver.findElements(LblParaMi).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra la pantalla Para mi",  driver);
						existeMensaje=true;
						status=true;
						intentos=5;
				}
				else
				{
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					intentos++;
				}
			}
		return status;
	}
	
	public static boolean existeLblImporte(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<5)
			{
				if(driver.findElements(LblImporte).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra ventana para confirmar retiro",  driver);
						existeMensaje=true;
						status=true;
						intentos=5;
				}
				else
				{
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					intentos++;
				}
			}
		return status;
	}
	public static boolean existeLblLeyenda(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<5)
			{
				if(driver.findElements(LblLeyenda).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla de confirmación Retiro para mi",  driver);
						existeMensaje=true;
						status=true;
						intentos=5;
				}
				else
				{
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					intentos++;
				}
			}
		return status;
	}
	
	public static boolean clickBtn100() {
		boolean blnOk = false;
		try {
			driver.findElement(Btn100).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtn200() {
		boolean blnOk = false;
		try {
			driver.findElement(Btn200).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtn300() {
		boolean blnOk = false;
		try {
			driver.findElement(Btn300).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtn500() {
		boolean blnOk = false;
		try {
			driver.findElement(Btn500).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtn1000() {
		boolean blnOk = false;
		try {
			driver.findElement(Btn1000).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtn1500() {
		boolean blnOk = false;
		try {
			driver.findElement(Btn1500).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean SetTxtOtraCantidad(String Cantidad){
		boolean blnOk = false;
		try{
			driver.findElement(TxtOtraCantidad).sendKeys(Cantidad);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	public static boolean clickBtnAgregarConcepto() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnAgregarConcepto).click();
			blnOk = true;
		} catch (Exception e) {
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

	public static boolean SetTxtConcepto(String Concepto){
		boolean blnOk = false;
		try{
			driver.findElement(TxtConcepto).sendKeys(Concepto);
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnConfirmar() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnConfirmar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean existeLblClaveRetiro12D() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 10) {
			if (driver.findElements(LblClaveRetiro12D).size() > 0) {
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
	
	
	public static boolean clickBtnMasDetalle() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnMasDetalle).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static String getTextLblCuentaRetiro() {
		AndroidElement element = (AndroidElement) driver.findElement(LblCuentaRetiro); 
		return element.getText();
	}
	
	public static String getTextLblNumeroCelular() {
		AndroidElement element = (AndroidElement) driver.findElement(LblNumeroCelular); 
		return element.getText();
	}
	
	public static String getTextLblConcepto() {
		AndroidElement element = (AndroidElement) driver.findElement(LblConcepto); 
		return element.getText();
	}
	public static boolean VerificarRetiroSinTarjeta(String CuentaRetiro, String NumeroCelular, String Concepto){
		boolean blnOk = false;
		
		if (CuentaRetiro.equals(RetiroParaMi.getTextLblCuentaRetiro())) 
		{
			if(NumeroCelular.equals(RetiroParaMi.getTextLblNumeroCelular()))
			{
				if(Concepto.equals(RetiroParaMi.getTextLblConcepto()))
				{
					blnOk = true;
				}
				else
				{
					EvidenceData.capturarPaso(true, "Error: El concepto mostrado, no coincide con "+Concepto, driver);
				}
			}
			else{
				EvidenceData.capturarPaso(true, "Error: El numero celular mostrado, no coincide con "+NumeroCelular, driver);
			}
		}
		else{
			EvidenceData.capturarPaso(true, "Error: La cuenta retiro mostrada, no coincide con la cuenta: "+CuentaRetiro, driver);
		}
		
		return blnOk;
	}
	
	
	public static boolean clickLblBtnMenu() {
		boolean blnOk = false;
		try {
			driver.findElement(LblBtnMenu).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
}

