/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package proyecto.proyecto2;
import App.*;
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
//        String[] hola =  "ci,primer_nombre,segundo_nombre,email,genero,tipo_hab,celular,llegada,salida,".split(",");
//        for (int i = 0; i < hola.length+1; i++) {
//            System.out.println(hola[i]);
//        }
        
        ReadExcel read = new ReadExcel();
        read.ReadFile(current_clients,aux_record,rooms,bookings);
        
        System.out.println(bookings.getRoot());
        bookings.inorder(bookings.getRoot());
        bookings.delete(74883147);
        bookings.inorder(bookings.getRoot());
    }
}
