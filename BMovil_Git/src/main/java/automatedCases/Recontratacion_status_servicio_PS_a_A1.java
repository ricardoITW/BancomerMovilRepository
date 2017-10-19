package automatedCases;

import java.util.ArrayList;

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
import windowsLibrary.Enrolamiento.PantallaConfirmarContrasenia;
import windowsLibrary.Enrolamiento.PantallaTerminosyCondiciones;
import windowsLibrary.Enrolamiento.VentanaActivacion;
import windowsLibrary.Enrolamiento.VentanaActivacionExitosa;
import windowsLibrary.Enrolamiento.VentanaBienvenida;
import windowsLibrary.Enrolamiento.VentanaFirma;
import windowsLibrary.Enrolamiento.VentanaPrincipal;
import windowsLibrary.Enrolamiento.YAATA_SMS;

public class Recontratacion_status_servicio_PS_a_A1 {
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
			if (CommonFunction.PrepararClientaDeC4toPS()) {
				if (VentanaPrincipal.existeLblHola()) {
					VentanaPrincipal.ClickBtnEntrar();
					Thread.sleep(3000);
					EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla ¡Bienvenido! a BBBVA Bancomer", driver);
					VentanaBienvenida.SetNumCelular(XlsData.getNumeroCelular());
					try {driver.hideKeyboard();}catch(Exception e){}
					//EvidenceData.capturarPaso(true, "Correcto: Se ingresa numero celular", driver);
					VentanaBienvenida.ClickBtnIngresar();
					if (IngresarTarjeta.existeTxtNumTarjeta()) {
						CommonFunction.realizarConsultaTestInstrumento1(XlsData.getAmbiente());//********Consulta 1
						if (LogResultInstrument1.getEstatusServicio().equals("PS")) {
							IngresarTarjeta.SetNumTarjeta(XlsData.getNumeroTarjeta());
							Thread.sleep(1000);
							//EvidenceData.capturarPaso(true, "Correcto: Se ingresa numero de tarjeta", driver);
							IngresarTarjeta.ClickBtnContinuar();
							if (IngresarCVV.existeTxtCVV()) {
								IngresarCVV.SetCVV(XlsData.getCVV());
								IngresarCVV.SetNIP(XlsData.getNIP());
								try {driver.hideKeyboard();}catch(Exception e){}
								//EvidenceData.capturarPaso(true, "Correcto: Se ingresa CVV y NIP", driver);
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
													+LogResultInstrument1.getEstatusServicio()+" a "+LogResultInstrument2.getEstatusServicio());
												}
												else{
													CommonFunction.evidenciaError(false,"Error: El estatus del servicio no cambio a A1, es "+LogResultInstrument2.getEstatusServicio());
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
									CommonFunction.evidenciaError(true,"Error: No se mostro pantalla Activación");
								}
							} else {
								CommonFunction.evidenciaError(true,"Error: No se mostro pantalla CVV y NIP");
							}
						} else {
							CommonFunction.evidenciaError(false,"Error: el estatus del servicio no es PS, es "+LogResultInstrument1.getEstatusServicio());
						}
					} else {
						CommonFunction.evidenciaError(true,"Error: No se mostro pantalla Tarjeta");
					}
				} else {
					CommonFunction.evidenciaError(true,"Error: No se mostro pantalla Hola");
				}
			} else {
				CommonFunction.evidenciaError(false,"Error: No se pudo cambiar el estatus de servicio a PS");
			}
			
			
		}
		catch(Exception e)
		{
			
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
