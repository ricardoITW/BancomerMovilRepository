package windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.Administrar;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class CancelarSuspenderCuenta extends BaseClass{

	public CancelarSuspenderCuenta(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//************************ PAntalla cancelar o suspender
	static By Header = By.id("com.bancomer.mbanking:id/header_layout");
	static By LblTituloCancelarSuspender = By.xpath("//android.widget.TextView[@text='Cancelar o suspender tu servicio']");
	static By BtnSuspenderTemporalmente = By.xpath("//android.widget.TextView[@text='Suspender temporalmente']");
	static By BtnCancelarDefinitivamente = By.xpath("//android.widget.TextView[@text='Cancelar definitivamente']");
	
	//Pantalla Confirmar ***************SUSPENDER
	static By LblTituloSuspenderTemporalmente = By.xpath("//android.widget.TextView[@text='Suspender temporalmente']");
	static By LblRevisaAutoriza = By.id("com.bancomer.mbanking:id/lista_datos_titulo");
	static By LblOperacion = By.id("com.bancomer.mbanking:id/lista_celda_1");
	static By LblSuspender = By.id("com.bancomer.mbanking:id/lista_celda_2");
	static By LblIngresaContrasenia = By.id("com.bancomer.mbanking:id/confirmacion_contrasena_label");
	static By TxtContrasenia = By.id("com.bancomer.mbanking:id/confirmacion_contrasena_edittext");
	static By BtnConfirmarSuspension = By.id("com.bancomer.mbanking:id/confirmacion_confirmar_button");
	
	//Modal Aviso, Cuenta Suspendida *******************************SUSPENDER
	static By LblTituloModalAviso = By.xpath("//android.widget.TextView[@text='Aviso']");
	static By LblMensaje = By.xpath("//android.widget.TextView[@text='Tu servicio de Bancomer móvil ha sido suspendido']"); 
	static By BtnOk = By.xpath("//android.widget.Button[@text='OK']"); 
	
	
	
	//******************************************************************************************
	//********************************Cancelar Definitivamente**********************************
	//******************************************************************************************
	static By LblCancelar = By.id("com.bancomer.mbanking:id/title_text");
	static By BtnConfirmar = By.id("com.bancomer.mbanking:id/confirmacion_confirmar_button");
	
	public static boolean existeLblTituloCancelarSuspender() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 60) {
			if (driver.findElements(LblTituloCancelarSuspender).size() > 0) {
				EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla Cancelar o Suspender", driver);
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

	
	public static boolean clickBtnSuspenderTemporalmente() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnSuspenderTemporalmente).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static boolean clickBtnCancelarDefinitivamente() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnCancelarDefinitivamente).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	
	
	public static boolean existeLblSuspenderTemporalmenteConfirmar() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 60) {
			if (driver.findElements(LblTituloSuspenderTemporalmente).size() > 0) {
				EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla Suspender Temporalmente", driver);
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
	
	
	public static boolean setTxtContrasenia(String Contrasenia) {
		boolean blnOk = false;
		try {
			driver.findElement(TxtContrasenia).sendKeys(Contrasenia);
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static boolean clickBtnConfirmarSuspension() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnConfirmarSuspension).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	public static boolean existeLblTituloModalAviso() {
		boolean status = false;
		boolean existeMensaje = false;
		int intentos = 0;
		while (existeMensaje == false && intentos < 15) {
			if (driver.findElements(LblTituloModalAviso).size() > 0) {
				EvidenceData.capturarPaso(true, "Correcto: Se muestra modal Aviso", driver);
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


	public static boolean clickBtnOk() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnOk).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}
	
	
	
	
	//************************************************
	public static boolean existeLblCancelar(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<10)
			{
				if(driver.findElements(LblCancelar).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra ventana Cancelar Definitivamente",  driver);
						existeMensaje=true;
						status=true;
						intentos=5;
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

}
