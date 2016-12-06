import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.socket.Message;
import br.com.socket.TipoComando;

public class SocketServer {
	
	 public static void main(String args[]) throws ClassNotFoundException{
		 
		 Arduino arduino = new Arduino();
		 try {
		      // Instancia o ServerSocket ouvindo a porta 12345
		      ServerSocket servidor = new ServerSocket(9080);
		      System.out.println("Servidor ouvindo a porta 9080");
		      while(true) {
		        // o método accept() bloqueia a execução até que
		        // o servidor receba um pedido de conexão
		        Socket cliente = servidor.accept();
		        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
		        ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
		        Message message = (Message)entrada.readObject();
		        System.out.println(message.getValor());
		        cliente.close();
		    	  
		    	//Message message = new Message(0, TipoComando.LAMPADA);
		    	try{  
		    		arduino.comunicacaoArduino(message);
		    	}catch(Exception e){
		    		
		    	}
		      }
		    }   
		    catch(Exception e) {
		       System.out.println("Erro: " + e.getMessage());
		    }
		    finally {
		    	
		    }
     }
	
}
