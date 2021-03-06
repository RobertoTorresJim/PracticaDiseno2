package mx.uam.is.practicadiseno.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MapeadorDatosAlmacena implements MapeadorDatos {
	
	private List <String> datos = new ArrayList <String> ();


	@Override
	public boolean agrega(String dato) {
		// TODO Auto-generated method stub
		if(!dato.equals("") && !datos.contains(dato)) {
			datos.add(dato);
			FileWriter fichero = null;
	        PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter("prueba.txt",true);
	            pw = new PrintWriter(fichero);

	                pw.println(dato);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           // Nuevamente aprovechamos el finally para 
	           // asegurarnos que se cierra el fichero.
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
			return true;
		}
		return false;
	}

	@Override
	public boolean borra(String dato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] dameDatos(){
		// TODO Auto-generated method stub
		
	      FileReader fr = null;
	      BufferedReader br = null;
		
		try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
			File archivo = new File("prueba.txt");
	         fr = new FileReader ("prueba.txt");
	         br = new BufferedReader(fr);

	         // Lectura del fichero
	         String linea;
	         while((linea=br.readLine())!=null)
	            datos.add(linea);
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
		String arregloDatos [] = new String[datos.size()];
		datos.toArray(arregloDatos);
		return arregloDatos;
	}

	@Override
	public boolean contiene(String dato) {
		// TODO Auto-generated method stub
		return false;
	}

}
