package automatedCases;

import java.util.ArrayList;

import JSONLogs.JsonConstructor;
import JSONLogs.LogResultEnrolamiento;
import JSONLogs.LogResultInstrument1;
import JSONLogs.LogResultInstrument2;
import JSONLogs.LogResultInstrument3;
import appiumConfiguration.DriverAppium;
import appiumConfiguration.appiumServer;
import configurationData.AppDataTest;
import configurationData.XlsData;
import evidence.ATC_Evidence;
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

public class Contratacion_PA_a_A1 {
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
			Thread.sleep(7000);		
			EvidenceData.capturarPaso(true, "Correcto: Se abre aplicación BBVA movil", driver);
			if(VentanaPrincipal.existeLblHola()){
				VentanaPrincipal.ClickBtnEntrar();
				Thread.sleep(2000);
				EvidenceData.capturarPaso(true, "Correcto: Se muestra Pantalla de Bienvenida", driver);
				if(VentanaBienvenida.SetNumCelular(XlsData.getNumeroCelular())){
					try {driver.hideKeyboard();}catch(Exception e){}
					//EvidenceData.capturarPaso(true, "Correcto: Ingresa un numero Celular", driver);
					if(VentanaBienvenida.ClickBtnIngresar()){
						if(IngresarTarjeta.existeTxtNumTarjeta()){
							Thread.sleep(1000);
							////////////*********************************
							if(IngresarTarjeta.SetNumTarjeta(XlsData.getNumeroTarjeta())){
								//EvidenceData.capturarPaso(true, "Correcto: Se ingresa Numero de Tarjeta", driver);
								IngresarTarjeta.ClickBtnContinuar();
								if(IngresarCVV.existeTxtCVV()){
									Thread.sleep(1000);
									IngresarCVV.SetCVV(XlsData.getCVV());
									IngresarCVV.SetNIP(XlsData.getNIP());
									//EvidenceData.capturarPaso(true, "Correcto: Se introducen campos CVV y NIP", driver);
									IngresarCVV.ClickBtnContinuar();
									if(VentanaActivacion.existeTituloActivacion()){
										CommonFunction.realizarConsultaTestInstrumento1(XlsData.getAmbiente());//******PrimerConsulta
										if (LogResultInstrument1.getEstatusServicio().equals("PA")) {
											EvidenceData.capturarPaso(false, "Correcto: El estatus del servicio es PA", driver);
											driver.startActivity("rpkandrodev.yaata", "rpkandrodev.yaata.activity.ThreadListActivity");
											if(YAATA_SMS.clickNumeroSMS()){
												Thread.sleep(4000);
												if(VentanaBienvenida.SetNumCelular(XlsData.getNumeroCelular())){
													try {driver.hideKeyboard();}catch(Exception e){}
													//EvidenceData.capturarPaso(true, "Correcto: Ingresa un numero Celular", driver);
													VentanaBienvenida.ClickBtnIngresar();
													if(VentanaActivacionExitosa.existeImgPalomita()){
														CommonFunction.realizarConsultaInstrumento2(XlsData.getAmbiente());//**SegundaConsulta
													
														if (LogResultInstrument2.getEstatusServicio().equals("A1")) {
															EvidenceData.capturarPaso(false, "Correcto: El estatus del servicio cambió de "+LogResultInstrument1.getEstatusServicio()
															+" a "+LogResultInstrument2.getEstatusServicio(), driver);
														}
													}else{
														CommonFunction.evidenciaError(false, "Error: No se presento pantalla de activacion exitosa");
													}
												}else{
												
													CommonFunction.evidenciaError(false, "Error: No se ingreso el numero celular");
												}
											}
											else{
												CommonFunction.evidenciaError(false, "Error: El SMS con liga de activación no fue recibido");
											}
										}else{
											CommonFunction.evidenciaError(false, "No se logro realizar la primera consulta");
									}
								}else{
										CommonFunction.evidenciaError(false, "Error: No se mostro Ventana de Activación");
									}
								}
								else{
									CommonFunction.evidenciaError(false, "Error: No se mostro pantalla CVV y NIP");
								}
							}
							else{
								CommonFunction.evidenciaError(false, "Error: No se ingreso el numero de tarjeta");
							}
						}
						else{
							CommonFunction.evidenciaError(false, "Error: No se mostro pantalla Tarjeta");
						}
					}
					else{
						CommonFunction.evidenciaError(false, "Error: No se encontro Botón Ingresar de Pantalla Bienvenida");
					}
				}
				else{
					CommonFunction.evidenciaError(false, "Error: No se ingreso el numero celular");
				}
			}
			else{
				CommonFunction.evidenciaError(false, "Error: No se encuentra Botón Entrar de Pantalla Hola");
			}
			
		} catch (Exception e) {
			// Acciones cuando no se encuentra un elemento
			AppDataTest.setStatusEjecucion("FAILED");
			AppDataTest.setComentarioEjecucion(e.getMessage());
		}
		finally{
			//Evidencia
			String filePath = ATC_Evidence.evidencia_pdf(EvidenceData.getComentarios(), EvidenceData.getTiempos());
			
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
