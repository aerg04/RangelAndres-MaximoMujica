/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package proyecto.proyecto2;
import App.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import primitivas.*;
/**
 *
 * @author DELL
 */
public class RangelAndresMujicaMaximo {

    public static void main(String[] args) {
        HashTable rooms = new HashTable(300);
        HashTable aux_record = new HashTable(300);
        HashTable current_clients = new HashTable(300);
        Binary_Tree bookings = new Binary_Tree();
        Binary_Tree record = new Binary_Tree();
        
        SearchRecordBooking app_record = new SearchRecordBooking();
        SearchCurrentClient app_current = new SearchCurrentClient();
                
        ReadExcel read = new ReadExcel();
        read.ReadFile(current_clients,aux_record,rooms,bookings);
        app_record.convertHashTable(aux_record, record);
        
//        CurrentClient p = app_current.getInfoClient("BriandEven", current_clients);
//        System.out.println(p.showAttributes());
        
        System.out.println(app_record.searchBooking(13502927, bookings).showAttributes());
        System.out.println(app_record.searchRecord(1, record));
        bookings.delete(13502927);
//        System.out.println(app_record.searchBooking(13502927, bookings).showAttributes());
        System.out.println(app_record.searchBooking(13369274, bookings).showAttributes());
        
        
//        
//        DateTimeFormatter f = DateTimeFormatter.ofPattern( "EEE MMM dd HH:mm:ss zzz uuuu", Locale.ENGLISH ) ;
//        ZonedDateTime zdt = ZonedDateTime.parse( "Mon Jun 18 00:00:00 IST 2012" , f ) ;
//        LocalDate localDate = zdt.toLocalDate() ;
//        System.out.println(localDate);
//        
//        System.out.println(bookings.getRoot());
//        bookings.inorder(bookings.getRoot());
//        bookings.delete(74883147);
//        bookings.inorder(bookings.getRoot());
    }
    public static LocalDate converToDate(String dateStr){
            
        //                String dateStr = "Mon Jun 18 00:00:00 IST 2012";
//        Sat Dec 12 00:00:00 KST 2020
//        DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            DateTimeFormatter f = DateTimeFormatter.ofPattern( "EEE MMM dd HH:mm:ss zzz uuuu", Locale.ENGLISH ) ;
        try{
            ZonedDateTime zdt = ZonedDateTime.parse(  dateStr, f ) ;
            LocalDate localDate = zdt.toLocalDate() ;
            return localDate;
        }catch(Exception e){
            System.out.println(e);
            System.out.println("error fomato fecha");
            return null;
                }
            }
        }

