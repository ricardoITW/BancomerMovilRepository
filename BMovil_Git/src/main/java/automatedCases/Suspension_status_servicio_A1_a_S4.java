package automatedCases;

import java.util.ArrayList;

import JSONLogs.LogResultInstrument1;
import JSONLogs.LogResultInstrument2;
import appiumConfiguration.DriverAppium;
import appiumConfiguration.appiumServer;
import configurationData.AppDataTest;
import configurationData.Utils;
import configurationData.XlsData;
import evidence.ATC_Evidence;
import evidence.EvidenceData;
import genericCases.CommonFunction;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuPrincipal;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.MenuHamburguesa;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.Administrar.CancelarSuspenderCuenta;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.Administrar.MenuHAdministrar;
import windowsLibrary.Enrolamiento.YAATA_SMS;

public class Suspension_status_servicio_A1_a_S4 {
	static AndroidDriver driver = null;
	static ArrayList<String> comentarios = new ArrayList<>();
	static ArrayList<String> tiempos = new ArrayList<>();
	
	public static void Ejecutar(){
		try
		{
			appiumServer.Stop();
			appiumServer.Start();
			driver = DriverAppium.getDriverAndroid(XlsData.getNombreDispositivo(), XlsData.getVersion());
			new BaseClass(driver);
			Thread.sleep(5000);		
			//EvidenceData.capturarPaso(true, "Correcto: Se abre aplicación BBVA movil", driver);
			if (CommonFunction.LogInBBVAMovil()) {
				MenuPrincipal.clickMenuHamburgesa();
				Thread.sleep(1500);
				EvidenceData.capturarPaso(true, "Correcto: Se muestra Menu Hamburguesa", driver);
				MenuHamburguesa.clickLblAdministrar();
				if (MenuHAdministrar.existeLblTituloAdministrar()) {
					MenuHAdministrar.clickBtnCancelarSuspender();
					if (CancelarSuspenderCuenta.existeLblTituloCancelarSuspender()) {
						CancelarSuspenderCuenta.clickBtnSuspenderTemporalmente();
						if (CancelarSuspenderCuenta.existeLblSuspenderTemporalmenteConfirmar()) {
							CancelarSuspenderCuenta.setTxtContrasenia(XlsData.getContraseniaActual());
							try {driver.hideKeyboard();}catch(Exception e){}
							//*****************Evaluar JSON antes de suspender
							CommonFunction.realizarConsultaTestInstrumento1(XlsData.getAmbiente());
							if (LogResultInstrument1.getEstatusServicio().equals("A1")) {
								CancelarSuspenderCuenta.clickBtnConfirmarSuspension();
								if (CancelarSuspenderCuenta.existeLblTituloModalAviso()) {
									CancelarSuspenderCuenta.clickBtnOk();
									
									//*****************Evaluar JSON despues de suspender
									CommonFunction.realizarConsultaInstrumento2(XlsData.getAmbiente());
									if (LogResultInstrument2.getEstatusServicio().equals("S4")) {
										
										EvidenceData.capturarPaso(false, "Correcto: El estatus del servicio cambió de "+LogResultInstrument1.getEstatusServicio()
										+" a "+LogResultInstrument2.getEstatusServicio(), driver);
										
										AppDataTest.setStatusEjecucion("PASSED");
										AppDataTest.setComentarioEjecucion("El cliente ha sido suspendido temporalmente, estatus de servicio de "
										+LogResultInstrument1.getEstatusServicio()+" a "+LogResultInstrument2.getEstatusServicio());
										
									} else {
										CommonFunction.evidenciaError(false,"Error: El estatus de servicio no cambio a S4");
									}
								} else {
									CommonFunction.evidenciaError(true,"Error: No se mostro Modal Aviso de suspensión");
								}
							} else {
								CommonFunction.evidenciaError(false,"Error; El estatus del servicio no es A1");
							}
						} else {
							CommonFunction.evidenciaError(true,"Error: No se mostro Pantalla de Confirmación de Suspensión");
						}
					} else {
						CommonFunction.evidenciaError(true,"Error: No se mostro Pantalla Cancelar o Suspender");
					}
				} else {
					CommonFunction.evidenciaError(true,"Error: No se mostro Pantalla Menú Administrar");
				}
			} else {
				CommonFunction.evidenciaError(false,"Error: No se realizo Login");
			}
			
		}
		catch(Exception e)
		{
			AppDataTest.setStatusEjecucion("FAILED");
			AppDataTest.setComentarioEjecucion(e.getMessage());
		}
		finally
		{
			//Evidencia
			String filePath = ATC_Evidence.evidencia_pdf(EvidenceData.getComentarios(), EvidenceData.getTiempos());
			
			//Ejecutar en JIRA
			//Utils.executeZephyr(AppDataTest.getIdProyectoJira(), AppDataTest.getIdCycle(), 
				//	AppDataTest.getStatusEjecucion(), AppDataTest.getComentarioEjecucion(), XlsData.getNombreCaso(), filePath);
			driver.startActivity("rpkandrodev.yaata", "rpkandrodev.yaata.activity.ThreadListActivity");
			YAATA_SMS.eliminarConversaciónSMS();
			
			driver.quit();
			appiumServer.Stop();
		}
	}
}
