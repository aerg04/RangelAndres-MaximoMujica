/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author DELL
 */
public class Room {
    private String number;
    private String type;
    private String floor;

    public Room(String number, String type, String floor) {
        this.number = number;
        this.type = type;
        this.floor = floor;
    }
    public String showAttributes(){
        String newline = System.getProperty("line.separator");
        return "numero de habitación: " + number + newline + "tipo: " + type + newline  + "piso: " + floor;
    }
    
}
