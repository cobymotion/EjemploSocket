package servidor;

import java.io.DataInputStream;

public class ProcesoServidor implements Runnable {
     
    DataInputStream leer; 
    
    public ProcesoServidor(DataInputStream leer)
    {
        this.leer = leer; 
    }

    @Override
    public void run() {
        try {
            while(true){
            String cad = leer.readUTF(); 
            System.out.println("Mensaje: " + cad);
            }
        } catch (Exception e) {
            System.out.println("Error al leer datos");
        }
    }
    
}
