package windowsLibrary.AppBBVAMovil.MenuPrincipal.RetiroSinTarjeta;

import java.util.List;

import org.openqa.selenium.By;

import configurationData.XlsData;
import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import windowsLibrary.BaseClass;

public class RetiroParaAlguien extends BaseClass{

	public RetiroParaAlguien(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	static By LblParaAlguien = By.id("com.bancomer.mbanking:id/texto_titulo");
	static By TxtFrecuentes = By.id("com.bancomer.mbanking:id/txtFiltro");
	static By BtnRegistrar = By.id("com.bancomer.mbanking:id/registrar_nuevo_button");
	
	
	//**********************************************************************************
	//**************Ventana de nombre de Beneficiario***********************************
	//**********************************************************************************
	
	static By LblNombreBene = By.id("com.bancomer.mbanking:id/ram_lblBeneficiario");
	static By TxtNombreBene = By.id("com.bancomer.mbanking:id/ram_textBeneficiario");
	static By TxtNumDestino = By.id("com.bancomer.mbanking:id/ram_textNumeroCel");
	static By BtnContinuar = By.id("com.bancomer.mbanking:id/ram_btnContinuar");
	
	//**********************************************************************************
	//**************Ventana de Monto a transferir***************************************
	//**********************************************************************************
	
	static By LblCtaOrigen = By.id("com.bancomer.mbanking:id/vista_cta_origen");
	static By Btn100 = By.id("com.bancomer.mbanking:id/b100");
	static By Btn200 = By.id("com.bancomer.mbanking:id/b200");
	static By Btn300 = By.id("com.bancomer.mbanking:id/b300");
	static By Btn500 = By.id("com.bancomer.mbanking:id/b500");
	static By Btn1000 = By.id("com.bancomer.mbanking:id/b1000");
	static By Btn1500 = By.id("com.bancomer.mbanking:id/b1500");
	static By TxtOtroImporte = By.id("com.bancomer.mbanking:id/textOtroImporte_retirosintar");
	static By BtnConcepto = By.id("com.bancomer.mbanking:id/btn_agregar_concepto");
	static By TxtConcepto = By.id("com.bancomer.mbanking:id/textConcepto_retirosintar");
	static By BtnContinuarRetiro = By.id("com.bancomer.mbanking:id/btnContinuar_retirosintar");
	
	//**********************************************************************************
	//**************Ventana de Confirmación Beneficiario********************************
	//**********************************************************************************
	
	static By LblImagen = By.id("com.bancomer.mbanking:id/imagen_compania");
	static By LblNombreBeneficiario = By.id("com.bancomer.mbanking:id/valor_nombre");
	static By LblNumeroCelular = By.id("com.bancomer.mbanking:id/valor_numero_celular");
	static By BtnConfirmar = By.id("com.bancomer.mbanking:id/confirmacion_confirmar_button");
	
	
	//**********************************************************************************
	//**************Ventana de Confirmación Cuenta retiro*******************************
	//**********************************************************************************
	
	static By LblImporte = By.id("com.bancomer.mbanking:id/valor_importe");
	static By LblCuentaRetiro = By.id("com.bancomer.mbanking:id/valor_cuenta_retiro2");
	//static By LblNombreBeneficiario = By.id("com.bancomer.mbanking:id/valor_nombre"); Mismo objeto
	static By LblNumeroCelular2 = By.id("com.bancomer.mbanking:id/valor_numero_celular2");
	static By LblConcepto = By.id("com.bancomer.mbanking:id/valor_concepto2");
	//static By BtnConfirmar = By.id("com.bancomer.mbanking:id/confirmacion_confirmar_button"); Mismo objeto
	
	//**********************************************************************************
	//**************Ventana Codigo 4 Digitos *******************************************
	//**********************************************************************************
	static By LblDescripcionClaveRetiro = By.id("com.bancomer.mbanking:id/label_descripcion_clave_retiro");
	//static By LblNombreBeneficiario = By.id("com.bancomer.mbanking:id/valor_nombre"); Mismo objeto
	//static By LblNumeroCelular2 = By.id("com.bancomer.mbanking:id/valor_numero_celular2"); Mismo Objeto
	static By LblCodigoSeguridad= By.id("com.bancomer.mbanking:id/valor_codigo_seguridad");
	static By LblFechaVencimiento= By.id("com.bancomer.mbanking:id/valor_vencimiento2");
	static By BtnMasDetalle= By.id("com.bancomer.mbanking:id/boton_detalle");
	
	static By BtnMenu= By.id("com.bancomer.mbanking:id/confirmacion_confirmar_button");
	
	public static boolean existeLblParaAlguien(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<5)
			{
				if(driver.findElements(LblParaAlguien).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra la pantalla Para alguien mas",  driver);
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
	
	public static boolean existeLblNombreBene(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<5)
			{
				if(driver.findElements(LblNombreBene).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla de Registro para alguien mas",  driver);
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
	
	public static boolean existeLblCtaOrigen(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<5)
			{
				if(driver.findElements(LblCtaOrigen).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra ventana para agregar Cuenta retiro, monto y concepto",  driver);
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
	
	public static boolean existeLblImagen(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<5)
			{
				if(driver.findElements(LblImagen).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla para confirmar beneficiario",  driver);
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
	
	public static boolean SetTxtFrecuentes(String NumDestino){
		boolean blnOk= false;
		try{
			driver.findElement(TxtFrecuentes).sendKeys(NumDestino);
			blnOk= true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnRegistrar() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnRegistrar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}

	public static boolean SetTxtNombreBene(String Nombre){
		boolean blnOk = false;
		try{
			driver.findElement(TxtNombreBene).sendKeys(Nombre);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean SetTxtNumDestino(String NumDestino){
		boolean blnOk = false;
		try{
			driver.findElement(TxtNumDestino).sendKeys(NumDestino);
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
	public static boolean SetTxtOtroImporte(String Importe){
		boolean blnOk = false;
		try{
			driver.findElement(TxtOtroImporte).sendKeys(Importe);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	public static boolean SetTxtConcepto(String Concepto){
		boolean blnOk = false;
		try{
			driver.findElement(TxtConcepto).sendKeys(Concepto);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnContinuarRetiro() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnContinuarRetiro).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnConcepto() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnConcepto).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	
	public static boolean existeLblCuentaRetiro() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 10) {
			if (driver.findElements(LblCuentaRetiro).size() > 0) {
				EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla confirmación cuenta retiro", driver);
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
	
	
	
	public static boolean existeLblDescripcionClaveRetiro() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 10) {
			if (driver.findElements(LblDescripcionClaveRetiro).size() > 0) {
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
	
	
	public static boolean clickBtnMenu() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnMenu).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//*********************ListView Frecuente***************************//
	
		public static int getLastIndexListaFrecuentes() {
			List<AndroidElement> listaFrecuentes = driver.findElements(By.id("com.bancomer.mbanking:id/lista_Seleccion_View"));
			return listaFrecuentes.size();
		}
		
		public static String getNombreCortoLista (String index){
			//driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView"));
			AndroidElement element = (AndroidElement) driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView")); 
			return element.getText();
		}
		
		public static String getNumeroTelefono (String index){
			String numeroTelefono="";
			//driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView"));
			AndroidElement element = (AndroidElement) driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[2]")); 
			numeroTelefono = element.getText();
			numeroTelefono = numeroTelefono.replace("-", "");
			return numeroTelefono;
		}
		
		public static boolean seleccionarContactoFrecuente(String nombreBeneficiario, String numeroCelularBeneficiario){
			boolean blnOk = false;
			int numeroContactosenLista=0;
			numeroContactosenLista=RetiroParaAlguien.getLastIndexListaFrecuentes()+1;
			for(int i=1;i<=numeroContactosenLista;i++)
			{
				String nombreContacto = "";
				String numeroCelular = "";
				nombreContacto = RetiroParaAlguien.getNombreCortoLista(String.valueOf(i));
				numeroCelular = RetiroParaAlguien.getNumeroTelefono(String.valueOf(i));
				
				if (nombreContacto.equals(nombreBeneficiario.toUpperCase()) && numeroCelular.equals(numeroCelularBeneficiario)) {
					driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[2]")).click();
					blnOk = true;
				}
			}
			return blnOk;
		}
}
