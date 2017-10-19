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

public class Realizar_un_retiro_sin_tarjeta_para_alguien_alta_frecuente {
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
			if (CommonFunction.LogInBBVAMovil()) {
				MenuPrincipal.clickBtnRetiroSinTarjeta();
				if (MenuRetiroSinTarjeta.existeLblRetiroSinTarj()) {
					MenuRetiroSinTarjeta.clickBtnParaAlguien();
					if (RetiroParaAlguien.existeLblParaAlguien()) {
						if (RetiroParaAlguien.seleccionarContactoFrecuente(XlsData.getBeneficiario(), XlsData.getCuentaBeneficiario())) {
							if (RetiroParaAlguien.existeLblCtaOrigen()) {
								RetiroParaAlguien.clickBtn100();
								EvidenceData.capturarPaso(true, "Correcto: Se ingresa el monto", driver);
								RetiroParaAlguien.clickBtnConcepto();
								RetiroParaAlguien.SetTxtConcepto(XlsData.getConcepto());
								EvidenceData.capturarPaso(true, "Correcto: Se visualiza el concepto", driver);
								RetiroParaMi.clickHeader(); //Sustituye Ocultar teclado
								CommonFunction.scrollDown();
								RetiroParaAlguien.clickBtnContinuarRetiro();
								if (RetiroParaAlguien.existeLblCuentaRetiro()) {
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
										CommonFunction.evidenciaError(true, "No se mostro pantalla Felicidades de retiro sin tarjeta exitoso");
									}
								} else {
									CommonFunction.evidenciaError(true, "No se mostro pantalla confirmar cuenta retiro y beneficiario");
								}
							} else {
								CommonFunction.evidenciaError(true, "No se mostro pantalla para definir cuenta retiro, monto y concepto");
							}
						} else {
							CommonFunction.evidenciaError(true, "No se encontro en la lista al beneficiario "+XlsData.getBeneficiario()+" con numero celular "+XlsData.getCuentaBeneficiario());
						}
					} else {
						CommonFunction.evidenciaError(true, "No se mostro pantalla Para alguien más");
					}
				} else {
					CommonFunction.evidenciaError(true, "No se mostro pantalla Retiro sin Tarjeta");
				}
			} else {
				CommonFunction.evidenciaError(true, "No se pudo realizar Log in en la app");
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
