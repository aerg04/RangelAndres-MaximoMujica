/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

//import java.util.LocalDate;

import java.time.LocalDate;


/**
 *
 * @author DELL
 */
public class ClientRecord {
    private String id;
    private String  firstname;
    private String lastname;
    private String email;
    private String gender;
    private LocalDate arrival;
    private String room;

    public ClientRecord(String id, String firstname, String lastname, String email, String gender, LocalDate arrival, String room) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.arrival = arrival;
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public String getRoom() {
        return room;
    }
    
}
