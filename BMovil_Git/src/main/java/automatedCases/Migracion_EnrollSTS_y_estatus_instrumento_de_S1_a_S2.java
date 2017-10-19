package automatedCases;

import java.util.ArrayList;

import JSONLogs.LogResultEnrolamiento;
import JSONLogs.LogResultInstrument1;
import JSONLogs.LogResultInstrument2;
import appiumConfiguration.DriverAppium;
import appiumConfiguration.appiumServer;
import configurationData.XlsData;
import evidence.EvidenceData;
import genericCases.CommonFunction;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;

public class Migracion_EnrollSTS_y_estatus_instrumento_de_S1_a_S2 {
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
			CommonFunction.realizarConsultaTestInstrumento1(XlsData.getAmbiente());//*****Primer Consulta
			if (LogResultInstrument1.getTipoInstrumento().equals("S1") && LogResultInstrument1.getEstatusServicio().equals("A1")) {
				if (LogResultEnrolamiento.getEnrollSTS().equals("01")) {
					if(CommonFunction.LogInBBVAMovil()){
						CommonFunction.realizarConsultaInstrumento2(XlsData.getAmbiente());//****Segunda Consulta
						if (LogResultInstrument2.getTipoInstrumento().equals("S2")) {
							
						} else {
							CommonFunction.evidenciaError(false,"Error: El tipo de instrumento no es S2, no se llevo a cabo la migración");
						}
					}else{
						CommonFunction.evidenciaError(true,"Error: No se inicio la sesión en BBVA Movil");
					}
				} else {
					CommonFunction.evidenciaError(true,"Error: La bandera EnrollSTS no tiene el valor 00");
				}
			} else {
				CommonFunction.evidenciaError(true,"Error: El tipo de instrumento y el estatus del servicio no cumplen los requisitos S1-A1");
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			
		}
	}
}
