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
import windowsLibrary.AppBBVAMovil.MenuPrincipal.RetiroSinTarjeta.RetiroParaAlguien;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.MenuTransferir;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrasCuentasBBVA.ConfTransferOtrasCtasBBVA;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrasCuentasBBVA.OperaExitosaOtrasCtasBBVA;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrasCuentasBBVA.TransferOtrasCtasBBVA;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrasCuentasBBVA.NvaCuenta.ConfirmarNvaCuenta;
import windowsLibrary.AppBBVAMovil.MenuPrincipal.Transferir.OtrasCuentasBBVA.NvaCuenta.RegistrarNvaCuenta;


public class Transferencia_exitosa_de_TD_CTA_o_CELBancomer {
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
							if (TransferOtrasCtasBBVA.seleccionarContactoFrecuente(XlsData.getNombreFrecuente(), XlsData.getCuentaBeneficiario())) {
								if(TransferOtrasCtasBBVA.existeLblOtrasCtasBBVA()){
									RegistrarNvaCuenta.SetImporte(XlsData.getImporte());
									RegistrarNvaCuenta.clickLblOtrasCtasBBVA();
									RegistrarNvaCuenta.SetMotivo(XlsData.getConcepto());
									RegistrarNvaCuenta.clickLblOtrasCtasBBVA();
									EvidenceData.capturarPaso(true, "Correcto: Se llena el formulario de forma correcta", driver);
									RegistrarNvaCuenta.clickBtnContinuar();
									if(ConfTransferOtrasCtasBBVA.existeLblRevisaYAutoriza()){
										Thread.sleep(2000);
										ConfTransferOtrasCtasBBVA.clickBtnConfirmar();
										if(OperaExitosaOtrasCtasBBVA.existeLblOperacionExitosa()){
											System.out.println("Prueba Completa");
										}
									}else{
										CommonFunction.evidenciaError(true, "No se muestra ventana para confirmar datos de transferencia");
									}
								}else{
									CommonFunction.evidenciaError(true, "No se muestra la ventana para indicar importe");
								}
							}else{
								CommonFunction.evidenciaError(true, "No se puedo seleccionar al frecuente correctamente");
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
