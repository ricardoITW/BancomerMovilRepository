package windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa;

import org.openqa.selenium.By;

import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import windowsLibrary.BaseClass;

public class AdmonAlertas extends BaseClass{

	public AdmonAlertas(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	static By LblNombreCuenta = By.id("com.bancomer.mbanking:id/nombre_cuenta");
	static By LblNumCuenta = By.id("com.bancomer.mbanking:id/numero_cuenta");
	static By LblNumTelefono = By.id("com.bancomer.mbanking:id/num_telefono");
	static By LblAlias = By.id("com.bancomer.mbanking:id/pagos_escondidos");
	static By BtnEditar = By.id("com.bancomer.mbanking:id/editar_informacion");
	
	
	static By TxtEditarAlias = By.id("com.bancomer.mbanking:id/tbAlias");
	static By BtnQuitarDeposito = By.id("com.bancomer.mbanking:id/txtDepositos");
	static By BtnAgregarDeposito = By.id("com.bancomer.mbanking:id/imgBotonDepositos");
	static By TxtEditarDeposito = By.id("com.bancomer.mbanking:id/tbImporteDeposito");
	static By TxtEditarCargo = By.id("com.bancomer.mbanking:id/tbImporteCargo");
	static By BtnGuardar = By.id("com.bancomer.mbanking:id/btnContinuar");
	
	static By LblModalContrasenia = By.id("com.bancomer.mbanking:id/confirmacion_contrasena_label");
	static By TxtContrasenia = By.id("com.bancomer.mbanking:id/confirmacion_contrasena_edittext");
	static By BtnConfirmar = By.id("com.bancomer.mbanking:id/confirmacion_confirmar_button");
	
	public static boolean existeLblNombreCuenta(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<10)
			{
				if(driver.findElements(LblNombreCuenta).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra ventana de Administración de alertas",  driver);
						existeMensaje=true;
						status=true;
						intentos=10;
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
	
	public static boolean existeLblModalContrasenia(){
		boolean status=false;
		boolean existeMensaje=false;
		int intentos = 0;
			while(existeMensaje==false && intentos<10)
			{
				if(driver.findElements(LblModalContrasenia).size() > 0)
				{
					EvidenceData.capturarPaso(true, "Correcto: Se muestra modal para confirmacion",  driver);
						existeMensaje=true;
						status=true;
						intentos=10;
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
	
	public static boolean SetTxtAlias(String cvv){
		boolean blnOk = false;
		try{
			driver.findElement(TxtEditarAlias).sendKeys(cvv);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static boolean SetTxtDeposito(String AlertaDeposito){
		boolean blnOk = false;
		try{
			driver.findElement(TxtEditarDeposito).sendKeys(AlertaDeposito);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
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
	
	public static boolean SetTxtCargo(String AlertaCargo){
		boolean blnOk = false;
		try{
			driver.findElement(TxtEditarCargo).sendKeys(AlertaCargo);
			blnOk = true;
		}catch(Exception e){
			System.out.println(e);
		}
		return blnOk;
	}
	
	public static String getTextCuenta() {
		AndroidElement element = (AndroidElement) driver.findElement(LblNumCuenta); 
		return element.getText();
	}
	public static String getTextA() {
		AndroidElement element = (AndroidElement) driver.findElement(LblNumTelefono); 
		return element.getText();
	}
	public static String getTextalias() {
		AndroidElement element = (AndroidElement) driver.findElement(LblAlias); 
		return element.getText();
	}
	
	public static boolean clickBtnEditar() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnEditar).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}

	public static boolean clickBtnQuitarDeposito() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnQuitarDeposito).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}

	public static boolean clickBtnAgregarDeposito() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnAgregarDeposito).click();
			blnOk = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return blnOk;
	}

	public static boolean clickBtnGuardar() {
		boolean blnOk = false;
		try {
			driver.findElement(BtnGuardar).click();
			blnOk = true;
		} catch (Exception e) {
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

}
