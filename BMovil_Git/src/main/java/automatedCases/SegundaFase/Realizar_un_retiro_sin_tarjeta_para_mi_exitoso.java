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
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuPrincipal;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.MenuHamburguesa;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.Administrar.MenuHAdministrar;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.Administrar.PantallaMontosOperacion;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.RetiroSinTarjeta.MenuRetiroSinTarjeta;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.RetiroSinTarjeta.PantallaTransferenciaExitosa;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.RetiroSinTarjeta.RetiroParaMi;

public class Realizar_un_retiro_sin_tarjeta_para_mi_exitoso {
	static AndroidDriver driver = null;
	static ArrayList<String> comentarios = new ArrayList<>();
	static ArrayList<String> tiempos = new ArrayList<>();
	
	public static void Ejecutar(){
		try{
			appiumServer.Stop();
			appiumServer.Start();
			driver = DriverAppium.getDriverAndroid(XlsData.getNombreDispositivo(), XlsData.getVersion());
			new BaseClass(driver);
			
			if (CommonFunction.LogInBBVAMovil()) {
				MenuPrincipal.clickBtnRetiroSinTarjeta();
				if(MenuRetiroSinTarjeta.existeLblRetiroSinTarj()){
					MenuRetiroSinTarjeta.clickBtnParaMi();
					if(RetiroParaMi.existeLblParaMi()){
						RetiroParaMi.clickBtn100();
						EvidenceData.capturarPaso(true, "Correcto: Se coloca $100 en el campo monto", driver);
						RetiroParaMi.clickBtnAgregarConcepto();
						RetiroParaMi.SetTxtConcepto(XlsData.getConcepto());
						EvidenceData.capturarPaso(true, "Correcto: Se ingresa el concepto", driver);
						RetiroParaMi.clickHeader();//Sustituye Ocultar teclado
						Thread.sleep(1000);
						EvidenceData.capturarPaso(true, "Correcto: Se minimiza el teclado alfanumérico", driver);
						RetiroParaMi.clickBtnContinuar();
						if(RetiroParaMi.existeLblLeyenda()){
							RetiroParaMi.clickBtnConfirmar();
							if (PantallaTransferenciaExitosa.existeLbltFelicidaddes()) {
								Thread.sleep(4000);
								EvidenceData.capturarPaso(true, "Correcto: Se muestra pantalla Clave de Retiro sin tarjeta", driver);
								RetiroParaMi.clickBtnMasDetalle();
								CommonFunction.scrollDown();
								EvidenceData.capturarPaso(true, "Correcto: Se muestran los detalles del retiro sin tarjeta", driver);
								RetiroParaMi.clickLblBtnMenu();
								if (MenuPrincipal.existelblTituloHeader()) {
									AppDataTest.setStatusEjecucion("PASSED");
									AppDataTest.setComentarioEjecucion("El retiro sin tarjeta para mí, fue exitoso");
									//EvidenceData.capturarPaso(false, "Correcto: El retiro sin tarjeta para mí, fue exitoso", driver);
								} else {
									CommonFunction.evidenciaError(true, "No se mostro Menú Principal");
								}
							} else {
								CommonFunction.evidenciaError(true, "No se pudo realizar el retiro");
							}
						}else{
							CommonFunction.evidenciaError(true, "No se muestra ventana de confirmacion");
						}
					}else{
						CommonFunction.evidenciaError(true, "No se muestra ventana para escojer cantidad");
					}
				}else{
					CommonFunction.evidenciaError(true, "No se muestra Menu para retiro sin terjeta");
				}
			}else{
				CommonFunction.evidenciaError(true, "No se logro realizar LogIn");
			}
		}catch(Exception e){
			
		}finally{
			driver.quit();
			appiumServer.Stop();
			
			//Evidencia
			String filePath = ATC_Evidence.evidencia_pdf(EvidenceData.getComentarios(), EvidenceData.getTiempos());
		}
	}
}
