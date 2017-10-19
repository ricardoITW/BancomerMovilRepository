package automatedCases.SegundaFase;

import java.util.ArrayList;

import appiumConfiguration.DriverAppium;
import appiumConfiguration.appiumServer;
import configurationData.AppDataTest;
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
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.Administrar.PantallaCambioContrasenia;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.Administrar.PantallaCambioContraseniaResultado;

public class Cambio_de_contrasenia_por_zona_privada_exitoso {
	static AndroidDriver driver = null;
	static ArrayList<String> comentarios = new ArrayList<>();
	static ArrayList<String> tiempos = new ArrayList<>();
	public static void Ejecutar() {
		try {
			appiumServer.Stop();
			appiumServer.Start();
			driver = DriverAppium.getDriverAndroid(XlsData.getNombreDispositivo(), XlsData.getVersion());
			new BaseClass(driver);
			
			if(PantallaLogIn.existeTxtContrasenia()) {
				PantallaLogIn.setContrasenia(XlsData.getContraseniaActual());
				PantallaLogIn.ClickBtnEntrar();
				if (MenuPrincipal.existelblTituloHeader()) {
					if (MenuPrincipal.clickMenuHamburgesa()) {
						Thread.sleep(1500);
						EvidenceData.capturarPaso(true, "Correcto: Se muestra Menu Hamburguesa", driver);
						MenuHamburguesa.clickLblAdministrar();
						if (MenuHAdministrar.existeLblTituloAdministrar()) {
							MenuHAdministrar.clickBtnCambiarContrasenia();
							if (PantallaCambioContrasenia.existeLblTituloCambiarContrasenia()) {
								PantallaCambioContrasenia.setTxtContraseniaActual(XlsData.getContraseniaActual());
								PantallaCambioContrasenia.setTxtContraseniaNueva(XlsData.getContraseniaNueva());
								PantallaCambioContrasenia.setTxtContraseniaNuevaConf(XlsData.getContraseniaNueva());
								try {driver.hideKeyboard();}catch(Exception e){}
								EvidenceData.capturarPaso(true, "Correcto: Se llenan los campos para cambio de contraseña", driver);
								PantallaCambioContrasenia.clickbtnConfirmar();
								if (PantallaCambioContraseniaResultado.existeLblResultadoMensaje()) {
									
									//Evaluación del resultado
									if (PantallaCambioContraseniaResultado.getTextLblResultadoCambio().equals("Operación exitosa")) {
										EvidenceData.capturarPaso(true, "Correcto: La contrasenia se modificó con exito, Numero de Folio "
												+PantallaCambioContraseniaResultado.getTextLblFolioNumero(), driver);
									} else {
										CommonFunction.evidenciaError(true,"La modificación de contraseña no se llevo a cabo");
									}
								} else {
									CommonFunction.evidenciaError(true,"No se mostro Pantalla Resultado Cambiar Constraseña");
								}
							} else {
								CommonFunction.evidenciaError(true,"No se mostro Pantalla Cambiar Constraseña");
							}
						} else {
							CommonFunction.evidenciaError(true,"No se mostro Menú Administrar");
						}	
					}else {
						CommonFunction.evidenciaError(true,"No se mostro Menú Hamburguesa Log In");
					}
				} else {
					CommonFunction.evidenciaError(true,"No se mostro Menú Principal");
				}
			}
			else{
				CommonFunction.evidenciaError(true,"No se mostro pantalla Log In");
			}
		}
		catch(Exception e) {
			// Acciones cuando no se encuentra un elemento
			AppDataTest.setStatusEjecucion("FAILED");
			AppDataTest.setComentarioEjecucion(e.getMessage());
		}
		finally {
			driver.quit();
			appiumServer.Stop();
			
			//Evidencia
			String filePath = ATC_Evidence.evidencia_pdf(EvidenceData.getComentarios(), EvidenceData.getTiempos());
			
			//Ejecutar en JIRA
			//Utils.executeZephyr(AppDataTest.getIdProyectoJira(), AppDataTest.getIdCycle(), 
				//	AppDataTest.getStatusEjecucion(), AppDataTest.getComentarioEjecucion(), XlsData.getNombreCaso(), filePath);
		}

	}

}
