package atcMainMenu;

import java.io.IOException;

import automatedCases.AdministrarAlertas;
import automatedCases.Cancelacion_status_servicio_A1_a_C4;
import automatedCases.Recontratacion_status_servicio_C4_a_A1;
import automatedCases.Recontratacion_status_servicio_PS_a_A1;
import automatedCases.Recontratacion_status_servicio_PE_a_A1;
import automatedCases.Recontratacion_status_servicio_S4_a_A1;
import automatedCases.Generar_codigo_de_seguridad_30_segundos;
import automatedCases.Migracion_EnrollSTS_y_estatus_instrumento_de_S1_a_S2;
import automatedCases.Recontratacion_status_servicio_A1_a_A1;
import automatedCases.Suspension_status_servicio_A1_a_S4;
import automatedCases.SegundaFase.Bloqueo_de_cliente_por_contrasenia_Incorrecta;
import automatedCases.SegundaFase.Cambio_de_contrasenia_por_zona_privada_exitoso;
import automatedCases.SegundaFase.Cambio_de_contrasenia_por_zona_publica_exitoso;
import automatedCases.SegundaFase.Cambio_de_correo_exitosamente;
import automatedCases.SegundaFase.Cambio_de_montos_exitoso;
import automatedCases.SegundaFase.Desbloqueo_de_cliente_por_cotraseña_incorrecta;
import automatedCases.SegundaFase.Reactivación_de_un_cliente_Status_servicio_de_BI_a_A1;
import automatedCases.SegundaFase.Realizar_un_retiro_sin_tarjeta_para_alguien;
import automatedCases.SegundaFase.Realizar_un_retiro_sin_tarjeta_para_alguien_alta_frecuente;
import automatedCases.SegundaFase.Realizar_un_retiro_sin_tarjeta_para_mi_exitoso;
import automatedCases.SegundaFase.Transferencia_exitosa_de_TD_CTA_o_CELBancomer;
import automatedCases.SegundaFase.Transferencia_exitosa_de_TD_CTA_o_CELBancomerAlta_frecuente;
import configurationData.AppDataTest;
import configurationData.ReadExcel;
import configurationData.Utils;
import configurationData.XlsData;
import evidence.ATC_Evidence;
import evidence.EvidenceData;


