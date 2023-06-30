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
public class Booking {
    private String last_name;
    private String first_name;
    private String gender;
    private LocalDate exit;
    private String type;
    
//    private String gender;
    private LocalDate arrival;
    private String cellphone;
    private String email;
    private int id;

    public Booking(String first_name, String last_name,String email,  String gender,String type, LocalDate arrival, String cellphone, LocalDate exit,     int id) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.gender = gender;
        this.exit = exit;
        this.type = type;
        this.arrival = arrival;
        this.cellphone = cellphone;
        this.email = email;
        this.id = id;
    }
    
    public String showAttributes(){
        String newline = System.getProperty("line.separator");
        return "apellido: " + last_name + newline +
                "nombre: " + first_name + newline +
                "id: " + id + newline +
                "genero: " + gender + newline +
                "llegada: " +  arrival + newline +
                "celular: " +   cellphone + newline +
                "email: " + email +   newline +
                "salida: " + exit   + newline+
                "tipo: " + type   + newline;
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

    public int getId() {
        return id;
    }

    public LocalDate getExit() {
        return exit;
    }

    public String getType() {
        return type;
    }
    
    
}


