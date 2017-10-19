package windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.Administrar;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class PantallaMontosOperacion extends BaseClass{

	public PantallaMontosOperacion(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static By LblHeaderMontosOper = By.id("com.bancomer.mbanking:id/title_text");
	static By TxtMontoMaxOperacion = By.id("com.bancomer.mbanking:id/configurar_montos_lim_op_txt");
	static By TxtMontoMaxDiario = By.id("com.bancomer.mbanking:id/configurar_montos_lim_diario_txt");
	static By TxtMontoMaxMes = By.id("com.bancomer.mbanking:id/configurar_montos_lim_mensual_txt");
	static By BtnContinuar = By.id("com.bancomer.mbanking:id/configurar_montos_boton_continuar");
	
	static By LblModalAviso = By.id("android:id/alertTitle");
	static By LblModalTexto = By.id("android:id/message");
	static By LblModalEror = By.id("com.bancomer.mbanking:id/descripcionError");
	static By BtnModalOk = By.id("android:id/button1");
	
	static By LblRevisar = By.id("com.bancomer.mbanking:id/lista_datos_titulo");
	static By TxtContrasenia = By.id("com.bancomer.mbanking:id/confirmacion_contrasena_edittext");
	static By BtnConfirmar = By.id("com.bancomer.mbanking:id/confirmacion_confirmar_button");
	
	static By LblOpExitosa = By.id("com.bancomer.mbanking:id/resultado_titulo");
	static By BtnMenu = By.id("com.bancomer.mbanking:id/resultados_menu_button");
	
	public static boolean existeLblHeaderMontosOper(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<10)
			{
				if(driver.findElements(LblHeaderMontosOper).size() >0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra ventana para ingresar nuevos montos",  driver);
					existeMensaje=true;
					status=true;
					intentos=10;
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
	
	public static boolean SetTxtMontoMaxOperacion(String MontoMaxOperacion){
		boolean blnOk = false;
		try{
			driver.findElement(TxtMontoMaxOperacion).sendKeys(MontoMaxOperacion);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean SetTxtMontoMaxDiario(String MontoMaxDiario){
		boolean blnOk = false;
		try{
			driver.findElement(TxtMontoMaxDiario).sendKeys(MontoMaxDiario);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean SetTxtMontoMaxMes(String MontoMaxMes){
		boolean blnOk = false;
		try{
			driver.findElement(TxtMontoMaxMes).sendKeys(MontoMaxMes);
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

	
	
	
	public static boolean existeLblRevisar(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<10)
			{
				if(driver.findElements(LblRevisar).size() >0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra ventana para confirmar nuevos montos",  driver);
					existeMensaje=true;
					status=true;
					intentos=10;
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
	
	public static boolean SetTxtContrasenia(String Contrasenia){
		boolean blnOk = false;
		try{
			driver.findElement(TxtContrasenia).sendKeys(Contrasenia);
			blnOk = true;
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
	
	public static boolean existeLblOpExitosa(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<10)
			{
				if(driver.findElements(LblOpExitosa).size() >0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra ventana de operación exitosa",  driver);
					existeMensaje=true;
					status=true;
					intentos=10;
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

}
