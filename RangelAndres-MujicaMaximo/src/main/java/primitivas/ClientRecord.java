/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

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
    private String arrival;
    private String room;

    public ClientRecord(String id, String firstname, String lastname, String email, String gender, String arrival, String room) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.arrival = arrival;
        this.room = room;
    }
    
}
