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
public class SearchRecordClient {

    public SearchRecordClient() {
    }
    public void convertHashTable(HashTable database, Binary_Tree RecordClientABB ){
//        Binary_Tree RecordClientABB = new Binary_Tree();
        int i = 1;
        int middle = database.getSize()/2;
        RecordClientABB.insert(database.search(middle),middle);
        System.out.println(middle);
        if(database.getSize()%2 == 0){
            while(i < database.getSize()/2){
                RecordClientABB.insert(database.search(middle-i),middle-i);
                RecordClientABB.insert(database.search(middle+i),middle+i);
                i++;
            }
            RecordClientABB.insert(database.search(0),0);
        }else{
            while(i < (database.getSize()/2)-1){
                RecordClientABB.insert(database.search(middle-i),middle-i);
                RecordClientABB.insert(database.search(middle+i),middle+i);
                i++;
            }
            RecordClientABB.insert(database.search(0),0);
            RecordClientABB.insert(database.search(database.getSize()-1),database.getSize()-1);
        }
//        return RecordClientABB;
}

}
