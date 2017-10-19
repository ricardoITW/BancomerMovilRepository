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
import windowsLibrary.Enrolamiento.IngresarCVV;
import windowsLibrary.Enrolamiento.IngresarTarjeta;
import windowsLibrary.Enrolamiento.PantallaConfirmarContrasenia;
import windowsLibrary.Enrolamiento.VentanaActivacionExitosa;
import windowsLibrary.Enrolamiento.VentanaSeguridad;

public class Desbloqueo_de_cliente_por_cotraseña_incorrecta {
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
				if (LogResultInstrument1.getEstatusServicio().equals("BI")) {
					EvidenceData.capturarPaso(false, "Correcto: El estatus del servicio es BI", driver);
					PantallaLogIn.setContrasenia(XlsData.getContraseniaActual());
					PantallaLogIn.ClickBtnEntrar();
					if (IngresarTarjeta.existeTxtNumTarjeta()) {
						IngresarTarjeta.SetTarjeta(XlsData.getNumeroTarjeta());
						IngresarTarjeta.ClickBtnContinuar();
						if (IngresarCVV.existeTxtNipCambioContrasenia()) {
							IngresarCVV.SetNipCambioContrasenia(XlsData.getNIP());
							IngresarCVV.ClickBtnContinuar();
							if (PantallaConfirmarContrasenia.existeLblTituloPantallaContrasenia()) {
								PantallaConfirmarContrasenia.setTxtContrasenia(XlsData.getContraseniaNueva());
								PantallaConfirmarContrasenia.setTxtContrasenia2(XlsData.getContraseniaNueva());
								PantallaConfirmarContrasenia.clickBtnContinuar();
								if (VentanaSeguridad.existeLblHeaderSeguridad()) {
									VentanaSeguridad.clickBtnAceptar();
									if (VentanaActivacionExitosa.existeLblActivacionExitosa1()) {
										CommonFunction.realizarConsultaInstrumento2(XlsData.getAmbiente());
										if (LogResultInstrument2.getEstatusServicio().equals("A1")) {
											EvidenceData.capturarPaso(false, "Correcto: El estatus del servicio cambio de BI a AI", driver);
											
											if (PantallaLogIn.existeTxtContrasenia()) {
												AppDataTest.setStatusEjecucion("PASSED");
												AppDataTest.setComentarioEjecucion("El cliente ha sido desbloqueado exitosamente");
											} else {
												CommonFunction.evidenciaError(false, "Error: No se mostró Pantalla Log In");
											}
										} else {
											CommonFunction.evidenciaError(true, "Error: El estatus del servicio no es A1, es "+LogResultInstrument2.getEstatusServicio());
										}
									} else {
										CommonFunction.evidenciaError(true, "Error: No se mostró Pantalla cambio de contraseña exitoso");
									}
								} else {
									CommonFunction.evidenciaError(true, "Error: No se mostró pantalla Seguridad");
								}
							} else {
								CommonFunction.evidenciaError(true, "Error: No se mostró Pantalla Contraseña");
							}
						} else {
							CommonFunction.evidenciaError(true, "Error: No se mostró pantalla NIP");
						}
					} else {
						CommonFunction.evidenciaError(true, "Error: No se mostró pantalla Tarjeta");
					}
				} else {
					CommonFunction.evidenciaError(true, "Error: El estatus del servicio no es Bi, es "+LogResultInstrument1.getEstatusServicio());
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
