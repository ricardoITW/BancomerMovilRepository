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
import windowsLibrary.AppBBVAMovil.PantallaLogIn;
import windowsLibrary.AppBBVAMovil.TokenMovil.TokenMovil;

public class Generar_codigo_de_seguridad_30_segundos {
	static AndroidDriver driver = null;
	static ArrayList<String> comentarios = new ArrayList<>();
	static ArrayList<String> tiempos = new ArrayList<>();
	public static void Ejecutar() {
		try 
		{
			appiumServer.Stop();
			appiumServer.Start();
			driver = DriverAppium.getDriverAndroid(XlsData.getNombreDispositivo(), XlsData.getVersion());
			new BaseClass(driver);
			
			if(PantallaLogIn.existeTxtContrasenia()) {
				PantallaLogIn.ClickTokenMovil();
				if(TokenMovil.existeLblTituloTokenMovil()) {
					TokenMovil.clickBtnGenerarCodigo();
					if(TokenMovil.existeLblCodigoSegurida()) {
						String OPT1, OPT2 = "";
						OPT1 = TokenMovil.getTextOPT();
						//EvidenceData.capturarPaso(false, "Correcto: Se genera primer código de seguridad "+OPT1, driver);
						TokenMovil.clickBtnAtras();
						if(TokenMovil.existeLblTituloTokenMovil()) {
							//Espera de 30 segundos
							TokenMovil.espera30Segundos();
							TokenMovil.clickBtnGenerarCodigo();
							if(TokenMovil.existeLblCodigoSegurida()) {
								OPT2 = TokenMovil.getTextOPT();
								//EvidenceData.capturarPaso(false, "Correcto: Se genera segundo código de seguridad "+OPT2, driver);
								if(!OPT1.equals(OPT2)) {
									TokenMovil.clickBtnAtras();
									if (TokenMovil.existeLblTituloTokenMovil()) {
										TokenMovil.clickBtnAtras();
										if (PantallaLogIn.existeTxtContrasenia()) {
											AppDataTest.setStatusEjecucion("PASSED");
											AppDataTest.setComentarioEjecucion("Se ha generado un nuevo código de seguridad, De "+OPT1+" a "+OPT2);
											EvidenceData.capturarPaso(false, "Correcto: Se ha generado un nuevo código de seguridad, De "+OPT1+" a "+OPT2, driver);
										} else {
											CommonFunction.evidenciaError(true,"No se mostro pantalla de Login");
										}
									} else {
										CommonFunction.evidenciaError(true,"No se mostro pantalla Token Movil");
									}
								}
								else {
									CommonFunction.evidenciaError(true,"No se ha generado un nuevo código de seguridad");
								}
							}
							else {
								CommonFunction.evidenciaError(true,"No se mostro pantalla Código de Seguridad");
							}
						}else {
							CommonFunction.evidenciaError(true,"No se mostro pantalla Token Movil");
						}
					}
					else {
						CommonFunction.evidenciaError(true,"No se mostro pantalla Código de Seguridad");
					}
				}
				else {
					CommonFunction.evidenciaError(true,"No se mostro pantalla Token Movil");
				}
			}
			else {
				CommonFunction.evidenciaError(true,"No se mostro pantalla Log In");
			}
			
			
			driver.quit();
			appiumServer.Stop();
		}
		catch(Exception e) {
			// Acciones cuando no se encuentra un elemento
			AppDataTest.setStatusEjecucion("FAILED");
			AppDataTest.setComentarioEjecucion(e.getMessage());
		}
		finally {
			//Evidencia
			String filePath = ATC_Evidence.evidencia_pdf(EvidenceData.getComentarios(), EvidenceData.getTiempos());
			
			//Ejecutar en JIRA
			//Utils.executeZephyr(AppDataTest.getIdProyectoJira(), AppDataTest.getIdCycle(), 
				//	AppDataTest.getStatusEjecucion(), AppDataTest.getComentarioEjecucion(), XlsData.getNombreCaso(), filePath);
		}

	}

}