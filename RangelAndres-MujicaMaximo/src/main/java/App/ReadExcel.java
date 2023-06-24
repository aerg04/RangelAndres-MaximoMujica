package App;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
//import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class ReadExcel {
    private String ruta = "C:/Users/DELL/Downloads/Booking_hotel.xlsx";

    public ReadExcel() {
    }
    
    public Object[] ReadFile(){
        Object[] output = new Object[4];
        // Cargar archivo de Excel
//        this.SelectFile();
        try {
            File Fil = new File(ruta); //Se crea un archivo File
            FileInputStream file = new FileInputStream(Fil); //Se crea archivo FileInput para la lectura
            // Crear el objeto que tendra el libro de Excel
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            /*
         * Obtenemos la primera pestaña a la que se quiera procesar indicando el indice.
         * Una vez obtenida la hoja excel con las filas que se quieren leer obtenemos el iterator
         * que nos permite recorrer cada una de las filas que contiene.
             */

            int Hojas = workbook.getNumberOfSheets(); //Obtenemos el número de hojas que contiene el documento
            System.out.println("Número Hojas: "+Hojas);
            String str_auxiliar = "";

            //For que recorre las hojas existentes
            for (int i = 0; i < Hojas; i++) {                
                System.out.println("Hoja #: "+i+" - Nombre: "+workbook.getSheetName(i)); //Muestra la hoja en la estamos y el nombre de esta
                XSSFSheet sheet = workbook.getSheetAt(i); //Seleccionamos la hoja que vamos a recorrer
                Iterator<Row> rowIterator = sheet.iterator();
                Row row;
                // Recorremos todas las filas para mostrar el contenido de cada celda
                while (rowIterator.hasNext()) {
                    row = rowIterator.next();
                    // Obtenemos el iterator que permite recorres todas las celdas de una fila
                    Iterator<Cell> cellIterator = row.cellIterator();
                    Cell celda;
                    while (cellIterator.hasNext()) {
                        celda = cellIterator.next();
//                        celda.setCellType(CellType._NONE);
                        if(celda.getCellType() == CellType.NUMERIC){
                            if (DateUtil.isCellDateFormatted(celda)) {
                                    str_auxiliar += celda +",";
                            } else {
                                
                                    str_auxiliar += (int)celda.getNumericCellValue() + ",";;
                            }
                        }else if(celda.getCellType() == CellType.STRING){
                            str_auxiliar += celda.getStringCellValue() + ",";;
                            
                        }
                        // Dependiendo del formato de la celda el valor se debe mostrar como String, Fecha, boolean, entero...
                        
                        }
                    System.out.println(str_auxiliar);
                    str_auxiliar = "";
                    }
                }
                file.close();
                
            }catch (Exception ex) {
            System.out.println("ERROR: " + ex);
       
            // cerramos el libro excel

        } 
            return output;
    }
        public void SelectFile(){
            String ruta_prueba;
            Scanner entrada = null;
            JFileChooser fileChooser = new JFileChooser();

            int valor = fileChooser.showOpenDialog(fileChooser);

            if (valor == JFileChooser.APPROVE_OPTION) {
                ruta_prueba = fileChooser.getSelectedFile().getAbsolutePath();
                System.out.println(ruta_prueba);
                String[] confirmation = ruta_prueba.split("\\.");
                if("xlsx".equals(confirmation[confirmation.length-1].replace(" ", ""))){
                       ruta = ruta_prueba;
                    } else {
                        System.out.println("No se ha seleccionado ningún archivo xlsx");
                        ruta = null;
                    }
                }
            else{
                        System.out.println("No se ha seleccionado ningún archivo");
                }
            }
        }