package App;

//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import primitivas.*;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundc
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
//import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
//import org.apache.poi.hssf.usermodel.HSSFDateUtil;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
    private String ruta;

    public ReadExcel() {
    }
    
    public void ReadFile(HashTable current, HashTable aux, HashTable rooms, Binary_Tree bookings){
        Object[] output = new Object[4];
        // Cargar archivo de Excel
        this.selectFile();
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
//                        System.out.println;
//                        celda.setCellType(CellType._NONE);
                        if(celda.getCellType() == CellType.NUMERIC){
                            if (DateUtil.isCellDateFormatted(celda)) {
                                    str_auxiliar += celda.getDateCellValue() +",";
                            } else {
                                
                                    str_auxiliar += (int)celda.getNumericCellValue() + ",";;
                            }
                        }else if(celda.getCellType() == CellType.STRING){
                            str_auxiliar += celda.getStringCellValue() + ",";
                            
                        }else{
                            str_auxiliar += celda.getDateCellValue() +",";
                        }
                        // Dependiendo del formato de la celda el valor se debe mostrar como String, Fecha, entero...
                        
                        }
//                    System.out.println(str_auxiliar);
                        try{
                            this.saveExcelData(i, str_auxiliar, current, aux,  rooms, bookings);
                            
                        }catch(Exception e){
                            System.out.println("error en el formato: " + e);
                            System.out.println("hoja: " + i );
                            System.out.println("fila: " + row.getRowNum() );
//                            System.out.println(row.getRowNum());
                        }
                    str_auxiliar = "";
                    }
                }
                file.close();
                
            }catch (Exception ex) {
                    System.out.println("ERROR: " + ex);
                } 
//            return output;
        }
    
        public void saveExcelData(int numHoja, String str_auxiliar, HashTable current, HashTable aux, HashTable rooms, Binary_Tree bookings){
            String[] array = str_auxiliar.split(",");
            
//            System.out.println(str_auxiliar);
//            System.out.println(this.converToDate("Mon Jun 18 00:00:00 IST 2012"));
            switch (numHoja){
                        case 0:
//                                Se crea objeto Booking se añade al arbol, id ocmo id BinaryTree
                            if(!"ci,primer_nombre,segundo_nombre,email,genero,tipo_hab,celular,llegada,salida,".equals(str_auxiliar)){
                                    LocalDate date1 = this.converToDate(array[7]);
                                    LocalDate date2 = this.converToDate(array[8]);                                    
                                    Booking reservation = new Booking(array[1],array[2],array[3],array[4],array[5],date1,array[6],date2,Integer.parseInt(array[0]));
                                    bookings.insert(reservation, Integer.parseInt(array[0]));
                            }
                            break;
                        case 1:
//                                Se crea objeto Room se añade al HashTable
                            if(!"num_hab,tipo_hab,piso,".equals(str_auxiliar)){
                                Room room = new Room(array[0],array[1],array[2]);
                                rooms.insert(Integer.parseInt(array[0])-1, room);
                            }
                            break;
                        
                        case 2:
//                                Se crea objeto CurrentClient se añade al HashTable, last + firt igual a la llave
                            if(!"num_hab,primer_nombre,apellido,email,genero,celular,llegada,".equals(str_auxiliar)){
                                  if(this.isNumeric(array[0])){
                                          CurrentClient client = new CurrentClient(array[0],array[1],array[2],array[3],array[4],array[5],this.converToDate(array[6]));
                                          current.insert(array[2] + array[1], client);
                                  }
                            }
                            break;
                        case 3:
//                                Se crea objeto RcordClient se añade al arbol, habitacion igual a la id
                            if(!"ci,primer_nombre,apellido,email,genero,llegada,num_hab,".equals(str_auxiliar)){
                                    ClientRecord record = new ClientRecord(array[0],array[1],array[2],array[3],array[4],this.converToDate(array[5]),array[6]);
                                    aux.insert(Integer.parseInt(array[6])-1, record);
                            }
                            break;
                        
                    }
        }
        
        public void selectFile(){
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
        public boolean isNumeric(String str) { 
        try {  
          Double.parseDouble(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
        }
        public LocalDate converToDate(String dateStr){
            
        //                String dateStr = "Mon Jun 18 00:00:00 IST 2012";
//        Sat Dec 12 00:00:00 KST 2020
//        DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        try{
            DateTimeFormatter f = DateTimeFormatter.ofPattern( "EEE MMM dd HH:mm:ss zzz uuuu", Locale.ENGLISH ) ;
            ZonedDateTime zdt = ZonedDateTime.parse(dateStr , f ) ;
            LocalDate localDate = zdt.toLocalDate() ;
            return localDate;
        }catch(Exception e){
            System.out.println("error fomato fecha");
            System.out.println(e);
            return null;
                }
            }
        }