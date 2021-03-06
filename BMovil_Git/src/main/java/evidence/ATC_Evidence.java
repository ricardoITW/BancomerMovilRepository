package evidence;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.apache.commons.io.comparator.LastModifiedFileComparator;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import JSONLogs.LogResultEnrolamiento;
import JSONLogs.LogResultInstrument1;
import JSONLogs.LogResultInstrument2;
import configurationData.AppDataTest;
import configurationData.DataBaseActions;
import configurationData.Utils;
import configurationData.XlsData;

public class ATC_Evidence {
	private static Font subTitulos = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD, BaseColor.BLACK);
	private static Font parrafo = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
	private static Font parrafoSmall = new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL, BaseColor.BLACK);
	private static Font parrafoSSmall = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL, BaseColor.BLACK);
	static String files;
	static String ruta = AppDataTest.getCarpeta();
	// static String ruta = "" + AppData.getRaiz() + "\\Evidencia\\";
	static File folder = new File(ruta);
	static File[] listOfFiles;
	static File folderEliminacion;
	static Image image;
	static Document document;
	static DataBaseActions db = new DataBaseActions();

	/**
	 * Genera el PDF que se adjunta en el correo con imágenes y lista de
	 * comentarios
	 * 
	 * @param comentarios
	 *            lista de comentarios agregados durante la ejecucion
	 * @param time
	 *            lista de tiempos agregados durante la ejecucion
	 */
	public static String evidencia_pdf(ArrayList<String> comentarios, ArrayList<String> time) {
		System.out.println("Los datos " + XlsData.getNombreCaso() + XlsData.getDescripcion());
		// TODO Auto-generated method stub
		//String FilePathEvidence = AppDataTest.getCarpeta() + XlsData.getNombreCaso() + "-" + Utils.getDateHours(null) + ".pdf";
		String FilePathEvidence = AppDataTest.getCarpeta() + XlsData.getNombreCaso() + "-" + ".pdf";
		System.out.println("Entró a la creación de la evidencia");
		document = new Document();
		try {
			System.out.println("En el try de crear el PDF");
			PdfWriter.getInstance(document, new FileOutputStream(FilePathEvidence));
			System.out.println("Paso la ruta");
			// String rutadocumento = "" + AppData.getRaiz() + "\\Evidencia\\" +
			// Utils.getActualDay(null) + "\\"
			// + Utils.getDateHours(null) + XlsData.getTestCase() +
			// Utils.getActualDay(null) + ".pdf";
			document.open();
			// Header
			Image logoInvestaBank = Image.getInstance(AppDataTest.getRaiz() + "Evidencias/Logo/logo.jpg");
			logoInvestaBank.scaleToFit(170, 150);
			System.out.println("Cargó el logo");
			PdfPTable header = new PdfPTable(5);
			header.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
			header.setWidthPercentage(100f);

			PdfPCell logoCliente = new PdfPCell(logoInvestaBank);
			logoCliente.setRowspan(2);
			logoCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
			logoCliente.setVerticalAlignment(Element.ALIGN_MIDDLE);
			logoCliente.setBorder(0);
			header.addCell(logoCliente);

			PdfPCell espacioVacio = new PdfPCell(new Phrase(""));
			espacioVacio.setRowspan(1);
			espacioVacio.setBorder(0);
			header.addCell(espacioVacio);

			PdfPCell titulo = new PdfPCell(new Phrase("Evidencia de pruebas automatizadas", subTitulos));
			titulo.setHorizontalAlignment(Element.ALIGN_RIGHT);
			titulo.setColspan(4);
			titulo.setBorder(0);
			header.addCell(titulo);

			PdfPCell espacioVacio2 = new PdfPCell(new Phrase(""));
			espacioVacio2.setRowspan(2);
			espacioVacio2.setBorder(0);
			header.addCell(espacioVacio2);

			PdfPCell subTitulo = new PdfPCell(new Phrase("Reporte de Ejecución - Daily Check ", parrafo));
			subTitulo.setColspan(4);
			subTitulo.setHorizontalAlignment(Element.ALIGN_RIGHT);
			subTitulo.setBorder(0);
			header.addCell(subTitulo);
			document.add(header);

			System.out.println("Puso el daily check");
			// Fin header
			Paragraph subPara = new Paragraph("Subcategory 1", parrafo);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			subPara = new Paragraph("Datos de la prueba", subTitulos);
			document.add(Chunk.NEWLINE);
			document.add(subPara);

			String TestCase = XlsData.getNombreCaso();
			String Descripcion = XlsData.getDescripcion();
			String browser = XlsData.getSistemaOperativo();
			String fecha = Utils.getActualDay(null).toString().replace("_", "/");
			String versionSO = Utils.getNombreVSistemaOperativo();
			String modelo = XlsData.getModeloDispositivo();

			PdfPTable testDataTable = new PdfPTable(3); // 3 columns.
			testDataTable.setWidthPercentage(100f);

			PdfPCell cell1 = new PdfPCell(new Paragraph("Nombre del script: ", parrafoSmall));
			cell1.setBorder(0);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);

			PdfPCell cell2 = new PdfPCell(new Paragraph(TestCase, parrafoSmall));
			cell2.setBorder(0);
			cell2.setHorizontalAlignment(Element.ALIGN_LEFT);

			PdfPCell cell3 = new PdfPCell(new Paragraph(""));
			cell3.setBorder(0);

			testDataTable.addCell(cell1);
			testDataTable.addCell(cell2);
			testDataTable.addCell(cell3);

			PdfPCell cell4 = new PdfPCell(new Paragraph("Descripción: ", parrafoSmall));
			cell4.setBorder(0);
			PdfPCell cell5 = new PdfPCell(new Paragraph(Descripcion, parrafoSmall));
			cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell5.setBorder(0);
			PdfPCell cell6 = new PdfPCell(new Paragraph(""));
			cell6.setBorder(0);

			testDataTable.addCell(cell4);
			testDataTable.addCell(cell5);
			testDataTable.addCell(cell6);

			PdfPCell cell7 = new PdfPCell(new Paragraph("Sistema Operativo: ", parrafoSmall));
			cell7.setBorder(0);
			PdfPCell cell8 = new PdfPCell(new Paragraph(browser, parrafoSmall));
			cell8.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell8.setBorder(0);
			PdfPCell cell9 = new PdfPCell(new Paragraph(""));
			cell9.setBorder(0);

			testDataTable.addCell(cell7);
			testDataTable.addCell(cell8);
			testDataTable.addCell(cell9);

			PdfPCell cell10 = new PdfPCell(new Paragraph("Version: ", parrafoSmall));
			cell10.setBorder(0);
			PdfPCell cell11 = new PdfPCell(new Paragraph(versionSO, parrafoSmall));
			cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell11.setBorder(0);
			PdfPCell cell12 = new PdfPCell(new Paragraph(""));
			cell12.setBorder(0);

			testDataTable.addCell(cell10);
			testDataTable.addCell(cell11);
			testDataTable.addCell(cell12);

			PdfPCell cell13 = new PdfPCell(new Paragraph("Modelo: ", parrafoSmall));
			cell13.setBorder(0);
			PdfPCell cell14 = new PdfPCell(new Paragraph(modelo, parrafoSmall));
			cell14.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell14.setBorder(0);
			PdfPCell cell15 = new PdfPCell(new Paragraph(""));
			cell15.setBorder(0);

			testDataTable.addCell(cell13);
			testDataTable.addCell(cell14);
			testDataTable.addCell(cell15);

			PdfPCell cell16 = new PdfPCell(new Paragraph("Fecha: ", parrafoSmall));
			cell16.setBorder(0);
			PdfPCell cell17 = new PdfPCell(new Paragraph(fecha, parrafoSmall));
			cell17.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell17.setBorder(0);
			PdfPCell cell18 = new PdfPCell(new Paragraph(""));
			cell18.setBorder(0);

			testDataTable.addCell(cell16);
			testDataTable.addCell(cell17);
			testDataTable.addCell(cell18);

			// Cliente y Usuario
			document.add(testDataTable);
			int step = 0;

			Paragraph subPara1 = new Paragraph("Subcategory 1", parrafo);
			document.add(Chunk.NEWLINE);
			subPara1 = new Paragraph("Resultados de ejecución", subTitulos);
			subPara1.setAlignment(Element.ALIGN_CENTER);
			document.add(subPara1);

			for (int i = 0; i < comentarios.size(); i++) {
				if (comentarios.get(i).contains("Error")) 
				{
					String comentario = comentarios.get(i).substring(7);
					System.out.println(comentario);

					step++;
					PdfPTable logTable = new PdfPTable(4); // 3 columns.
					logTable.setWidthPercentage(100f);
					logTable.setWidths(new float[] { 1, 1,2,1 });
					PdfPCell nPaso = null;
					PdfPCell estatusPaso = null;
					PdfPCell log3 = null;
					PdfPCell log4 = null;

					nPaso = new PdfPCell(new Paragraph("Paso " + step + "", parrafo));
					nPaso.setBorder(0);
					nPaso.setHorizontalAlignment(Element.ALIGN_LEFT);

					estatusPaso = new PdfPCell(new Paragraph("Error", parrafoSmall));
					estatusPaso.setBorder(0);
					estatusPaso.setHorizontalAlignment(Element.ALIGN_LEFT);

					log3 = new PdfPCell(new Paragraph(comentarios.get(i).substring(6).trim(), parrafoSmall));
					log3.setBorder(0);

					if (time.get(i).equals("") || time.get(i).equals(" ")) {
						log4 = new PdfPCell(new Paragraph("-", parrafoSmall));
						log4.setBorder(0);
					} else {
						log4 = new PdfPCell(new Paragraph(time.get(i).trim(), parrafoSmall));
						log4.setBorder(0);
					}
					logTable.addCell(nPaso);
					logTable.addCell(estatusPaso);
					logTable.addCell(log3);
					logTable.addCell(log4);
					document.add(logTable);

				} 
				else 
				{
					String comentario = comentarios.get(i).substring(10);
					System.out.println(comentario);

					step++;
					PdfPTable logTable = new PdfPTable(4); // 3 columns.
					logTable.setWidthPercentage(100f);
					logTable.setWidths(new float[] { 1, 1,2,1 });
					PdfPCell log1 = null;
					PdfPCell log2 = null;
					PdfPCell log3 = null;
					PdfPCell log4 = null;

					log1 = new PdfPCell(new Paragraph("Paso " + step + "", parrafo));
					log1.setBorder(0);
					log1.setHorizontalAlignment(Element.ALIGN_LEFT);

					log2 = new PdfPCell(new Paragraph("Correcto", parrafoSmall));
					log2.setBorder(0);
					log2.setHorizontalAlignment(Element.ALIGN_LEFT);

					log3 = new PdfPCell(new Paragraph(comentarios.get(i).substring(10).trim(), parrafoSmall));
					log3.setBorder(0);

					if (time.get(i).equals("") || time.get(i).equals(" ")) {
						log4 = new PdfPCell(new Paragraph("-", parrafoSmall));
						log4.setBorder(0);
					} else {
						log4 = new PdfPCell(new Paragraph(time.get(i).trim(), parrafoSmall));
						log4.setBorder(0);
					}
					logTable.addCell(log1);
					logTable.addCell(log2);
					logTable.addCell(log3);
					logTable.addCell(log4);
					document.add(logTable);
				}
			}

			System.out.println("Agregó el log");
			document.newPage();
			document.add(header);
			document.add(subPara);
			document.add(testDataTable);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			
			PdfPTable tabla2 = new PdfPTable(2);
			tabla2.setWidthPercentage(30f);

			PdfPCell celda22 = new PdfPCell(new Paragraph(""));
			celda22.setBorder(0);
			tabla2.addCell(celda22);
			document.add(tabla2); // Logotipo

			Paragraph parrafo3 = new Paragraph("REPORTE DE EVIDENCIAS"); //
			parrafo3.setAlignment(Element.ALIGN_CENTER);
			document.add(Chunk.NEWLINE);
			document.add(parrafo3);
			listOfFiles = folder.listFiles();
			int NumeroImagen=0;
			Arrays.sort(listOfFiles, LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					files = listOfFiles[i].getName();
					if (files.contains(".png")) {
						NumeroImagen++;
						if(NumeroImagen!=1)
						{
							document.newPage();
							document.add(header);
							document.add(subPara);
							document.add(testDataTable);
							document.add(Chunk.NEWLINE);
							document.add(Chunk.NEWLINE);
							document.add(Chunk.NEWLINE);
						}
						System.out.println("Obtenecion de Imagenes" + listOfFiles[i].getName());
						System.out.println("RutaBusqueda:" + AppDataTest.getRaiz() + listOfFiles[i].getName());

						image = Image.getInstance("" + ruta + "/" + listOfFiles[i].getName());
						image.scaleAbsolute(200f, 370f);//480

						PdfPTable contentTable = new PdfPTable(1); // 1 column.
						contentTable.setWidthPercentage(100f);

						String descripcion_img = listOfFiles[i].getName();
						descripcion_img.replaceAll("_", " ");

						// "Paso " + step + ": " +
						PdfPCell descripcionImage = new PdfPCell(
								new Paragraph(descripcion_img.substring(0, descripcion_img.length() - 4), parrafo));
						descripcionImage.setRowspan(2);
						descripcionImage.setHorizontalAlignment(Element.ALIGN_CENTER);
						descripcionImage.setVerticalAlignment(Element.ALIGN_MIDDLE);
						descripcionImage.setBorder(PdfPCell.NO_BORDER);
						// descripcionImage.setBorder(0);

						PdfPCell imgPaso = new PdfPCell(image);
						imgPaso.setRowspan(2);
						imgPaso.setHorizontalAlignment(Element.ALIGN_CENTER);
						imgPaso.setVerticalAlignment(Element.ALIGN_MIDDLE);
						imgPaso.setBorder(PdfPCell.NO_BORDER);
						// imgPaso.setBorder(0);

						// contentTable
						contentTable.addCell(descripcionImage);
						contentTable.addCell(imgPaso);
						contentTable.setKeepTogether(true);
						document.add(contentTable);
						document.add(Chunk.NEWLINE);

						// document.add(image);
						step++;
						System.out.println("Imagen:" + listOfFiles[i].getName() + "Se ha agregado al PDF");
						document.add(Chunk.NEWLINE);
					}
				}
			}
			System.out.println("Fin del for de imagenes");
			
			//Escritura de Json
			document.newPage();
			document.add(header);
			document.add(subPara);
			document.add(testDataTable);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			
			PdfPTable contentTable1 = new PdfPTable(1); // 1 column.
			contentTable1.setWidthPercentage(100f);
			
			PdfPTable contentTable2 = new PdfPTable(1); // 1 column.
			contentTable2.setWidthPercentage(100f);
			
			PdfPTable contentTable3 = new PdfPTable(1); // 1 column.
			contentTable3.setWidthPercentage(100f);
			
			PdfPCell TituloJson = new PdfPCell(
					new Paragraph("Primer Consulta del instrumento", parrafo));
			TituloJson.setRowspan(2);
			TituloJson.setHorizontalAlignment(Element.ALIGN_CENTER);
			TituloJson.setVerticalAlignment(Element.ALIGN_MIDDLE);
			TituloJson.setBorder(PdfPCell.NO_BORDER);
			
			PdfPCell contenidoJson = new PdfPCell(
					new Paragraph(LogResultInstrument1.getResultadoEvidencia(), parrafo));
			contenidoJson.setRowspan(2);
			contenidoJson.setHorizontalAlignment(Element.ALIGN_LEFT);
			contenidoJson.setVerticalAlignment(Element.ALIGN_MIDDLE);
			contenidoJson.setBorder(PdfPCell.NO_BORDER);
			
			PdfPCell cadenaJsonInstrumento1 = new PdfPCell(
					new Paragraph(LogResultInstrument1.getCadenaJson(), parrafoSSmall));
			cadenaJsonInstrumento1.setRowspan(2);
			cadenaJsonInstrumento1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cadenaJsonInstrumento1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cadenaJsonInstrumento1.setBorder(PdfPCell.NO_BORDER);
			
			
			
			
			PdfPCell TituloJson2 = new PdfPCell(
					new Paragraph("Segunda Consulta del instrumento", parrafo));
			TituloJson2.setRowspan(2);
			TituloJson2.setHorizontalAlignment(Element.ALIGN_CENTER);
			TituloJson2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			TituloJson2.setBorder(PdfPCell.NO_BORDER);
			
			PdfPCell contenidoJson2 = new PdfPCell(
					new Paragraph(LogResultInstrument2.getResultadoEvidencia(), parrafo));
			contenidoJson2.setRowspan(2);
			contenidoJson2.setHorizontalAlignment(Element.ALIGN_LEFT);
			contenidoJson2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			contenidoJson2.setBorder(PdfPCell.NO_BORDER);
			
			PdfPCell cadenaJsonEnrolamiento = new PdfPCell(
					new Paragraph(LogResultEnrolamiento.getCadenaJson(), parrafoSSmall));
			cadenaJsonEnrolamiento.setRowspan(2);
			cadenaJsonEnrolamiento.setHorizontalAlignment(Element.ALIGN_LEFT);
			cadenaJsonEnrolamiento.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cadenaJsonEnrolamiento.setBorder(PdfPCell.NO_BORDER);
			
			
			
			
			PdfPCell TituloJson3 = new PdfPCell(
					new Paragraph("Consulta status del enrolamiento", parrafo));
			TituloJson3.setRowspan(2);
			TituloJson3.setHorizontalAlignment(Element.ALIGN_CENTER);
			TituloJson3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			TituloJson3.setBorder(PdfPCell.NO_BORDER);
			
			PdfPCell contenidoJson3 = new PdfPCell(
					new Paragraph("Estatus de Enrolamiento: "+LogResultEnrolamiento.getEnrollSTS(), parrafo));
			contenidoJson3.setRowspan(2);
			contenidoJson3.setHorizontalAlignment(Element.ALIGN_LEFT);
			contenidoJson3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			contenidoJson3.setBorder(PdfPCell.NO_BORDER);
			
			PdfPCell cadenaJsonInstrumento2 = new PdfPCell(
					new Paragraph(LogResultInstrument2.getCadenaJson(), parrafoSSmall));
			cadenaJsonInstrumento2.setRowspan(2);
			cadenaJsonInstrumento2.setHorizontalAlignment(Element.ALIGN_LEFT);
			cadenaJsonInstrumento2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cadenaJsonInstrumento2.setBorder(PdfPCell.NO_BORDER);
			
			
			contentTable1.addCell(TituloJson);
			contentTable1.addCell(contenidoJson);
			contentTable1.addCell(cadenaJsonInstrumento1);
			contentTable1.setKeepTogether(true);
			
			contentTable2.addCell(TituloJson3);
			contentTable2.addCell(contenidoJson3);
			contentTable2.addCell(cadenaJsonEnrolamiento);
			contentTable2.setKeepTogether(true);
			
			contentTable3.addCell(TituloJson2);
			contentTable3.addCell(contenidoJson2);
			contentTable3.addCell(cadenaJsonInstrumento2);
			contentTable3.setKeepTogether(true);
			
			document.add(contentTable1);
			document.add(Chunk.NEWLINE);
			document.add(contentTable2);
			document.add(Chunk.NEWLINE);
			document.add(contentTable3);
			document.add(Chunk.NEWLINE);
			document.close();
			
			eliminarImagenes();
			comentarios = null;
			time = null;
			
			Thread.sleep(5000);
			//DataBaseActions.insertarTestLink();

		} catch (Exception e) {
			System.out.print(e.getMessage());
			System.out.println("No se ha podido leer las imagenes" + e);
		}
		return FilePathEvidence;
	}

	public static void eliminarImagenes() {
		folderEliminacion = new File(ruta);
		System.out.println(ruta);
		File[] listOfFilesEliminacion = folder.listFiles();
		//System.out.println(listOfFilesEliminacion.length);
		//if(listOfFilesEliminacion.length!=0)
		
			for (int i = 0; i < listOfFilesEliminacion.length; i++) {
				if (listOfFilesEliminacion[i].isFile()) {
					files = listOfFilesEliminacion[i].getName();
					if (files.endsWith(".png") || files.endsWith(".PNG")) {
						listOfFilesEliminacion[i].delete();
					}
				}
			}
		
		
		System.out.println("Algunas imagenes han sido eliminadas");
	}
	public static void main(String args[])
	{
		String rutaP = AppDataTest.getCarpeta();
		File folderP = new File(rutaP);
		File[] listOfFilesP = folderP.listFiles();
		String files;
		System.out.println(listOfFilesP.length);
		
		for (int i = 0; i < listOfFilesP.length; i++) 
		{
			if (listOfFilesP[i].isFile()) 
			{
				files = listOfFilesP[i].getName();
				if (files.contains(".png")) 
				{
					Arrays.sort(listOfFilesP, new Comparator<File>() {
						public int compare(File f1, File f2) {
							return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
						}
					});
					
				}
			}
		}
		
		
		for (int i = 0; i < listOfFilesP.length; i++) 
		{
			System.out.println(listOfFilesP[i].getName());
		}
	}
}
