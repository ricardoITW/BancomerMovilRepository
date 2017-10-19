package evidence;

import java.util.ArrayList;
import configurationData.Utils;
import io.appium.java_client.AppiumDriver;

public class EvidenceData {
	static ArrayList<String> comentarios = new ArrayList<String>();
	static ArrayList<String> tiempos = new ArrayList<String>();
	
	public static ArrayList<String> getComentarios() {
		return comentarios;
	}

	public static void setComentarios(ArrayList<String> comentarios) {
		EvidenceData.comentarios = comentarios;
	}

	public static ArrayList<String> getTiempos() {
		return tiempos;
	}

	public static void setTiempos(ArrayList<String> tiempos) {
		EvidenceData.tiempos = tiempos;
	}
	
	public static void setComentario(String coment){
		comentarios.add(coment);
	}
	
	public static void setTiempo(String tiempo){
		tiempos.add(tiempo);
	}
	
	@SuppressWarnings("rawtypes")
	public static void capturarPaso(boolean capturaPantalla, String comentarioPaso, AppiumDriver driverSend){
		EvidenceData.setComentario(comentarioPaso);
		EvidenceData.setTiempo(Utils.tiempotranscurrido());
		if(capturaPantalla){
			System.out.println("Captura Pantalla y comentario");
			if(comentarioPaso.contains("Correcto")){
				Utils.capturar(driverSend, comentarioPaso.substring(10));
			}
			else if (comentarioPaso.contains("Error")){
				Utils.capturar(driverSend, comentarioPaso.substring(7));
			}
		}
		else{
			System.out.println("Sin captura de pantalla");
		}
		
	}
	
}
