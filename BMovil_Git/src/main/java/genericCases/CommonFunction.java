package genericCases;

import java.io.IOException;

import org.openqa.selenium.Dimension;

import JSONLogs.JsonConstructor;
import JSONLogs.LogResultEnrolamiento;
import JSONLogs.LogResultInstrument1;
import JSONLogs.LogResultInstrument2;
import JSONLogs.LogResultInstrument3;
import appiumConfiguration.appiumServer;
import configurationData.AppDataTest;
import configurationData.XlsData;
import evidence.ATC_Evidence;
import evidence.EvidenceData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import windowsLibrary.BaseClass;
import windowsLibrary.AppBBVAMovil.PantallaLogIn;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuPrincipal;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.AdmonAlertas;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.MenuHamburguesa;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.Administrar.CancelarSuspenderCuenta;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.Administrar.MenuHAdministrar;
import windowsLibrary.Enrolamiento.IngresarCVV;
import windowsLibrary.Enrolamiento.IngresarTarjeta;
import windowsLibrary.Enrolamiento.PantallaConfirmarContrasenia;
import windowsLibrary.Enrolamiento.PantallaTerminosyCondiciones;
import windowsLibrary.Enrolamiento.VentanaActivacion;
import windowsLibrary.Enrolamiento.VentanaActivacionExitosa;
import windowsLibrary.Enrolamiento.VentanaBienvenida;
import windowsLibrary.Enrolamiento.VentanaFirma;
import windowsLibrary.Enrolamiento.VentanaPrincipal;
import windowsLibrary.Enrolamiento.YAATA_SMS;

