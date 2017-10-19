package configurationData;

import configurationData.Utils;

public class AppDataTest {
		
		// Directorio donde se guardan los resultados de las ejecuciones
		private static String raiz = "C:/Users/Administrator/Documents/Bancomer/BBVA_Send/";//"/Users/itworkers/Documents/Bancomer/BBVA_Send/";
		
		// Carpeta donde se guardan las ejecuciones del día
		private static String carpeta = (raiz +"Evidencias/"+ Utils.getActualDay(null)+"/");

		// Nombre del archivo XLS donde se encuentran los datos para las ejecuciones
		private static String xlsName = "dataPool.xls";

		// Direccion donde se encuentra el archivo con los datos de las ejecuciones
		private static String xlsPath = raiz + "Datos/" + xlsName;
		
		// Nombre de la hoja de que contiene los datos para las ejecuciones
		private static String sheetName = "Ejemplo";

		// Directorio donde se guardan los resultados de evidencia de Testlink
		private static String upload_area = "/Applications/XAMPP/xamppfiles/htdocs/testlink/upload_area";
		
		private static String idProyectoJira = "PDA";

		private static String idCycle = "0001495576922484-242ac112-0001";
		
		private static String statusEjecucion = "";
		
		private static String comentarioEjecucion = "";
		

		public static String getRaiz() {
			return raiz;
		}

		public static String getCarpeta() {
			return carpeta;
		}
		
		public static void setCarpeta(String filePath) {
			AppDataTest.carpeta = filePath;
		}

		public static String getXlsPath() {
			return xlsPath;
		}

		public static String getSheetName() {
			return sheetName;
		}
		
		public static String getXlsName() {
			return xlsName;
		}
		
		public static String getUpload_Area(){
			return upload_area;
		}
		
		public static String getIdProyectoJira() {
			return idProyectoJira;
		}
		
		public static String getIdCycle() {
			return idCycle;
		}
		
		public static String getStatusEjecucion() {
			return statusEjecucion;
		}

		public static void setStatusEjecucion(String statusEjecucion) {
			AppDataTest.statusEjecucion = statusEjecucion;
		}
		
		public static String getComentarioEjecucion() {
			return comentarioEjecucion;
		}

		public static void setComentarioEjecucion(String comentarioEjecucion) {
			AppDataTest.comentarioEjecucion = "\""+comentarioEjecucion+"\"";
		}
}
