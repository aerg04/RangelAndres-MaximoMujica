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
public class SearchRecordBooking {

    public SearchRecordBooking() {
    }
    public void convertHashTable(HashTable database, Binary_Tree RecordClientABB ){
//        Binary_Tree RecordClientABB = new Binary_Tree();
        int i = 1;
        int middle = database.getSize()/2;
        RecordClientABB.insert(database.search(middle),middle);
//        System.out.println(middle);
        if(database.getSize()%2 == 0){
            while(i < database.getSize()/2){
                RecordClientABB.insert(database.search(middle-i),middle-i+1);
                RecordClientABB.insert(database.search(middle+i),middle+i+1);
                i++;
            }
            RecordClientABB.insert(database.search(0),1);
        }else{
            while(i < (database.getSize()/2)-1){
                RecordClientABB.insert(database.search(middle-i),middle-i);
                RecordClientABB.insert(database.search(middle+i),middle+i);
                i++;
            }
            RecordClientABB.insert(database.search(0),1);
            RecordClientABB.insert(database.search(1),2);
            RecordClientABB.insert(database.search(database.getSize()-1),database.getSize()-1);
        }
//        return RecordClientABB;
    }
    public Booking searchBooking(int id, Binary_Tree database){
        Nodo<Booking> output  = database.search(id);
        if(output!= null){
            return output.getValue();
            
        }
        return null;
    }
    
    public String searchRecord(int id, Binary_Tree database){
        Nodo<List> Nodolist = database.search(id);
        NodoList<ClientRecord> client = Nodolist.getValue().getHead();
        
        if(Nodolist.getValue().getSize() == 1){
            return client.getValue().showAttributes();
            
        }else{
            String output = "";
            NodoList<ClientRecord> pAux = client;
            while(pAux != null){
                output  += "\n ----------------------------- \n" +pAux.getValue().showAttributes()+ "\n ----------------------------- \n";
                pAux = pAux.getpNext();
            }
            return output;
        }
    }
    public void insertClientRecord(int id,ClientRecord newrecord , Binary_Tree database){
        Nodo<List> Nodolist = database.search(id);
        Nodolist.getValue().appendLast(newrecord);
    }

}
