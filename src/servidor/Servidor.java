package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Servidor {

    public static void main(String[] args) {
        try {
            ServerSocket sc = new ServerSocket(5000);
            Socket sket = sc.accept();
            /// creando flujos 
            DataOutputStream salida = new DataOutputStream
                                    (sket.getOutputStream());
            DataInputStream entrada  = new 
                    DataInputStream(sket.getInputStream());
            
            ProcesoServidor ps = new ProcesoServidor(entrada); 
            Thread hilo = new Thread(ps); 
            hilo.start();
            
            String cad = ""; 
            do {
                cad = JOptionPane.showInputDialog("Mensaje");
                salida.writeUTF(cad);
            }while(!cad.equals("salir"));            
            /// + +++ + + ++ + + + ++ + ++ + ++ +
            System.out.println("Termino el programa");
        } catch (Exception e) {
            System.out.println("No es posible conectar");
            e.printStackTrace();
        }
    }

}
