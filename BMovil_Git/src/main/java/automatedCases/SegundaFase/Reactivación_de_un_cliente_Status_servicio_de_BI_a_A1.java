package automatedCases.SegundaFase;

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
import windowsLibrary.AppBBVAMovil.PantallaLogIn;
import windowsLibrary.Enrolamiento.IngresarCVV;
import windowsLibrary.Enrolamiento.IngresarTarjeta;
import windowsLibrary.Enrolamiento.PantallaConfirmarContrasenia;
import windowsLibrary.Enrolamiento.VentanaActivacion;
import windowsLibrary.Enrolamiento.VentanaActivacionExitosa;
import windowsLibrary.Enrolamiento.VentanaBienvenida;
import windowsLibrary.Enrolamiento.VentanaPrincipal;
import windowsLibrary.Enrolamiento.YAATA_SMS;


public class Reactivación_de_un_cliente_Status_servicio_de_BI_a_A1 {
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
			driver.resetApp();
			Thread.sleep(7000);
			EvidenceData.capturarPaso(true, "Correcto: Se abre aplicación BBVA movil", driver);
			if (VentanaPrincipal.existeLblHola()) {
				VentanaPrincipal.ClickBtnEntrar();
				Thread.sleep(2000);
				VentanaBienvenida.SetNumCelular(XlsData.getNumeroCelular());
				try {driver.hideKeyboard();}catch(Exception e){}
				VentanaBienvenida.ClickBtnIngresar();
				if (IngresarTarjeta.existeTxtNumTarjeta()) {
					IngresarTarjeta.SetNumTarjeta(XlsData.getNumeroTarjeta());
					EvidenceData.capturarPaso(true, "Correcto: Se introduce numero de tarjeta", driver);
					CommonFunction.realizarConsultaTestInstrumento1(XlsData.getAmbiente());//******PrimerConsulta
					if (LogResultInstrument1.getEstatusServicio().equals("BI")) {
						EvidenceData.capturarPaso(false, "Correcto: El estatus del servicio es BI", driver);
						IngresarTarjeta.ClickBtnContinuar();
						if (IngresarCVV.existeTxtCVV()) {
							IngresarCVV.SetCVV(XlsData.getCVV());
							IngresarCVV.SetNIP(XlsData.getNIP());
							Thread.sleep(1000);
							try {driver.hideKeyboard();}catch(Exception e){}
							EvidenceData.capturarPaso(true, "Correcto: Se introduce CVV y NIP", driver);
							IngresarCVV.ClickBtnContinuar();
							if (PantallaConfirmarContrasenia.existeLblTituloPantallaContrasenia()) {
								PantallaConfirmarContrasenia.setTxtContrasenia(XlsData.getContraseniaActual());
								PantallaConfirmarContrasenia.setTxtContrasenia2(XlsData.getContraseniaActual());
								try {driver.hideKeyboard();}catch(Exception e){}
								EvidenceData.capturarPaso(true, "Correcto: Se introduce la contraseña y se confirma", driver);
								PantallaConfirmarContrasenia.clickBtnContinuar();
								if (VentanaActivacion.existeTituloActivacion()) {
									CommonFunction.realizarConsultaInstrumento2(XlsData.getAmbiente());//**SegundaConsulta
									if (LogResultInstrument2.getEstatusServicio().equals("PE")) {
										EvidenceData.capturarPaso(false, "Correcto: El estatus del servicio cambió de "+LogResultInstrument1.getEstatusServicio()
										+" a "+LogResultInstrument2.getEstatusServicio(), driver);
										driver.startActivity("rpkandrodev.yaata", "rpkandrodev.yaata.activity.ThreadListActivity");
										if(YAATA_SMS.clickNumeroSMS()){
											Thread.sleep(4000);
											if(VentanaBienvenida.SetNumCelular(XlsData.getNumeroCelular())){
												try {driver.hideKeyboard();}catch(Exception e){}
												EvidenceData.capturarPaso(true, "Correcto: Ingresa un numero Celular", driver);
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
									}else{
										CommonFunction.evidenciaError(true, "El estatus del servicio es diferente de PE en la segunda consulta");
									}
								}else{
									CommonFunction.evidenciaError(true, "No se muestra ventana de acivacion");
								}
							}else{
								CommonFunction.evidenciaError(true, "No se muestra ventana para ingresar nueva contraseña");
							}
						}else{
							CommonFunction.evidenciaError(true, "No se muestra ventana para ingresar CVV y NIP");
						}
					}else{
						CommonFunction.evidenciaError(true, "El estatus de servicio de diferente de BI");
					}
				}else{
					CommonFunction.evidenciaError(true, "No se muestra ventan para ingresar tarjeta");
				}
			}else{
				CommonFunction.evidenciaError(true, "No se muestra ventana de 'HOLA'");
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			driver.quit();
			appiumServer.Stop();
			
			//Evidencia
			String filePath = ATC_Evidence.evidencia_pdf(EvidenceData.getComentarios(), EvidenceData.getTiempos());
		}
	}
}
