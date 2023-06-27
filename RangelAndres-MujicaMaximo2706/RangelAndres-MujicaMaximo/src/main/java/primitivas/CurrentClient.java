/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author DELL
 */
public class CurrentClient {
    private String last_name;
    private String first_name;
    private String gender;
    private String arrival;
    private String cellphone;
    private String email;
    private String id;

    public CurrentClient(String last_name, String first_name, String gender, String arrival, String cellphone, String email, String id) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.gender = gender;
        this.arrival = arrival;
        this.cellphone = cellphone;
        this.email = email;
//        this.id = id;
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

    public String getArrival() {
        return arrival;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }

//    public String getId() {
//        return id;
//    }
    
}
