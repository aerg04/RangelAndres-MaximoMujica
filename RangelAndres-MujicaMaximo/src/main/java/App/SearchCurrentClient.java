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
public class SearchCurrentClient {

    public SearchCurrentClient() {
    }
    public CurrentClient getInfoClient(String name, HashTable database ){
        List list = database.search(name.replace(" ", "").toLowerCase());
        if(list == null){
            NodoList <CurrentClient> pAux;
            pAux = list.getHead();
            if(list.getSize() == 1){
                return pAux.getValue();
            }else{
                while(pAux != null){
                    if(name.equals((pAux.getValue().getFirst_name() + pAux.getValue().getFirst_name()).replace(" ", "").toLowerCase())){
                        return pAux.getValue();
                    }
                    pAux = pAux.getpNext();
                }
            }
        }
//          else innecesario
            return null;
    }
}
