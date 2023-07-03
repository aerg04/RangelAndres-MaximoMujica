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
        
        W1 w1 = new W1(rooms, aux_record,current_clients,bookings,record);
        w1.setVisible(true);

    }
    
        }

