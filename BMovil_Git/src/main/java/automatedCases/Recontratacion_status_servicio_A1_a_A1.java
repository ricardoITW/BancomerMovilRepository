package automatedCases;

import java.util.ArrayList;

import JSONLogs.LogResultInstrument1;
import JSONLogs.LogResultInstrument2;
import JSONLogs.LogResultInstrument3;
import appiumConfiguration.DriverAppium;
import appiumConfiguration.appiumServer;
import configurationData.AppDataTest;
import configurationData.XlsData;
import evidence.ATC_Evidence3Consultas;
import evidence.EvidenceData;
import genericCases.CommonFunction;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;
import windowsLibrary.Enrolamiento.IngresarCVV;
import windowsLibrary.Enrolamiento.IngresarTarjeta;
import windowsLibrary.Enrolamiento.VentanaActivacion;
import windowsLibrary.Enrolamiento.VentanaActivacionExitosa;
import windowsLibrary.Enrolamiento.VentanaBienvenida;
import windowsLibrary.Enrolamiento.VentanaPrincipal;
import windowsLibrary.Enrolamiento.YAATA_SMS;

public class Recontratacion_status_servicio_A1_a_A1 {
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
			if(VentanaPrincipal.existeLblHola()){
				VentanaPrincipal.ClickBtnEntrar();
				Thread.sleep(2000);
				VentanaBienvenida.SetNumCelular(XlsData.getNumeroCelular());
				try {driver.hideKeyboard();}catch(Exception e){}
				VentanaBienvenida.ClickBtnIngresar();
				if (IngresarTarjeta.existeTxtNumTarjeta()) {
					CommonFunction.realizarConsultaTestInstrumento1(XlsData.getAmbiente());//******Consulta1
					if (LogResultInstrument1.getEstatusServicio().equals("A1")) {
						IngresarTarjeta.SetNumTarjeta(XlsData.getNumeroTarjeta());
						IngresarTarjeta.ClickBtnContinuar();
						if (IngresarCVV.existeTxtCVV()) {
							IngresarCVV.SetCVV(XlsData.getCVV());
							IngresarCVV.SetNIP(XlsData.getNIP());
							IngresarCVV.ClickBtnContinuar();
							if (VentanaActivacion.existeTituloActivacion()) {
								driver.startActivity("rpkandrodev.yaata", "rpkandrodev.yaata.activity.ThreadListActivity");
								if(YAATA_SMS.clickNumeroSMS()){
									Thread.sleep(4000);
									if(VentanaBienvenida.SetNumCelular(XlsData.getNumeroCelular())){
										try {driver.hideKeyboard();}catch(Exception e){}
										//EvidenceData.capturarPaso(true, "Correcto: Ingresa un numero Celular", driver);
										VentanaBienvenida.ClickBtnIngresar();
										if(VentanaActivacionExitosa.existeLblActivacionExitosa1()){
											CommonFunction.realizarConsultaInstrumento2(XlsData.getAmbiente());//****Segunda consulta
											if(LogResultInstrument2.getEstatusServicio().equals("A1")){
												EvidenceData.capturarPaso(false, "Correcto: El estatus del servicio cambió de "+LogResultInstrument1.getEstatusServicio()
												+" a "+LogResultInstrument2.getEstatusServicio(), driver);
													
												AppDataTest.setStatusEjecucion("PASSED");
												AppDataTest.setComentarioEjecucion("El cliente ha sido Activado exitosamente y el estatus de servicio cambio de "
												+LogResultInstrument1.getEstatusServicio()+" a "+LogResultInstrument3.getEstatusServicio());
											}
											else{
												CommonFunction.evidenciaError(false,"Error: El estatus del servicio no cambio a A1, es "+LogResultInstrument3.getEstatusServicio());
											}
											}else{
												CommonFunction.evidenciaError(true,"Error: No se presento pantalla de activacion exitosa");
											}
										}else{
											CommonFunction.evidenciaError(true,"Error: No se ingreso el numero celular");
										}
									}
									else{
										CommonFunction.evidenciaError(true,"Error: El SMS con liga de activación no fue recibido");
									}
							} else {
								CommonFunction.evidenciaError(true,"Error: No se mostro ventana de Activación");
							}
						} else {
							CommonFunction.evidenciaError(true,"Error: No se mostro pantalla CVV");
						}
					} else {
						CommonFunction.evidenciaError(false,"Error: El estatus de servicio no es A1, es "+LogResultInstrument1.getEstatusServicio());
					}
				} else {
					CommonFunction.evidenciaError(true,"Error: No se mostro pantalla Tarjeta");
				}
			}else{
				//CommonFunction.evidenciaError(true,"Error: No se mostro pantalla Hola");
				if (VentanaBienvenida.existetxtNumCelular()) {
					VentanaBienvenida.SetNumCelular(XlsData.getNumeroCelular());
					try {driver.hideKeyboard();}catch(Exception e){}
					VentanaBienvenida.ClickBtnIngresar();
					if (IngresarTarjeta.existeTxtNumTarjeta()) {
						CommonFunction.realizarConsultaTestInstrumento1(XlsData.getAmbiente());//******Consulta1
						if (LogResultInstrument1.getEstatusServicio().equals("A1")) {
							IngresarTarjeta.SetNumTarjeta(XlsData.getNumeroTarjeta());
							IngresarTarjeta.ClickBtnContinuar();
							if (IngresarCVV.existeTxtCVV()) {
								IngresarCVV.SetCVV(XlsData.getCVV());
								IngresarCVV.SetNIP(XlsData.getNIP());
								IngresarCVV.ClickBtnContinuar();
								if (VentanaActivacion.existeTituloActivacion()) {
									driver.startActivity("rpkandrodev.yaata", "rpkandrodev.yaata.activity.ThreadListActivity");
									if(YAATA_SMS.clickNumeroSMS()){
										Thread.sleep(4000);
										if(VentanaBienvenida.SetNumCelular(XlsData.getNumeroCelular())){
											try {driver.hideKeyboard();}catch(Exception e){}
											//EvidenceData.capturarPaso(true, "Correcto: Ingresa un numero Celular", driver);
											VentanaBienvenida.ClickBtnIngresar();
											if(VentanaActivacionExitosa.existeLblActivacionExitosa1()){
												CommonFunction.realizarConsultaInstrumento2(XlsData.getAmbiente());//****Segunda consulta
												if(LogResultInstrument2.getEstatusServicio().equals("A1")){
													EvidenceData.capturarPaso(false, "Correcto: El estatus del servicio cambió de "+LogResultInstrument1.getEstatusServicio()
													+" a "+LogResultInstrument2.getEstatusServicio(), driver);
														
													AppDataTest.setStatusEjecucion("PASSED");
													AppDataTest.setComentarioEjecucion("El cliente ha sido Activado exitosamente y el estatus de servicio cambio de "
													+LogResultInstrument1.getEstatusServicio()+" a "+LogResultInstrument3.getEstatusServicio());
												}
												else{
													CommonFunction.evidenciaError(false,"Error: El estatus del servicio no cambio a A1, es "+LogResultInstrument3.getEstatusServicio());
												}
												}else{
													CommonFunction.evidenciaError(true,"Error: No se presento pantalla de activacion exitosa");
												}
											}else{
												CommonFunction.evidenciaError(true,"Error: No se ingreso el numero celular");
											}
										}
										else{
											CommonFunction.evidenciaError(true,"Error: El SMS con liga de activación no fue recibido");
										}
								} else {
									CommonFunction.evidenciaError(true,"Error: No se mostro ventana de Activación");
								}
							} else {
								CommonFunction.evidenciaError(true,"Error: No se mostro pantalla CVV");
							}
						} else {
							CommonFunction.evidenciaError(false,"Error: El estatus de servicio no es A1, es "+LogResultInstrument1.getEstatusServicio());
						}
					} else {
						CommonFunction.evidenciaError(true,"Error: No se mostro pantalla Tarjeta");
					}
				} else {
					CommonFunction.evidenciaError(true,"Error: No se mostro pantalla Hola o Pantalla Bienvenida");
				}
			}
			
		} catch (Exception e) {
			// Acciones cuando no se encuentra un elemento
			AppDataTest.setStatusEjecucion("FAILED");
			AppDataTest.setComentarioEjecucion(e.getMessage());
		}
		finally{
			//Evidencia
			String filePath = ATC_Evidence3Consultas.evidencia_pdf(EvidenceData.getComentarios(), EvidenceData.getTiempos());
			
			//Ejecutar en JIRA
			//Utils.executeZephyr(AppDataTest.getIdProyectoJira(), AppDataTest.getIdCycle(), 
					//AppDataTest.getStatusEjecucion(), AppDataTest.getComentarioEjecucion(), XlsData.getNombreCaso(), filePath);
			driver.startActivity("rpkandrodev.yaata", "rpkandrodev.yaata.activity.ThreadListActivity");
			YAATA_SMS.eliminarConversaciónSMS();
			driver.quit();
			appiumServer.Stop();
		}
		
		
	}
}
