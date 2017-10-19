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
import windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.MenuTransferir;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrasCuentasBBVA.AltaFrecuentes;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrasCuentasBBVA.ConfTransferOtrasCtasBBVA;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrasCuentasBBVA.OperaExitosaOtrasCtasBBVA;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrasCuentasBBVA.TransferOtrasCtasBBVA;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrasCuentasBBVA.NvaCuenta.ConfirmarNvaCuenta;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrasCuentasBBVA.NvaCuenta.RegistrarNvaCuenta;

public class Transferencia_exitosa_de_TD_CTA_o_CELBancomerAlta_frecuente {
	static AndroidDriver driver = null;
	static ArrayList<String> comentarios = new ArrayList<>();
	static ArrayList<String> tiempos = new ArrayList<>();
	
	public static void Ejecutar(){
		try{
			appiumServer.Stop();
			appiumServer.Start();
			driver = DriverAppium.getDriverAndroid(XlsData.getNombreDispositivo(), XlsData.getVersion());
			new BaseClass(driver);
			Thread.sleep(7000);		
			EvidenceData.capturarPaso(true, "Correcto: Se abre aplicación BBVA movil", driver);
			if(CommonFunction.LogInBBVAMovil()){
				if(MenuPrincipal.existelblTituloHeader()){
					
					MenuPrincipal.clickBtnTransferencias();
					if(MenuTransferir.existeLblTransfer()){
						MenuTransferir.ClickBtnOtrasCtasBBVA();
						if(TransferOtrasCtasBBVA.existeLblOtrasCtasBBVA()){
							TransferOtrasCtasBBVA.clickBtnRegistrarCuenta();
							if(RegistrarNvaCuenta.existeLblTipoCta()){
								RegistrarNvaCuenta.clickBtnSeleccionaTipoCta();
								RegistrarNvaCuenta.clickBtnModalNumCuenta();
								RegistrarNvaCuenta.SetNumDestino(XlsData.getCuentaBeneficiario());
								RegistrarNvaCuenta.clickLblOtrasCtasBBVA();
								RegistrarNvaCuenta.SetImporte(XlsData.getImporte());
								RegistrarNvaCuenta.clickLblOtrasCtasBBVA();
								RegistrarNvaCuenta.SetMotivo(XlsData.getConcepto());
								RegistrarNvaCuenta.clickLblOtrasCtasBBVA();
								EvidenceData.capturarPaso(true, "Correcto: Se llena el formulario de forma correcta", driver);
								RegistrarNvaCuenta.clickBtnContinuar();
								if(ConfirmarNvaCuenta.existeLeyendaSeguridad()){
									Thread.sleep(2000);
									ConfirmarNvaCuenta.clickBtnContinuar();
									if(ConfTransferOtrasCtasBBVA.existeLblDatosOperacion()){
										Thread.sleep(2000);
										CommonFunction.scrollDown();
										ConfTransferOtrasCtasBBVA.clickBtnContinuar();
										if(OperaExitosaOtrasCtasBBVA.existeLblOperacionExitosa()){
											OperaExitosaOtrasCtasBBVA.clickBtnAgregarFrecuente();
											if(AltaFrecuentes.existeLblAltaFrecuentes()){
												AltaFrecuentes.setTxtNombreFrecuente(XlsData.getNombreFrecuente());
												AltaFrecuentes.clickLblAltaFrecuentes();
												AltaFrecuentes.ClickBtnConfirmar();
												if(AltaFrecuentes.existeLblAviso()){
													AltaFrecuentes.clickBtnOkAviso();
													if(OperaExitosaOtrasCtasBBVA.existeLblOperacionExitosa()){
														CommonFunction.scrollDown();
														OperaExitosaOtrasCtasBBVA.clickBtnRegresarMenu();
														if(MenuTransferir.existeLblTransfer()){
															System.out.println("Prueba completa");
														}else{
															CommonFunction.evidenciaError(true, "No se muestra dashboard");
														}
													}else{
													CommonFunction.evidenciaError(true, "No se muestra ventana de operación exitosa una vez dado de alta el frecuente");
													}
												}else{
													CommonFunction.evidenciaError(true, "Hubo un error al dar de alta al frecuente");
												}
											}else{
												CommonFunction.evidenciaError(true, "No se muestra ventana para dar de alta un frecuente");
											}
	
										}else{
										CommonFunction.evidenciaError(true, "No se muestra ventana de Operacion Exitosa");	
										}
									}else{
										CommonFunction.evidenciaError(true, "No se muestra ventana para Confirmar transsaccion ");
									}
								}else{
									CommonFunction.evidenciaError(true, "No se muestra ventana de confirmacion de nueva cuenta");
								}
							}else{
								CommonFunction.evidenciaError(true, "No se muestra formulario para nuevo registro de cuenta");
							}
						}else{
							CommonFunction.evidenciaError(true, "No se muestra Ventana de Transferencia a Otras Cuentas BBVA");
						}
					}else{
						CommonFunction.evidenciaError(true, "No se muestra menú de transferencias");
					}
				}else{
					CommonFunction.evidenciaError(true, "No se Muestra el Menú Principal");
				}
			}else{
				CommonFunction.evidenciaError(true, "No se logro realizar Login");
			}
		}catch(Exception e){
			AppDataTest.setStatusEjecucion("FAILED");
			AppDataTest.setComentarioEjecucion(e.getMessage());
		}finally{
			driver.quit();
			appiumServer.Stop();

			//Evidencia
			String filePath = ATC_Evidence.evidencia_pdf(EvidenceData.getComentarios(), EvidenceData.getTiempos());
		}
	}
}

