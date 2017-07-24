package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import servidor.ProcesoServidor;

public class Cliente {
    
    public static void main(String[] args) {
        System.out.println("Iniciando cliente");
        try {
            Socket sc = new Socket("127.0.0.1",5000); 
            
            DataOutputStream salida = new 
                 DataOutputStream(sc.getOutputStream()); 
            DataInputStream entrada  = new 
                 DataInputStream(sc.getInputStream());
            
            ProcesoServidor ps = new ProcesoServidor(entrada); 
            Thread hilo = new Thread(ps);
            hilo.start();
            
            String cad = "" ;
            do { 
                cad = JOptionPane.showInputDialog("Mensaje");
            salida.writeUTF(cad);
            }while(!cad.equals("salir"));

            System.out.println("Se conecto");
        } catch (Exception e) {
            System.out.println("Error al conectar");
            e.printStackTrace();
        }
    }
    
}
