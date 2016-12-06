import br.com.socket.Message;
import br.com.socket.TipoComando;

public class Arduino {
  private ControlePorta arduino;
  
  public Arduino(){
      arduino = new ControlePorta("COM3", 9600);//Windows - porta e taxa de transmissão
      //arduino = new ControlePorta("/dev/ttyUSB0",9600);//Linux - porta e taxa de transmissão
  }    

  public void comunicacaoArduino(Message message) {        
    if(message.getComando() == TipoComando.LAMPADA){
    	if (message.getValor() == 1){
    		arduino.enviaDados(1);
    		System.out.println(message.getValor());
    	}else if(message.getValor() == 0){
    		arduino.enviaDados(2);
    		System.out.println(message.getValor());
    	}
    }
    else if (message.getComando() == TipoComando.ALARME){
    	if(message.getValor() == 1){
    		arduino.enviaDados(3);
    		System.out.println(message.getValor());
    	}else if (message.getValor() == 0){
    		arduino.enviaDados(4);
    		System.out.println(message.getValor());
    	}
    }
    
    //arduino.close();
  }
}
