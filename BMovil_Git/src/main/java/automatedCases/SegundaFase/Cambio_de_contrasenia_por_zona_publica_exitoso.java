package automatedCases.SegundaFase;

import java.util.ArrayList;

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

public class Cambio_de_contrasenia_por_zona_publica_exitoso {
	static AndroidDriver driver = null;
	static ArrayList<String> comentarios = new ArrayList<>();
	static ArrayList<String> tiempos = new ArrayList<>();
	
	public static void Ejecutar() {
		try{
			appiumServer.Stop();
			appiumServer.Start();
			driver = DriverAppium.getDriverAndroid(XlsData.getNombreDispositivo(), XlsData.getVersion());
			new BaseClass(driver);
			
			if(PantallaLogIn.existeTxtContrasenia()){
				PantallaLogIn.ClickLigaOlvidoContrasenia();
				if(IngresarTarjeta.existeTxtTarjeta()){
					IngresarTarjeta.SetTarjeta(XlsData.getNumeroTarjeta());
					try{driver.hideKeyboard();}catch(Exception e){}
					IngresarTarjeta.ClickBtnContinuar();
					if(IngresarCVV.existeTxtNipCambioContrasenia()){
						IngresarCVV.SetNipCambioContrasenia(XlsData.getNIP());
						try{driver.hideKeyboard();}catch(Exception e){}
						IngresarCVV.ClickBtnContinuar();
						if(PantallaConfirmarContrasenia.existeLblTituloPantallaContrasenia()){
							PantallaConfirmarContrasenia.setTxtContrasenia(XlsData.getContraseniaNueva());
							PantallaConfirmarContrasenia.setTxtContrasenia2(XlsData.getContraseniaNueva());
							try{driver.hideKeyboard();}catch(Exception e){}
							PantallaConfirmarContrasenia.clickBtnContinuar();
							if(VentanaSeguridad.existeLblHeaderSeguridad()){
								VentanaSeguridad.clickBtnAceptar();
								if(VentanaActivacionExitosa.existeLblActivacionExitosa1()){
									EvidenceData.capturarPaso(false, "Correcto : Ejecucion completa", driver);
								}else{
									CommonFunction.evidenciaError(true, "No se muestra ventana de confirmacion de cambio de comtraseña");
								}
							}else{
								CommonFunction.evidenciaError(true, "No se muestra ventana de codigo de seguriad");
							}
						}else{
							CommonFunction.evidenciaError(true, "No se muestra ventana para ingresar nueva contraseña");
						}
					}else{
						CommonFunction.evidenciaError(true, "No se muestra entana para infresar NIP");
					}
				}else{
					CommonFunction.evidenciaError(true, "No se muestra la Ventana para ingresar número de tarjeta");
				}
			}else{
				CommonFunction.evidenciaError(true, "No se muestra la Ventana de LogIn");
			}
		}catch(Exception e) {
			// Acciones cuando no se encuentra un elemento
			AppDataTest.setStatusEjecucion("FAILED");
			AppDataTest.setComentarioEjecucion(e.getMessage());
		}
		finally {
			driver.quit();
			appiumServer.Stop();
			
			//Evidencia
			String filePath = ATC_Evidence.evidencia_pdf(EvidenceData.getComentarios(), EvidenceData.getTiempos());
			
		}
	}
}
