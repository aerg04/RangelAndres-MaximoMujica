/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author DELL
 * @param <T>
 */
public class Nodo <T>{
    private Nodo pL;
    private Nodo pR;
    private T value;
    private int id;
//    el id es un valo numerico para la busqueda independientemene de T

    public Nodo(T value, int id) {
        this.pL = null;
        this.pR = null;
        this.id = id;
        this.value = value;
    }

    public Nodo getpL() {
        return pL;
    }

    public void setpL(Nodo pL) {
        this.pL = pL;
    }

    public Nodo getpR() {
        return pR;
    }

    public void setpR(Nodo pR) {
        this.pR = pR;
    }
    
    public T getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public void setValue(T  value) {
        this.value = value;
    }
}
