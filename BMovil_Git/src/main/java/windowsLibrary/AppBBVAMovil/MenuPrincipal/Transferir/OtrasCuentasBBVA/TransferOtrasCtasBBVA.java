package windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrasCuentasBBVA;

import java.util.List;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import genericCases.CommonFunction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import windowsLibrary.BaseClass;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.RetiroSinTarjeta.RetiroParaAlguien;

public class TransferOtrasCtasBBVA extends BaseClass{

	public TransferOtrasCtasBBVA(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static By LblOtrasCtasBBVA = By.xpath("//android.widget.TextView[@resource-id='com.bancomer.mbanking:id/title_text' and @text='Otras cuentas BBVA Bancomer']");
	static By BtnTransferConQR = By.id("com.bancomer.mbanking:id/boton_transferir_leer_qr");
	static By BtnBuscarFrecuentes = By.id("com.bancomer.mbanking:id/button_buscar");
	static By TxtBuscar = By.id("com.bancomer.mbanking:id/txtFiltro");
	static By BtnRegistrarCuenta = By.id("com.bancomer.mbanking:id/transfer_view_controller_btn_cuenta_nueva");
	
	static By BtnCuentaOrigen = By.id("com.bancomer.mbanking:id/vista_cta_origen");
	
	
	public static boolean existeLblOtrasCtasBBVA(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<60)
			{
				if(driver.findElements(LblOtrasCtasBBVA).size() > 0)
				{	
					EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla de Otras Cuentas BBVA",  driver);
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
	
	public static boolean clickBtnTransferConQR() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnTransferConQR).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnBuscarFrecuentes() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnBuscarFrecuentes).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean SetTxtBuscar(String OperacionFrecuente) {
		boolean blnOk = false;
		try {
			driver.findElement(TxtBuscar).sendKeys(OperacionFrecuente);
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean clickBtnRegistrarCuenta() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnRegistrarCuenta).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static boolean clickBtnCuentaOrigen() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnCuentaOrigen).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static String getTextBtnCuentaOrigen() {
		AndroidElement element = (AndroidElement) driver.findElement(BtnCuentaOrigen);
		return element.getText();
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
			
			public static String getNumeroCuenta (String index){
				String NumeroCuenta="";
				//driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView"));
				AndroidElement element = (AndroidElement) driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[2]")); 
				NumeroCuenta = element.getText();
				return NumeroCuenta;
			}
			
			public static boolean seleccionarContactoFrecuente(String nombreBeneficiario, String CuentaBeneficiario){
				boolean blnOk = false;
				int numeroContactosenLista=0;
				CuentaBeneficiario = CommonFunction.TratamientoString(CuentaBeneficiario);
				numeroContactosenLista=TransferOtrasCtasBBVA.getLastIndexListaFrecuentes()+1;
				for(int i=1;i<=numeroContactosenLista;i++)
				{
					String nombreContacto = "";
					String numeroCuenta = "";
					nombreContacto = TransferOtrasCtasBBVA.getNombreCortoLista(String.valueOf(i));
					numeroCuenta = TransferOtrasCtasBBVA.getNumeroCuenta(String.valueOf(i));
					
					if (nombreContacto.equals(nombreBeneficiario.toUpperCase()) && numeroCuenta.equals(CuentaBeneficiario)) {
						driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[2]")).click();
						blnOk = true;
					}
				}
				return blnOk;
			}
			
}
