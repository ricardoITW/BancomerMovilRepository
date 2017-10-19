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
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuPrincipal;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.AdmonAlertas;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.MenuHamburguesa;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.Administrar.MenuHAdministrar;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.MenuHamburguesa.Administrar.PantallaMontosOperacion;

public class AdministrarAlertas {
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
				MenuHamburguesa.clickLblAdministrarAlertas();
				if(AdmonAlertas.existeLblNombreCuenta()){
					String cuentatratada = CommonFunction.TratamientoString("00740010141534797833");
					CommonFunction.cambiarAlertas(cuentatratada, "50", "1000", "aliasn");
					/*AdmonAlertas.clickBtnEditar();
					AdmonAlertas.SetTxtDeposito(XlsData.getAlertaDeposito());
					try{driver.hideKeyboard();}catch(Exception e){}
					AdmonAlertas.SetTxtCargo(XlsData.getAlertaCargo());
					try{driver.hideKeyboard();}catch(Exception e){}
					AdmonAlertas.clickBtnGuardar();
					if(AdmonAlertas.existeLblModalContrasenia()){
						AdmonAlertas.SetTxtContrasenia(XlsData.getContraseniaActual());
						AdmonAlertas.clickBtnConfirmar();
						if(AdmonAlertas.existeLblNombreCuenta()){
							EvidenceData.capturarPaso(false, "Correcto : Prueba finalizada", driver);
						}else{
							CommonFunction.evidenciaError(true, "No se pudo actulizar montos");
						}
					}else{
						CommonFunction.evidenciaError(true, "No se mostro modal para confirmar");
					}*/
				}else{
					CommonFunction.evidenciaError(true, "No se muestra ventana de administrar alertas");
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
