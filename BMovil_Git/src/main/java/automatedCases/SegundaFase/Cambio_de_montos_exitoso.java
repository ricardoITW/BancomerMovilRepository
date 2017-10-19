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

public class Cambio_de_montos_exitoso {
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
				MenuPrincipal.clickMenuHamburgesa();
				Thread.sleep(1500);
				EvidenceData.capturarPaso(true, "Correcto: Se muestra Menu Hamburguesa", driver);
				MenuHamburguesa.clickLblAdministrar();
				if (MenuHAdministrar.existeLblTituloAdministrar()) {
					MenuHAdministrar.clickBtnConfMontosOp();
					if(PantallaMontosOperacion.existeLblHeaderMontosOper()){
						//PantallaMontosOperacion.SetTxtMontoMaxOperacion(XlsData.getMontoMaxOperacion());
						//PantallaMontosOperacion.SetTxtMontoMaxDiario(XlsData.getMontoMaxDiario());
						//PantallaMontosOperacion.SetTxtMontoMaxMes(XlsData.getMontoMaxMes());
						//try{driver.hideKeyboard();}catch(Exception e){}
						PantallaMontosOperacion.clickBtnContinuar();
						if(PantallaMontosOperacion.existeLblRevisar()){
							PantallaMontosOperacion.SetTxtContrasenia(XlsData.getContraseniaActual());
							try{driver.hideKeyboard();}catch(Exception e){}
							PantallaMontosOperacion.clickBtnConfirmar();
							if(PantallaMontosOperacion.existeLblOpExitosa()){
								PantallaMontosOperacion.clickBtnMenu();
								AppDataTest.setStatusEjecucion("PASSED");
								AppDataTest.setComentarioEjecucion("El cambio de montos de operación fue exitoso");
							} else{
								CommonFunction.evidenciaError(true, "El cambio de montos de operación no fue exitoso");
							}
						}else{
							CommonFunction.evidenciaError(true, "No se muestra ventana para confirmar Montos");
						}
					}else{
						CommonFunction.evidenciaError(true, "No se muestra ventana para ingresar nuevos montos");
					}
				}else{
					CommonFunction.evidenciaError(true, "No se muestra menú Administrar");
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
