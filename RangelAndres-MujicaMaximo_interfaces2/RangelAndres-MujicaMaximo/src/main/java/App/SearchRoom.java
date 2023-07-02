/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import primitivas.*;
/**
 *
 * @author DELL
 */
public class SearchRoom {

    public SearchRoom() {
    }
    public void setRoomDatabase(HashTable current,HashTable rooms){
        List list;
        for (int i = 0; i < current.getSize(); i++) {
            list = current.search(0);
            if(list != null){
                NodoList<CurrentClient>pAux = list.getHead();
                while(pAux != null){
                    int k = Integer.parseInt(pAux.getValue().getRoom());
                    NodoList<Room> pAux2 = rooms.search(k).getHead();
                    pAux2.getValue().setDisponibility(false);
                    pAux = pAux.getpNext();
                }
            }
        }
        
    }
    public int searchRoom(String type, HashTable rooms){
        for (int i = 0; i < rooms.getSize(); i++) {
            NodoList<Room> pAux = rooms.search(i).getHead();
            if(pAux.getValue().getType().toLowerCase().equals(type.toLowerCase()) && pAux.getValue().isDisponibility()){
                pAux.getValue().setDisponibility(false);
                return i;
            }
        }
        return -1;
    }
//    private void updateRoom(int k, Room room){
//        
//    }
}
