package configurationData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;

import configurationData.AppDataTest;
import configurationData.ReadExcel;
import configurationData.XlsData;


public class ReadExcel {
	static String[][] arregloExcel;
	
	 public static int contarNumeroPruebas(String xlsPath, String sheetName) 
	 {
		 int noOfColumns=0;
			try {
				File myFile = new File(xlsPath); 
				InputStream fis;
				fis = new FileInputStream (myFile);
				HSSFWorkbook myWorkBook = new HSSFWorkbook (fis); 
				HSSFSheet sheet = myWorkBook.getSheet(sheetName);
				noOfColumns = sheet.getLastRowNum();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			return noOfColumns;
			
	 }
	 public static String leerDatoporColumna(String pathExcel, String sheetName, int numeroFila, String columName) throws IOException
	 {
		 File myFile = new File(pathExcel); 
			InputStream fis = new FileInputStream (myFile);
			HSSFWorkbook myWorkBook = new HSSFWorkbook (fis);
			HSSFSheet sheet = myWorkBook.getSheet(sheetName);
	        String Dato=null;
	        Iterator<Row> rowIterator = sheet.iterator();
	        
	        DataFormatter objDefaultFormat = new DataFormatter();
	        FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator(myWorkBook);

	        
	        while (rowIterator.hasNext()) {
	            Row row = rowIterator.next();
	            Iterator<Cell> cellIterator = row.cellIterator();
	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();

	                if(row.getRowNum() == 0){
	                    if(cell.getStringCellValue().toUpperCase().equals(columName.toUpperCase())){// To match column index
	                    	int columna=cell.getColumnIndex();
	                    	for(int columnIterator=0;columnIterator<numeroFila;columnIterator++)
	                    	{
	                    		row=rowIterator.next();
	                    	}	                    	
	                    	
	                    	cellIterator = row.cellIterator();
	                    	for(int i=0; i < columna+1; i++)
	                    	{
	                    		try{cell = row.getCell(i);}catch(Exception e){cell.getStringCellValue();}
	                    		//cell = row.getCell(i);
	                    		//System.out.println(cell.getStringCellValue());
	                    	}
	                    	
	                        Dato = objDefaultFormat.formatCellValue(cell,objFormulaEvaluator);
	                        
	                    }
	                }
	            }
	        }      		
			return Dato;
	 }
	 
	 public static void getDataPoolPrueba(String xlsPath, String sheetName, int indice)
	 {
	 	try 
	 	{
			XlsData.setNombreCaso(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "NombreCaso"));
			XlsData.setDescripcion(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "Descripcion"));
			XlsData.setSistemaOperativo(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "SistemaOperativo"));
			XlsData.setVersion(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "Version"));
			XlsData.setModeloDispositivo(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "ModeloDispositivo"));
			XlsData.setNombreDispositivo(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "NombreDispositivo"));
			XlsData.setAmbiente(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "Ambiente"));
			
			XlsData.setNumeroCelular(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "NumeroCelular"));
			XlsData.setNumeroTarjeta(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "NumeroTarjeta"));
			XlsData.setCVV(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "CVV"));
			XlsData.setNIP(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "NIP"));
			
			XlsData.setContraseniaActual(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "ContraseniaActual"));
			XlsData.setContraseniaNueva(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "ContraseniaNueva"));
			
			XlsData.setCorreoElectronicoActual(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "CorreoElectronicoActual"));
			XlsData.setCorreoElectronicoNuevo(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "CorreoElectronicoNuevo"));
			
			XlsData.setCuentaBeneficiario(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "CuentaBeneficiario"));
			XlsData.setImporte(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "Importe"));
			XlsData.setConcepto(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "Concepto"));
			
			XlsData.setMontoMaxOperacion(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "MontoMaxOperacion"));
			XlsData.setMontoMaxDiario(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "MontoMaxDiario"));
			XlsData.setMontoMaxMes(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "MontoMaxMes"));
			
			XlsData.setAlertaDeposito(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "AlertaDeposito"));
			XlsData.setAlertaCargo(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "AlertaCargo"));
			
			XlsData.setBeneficiario(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "BeneficiarioRetiroSinTarjeta"));
			
			XlsData.setNombreFrecuente(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "NombreFrecuente"));
			XlsData.setCorreoFrecuente(ReadExcel.leerDatoporColumna(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), indice, "CorreoFrecuente"));
	 	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	 }
	 public static void main(String[] args) {
		 System.out.println(ReadExcel.contarNumeroPruebas(AppDataTest.getXlsPath(), AppDataTest.getSheetName()));
		 ReadExcel.getDataPoolPrueba(AppDataTest.getXlsPath(), AppDataTest.getSheetName(), 1);
		 System.out.println(XlsData.getNombreCaso());
	}
}
