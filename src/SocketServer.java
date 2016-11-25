import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;

import com.sun.istack.internal.logging.Logger;

import br.com.socket.Message;
import br.com.socket.TipoComando;

public class SocketServer {
	
	 public static void main(String args[]) throws ClassNotFoundException{
		 try {
		      // Instancia o ServerSocket ouvindo a porta 12345
		      ServerSocket servidor = new ServerSocket(12345);
		      System.out.println("Servidor ouvindo a porta 12345");
		      while(true) {
		        // o m�todo accept() bloqueia a execu��o at� que
		        // o servidor receba um pedido de conex�o
		        Socket cliente = servidor.accept();
		        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
		        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
		        saida.flush();
		        Message message = new Message(1, TipoComando.ALARME);
		        saida.writeObject(message);
		        saida.close();
		        cliente.close();
		      }  
		    }   
		    catch(Exception e) {
		       System.out.println("Erro: " + e.getMessage());
		    }
		    finally {
		    	
		    }
     }
	
}
