/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forovagos;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author yasie
 */
public class FilePersistence {
    public static void main(String [] arg) {
    }
    
    //FUNCION PARA BUSCAR POR LOCALIDAD
    static void busqueda(){
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      try {
         //ABRIMOS EL FICHERO Y LO LEEMOS
         archivo = new File ("src\\forovagos\\Hoteles.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
         String linea;
         //INTRODUCIMOS LA LOCALIDAD A BUSCAR 
         Scanner dc = new Scanner(System.in);
         System.out.println("Introduce Localidad");
         String localidad = dc.nextLine();
         
         while((linea=br.readLine())!=null)
         //CONDICION PARA ENCONTRAR LA LINEA IGUAL A LA LOCALIDAD INTRODUCIDA
         if(linea.equals(localidad)){
             String Nombre;
             Nombre = br.readLine();
             int estrellas;
             estrellas = Integer.parseInt(br.readLine());
             int precio;
             precio = Integer.parseInt(br.readLine());
             //SACAMOS EL NOMBRE DEL HOTEL LAS ESTRELLAS Y EL PRECIO
             System.out.println(Nombre + " " + estrellas + " Estrellas " +"el precio por noche es de "+ precio + " Euros \n");
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
   }
    
    //FUNCION PARA BORRAR LINEAS DE UN FICHERO
    static void borrar(){
        try {
 //BUSCAMOS EL FICHERO
        File inFile = new File("src\\forovagos\\Hoteles.txt");
 
        if (!inFile.isFile()) {
            System.out.println("no hay archivo");
            return;
        }
 
        //CONSTRUYE UN NUEVO ARCHIVO QUE MÁS TARDE SE LE PONDRÁ EL NOMBRE ORIGINAL
        File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
        BufferedReader br = new BufferedReader(new FileReader("src\\forovagos\\Hoteles.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
        //PEDIMOS EL NOMBRE DEL HOTEL A BORRAR
        Scanner dc = new Scanner(System.in);
        System.out.println("Introduce Hotel");
        String Hotel = dc.nextLine();
        String line = null;
        
       //BORRAMOS EL HOTEL LAS ESTRELLAS Y EL PRECIO POR NOCHE
        int borrarlineas = 3;
        //borrar lineas desactivado
        boolean borrarOK = false;
        while ((line = br.readLine()) != null) {
            //cuando entra y es igual a Hotel activamos borrar lineas
            if(line.trim().equals(Hotel)){
                borrarOK = true;
            }
            //imprime las lineas que vamos a borrar
            if(!borrarOK){
                pw.println(line);
                pw.flush();
            }else{//resta la cantidad de lineas a borrar hasta que sea igual 0 y devuelve a falso borrar lineas y 
                //vuelve a establecer la cantidad
                borrarlineas--;
                if(borrarlineas == 0){
                    borrarOK = false;
                    borrarlineas = 3;
                }
            }
        }
        
        pw.close();
        br.close();
 
        //ELIMINAR EL ARCHIVO ORIGINAL
        if (!inFile.delete()) {
            System.out.println("No se ha podido eliminar el fichero");
            return;
        }
 
        //lE PONEMOS EL NOMBRE DEL ARCHIVO ORIGINAL
        if (!tempFile.renameTo(inFile)){
            System.out.println("No se a podido renombrar el fichero");
 
        }
    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    }
    
    //FUNCIÓN QUE MUESTRA TODO EL FICHERO 
    static void listar(){
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      try {
         //ABRIMOS EL FICHERO Y LEEMOS CON BUFFEREDREADER.
         archivo = new File ("src\\forovagos\\Hoteles.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         //LECTURA DEL FICHER
         String linea;
         while((linea=br.readLine())!=null)
            System.out.println(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         //CERRAMOS EL FICHERO
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
   }
//FUNCION QUE ESCRIBE AL FINAL DEL FICERO
    static void escritura(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            //ABRIMOS EL FICHERO, SI NO EXISTE SE CREA, LO PONEMOS A 
            //TRUE PARA QUE SI EXISTE NO LO BORRE Y LO VUELVA A CREAR CON LOS DATOS QUE INTRODUCIREMOS LUEGO
            fichero = new FileWriter("src\\forovagos\\Hoteles.txt",true);
            pw = new PrintWriter(fichero);
            //PEDIMOS LO QUE VAMOS A AÑADIRLE AL FICHERO
            Scanner dc = new Scanner(System.in);
           
                System.out.println("Nombre de la Localidad a añadir");
                String Localidad = dc.nextLine();
                System.out.println("Nombre del Hotel a añadir");
                String Hotel = dc.nextLine();
                System.out.println("Numero de las estrellas");
                int Estrellas = dc.nextInt();
                System.out.println("Precio por noche");
                int Precio = dc.nextInt();
                //INTRODUCIMOS EN EL FICHERO LO PEDIDO HACIENDO UN SALTO DE LINEA 
                //(EN EL BLOCK DE NOTAS SALDRÁ 
                //EN UNA SOLA LINEA AUNQUE SI LO ABRIMOS CON OTRO EDITOR COMPROVAREMOS
                //QUE ESTÁ CON VARIOS SALTOS DE LINEA)
                pw.println("\n"+Localidad + "\n" + Hotel +"\n"+ Estrellas +"\n"+ Precio);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           //CERRAMOS FICHERO
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    
    }
    
    
}
