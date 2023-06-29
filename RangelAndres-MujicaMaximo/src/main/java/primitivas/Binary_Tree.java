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

    public Nodo getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }
    
    
    public Binary_Tree() {
    }
    
    public void insert(T value, int id){
        Nodo <T> pNew = new Nodo(value, id);
        
        if(this.isEmpty()){
            this.insertInside(root, pNew);
        }else{
            root = pNew;
        }
        size++;
    }
//  
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
    
    public void delete(int id){
        Nodo pAux = this.search(id);
        if(pAux != null){
            this.deleteNodo(root, id);
        }
    }
    
    
    public boolean isEmpty(){
        return root != null;
    }
    
    // Función para realizar un recorrido en orden en el BST
    public void inorder(Nodo root){
        if (root == null) {
            return;
        }
 
        inorder(root.getpL());
        System.out.println(root.getId() + " ");
        inorder(root.getpR());
    }
 
    // Función auxiliar para encontrar el nodo de valor máximo en el subárbol enraizado en `ptr`
    public  Nodo findMaximumKey(Nodo ptr)
    {
        while (ptr.getpR() != null) {
            ptr = ptr.getpR();
        }
        return ptr;
    }

    // Función para eliminar un nodo de un BST
    public  Nodo deleteNodo(Nodo proot, int key){
        // si la clave dada es menor que el nodo raíz, se repite para el subárbol izquierdo
        if (key < proot.getId()) {
            proot.setpL(deleteNodo(proot.getpL(), key));
        }
 
        // si la clave dada es mayor que el nodo raíz, se repite para el subárbol derecho
        else if (key > proot.getId()) {
            proot.setpR(deleteNodo(proot.getpR(), key));
//            deleteNodo(proot.getpR(), key);
        }
 
        // Llave encontrada
        else {
            // Caso 1: el nodo a eliminar no tiene hijos (es un nodo hoja)
            if (proot.getpL() == null && proot.getpR() == null){
                // actualizar raíz a nulo
                return null;
            }
 
            // Caso 2: el nodo a eliminar tiene dos hijos
            else if (proot.getpL() != null && proot.getpR() != null)
            {
                // encuentra su nodo predecesor en orden
                Nodo predecessor = findMaximumKey(proot.getpL());
 
                // copia el valor del predecesor al nodo actual
                proot.setId(predecessor.getId());
                proot.setValue(predecessor.getValue());
 
                // elimina recursivamentemente el predecesor. Tenga en cuenta que el
                // el predecesor tendrá como máximo un hijo (hijo izquierdo)
                proot.setpR(deleteNodo(proot.getpL(), predecessor.getId()));
            }
 
            // Caso 3: el nodo a eliminar solo tiene un hijo
            else {
                // elige un nodo hijo
                Nodo child = (proot.getpL() != null) ? proot.getpL(): proot.getpR();
                proot = child;
            }
        }
 
        return proot;
    }
}        
            

