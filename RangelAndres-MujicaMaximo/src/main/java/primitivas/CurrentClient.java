/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

import java.time.LocalDate;
//import java.util.LocalDate;

/**
 *
 * @author DELL
 */
public class CurrentClient {
    private String last_name;
    private String first_name;
    private String gender;
    private LocalDate arrival;
    private String cellphone;
    private String email;
    private String room;

    public CurrentClient(String room, String first_name, String last_name, String email,  String gender, String cellphone,  LocalDate arrival) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.gender = gender;
        this.arrival = arrival;
        this.cellphone = cellphone;
        this.email = email;
        this.room = room;
    }
    public String showAttributes(){
        String newline = System.getProperty("line.separator");
        return "apellido: " + last_name + newline +
                "nombre: " + first_name + newline +
                "genero: " + gender + newline +
                "llegada: " +  arrival + newline +
                "celular: " +   cellphone + newline +
                "email: " + email +   newline +
                "habitación: " + room   + newline;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return room;
    }
    
}
