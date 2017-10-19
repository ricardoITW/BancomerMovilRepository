package automatedCases.SegundaFase;

import java.util.ArrayList;

import appiumConfiguration.DriverAppium;
import appiumConfiguration.appiumServer;
import configurationData.XlsData;
import evidence.ATC_Evidence;
import evidence.EvidenceData;
import genericCases.CommonFunction;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;
import windowsLibrary.AppBBVAMovil.PantallaLogIn;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuPrincipal;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.MenuHamburguesa;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.Administrar.MenuHAdministrar;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.Administrar.PantallaCambioCorreo;

public class Cambio_de_correo_exitosamente {
	static AndroidDriver driver = null;
	static ArrayList<String> comentarios = new ArrayList<>();
	static ArrayList<String> tiempos = new ArrayList<>();
	
	public static void Ejecutar() {
		appiumServer.Stop();
		appiumServer.Start();
		driver = DriverAppium.getDriverAndroid(XlsData.getNombreDispositivo(), XlsData.getVersion());
		new BaseClass(driver);
		
		try{
			if(PantallaLogIn.existeTxtContrasenia()) {
				PantallaLogIn.setContrasenia(XlsData.getContraseniaActual());
				PantallaLogIn.ClickBtnEntrar();
				if (MenuPrincipal.clickMenuHamburgesa()) {
					Thread.sleep(1500);
					EvidenceData.capturarPaso(true, "Correcto: Se muestra Menu Hamburguesa", driver);
					MenuHamburguesa.clickLblAdministrar();
					Thread.sleep(1000);
					EvidenceData.capturarPaso(true, "Correcto: Se muestra Pantalla Menú Administrar", driver);
					MenuHAdministrar.clickBtnConfCorreoElec();
					if(PantallaCambioCorreo.existeLblConfigCorreo()){
						PantallaCambioCorreo.SetCorreoNuevo(XlsData.getCorreoElectronicoNuevo());
						PantallaCambioCorreo.SetConfirmaCorreo(XlsData.getCorreoElectronicoNuevo());
						try {driver.hideKeyboard();}catch(Exception e){}
						Thread.sleep(1500);
						EvidenceData.capturarPaso(true, "Correcto: Se llenan los campos correctamente", driver);
						PantallaCambioCorreo.clickBtnContinuar();
						if(PantallaCambioCorreo.existeLblRevisar()){
							PantallaCambioCorreo.SetContrasenia(XlsData.getContraseniaActual());
							try {driver.hideKeyboard();}catch(Exception e){}
							Thread.sleep(1500);
							EvidenceData.capturarPaso(true, "Correcto: Se ingresa contraseña para autorizar modificación", driver);
							PantallaCambioCorreo.clickBtnConfirmar();
							if(PantallaCambioCorreo.existeLblOperacionExitosa()){
								Thread.sleep(1500);
								PantallaCambioCorreo.clickBtnMenu();
							}else{
								CommonFunction.evidenciaError(true,"No se mostro ventana de Operación exitosa");
							}
						}else{
							CommonFunction.evidenciaError(true,"No se mostro ventana para confirmación mediante contraseña");
						}
					}else{
						CommonFunction.evidenciaError(true,"No se mostro ventana de configuración de correo");
					}
				}else{
					CommonFunction.evidenciaError(true,"No se mostro menú hamburgesa");
				}
			}else{
				CommonFunction.evidenciaError(true,"No se mostro ventana de Log in");
			}
		}catch(Exception e){
			
		}finally{
			driver.quit();
			appiumServer.Stop();
			
			//Evidencia
			String filePath = ATC_Evidence.evidencia_pdf(EvidenceData.getComentarios(), EvidenceData.getTiempos());
		}

	}
}