public class ExecuterTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		// Cuenta el número de pruebas a realizar
		int numeroPruebas = ReadExcel.contarNumeroPruebas(AppDataTest.getXlsPath(), AppDataTest.getSheetName());
		// Indica el indice de lectura de la fila en el excel
		int contador = 1;
		Utils.crearCarpeta();
		ATC_Evidence.eliminarImagenes();
		Thread.sleep(2000);
		System.out.println("El número de pruebas es: " + numeroPruebas);
		do 
		{
			try 
			{
				ReadExcel.getDataPoolPrueba(AppDataTest.getXlsPath(), AppDataTest.getSheetName(),  contador);
				System.out.println("Iniciando prueba numero: " + contador +" Nombre: "+XlsData.getNombreTestCase());
				
				if (XlsData.getTestCaseDivided().equals("Recontratacion_status_servicio_S4_a_A1")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Recontratacion_status_servicio_S4_a_A1.Ejecutar();
				} 
				else if(XlsData.getTestCaseDivided().equals("Recontratacion_status_servicio_PE_a_A1")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Recontratacion_status_servicio_PE_a_A1.Ejecutar();
				} 
				else if(XlsData.getTestCaseDivided().equals("Generar_codigo_de_seguridad_30_segundos")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Generar_codigo_de_seguridad_30_segundos.Ejecutar();
				} 
				else if(XlsData.getTestCaseDivided().equals("Suspension_status_servicio_A1_a_S4")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Suspension_status_servicio_A1_a_S4.Ejecutar();
				} 
				else if(XlsData.getTestCaseDivided().equals("Cambio_de_correo_exitosamente")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Cambio_de_correo_exitosamente.Ejecutar();
				} 
				else if(XlsData.getTestCaseDivided().equals("Cambio_de_contrasenia_por_zona_privada_exitoso")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Cambio_de_contrasenia_por_zona_privada_exitoso.Ejecutar();
				} 
				else if(XlsData.getTestCaseDivided().equals("Cancelacion_status_servicio_A1_a_C4")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Cancelacion_status_servicio_A1_a_C4.Ejecutar();
				} 
				else if(XlsData.getTestCaseDivided().equals("Recontratacion_status_servicio_C4_a_A1")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Recontratacion_status_servicio_C4_a_A1.Ejecutar();
				}
				else if(XlsData.getTestCaseDivided().equals("Recontratacion_status_servicio_PS_a_A1")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Recontratacion_status_servicio_PS_a_A1.Ejecutar();
				}
				else if(XlsData.getTestCaseDivided().equals("Migracion_EnrollSTS_y_estatus_instrumento_de_S1_a_S2")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Migracion_EnrollSTS_y_estatus_instrumento_de_S1_a_S2.Ejecutar();
				}
				else if(XlsData.getTestCaseDivided().equals("Cambio_de_contrasenia_por_zona_publica_exitoso")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Cambio_de_contrasenia_por_zona_publica_exitoso.Ejecutar();
				}
				else if(XlsData.getTestCaseDivided().equals("Cambio_de_montos_exitoso")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Cambio_de_montos_exitoso.Ejecutar();
				}
				else if(XlsData.getTestCaseDivided().equals("AdministrarAlertas")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					AdministrarAlertas.Ejecutar();
				}
				else if(XlsData.getTestCaseDivided().equals("Realizar_un_retiro_sin_tarjeta_para_mi_exitoso")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Realizar_un_retiro_sin_tarjeta_para_mi_exitoso.Ejecutar();
				}
				else if(XlsData.getTestCaseDivided().equals("Realizar_un_retiro_sin_tarjeta_para_alguien")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Realizar_un_retiro_sin_tarjeta_para_alguien.Ejecutar();
				}
				else if(XlsData.getTestCaseDivided().equals("Realizar_un_retiro_sin_tarjeta_para_alguien_alta_frecuente")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Realizar_un_retiro_sin_tarjeta_para_alguien_alta_frecuente.Ejecutar();
				}
				else if(XlsData.getTestCaseDivided().equals("Bloqueo_de_cliente_por_contrasenia_Incorrecta")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Bloqueo_de_cliente_por_contrasenia_Incorrecta.Ejecutar();
				}
				else if(XlsData.getTestCaseDivided().equals("Desbloqueo_de_cliente_por_cotraseña_incorrecta")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Desbloqueo_de_cliente_por_cotraseña_incorrecta.Ejecutar();
				}
				else if(XlsData.getTestCaseDivided().equals("Recontratacion_status_servicio_A1_a_A1")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Recontratacion_status_servicio_A1_a_A1.Ejecutar();
				}
				else if(XlsData.getTestCaseDivided().equals("Transferencia_exitosa_de_TD_CTA_o_CELBancomerAlta_frecuente")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Transferencia_exitosa_de_TD_CTA_o_CELBancomerAlta_frecuente.Ejecutar();
				}
				else if(XlsData.getTestCaseDivided().equals("Transferencia_exitosa_de_TD_CTA_o_CELBancomer")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Transferencia_exitosa_de_TD_CTA_o_CELBancomer.Ejecutar();
				}
				else if(XlsData.getTestCaseDivided().equals("Reactivación_de_un_cliente_Status_servicio_de_BI_a_A1")) 
				{
					XlsData.iniciarTiempo();
					EvidenceData.getComentarios().clear();
					EvidenceData.getTiempos().clear();
					
					Reactivación_de_un_cliente_Status_servicio_de_BI_a_A1.Ejecutar();
				}
				else 
				{
					System.out.println("La prueba indicada no existe");
				}

			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			contador++;
		} while (contador <= numeroPruebas);
	}
}