public class CommonFunction extends BaseClass{
	public CommonFunction(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public static void realizarConsultaTestInstrumento1(String Ambiente){
		if (Ambiente.toUpperCase().equals("TEST")) {
			JsonConstructor.createJsonInstrumentTest1(XlsData.getNumeroCelular());
			JsonConstructor.createJsonEnrolamientoTest(XlsData.getNumeroCelular());
			EvidenceData.capturarPaso(false, "Correcto: Se realizo consulta, el tipo de instrumento es "+LogResultInstrument1.getTipoInstrumento()
			+" y el estatus de producto es "+LogResultInstrument1.getEstatusInstrumento()+" con estatus de servicio "+LogResultInstrument1.getEstatusServicio(), driver);
			
			EvidenceData.capturarPaso(false, "Correcto: Se realizo consulta de enrolamiento, estatus IsNewTC -> "+LogResultEnrolamiento.getIsNewTC()
			+" y el estatus EnrollSTS -> "+LogResultEnrolamiento.getEnrollSTS(), driver);
		}
		else if(Ambiente.toUpperCase().equals("PRODUCCION")) {
			JsonConstructor.createJsonInstrument1Prod(XlsData.getNumeroCelular());
			JsonConstructor.createJsonEnrolamientoProd(XlsData.getNumeroCelular());
			EvidenceData.capturarPaso(false, "Correcto: Se realizo consulta, el tipo de instrumento es "+LogResultInstrument1.getTipoInstrumento()
			+" y el estatus de producto es "+LogResultInstrument1.getEstatusInstrumento()+" con estatus de servicio "+LogResultInstrument1.getEstatusServicio(), driver);
			
			EvidenceData.capturarPaso(false, "Correcto: Se realizo consulta de enrolamiento, estatus IsNewTC -> "+LogResultEnrolamiento.getIsNewTC()
			+" y el estatus EnrollSTS -> "+LogResultEnrolamiento.getEnrollSTS(), driver);	
		}
			
	}
	
	public static void realizarConsultaInstrumento2(String Ambiente){
		if (Ambiente.toUpperCase().equals("TEST")) {
			JsonConstructor.createJsonInstrumentTest2(XlsData.getNumeroCelular());
			JsonConstructor.createJsonEnrolamientoTest(XlsData.getNumeroCelular());
			EvidenceData.capturarPaso(false, "Correcto: Se realizo consulta, el tipo de instrumento es "+LogResultInstrument2.getTipoInstrumento()
			+" y el estatus de producto es "+LogResultInstrument2.getEstatusInstrumento()+" con estatus de servicio "+LogResultInstrument2.getEstatusServicio(), driver);
			
			EvidenceData.capturarPaso(false, "Correcto: Se realizo consulta de enrolamiento, estatus IsNewTC -> "+LogResultEnrolamiento.getIsNewTC()
			+" y el estatus EnrollSTS -> "+LogResultEnrolamiento.getEnrollSTS(), driver);
		} else if (Ambiente.toUpperCase().equals("PRODUCCION")) {
			JsonConstructor.createJsonInstrument2Prod(XlsData.getNumeroCelular());
			JsonConstructor.createJsonEnrolamientoProd(XlsData.getNumeroCelular());
			EvidenceData.capturarPaso(false, "Correcto: Se realizo consulta, el tipo de instrumento es "+LogResultInstrument2.getTipoInstrumento()
			+" y el estatus de producto es "+LogResultInstrument2.getEstatusInstrumento()+" con estatus de servicio "+LogResultInstrument2.getEstatusServicio(), driver);
			
			EvidenceData.capturarPaso(false, "Correcto: Se realizo consulta de enrolamiento, estatus IsNewTC -> "+LogResultEnrolamiento.getIsNewTC()
			+" y el estatus EnrollSTS -> "+LogResultEnrolamiento.getEnrollSTS(), driver);	
		} 	
	}
	
	public static void realizarConsultaTestInstrumento3(String Ambiente){
		if (Ambiente.toUpperCase().equals("TEST")) {
			JsonConstructor.createJsonInstrumentTest3(XlsData.getNumeroCelular());
			JsonConstructor.createJsonEnrolamientoTest(XlsData.getNumeroCelular());
			EvidenceData.capturarPaso(false, "Correcto: Se realizo consulta, el tipo de instrumento es "+LogResultInstrument3.getTipoInstrumento()
			+" y el estatus de producto es "+LogResultInstrument3.getEstatusInstrumento()+" con estatus de servicio "+LogResultInstrument3.getEstatusServicio(), driver);
			
			EvidenceData.capturarPaso(false, "Correcto: Se realizo consulta de enrolamiento, estatus IsNewTC -> "+LogResultEnrolamiento.getIsNewTC()
			+" y el estatus EnrollSTS -> "+LogResultEnrolamiento.getEnrollSTS(), driver);	
		} else if (Ambiente.toUpperCase().equals("PRODUCCION")) {
			JsonConstructor.createJsonInstrument3Prod(XlsData.getNumeroCelular());
			JsonConstructor.createJsonEnrolamientoProd(XlsData.getNumeroCelular());
			EvidenceData.capturarPaso(false, "Correcto: Se realizo consulta, el tipo de instrumento es "+LogResultInstrument3.getTipoInstrumento()
			+" y el estatus de producto es "+LogResultInstrument3.getEstatusInstrumento()+" con estatus de servicio "+LogResultInstrument3.getEstatusServicio(), driver);
			
			EvidenceData.capturarPaso(false, "Correcto: Se realizo consulta de enrolamiento, estatus IsNewTC -> "+LogResultEnrolamiento.getIsNewTC()
			+" y el estatus EnrollSTS -> "+LogResultEnrolamiento.getEnrollSTS(), driver);
		}
		
	}
	
	/*public static void realizarConsultaProdInstrumento1(){
		JsonConstructor.createJsonInstrument1Prod(XlsData.getNumeroCelular());
		JsonConstructor.createJsonEnrolamientoProd(XlsData.getNumeroCelular());
		EvidenceData.capturarPaso(false, "Correcto: Se realizo consulta, el tipo de instrumento es "+LogResultInstrument1.getTipoInstrumento()
		+" y el estatus es "+LogResultInstrument1.getEstatusInstrumento()+" con estatus de servicio "+LogResultInstrument1.getEstatusServicio(), driver);
		
		EvidenceData.capturarPaso(false, "Correcto: Se realizo consulta de enrolamiento, estatus IsNewTC -> "+LogResultEnrolamiento.getIsNewTC()
		+" y el estatus EnrollSTS -> "+LogResultEnrolamiento.getEnrollSTS(), driver);	
	}
	
	public static void realizarConsultaProdInstrumento2(){
		JsonConstructor.createJsonInstrument2Prod(XlsData.getNumeroCelular());
		JsonConstructor.createJsonEnrolamientoProd(XlsData.getNumeroCelular());
		EvidenceData.capturarPaso(false, "Correcto: Se realizo consulta, el tipo de instrumento es "+LogResultInstrument2.getTipoInstrumento()
		+" y el estatus es "+LogResultInstrument1.getEstatusInstrumento()+" con estatus de servicio "+LogResultInstrument2.getEstatusServicio(), driver);
		
		EvidenceData.capturarPaso(false, "Correcto: Se realizo consulta de enrolamiento, estatus IsNewTC -> "+LogResultEnrolamiento.getIsNewTC()
		+" y el estatus EnrollSTS -> "+LogResultEnrolamiento.getEnrollSTS(), driver);	
	}
	
	public static void realizarConsultaProdInstrumento3(){
		JsonConstructor.createJsonInstrument3Prod(XlsData.getNumeroCelular());
		JsonConstructor.createJsonEnrolamientoProd(XlsData.getNumeroCelular());
		EvidenceData.capturarPaso(false, "Correcto: Se realizo consulta, el tipo de instrumento es "+LogResultInstrument2.getTipoInstrumento()
		+" y el estatus es "+LogResultInstrument1.getEstatusInstrumento()+" con estatus de servicio "+LogResultInstrument2.getEstatusServicio(), driver);
		
		EvidenceData.capturarPaso(false, "Correcto: Se realizo consulta de enrolamiento, estatus IsNewTC -> "+LogResultEnrolamiento.getIsNewTC()
		+" y el estatus EnrollSTS -> "+LogResultEnrolamiento.getEnrollSTS(), driver);	
	}*/
	
	
	
	public static boolean LogInBBVAMovil(){
		boolean statusLogin = false;
		if(PantallaLogIn.existeTxtContrasenia()){
			PantallaLogIn.setContrasenia(XlsData.getContraseniaActual());
			PantallaLogIn.ClickBtnEntrar();
			
			if(MenuPrincipal.existelblTituloHeader()){
				statusLogin=true;
			}
			else if (PantallaLogIn.existeLblModalAviso()) {
				CommonFunction.evidenciaError(true, "Se muestra Modal "+VentanaActivacion.getTextModal()+"");
				PantallaLogIn.clickBtnModalOk();
				statusLogin=false;
			}
			else{
				CommonFunction.evidenciaError(true,"No se mostro Menú Principal");
			}
		}
		else{
			CommonFunction.evidenciaError(true,"No se mostro pantalla Log In");
		}
		
		return statusLogin;
	}
	
	public static void evidenciaError(boolean captura, String descripcionError) {
		AppDataTest.setStatusEjecucion("FAILED");
		AppDataTest.setComentarioEjecucion(descripcionError);
		EvidenceData.capturarPaso(captura, "Error: "+descripcionError, driver);
	}
	
	public static void scrollDown(){
        for(int i=0;i<1;i++) {
        	Dimension dimensions = driver.manage().window().getSize();
            System.out.println("Size of screen= " +dimensions);
            int Startpoint = (int) (dimensions.getHeight() * 0.8);
            System.out.println("Size of scrollStart= " +Startpoint );
            int scrollEnd = (int) (dimensions.getHeight() * 0.2);
            System.out.println("Size of cscrollEnd= " + scrollEnd);             
            driver.swipe(0, Startpoint,0,scrollEnd,200); 
        }   
	}
	
	public static void scrollUp(){
        for(int i=0;i<1;i++) {
        	Dimension dimensions = driver.manage().window().getSize();
            System.out.println("Size of screen= " +dimensions);
            int Startpoint = (int) (dimensions.getHeight() * 0.5);
            System.out.println("Size of scrollStart= " +Startpoint );
            int scrollEnd = (int) (dimensions.getHeight() * 0.2);
            System.out.println("Size of cscrollEnd= " + scrollEnd);             
            driver.swipe(0, scrollEnd,0,Startpoint,100); 
        }   
	}
	
	public static boolean PrepararClientaDeA1toC4(){
		boolean blnOk = false;
		try{
			if(CommonFunction.LogInBBVAMovil()){
				
				if(MenuPrincipal.clickMenuHamburgesa()){
					Thread.sleep(1500);
					MenuHamburguesa.clickLblAdministrar();
					Thread.sleep(1000);
					MenuHAdministrar.clickBtnCancelarSuspender();
					CancelarSuspenderCuenta.clickBtnCancelarDefinitivamente();
							if(CancelarSuspenderCuenta.existeLblCancelar()){
								CancelarSuspenderCuenta.setTxtContrasenia(XlsData.getContraseniaActual());
								try{driver.hideKeyboard();}catch(Exception e){}
								CancelarSuspenderCuenta.clickBtnConfirmar();
								if(CancelarSuspenderCuenta.existeLblTituloModalAviso()){
									CancelarSuspenderCuenta.clickBtnOk();
									if(VentanaBienvenida.existetxtNumCelular()){
										driver.startActivity("rpkandrodev.yaata", "rpkandrodev.yaata.activity.ThreadListActivity");
										Thread.sleep(4000);
										YAATA_SMS.eliminarConversaciónSMS();
										driver.startActivity("com.bancomer.mbanking", "com.bancomer.mbanking.SplashViewController");
										blnOk = true;
									}else{
										System.out.println("No se muestra la ventana de Bienvenida");
									}
								}else{
									System.out.println("No se muestra modal de cancelacion");
								}
							}else{
								System.out.println("No se muestra ventana para confirmar cancelación");
							}
					}else{
						System.out.println("Se Abre el menu Hamburgesa");
				}
			}else{
				System.out.println("No se logro logear correctamente");
			}
		}catch(Exception e){
			System.out.println(e);
		}finally{
			ATC_Evidence.eliminarImagenes();
			EvidenceData.getComentarios().clear();
			EvidenceData.getTiempos().clear();
			XlsData.iniciarTiempo();
			System.out.println(blnOk);
		}
		return blnOk;
	}
	
	
	public static boolean PrepararClientaDeC4toPS(){
		boolean blnOk = false;
		try
		{
			if (VentanaPrincipal.existeLblHola()) {
				VentanaPrincipal.ClickBtnEntrar();
				Thread.sleep(3000);
				VentanaBienvenida.SetNumCelular(XlsData.getNumeroCelular());
				try {driver.hideKeyboard();}catch(Exception e){}
				VentanaBienvenida.ClickBtnIngresar();
				if (IngresarTarjeta.existeTxtNumTarjeta()) {
					IngresarTarjeta.SetNumTarjeta(XlsData.getNumeroTarjeta());
					IngresarTarjeta.ClickBtnContinuar();
					if (IngresarCVV.existeTxtCVV()) {
						IngresarCVV.SetCVV(XlsData.getCVV());
						IngresarCVV.SetNIP(XlsData.getNIP());
						IngresarCVV.ClickBtnContinuar();
						if (PantallaConfirmarContrasenia.existeLblTituloPantallaContrasenia()) {
							PantallaConfirmarContrasenia.setTxtContrasenia(XlsData.getContraseniaActual());
							PantallaConfirmarContrasenia.setTxtContrasenia2(XlsData.getContraseniaActual());
							PantallaConfirmarContrasenia.clickBtnContinuar();
							if (PantallaTerminosyCondiciones.existeLblTituloTerminosyCondiciones()) {
								PantallaTerminosyCondiciones.clickSwithSiNo();
								PantallaTerminosyCondiciones.clickLayoutFirma();
								if (VentanaFirma.ExisteAreaParaFirma()) {
									CommonFunction.scrollDown();
									VentanaFirma.clickBtnAceptarFirma();
									if (PantallaTerminosyCondiciones.existeLblTituloTerminosyCondiciones()) {
										PantallaTerminosyCondiciones.clickBtnContratar();
										if (VentanaActivacionExitosa.existeImgPalomita()) {
											driver.startActivity("com.bancomer.mbanking", "com.bancomer.mbanking.SplashViewController");
											blnOk = true;
										} else {
											System.out.println("No se mostro pantalla contratación exitosa");
										}
									} else {
										System.out.println("No se mostro pantalla terminos y condiciones");
									}
								} else {
									System.out.println("No se mostro pantalla para firmar");
								}
							} else {
								System.out.println("No se mostro pantalla terminos y condiciones");
							}
						} else {
							System.out.println("No se mostro pantalla confirmar contraseña");
						}
					} else {
						System.out.println("No se mostro pantalla CVV y NIP");
					}
				} else {
					System.out.println("No se mostro pantalla Tarjeta");
				}
			} else {
				System.out.println("No se mostro pantalla Hola");
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			ATC_Evidence.eliminarImagenes();
			EvidenceData.getComentarios().clear();
			EvidenceData.getTiempos().clear();
			XlsData.iniciarTiempo();
			System.out.println(blnOk);
		}
		return blnOk;
	}
	
	public static String TratamientoString(String Cuenta){
		try{
			Cuenta = Cuenta.substring(11);
			Cuenta = "*"+Cuenta;
			//System.out.println(Cuenta);
		}catch(Exception e){
			System.out.println(e);
		}
		return Cuenta;
	}
	
	public static void swipeFromRightToLeft() {
		 Dimension size = driver.manage().window().getSize();
		 try 
       {
           int startx = (int) (size.width * 0.9); 
           int endx = (int) (size.width * 0.10); 
           int starty = size.height / 2; 
           driver.swipe(startx, starty, endx, starty, 300);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	public static boolean cambiarAlertas(String numeroCuenta, String montoDeposito, String montoCargos, String alias){
		boolean blnOk=false;
		String numeroCuenta1=AdmonAlertas.getTextCuenta();
		String numeroCuenta2=null;
		while (!numeroCuenta1.equals(numeroCuenta2)) 
		{
			numeroCuenta1=AdmonAlertas.getTextCuenta();
			if(AdmonAlertas.getTextCuenta().equals(numeroCuenta)){
				System.out.println("Encontre la cuenta a buscar "+AdmonAlertas.getTextCuenta());
				try 
				{
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				AdmonAlertas.clickBtnEditar();
				AdmonAlertas.SetTxtDeposito(montoDeposito);
				try{driver.hideKeyboard();}catch(Exception e){}
				AdmonAlertas.SetTxtCargo(montoCargos);
				try{driver.hideKeyboard();}catch(Exception e){}
				AdmonAlertas.clickBtnGuardar();
				if(AdmonAlertas.existeLblModalContrasenia()){
					AdmonAlertas.SetTxtContrasenia(XlsData.getContraseniaActual());
					AdmonAlertas.clickBtnConfirmar();
					if(AdmonAlertas.existeLblNombreCuenta()){
						EvidenceData.capturarPaso(false, "Correcto : Prueba finalizada", driver);
					}else{
						CommonFunction.evidenciaError(true, "No se pudo actulizar montos");
					}
				}else{
					CommonFunction.evidenciaError(true, "No se mostro modal para confirmar");
				}
				numeroCuenta1=null;
				numeroCuenta2=null;
				blnOk=true;
			}
			else
			{
				CommonFunction.swipeFromRightToLeft();
				numeroCuenta2=AdmonAlertas.getTextCuenta();
			}
			
		}
		System.out.println("llegue al final del carrusel");
		try 
		{
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blnOk;
	 }
	
	
	
	public static void main(String []args){
		System.out.println(CommonFunction.TratamientoString("4152313293254574"));
	}
	 
}
