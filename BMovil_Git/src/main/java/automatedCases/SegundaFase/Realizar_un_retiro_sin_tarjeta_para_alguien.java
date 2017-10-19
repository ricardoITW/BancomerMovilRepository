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
import windowsLibrary.AppBBVAMovil.MenuPrincipal.RetiroSinTarjeta.MenuRetiroSinTarjeta;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.RetiroSinTarjeta.PantallaTransferenciaExitosa;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.RetiroSinTarjeta.RetiroParaAlguien;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.RetiroSinTarjeta.RetiroParaMi;

public class Realizar_un_retiro_sin_tarjeta_para_alguien {
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
					MenuRetiroSinTarjeta.clickBtnParaAlguien();
					if(RetiroParaAlguien.existeLblParaAlguien()){
						RetiroParaAlguien.clickBtnRegistrar();
						if(RetiroParaAlguien.existeLblNombreBene()){
							RetiroParaAlguien.SetTxtNombreBene(XlsData.getBeneficiario());
							RetiroParaAlguien.SetTxtNumDestino(XlsData.getCuentaBeneficiario());
							RetiroParaAlguien.clickBtnContinuar();
							if(RetiroParaAlguien.existeLblCtaOrigen()){
								RetiroParaAlguien.clickBtn100();
								RetiroParaAlguien.clickBtnConcepto();
								RetiroParaAlguien.SetTxtConcepto(XlsData.getConcepto());
								RetiroParaMi.clickHeader(); //Sustituye Ocultar teclado
								RetiroParaAlguien.clickBtnContinuarRetiro();
								if(RetiroParaAlguien.existeLblImagen()){
									RetiroParaAlguien.clickBtnConfirmar();
									if(RetiroParaAlguien.existeLblCuentaRetiro()){
										RetiroParaAlguien.clickBtnConfirmar();
										if (PantallaTransferenciaExitosa.existeLbltFelicidaddes()) {
											Thread.sleep(4000);
											EvidenceData.capturarPaso(true, "Correcto: Se despliega la ventana, clave retiro sin tarjeta", driver);
											RetiroParaAlguien.clickBtnMasDetalle();
											CommonFunction.scrollDown();
											EvidenceData.capturarPaso(true, "Correcto: Se despliega la ventana, validar información", driver);
											RetiroParaAlguien.clickBtnMenu();
											if (MenuPrincipal.existelblTituloHeader()) {
												AppDataTest.setStatusEjecucion("PASSED");
												AppDataTest.setComentarioEjecucion("El retiro sin tarjeta para alguien más, fue exitoso");
												//EvidenceData.capturarPaso(false, "Correcto: El retiro sin tarjeta para mí, fue exitoso", driver);
											} else {
												CommonFunction.evidenciaError(true, "No se mostro Menú Principal");
											}
										} else {
											CommonFunction.evidenciaError(true, "No se muestra pantalla Retiro sin tarjeta para alguien mas exitosa");
										}
										
									}else{
										CommonFunction.evidenciaError(true, "No se muestra ventana para terminar transaccion");
									}
								}else{
									CommonFunction.evidenciaError(true, "No se muestra ventana de confirmacion de registro");
								}
							}else{
								CommonFunction.evidenciaError(true, "No se muestra ventana para elegir monto");
							}
						}else{
							CommonFunction.evidenciaError(true,"No se muestra ventana para registrar nuevo");
						}
					}else{
						CommonFunction.evidenciaError(true, "No se muestra ventana de transferencias frecuentes");
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
