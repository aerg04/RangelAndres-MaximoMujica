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
    private boolean disponibility;

    public Room(String number, String type, String floor) {
        this.number = number;
        this.type = type;
        this.floor = floor;
        this.disponibility = true;
    }
    public String showAttributes(){
        String newline = System.getProperty("line.separator");
        return "numero de habitación: " + number + newline + "tipo: " + type + newline  + "piso: " + floor;
    }

    public boolean isDisponibility() {
        return disponibility;
    }

    public void setDisponibility(boolean disponibility) {
        this.disponibility = disponibility;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
    
}
