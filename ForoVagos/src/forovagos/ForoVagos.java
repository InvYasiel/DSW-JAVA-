/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forovagos;
import java.util.Scanner;
/**
 *
 * @author yasie
 */
public class ForoVagos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        menu();
    }
    
    //Menu principal
    static void menu(){
        Scanner reader = new Scanner(System.in);
        int opcion = 0;
        do{
        System.out.println("==============FOR VAGOS==============");
        System.out.println("Échese una siestita mientras nosotros buscamos");
        System.out.println("1. Busque por localidad");
        System.out.println("1. Mostrar toda la lista de Hoteles");
        System.out.println("0. Salir");
        System.out.println("--------------------");
        System.out.println("9. Admin");
        System.out.println("Introduzca opción:");
        opcion = reader.nextInt();
        switch(opcion){
        case 1:
        
        FilePersistence.busqueda();
        break;
        
        case 2:
        FilePersistence.listar();
        
        break;
        case 9:
        menuAdmin();
        }
        
        }
        while (opcion != 0); 
        

        
    }
    //menu del administrador
    static void menuAdmin(){
        Scanner reader = new Scanner(System.in);
        int opcion = 0;
        do{
        System.out.println("==============FOR VAGOS==============");
        System.out.println("1. Añadir hotel");
        System.out.println("2. Borrar hotel");
        System.out.println("0. Salir");
        System.out.println("Introduzca opción: ");
        opcion = reader.nextInt();
        switch(opcion){
        case 1:
        FilePersistence.escritura();
        break;
        
        case 2:
        FilePersistence.borrar();
        break;
        }
        
        }
        while (opcion != 0);
    }
    
}
