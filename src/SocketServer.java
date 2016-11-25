import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import br.com.socket.Message;
import br.com.socket.TipoComando;

public class SocketServer {
	
	 public static void main(String args[]) throws ClassNotFoundException{
		 try {
		      // Instancia o ServerSocket ouvindo a porta 12345
		      ServerSocket servidor = new ServerSocket(12345);
		      System.out.println("Servidor ouvindo a porta 12345");
		      while(true) {
		        // o método accept() bloqueia a execução até que
		        // o servidor receba um pedido de conexão
		        Socket cliente = servidor.accept();
		        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
		        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
		        saida.flush();
		        Message message = new Message(1, TipoComando.ALARME);
		        saida.writeObject(message);
		        saida.close();
		        cliente.close();
		        Arduino arduino = new Arduino();
		    	arduino.comunicacaoArduino(message);
		      }
		    }   
		    catch(Exception e) {
		       System.out.println("Erro: " + e.getMessage());
		    }
		    finally {
		    	
		    }
     }
	
}
