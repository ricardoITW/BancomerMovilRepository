package automatedCases.SegundaFase;

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
import windowsLibrary.AppBBVAMovil.PantallaLogIn;

public class Bloqueo_de_cliente_por_contrasenia_Incorrecta {
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
			
			if (PantallaLogIn.existeTxtContrasenia()) {
				CommonFunction.realizarConsultaTestInstrumento1(XlsData.getAmbiente());
				if (LogResultInstrument1.getEstatusServicio().equals("A1")) {
					EvidenceData.capturarPaso(false, "Correcto: El estatus del servicio es A1", driver);
					PantallaLogIn.setContrasenia("111111");
					PantallaLogIn.ClickBtnEntrar();
					if(PantallaLogIn.existeLblModalAviso()){
						EvidenceData.capturarPaso(true, "Correcto: Se muestra la modal Datos incorrectos, primera vez", driver);
						PantallaLogIn.clickBtnModalOk();
						
						PantallaLogIn.setContrasenia("111111");
						PantallaLogIn.ClickBtnEntrar();
						if(PantallaLogIn.existeLblModalAviso()){
							EvidenceData.capturarPaso(true, "Correcto: Se muestra la modal Datos incorrectos, segunda vez", driver);
							PantallaLogIn.clickBtnModalOk();
							
							PantallaLogIn.setContrasenia("111111");
							PantallaLogIn.ClickBtnEntrar();
							if (PantallaLogIn.existeLblModalAviso()) {
								EvidenceData.capturarPaso(true, "Correcto: Se muestra modal la contraseña ha sido bloqueada...", driver);
								PantallaLogIn.clickBtnModalOk();
								CommonFunction.realizarConsultaInstrumento2(XlsData.getAmbiente());
								if (LogResultInstrument2.getEstatusServicio().equals("BI")) {
									EvidenceData.capturarPaso(false, "Correcto: El estatus del servicio cambio de A1 a BI", driver);
									AppDataTest.setStatusEjecucion("PASSED");
									AppDataTest.setComentarioEjecucion("El cliente ha sido bloqueado por contraseña incorrecta exitosamente");
								} else {
									CommonFunction.evidenciaError(true, "Error: El estatus del servicio no es BI, es "+LogResultInstrument2.getEstatusServicio());
								}
							} else {
								CommonFunction.evidenciaError(true, "Error: No se mostró modal de contraseña bloqueada");
							}
						} else {
							CommonFunction.evidenciaError(true, "Error: No se mostró modal de datos incorrectos");
						}
					} else {
						CommonFunction.evidenciaError(true, "Error: No se mostró modal de datos incorrectos");
					}
				} else {
					CommonFunction.evidenciaError(true, "Error: El estatus del servicio no es A1, es "+LogResultInstrument1.getEstatusServicio());
				}
			} else {
				CommonFunction.evidenciaError(true, "Error: No se mostró pantalla Log in");
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
