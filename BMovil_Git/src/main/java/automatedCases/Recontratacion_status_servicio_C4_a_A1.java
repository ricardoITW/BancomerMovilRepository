package automatedCases;

import java.util.ArrayList;

import JSONLogs.LogResultInstrument1;
import JSONLogs.LogResultInstrument2;
import JSONLogs.LogResultInstrument3;
import appiumConfiguration.DriverAppium;
import appiumConfiguration.appiumServer;
import configurationData.AppDataTest;
import configurationData.Utils;
import configurationData.XlsData;
import evidence.ATC_Evidence;
import evidence.ATC_Evidence3Consultas;
import evidence.EvidenceData;
import genericCases.CommonFunction;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;
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

public class Recontratacion_status_servicio_C4_a_A1 {
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
			
			EvidenceData.capturarPaso(true, "Correcto: Se abre aplicación BBVA movil", driver);
			//if(CommonFunction.PrepararClientaDeA1toC4()){
				if (VentanaPrincipal.existeLblHola()) {
					VentanaPrincipal.ClickBtnEntrar();
					Thread.sleep(2000);
					VentanaBienvenida.SetNumCelular(XlsData.getNumeroCelular());
					try {driver.hideKeyboard();}catch(Exception e){}
					//EvidenceData.capturarPaso(true, "Correcto: Se introduce numero celular", driver);
					VentanaBienvenida.ClickBtnIngresar();
					if (IngresarTarjeta.existeTxtNumTarjeta()) {
						IngresarTarjeta.SetNumTarjeta(XlsData.getNumeroTarjeta());
						//EvidenceData.capturarPaso(true, "Correcto: Se introduce numero de tarjeta", driver);
						CommonFunction.realizarConsultaTestInstrumento1(XlsData.getAmbiente());//******PrimerConsulta
						if (LogResultInstrument1.getEstatusServicio().equals("C4")) {
							EvidenceData.capturarPaso(false, "Correcto: El estatus del servicio es C4", driver);
							IngresarTarjeta.ClickBtnContinuar();
							if (IngresarCVV.existeTxtCVV()) {
								IngresarCVV.SetCVV(XlsData.getCVV());
								IngresarCVV.SetNIP(XlsData.getNIP());
								Thread.sleep(1000);
								try {driver.hideKeyboard();}catch(Exception e){}
								//EvidenceData.capturarPaso(true, "Correcto: Se introduce CVV y NIP", driver);
								IngresarCVV.ClickBtnContinuar();
								if (PantallaConfirmarContrasenia.existeLblTituloPantallaContrasenia()) {
									PantallaConfirmarContrasenia.setTxtContrasenia(XlsData.getContraseniaActual());
									PantallaConfirmarContrasenia.setTxtContrasenia2(XlsData.getContraseniaActual());
									try {driver.hideKeyboard();}catch(Exception e){}
									//EvidenceData.capturarPaso(true, "Correcto: Se introduce la contraseña y se confirma", driver);
									PantallaConfirmarContrasenia.clickBtnContinuar();
									if (PantallaTerminosyCondiciones.existeLblTituloTerminosyCondiciones()) {
										PantallaTerminosyCondiciones.clickSwithSiNo();
										//EvidenceData.capturarPaso(true, "Correcto: Se aceptan terminos y condiciones", driver);
										PantallaTerminosyCondiciones.clickLayoutFirma();
										if (VentanaFirma.ExisteAreaParaFirma()) {
											CommonFunction.scrollDown();
											//EvidenceData.capturarPaso(true, "Correcto: Se introduce firma", driver);
											VentanaFirma.clickBtnAceptarFirma();
											if (PantallaTerminosyCondiciones.existeLblTituloTerminosyCondiciones()) {
												PantallaTerminosyCondiciones.clickBtnContratar();
												if (VentanaActivacionExitosa.existeImgPalomita()) {
													CommonFunction.realizarConsultaInstrumento2(XlsData.getAmbiente());//**SegundaConsulta
													
													if (LogResultInstrument2.getEstatusServicio().equals("PS")) {
														EvidenceData.capturarPaso(false, "Correcto: El estatus del servicio cambió de "+LogResultInstrument1.getEstatusServicio()
														+" a "+LogResultInstrument2.getEstatusServicio(), driver);
														
														if (VentanaActivacion.existeTituloActivacion()) {
															driver.startActivity("rpkandrodev.yaata", "rpkandrodev.yaata.activity.ThreadListActivity");
															if(YAATA_SMS.clickNumeroSMS()){
																Thread.sleep(4000);
																if(VentanaBienvenida.SetNumCelular(XlsData.getNumeroCelular())){
																	try {driver.hideKeyboard();}catch(Exception e){}
																	//EvidenceData.capturarPaso(true, "Correcto: Ingresa un numero Celular", driver);
																	VentanaBienvenida.ClickBtnIngresar();
																	if(VentanaActivacionExitosa.existeLblActivacionExitosa1()){
																		CommonFunction.realizarConsultaTestInstrumento3(XlsData.getAmbiente());//****Tercer consulta
																		
																		if(LogResultInstrument3.getEstatusServicio().equals("A1")){
																			EvidenceData.capturarPaso(false, "Correcto: El estatus del servicio cambió de "+LogResultInstrument1.getEstatusServicio()
																			+" a "+LogResultInstrument3.getEstatusServicio(), driver);
																			
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
															CommonFunction.evidenciaError(true,"No se mostro pantalla de Activación");
														}
													} else {
														CommonFunction.evidenciaError(true,"Error: El estatus de servicio no es PS, es "+LogResultInstrument2.getEstatusServicio());
													}
												} else {
													CommonFunction.evidenciaError(true,"No se mostro pantalla de confirmación de contratación");
												}
											} else {
												CommonFunction.evidenciaError(true,"No se mostro pantalla Terminos y condiciones");
											}
										} else {
											CommonFunction.evidenciaError(true,"No se mostro pantalla para firmar");
										}
									} else {
										CommonFunction.evidenciaError(true,"No se mostro pantalla Terminos y Condiciones");
									}
								} else {
									CommonFunction.evidenciaError(true,"No se mostro pantalla Contraseña");
								}
							} else {
								CommonFunction.evidenciaError(true,"No se mostro pantalla CVV y NIP");
							}
						} else {
							CommonFunction.evidenciaError(false,"El estatus del servicio no es C4, es "+LogResultInstrument1.getEstatusServicio());
						}
						
					} else {
						CommonFunction.evidenciaError(true,"No se mostro pantalla Tarjeta");
					}
				} else {
					CommonFunction.evidenciaError(true,"No se mostro pantalla Hola");
				}
			//}
			//else{
				//CommonFunction.evidenciaError(true,"No se cancelo al cliente");
			//}	
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			
			//Evidencia
			String filePath = ATC_Evidence3Consultas.evidencia_pdf(EvidenceData.getComentarios(), EvidenceData.getTiempos());
			
			//Ejecutar en JIRA
			Utils.executeZephyr(AppDataTest.getIdProyectoJira(), AppDataTest.getIdCycle(), 
				AppDataTest.getStatusEjecucion(), AppDataTest.getComentarioEjecucion(), XlsData.getNombreCaso(), filePath);
			
			driver.startActivity("rpkandrodev.yaata", "rpkandrodev.yaata.activity.ThreadListActivity");
			YAATA_SMS.eliminarConversaciónSMS();
			
			driver.quit();
			appiumServer.Stop();
		}
	}
}
