package configurationData;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.github.genium_framework.appium.support.command.CommandManager;

import configurationData.AppDataTest;
import configurationData.Utils;
import configurationData.XlsData;

public class Utils {
	static String totalTimeElement;
	static Date date = new Date();
	static File captura;
	static WebDriver elementosInterfaz = null;
	static WebDriver winiumDriver;
	static DesiredCapabilities caps = new DesiredCapabilities();

	public static String getDateHours(String date) {//Usada para guardar documentos, dejar los puntos ya que un archivo no puede tener nombre con /
		String hora, min, sec, milisec;
		Calendar cal1 = Calendar.getInstance();
		hora = Integer.toString(cal1.get(Calendar.HOUR_OF_DAY));
		min = Integer.toString(cal1.get(Calendar.MINUTE));
		sec = Integer.toString(cal1.get(Calendar.SECOND));
		milisec = Integer.toString(cal1.get(Calendar.MILLISECOND));
		if (cal1.get(Calendar.SECOND) < 9) {
			date = hora + "." + min + "." + "0" + sec + "." + milisec;
		} else {
			date = hora + "." + min + "." + sec + "." + milisec;
		}
		return (date);
	}

	/**
	 * Obtiene la hora actual
	 */
	public static String getHours(String date) {
		return new SimpleDateFormat("h:mm:ss a").format(new Date());
	}
	
	/**
	 * Obtiene la fecha actual
	 */
	public static String getActualDay(String date) {
		return new SimpleDateFormat("dd_MM_yyyy").format(new Date());
	}

	/**
	 * Obtiene la fecha para enviarla en el mail
	 */
	public static String getFechaCorreo(String date) {
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}

	/**
	 * Obtiene la fecha para transferencias en BEL
	 */
	public static String getFechaTransferencias() {
		return new SimpleDateFormat("dMMyy").format(new Date());
	}
	
	/**
	 * Toma el tiempo que tarda en aparecer un elemento identificado por su id
	 */
	public static String tiempo(WebDriver browserElements, String elemento) {
		System.out.println("Entró a tiempos");
		long start = System.currentTimeMillis();
		browserElements.findElement(By.id(elemento));
		long finish = System.currentTimeMillis();
		long totalTime = finish - start;
		totalTimeElement = (totalTime + " ms");
		return totalTimeElement;
	}
	
	public static String tiempotranscurrido()
	{
		long actual = System.currentTimeMillis();
		long transcurrido= (actual-XlsData.gettiempoInicio())/1000;
		return (transcurrido+" s");
	}

	/**
	 * Toma el tiempo que tarda en aparecer un elemento identificado por su
	 * Xpath
	 */
	public static String tiempoXpath(WebDriver browserElements, String elemento) {
		System.out.println("Entró a tiempos");
		long start = System.currentTimeMillis();
		browserElements.findElement(By.xpath(elemento));
		long finish = System.currentTimeMillis();
		long totalTime = finish - start;
		totalTimeElement = (totalTime + " ms");
		return totalTimeElement;
	}

	/**
	 * Toma captura de la pantalla en el momento que es llamado
	 * 
	 * @param comentario
	 *            Es el nombre que llevará la imágen
	 */
	public static void capturar(WebDriver driver, String comentario) {
		captura = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println("Capturando");
		try {
			FileUtils.copyFile(captura,
					new File(AppDataTest.getCarpeta() + comentario + " -Automation- " + Utils.getDateHours(null) + ".png"));
			System.out.println("Guardó a la captura");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea la carpeta con la fecha del día
	 */
	public static void crearCarpeta() {
		String rutaCarpeta = AppDataTest.getCarpeta();
		System.out.println(rutaCarpeta);
		File dir = new File(rutaCarpeta);
		dir.mkdirs();
		if(dir.exists())
		{
			System.out.println("La carpeta de Evidencias esta creada");
		}
		else
		{
			System.out.println("No existe la carpeta de evidencias");
		}
	}
	
	public static String crearSubCarpetaEvidencia() {
		String rutaCarpeta = AppDataTest.getCarpeta()+getDateHours(null)+"/";
		System.out.println(rutaCarpeta);
		File dir = new File(rutaCarpeta);
		dir.mkdirs();
		if(dir.exists())
		{
			System.out.println("La carpeta de Evidencias esta creada");
		}
		else
		{
			System.out.println("No existe la carpeta de evidencias");
		}
		return rutaCarpeta;
	}
	
	public static String getNombreVSistemaOperativo(){
		String nombreVersion=null;
		if(XlsData.getSistemaOperativo().equals("Android"))
		{
			if(XlsData.getVersion().equals("4.4") || XlsData.getVersion().equals("4.4.4") || XlsData.getVersion().equals("4.4W") || XlsData.getVersion().equals("4.4W.2"))
			{
				nombreVersion="KitKat "+XlsData.getVersion();
			}
			else if(XlsData.getVersion().equals("5.0") || XlsData.getVersion().equals("5.1.1"))
			{
				nombreVersion="Lollipop "+XlsData.getVersion();
			}
			else if(XlsData.getVersion().equals("6.0") || XlsData.getVersion().equals("6.0.1"))
			{
				nombreVersion="Marshmallow "+XlsData.getVersion();
			}
			else if(XlsData.getVersion().equals("7.0") || XlsData.getVersion().equals("7.1"))
			{
				nombreVersion="Nougat "+XlsData.getVersion();
			}
			else
			{
				nombreVersion=XlsData.getVersion();
			}
		}
		else
		{
			nombreVersion=XlsData.getVersion();
		}
		return nombreVersion;
		
	}
	
	/**
	 * Funcion que ejecuta el caso de prueba en Jira dentro del plug in Zephyr
	 * @param projectKey
	 * @param status
	 * @param comment
	 * @param NombreCaso
	 * @param filePath
	 */
	public static void executeZephyr(String projectKey, String idCycle, String status, String comment, String NombreCaso, String filePath){
		String comando="cd "+AppDataTest.getRaiz()+"Zephyr && java -jar ZephyrExecutor.jar "+projectKey+" "+idCycle+" "+status+" "+comment+" "+NombreCaso+" "+filePath;
		System.out.println(comando);
		String[] ExecuteJarZephyrMac= null;
		String[] ExecuteJarZephyrWindows= null;
		ExecuteJarZephyrMac = new String[]{"/bin/sh", "-c",comando};
		ExecuteJarZephyrWindows = new String[]{"cmd", "/c",comando};
		try
		{
			System.out.println(CommandManager.executeCommandUsingJavaRuntime(ExecuteJarZephyrWindows, true));
		}catch(Exception e){
			System.out.println("Error en la ejecución del JAR ZephyrExecutor");
		}
		 
		 
	 }
	
	public static void main(String args[]){
		System.out.println(AppDataTest.getRaiz());
		executeZephyr("PDA","0001495576967018-242ac112-0001","UNEXECUTED","\"Algun tipo de comentario\"","ATC-F2-Crear_Contacto","C:/Users/Administrator/Documents/Bancomer/BBVA_Send/Evidencias/14_08_2017/ATC-F1-Cambiar_Color_Tema-12.37.32.577.pdf");
	}
}
