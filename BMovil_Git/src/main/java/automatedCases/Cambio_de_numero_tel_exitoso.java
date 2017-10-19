package automatedCases;

import java.util.ArrayList;

import appiumConfiguration.DriverAppium;
import appiumConfiguration.appiumServer;
import configurationData.XlsData;
import evidence.ATC_Evidence;
import evidence.EvidenceData;
import genericCases.CommonFunction;
import io.appium.java_client.android.AndroidDriver;
import windowsLibrary.BaseClass;
import windowsLibrary.Enrolamiento.IngresarCVV;
import windowsLibrary.Enrolamiento.IngresarTarjeta;
import windowsLibrary.Enrolamiento.VentanaActivacion;
import windowsLibrary.Enrolamiento.VentanaBienvenida;
import windowsLibrary.Enrolamiento.VentanaPrincipal;
import windowsLibrary.Enrolamiento.YAATA_SMS;

public class Cambio_de_numero_tel_exitoso {
	static AndroidDriver driver = null;
	static ArrayList<String> comentarios = new ArrayList<>();
	static ArrayList<String> tiempos = new ArrayList<>();
	
	public static void Ejecutar() {
		appiumServer.Stop();
		appiumServer.Start();
		driver = DriverAppium.getDriverAndroid(XlsData.getNombreDispositivo(), XlsData.getVersion());
		new BaseClass(driver);
		try{
			if(VentanaPrincipal.existeLblHola()){
				VentanaPrincipal.ClickBtnEntrar();
				Thread.sleep(1500);
				EvidenceData.capturarPaso(true, "Correcto: Se muestra ventana ¡Bienvenido! a BBVA Bancomer", driver);
				VentanaBienvenida.SetNumCelular(XlsData.getNumeroCelular());
				try {driver.hideKeyboard();}catch(Exception e){}
				//EvidenceData.capturarPaso(true, "Correcto: Se ingresa correctamente el número de teléfono ", driver);
				VentanaBienvenida.ClickBtnIngresar();
				if(IngresarTarjeta.existeTxtNumTarjeta()){
					IngresarTarjeta.SetNumTarjeta(XlsData.getNumeroTarjeta());
					Thread.sleep(1500);
					//EvidenceData.capturarPaso(true, "Correcto: Se ingresa correctamente el número de tarjeta ", driver);
					IngresarTarjeta.ClickBtnContinuar();
					if(IngresarCVV.existeTxtCVV()){
						IngresarCVV.SetCVV(XlsData.getCVV());
						IngresarCVV.SetNIP(XlsData.getNIP());
						Thread.sleep(1500);
						//EvidenceData.capturarPaso(true, "Correcto: Se ingresan correctamente CVV y NIP ", driver);
						IngresarCVV.ClickBtnContinuar();
						if(VentanaActivacion.existeLblMensajeEnvioSMS()){
							if(VentanaActivacion.existeUrlNoRecibiMensaje()){
								VentanaActivacion.clickUrlNoRecibiMensaje();
								if(VentanaActivacion.existeLblModalAviso()){
									VentanaActivacion.clickBtnModalSi();
									if(VentanaActivacion.existeLblModal()){
										VentanaActivacion.clickBtnOkModal();
									}
								}else{
									CommonFunction.evidenciaError(true,"No se mostro modal de Aviso");
								}
							}else{
								CommonFunction.evidenciaError(true,"No se mostro link de reenvio");
							}
						}else{
							CommonFunction.evidenciaError(true,"No se mostro ventana de activación");
						}
					}else{
						CommonFunction.evidenciaError(true,"No se mostro ventana para ingresar CVV y NIP");
					}
				}else{
					CommonFunction.evidenciaError(true,"No se mostro ventana para ingresar número de tarjeta");
				}
			}else{
				CommonFunction.evidenciaError(true,"No se mostro ventana Hola");
			}
		}catch(Exception e){
			
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