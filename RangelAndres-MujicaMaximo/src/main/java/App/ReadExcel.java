package App;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
public class ReadExcel {
    private String ruta;

    public ReadExcel() {
    }
    
    public Object[] ReadFile(){
        Object[] output = new Object[4];
        
        
        return output;
    }
    
    public String SelectFile(){
        
        Scanner entrada = null;
        JFileChooser fileChooser = new JFileChooser();
        
        int valor = fileChooser.showOpenDialog(fileChooser);
        
        if (valor == JFileChooser.APPROVE_OPTION) {
            ruta = fileChooser.getSelectedFile().getAbsolutePath();
            System.out.println(ruta);
            String[] confirmation = ruta.split("\\.");
            if("xlsx".equals(confirmation[confirmation.length-1].replace(" ", ""))){
                   return ruta;
                } else {
                    System.out.println("No se ha seleccionado ningún archivo xlsx");
                }
            }
        else{
                    System.out.println("No se ha seleccionado ningún archivo");
            }
        return ruta;
        }
    
    }
