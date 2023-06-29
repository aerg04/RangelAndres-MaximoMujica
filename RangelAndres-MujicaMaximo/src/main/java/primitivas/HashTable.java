/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author DELL
 */
public class HashTable<T> {
    private List[] array;
    private int size;
    
    public HashTable(int number){
        size = number;
        array = new List[number];
        for (int i = 0; i < array.length; i++) {
            array[i] = new List();
        }
    }

    public List[] getArray() {
        return array;
    }

    public void setArray(List[] array) {
        this.array = array;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public int HashFuntion(String key){
//        debe ser sin espacio y minuscula
        int hash_output, dividend;
        int hashvalue = key.replace(" ", "").toLowerCase().hashCode();
        if(hashvalue <0)
            hashvalue = hashvalue*(-1);
        System.out.println(hashvalue);
        dividend = hashvalue % size;
//        System.out.println(hashvalue % size);
        hash_output = dividend;
        
        return hash_output;
    }
    public void insert(String key, T new_object){
        int index = this.HashFuntion(key);
        if(index > size){
            System.out.println(index);
        }
        array[index].appendLast(new_object);;
    }
    
    public void insert(int index, T new_object){
//        int index = this.HashFuntion(key);
        array[index].appendLast(new_object);;
    }
    
    
    public List search(String key){
        int index = this.HashFuntion(key);
        try{
            return array[index];
            
        }catch(Exception e){
            return null;
        }
    }
    public List search(int index){
//        int index = this.HashFuntion(key);
        try{
            return array[index];
            
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    public void delete(String key){
        int index = this.HashFuntion(key);
        try{
            array[index] = null;
            
        }catch(Exception e){
            System.out.println("error al borrar");
//            return null;
        }
    }
    
}
