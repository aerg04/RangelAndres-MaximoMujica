package primitivas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class Binary_Tree<T> {
    private Nodo root;
    private int size;

    public Binary_Tree() {
    }
    
    public void insert(T value, int id){
        Nodo <T> pNew = new Nodo(value, id);
        
        if(this.isEmpty()){
            this.insertInside(root, pNew);
        }else{
            root = pNew;
        }
    }
    
    public void insertInside(Nodo proot, Nodo pNew){
        if(proot.getId() > pNew.getId()){
            if(proot.getpL() != null){
                this.insertInside(proot.getpL(), pNew);
            }else{
                proot.setpL(pNew);
            }   
        }else{
            if(proot.getpR() != null){
                this.insertInside(proot.getpR(), pNew);
            }else{
                proot.setpR(pNew);
            }
        }
    }
    public Nodo search(int id){
        return this.searchRecursive(root, id);
    }
    
    public Nodo searchRecursive(Nodo proot, int id){
        if(proot != null){
            if(id == proot.getId()){
                return proot;
            }else{
                if(id < proot.getId()){
                    return this.searchRecursive(proot.getpL(), id);
                }else{
                    return this.searchRecursive(proot.getpR(), id);
                }   
            }
        }
        return null;
    }
    
    
    public boolean isEmpty(){
        return root != null;
    }
            
            
}
