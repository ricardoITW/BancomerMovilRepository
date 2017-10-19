package automatedCases;

import java.util.ArrayList;

import JSONLogs.LogResultInstrument1;
import JSONLogs.LogResultInstrument2;
import appiumConfiguration.DriverAppium;
import appiumConfiguration.appiumServer;
import configurationData.AppDataTest;
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
import windowsLibrary.Enrolamiento.VentanaBienvenida;
import windowsLibrary.Enrolamiento.YAATA_SMS;

public class Cancelacion_status_servicio_A1_a_C4 {
	static AndroidDriver driver = null;
	static ArrayList<String> comentarios = new ArrayList<>();
	static ArrayList<String> tiempos = new ArrayList<>();
	
	public static void Ejecutar(){
		
		try{
			appiumServer.Stop();
			appiumServer.Start();
			driver = DriverAppium.getDriverAndroid(XlsData.getNombreDispositivo(), XlsData.getVersion());
			new BaseClass(driver);
			Thread.sleep(4000);		
			//EvidenceData.capturarPaso(true, "Correcto: Se muestra la pantalla de Login", driver);
			if(CommonFunction.LogInBBVAMovil()){
			
				if(MenuPrincipal.clickMenuHamburgesa()){
					Thread.sleep(1500);
					EvidenceData.capturarPaso(true, "Correcto: Se muestra el Menu Hamburguesa", driver);
					MenuHamburguesa.clickLblAdministrar();
					Thread.sleep(1000);
					EvidenceData.capturarPaso(true, "Correcto: Se muestra Pantalla Administrar", driver);
					MenuHAdministrar.clickBtnCancelarSuspender();
					EvidenceData.capturarPaso(true, "Correcto: Se muestra Pantalla Menú Cancelar o Suspender Servicio", driver);
					CancelarSuspenderCuenta.clickBtnCancelarDefinitivamente();
							if(CancelarSuspenderCuenta.existeLblCancelar()){
								CommonFunction.realizarConsultaTestInstrumento1(XlsData.getAmbiente());//***Consulta1
								if (LogResultInstrument1.getEstatusServicio().equals("A1")) {
									CancelarSuspenderCuenta.setTxtContrasenia(XlsData.getContraseniaActual());
									try{driver.hideKeyboard();}catch(Exception e){}
									//EvidenceData.capturarPaso(true, "Correcto: Se ingresa contraseña para autorizar cancelación", driver);		
									CancelarSuspenderCuenta.clickBtnConfirmar();
									if(CancelarSuspenderCuenta.existeLblTituloModalAviso()){
										CancelarSuspenderCuenta.clickBtnOk();
										CommonFunction.realizarConsultaInstrumento2(XlsData.getAmbiente());//***Consulta2
										if (VentanaBienvenida.existetxtNumCelular()) {
											if(LogResultInstrument2.getEstatusServicio().equals("C4")){
												EvidenceData.capturarPaso(false, "Correcto: El Estatus del servicio del instrumento cambio de "+LogResultInstrument1.getEstatusServicio()+" a "+LogResultInstrument2.getEstatusServicio(), driver);
												AppDataTest.setStatusEjecucion("PASSED");
												AppDataTest.setComentarioEjecucion("Correcto: El Estatus del servicio del instrumento cambio de "+LogResultInstrument1.getEstatusServicio()+" a "+LogResultInstrument2.getEstatusServicio());
											}else{
												CommonFunction.evidenciaError(false, "El Estatus del servicio del instrumento no cambio, el estatus actual es "+LogResultInstrument2.getEstatusServicio());
											}
										} else {
											CommonFunction.evidenciaError(true, "No se mostro Ventana ¡Bienvenido! a BBVA Bancomer");
										}
									}else{
										CommonFunction.evidenciaError(true, "No se modal de cancelacion");
									}
								} else {
									CommonFunction.evidenciaError(true, "El estatus del servicio no es A1, es "+LogResultInstrument1.getEstatusServicio());
								}
							}else{
								CommonFunction.evidenciaError(true, "No se muestra ventana para confirmar cancelación");
							}
					}else{
					CommonFunction.evidenciaError(true, "Se Abre el menu Hamburgesa");
				}
			}else{
				CommonFunction.evidenciaError(true, "No se logro logear correctamente");
			}
		}catch(Exception e)
			{
				AppDataTest.setStatusEjecucion("FAILED");
				AppDataTest.setComentarioEjecucion(e.getMessage());
			}
			finally
			{
				//Evidencia
				String filePath = ATC_Evidence.evidencia_pdf(EvidenceData.getComentarios(), EvidenceData.getTiempos());
				
				driver.startActivity("rpkandrodev.yaata", "rpkandrodev.yaata.activity.ThreadListActivity");
				YAATA_SMS.eliminarConversaciónSMS();
				driver.quit();
				appiumServer.Stop();			
		}
	}
}
