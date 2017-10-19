package configurationData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

import org.apache.commons.io.comparator.LastModifiedFileComparator;

//**********************Solo se usara si el proyecto se liga con Testlink *************

public class DataBaseActions {
	static String fromFile;
	static String toFile;
	static File[] listOfFiles;
	static File folder;
	static String files;

	public static Connection insertarTestLink() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Entra a insertar Testlink");
			con = DriverManager.getConnection("jdbc:mysql://localhost/testlink", "root", "root");
			System.out.println("conexion establecida---BASE DE DATOS CORRECTO---");

			Statement stmt2 = con.createStatement();
			String query2 = "SELECT * FROM  `executions` ORDER BY  `id` DESC LIMIT 1";

			ResultSet rst2 = stmt2.executeQuery(query2);

			while (rst2.next()) {
				int valor3 = rst2.getInt("id");
				System.out.println("...select  ejecutado:::" + valor3);

				String ruta = "";
				ruta = String.valueOf(valor3);
				
				//File directorio = new File("C://wamp//www//testlink//upload_area//executions//" + ruta+"//"  );
				//System.out.println(directorio);
				new File(AppDataTest.getUpload_Area()+"/executions/" + ruta+"").mkdirs();

				System.out.println("Se ha creado la carpeta");

				String actualDay = Utils.getActualDay(null);
				String caso = XlsData.getNombreCaso();
				String date = Utils.getDateHours(null);
				String archivoYRuta = "";

				String rutaArchivo = AppDataTest.getCarpeta();
				System.out.println(rutaArchivo);
				folder = new File(rutaArchivo);
				listOfFiles = folder.listFiles();

				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile()) {
						files = listOfFiles[i].getName();
						if (files.endsWith(".pdf") || files.endsWith(".PDF")) {
							Arrays.sort(listOfFiles, LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);
						}
					}
					System.out.println("RutaBusqueda:" + AppDataTest.getRaiz() + listOfFiles[i].getName());
					archivoYRuta = AppDataTest.getCarpeta() + listOfFiles[i].getName();
				}

				fromFile = archivoYRuta;
				System.out.println("Esta es la ruta de la evidencia "+archivoYRuta);

				toFile = AppDataTest.getUpload_Area()+"/executions/" + ruta + "/archivo20.pdf";
				
				System.out.println("Archivo que se extrae: " + fromFile);
				System.out.println("Destino del archivo" + toFile);
				System.out.println("RutaDondeSeGuardaArchivo ahora " + toFile);

				File fichero = new File(fromFile);
				Long varTamano = fichero.length();

				System.out.println("El tamaño del archivo es de :" + varTamano);
				Statement stmt = con.createStatement();

				String query;
				query = "INSERT INTO attachments (fk_id, fk_table, title, description, file_name, file_path, file_size, file_type, date_added, content, compression_type) VALUES("
						+ valor3 + ", 'executions', '', '', '" + caso + "', 'executions/" + valor3
						+ "/archivo20.pdf','" + varTamano + "', 'application/pdf', '0000-00-00 00:00:00', NULL, 1)";

				int rs = stmt.executeUpdate(query);
				System.out.println("...Insert  ejecutado.");
				copyFile(fromFile,toFile);

			}
		} catch (Exception e) {
			System.out.println("Error de conexión - no entró en try-");
		}
		return con;
	}

	/* CopiaDelArchivo */
	public static boolean copyFile(String fromFile, String toFile) {
		File origin = new File(fromFile);
		File destination = new File(toFile);
		if (origin.exists()) {
			try {
				InputStream in = new FileInputStream(origin);
				OutputStream out = new FileOutputStream(destination);
				byte[] buf = new byte[1024];
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				in.close();
				out.close();
				return true;
			} catch (IOException ioe) {
				ioe.printStackTrace();
				return false;
			}
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		//DataBaseActions javaIOUtils = new DataBaseActions();
		DataBaseActions.insertarTestLink();
		
		//boolean result = javaIOUtils.copyFile(fromFile, toFile);
		//System.out.println(result ? "Success! File copying (Éxito! Fichero copiado)"
		//		: "Error! Failed to copy the file (Error! No se ha podido copiar el fichero)");

	}
}
