import br.com.socket.Message;
import br.com.socket.TipoComando;

public class Arduino {
  private ControlePorta arduino;
  
  public Arduino(){
      arduino = new ControlePorta("COM3",9600);//Windows - porta e taxa de transmissão
      //arduino = new ControlePorta("/dev/ttyUSB0",9600);//Linux - porta e taxa de transmissão
  }    

  public void comunicacaoArduino(Message message) {        
    if(message.getComando() == TipoComando.LAMPADA){
      arduino.enviaDados(message.getValor());
      System.out.println(message.getValor());
    }
    else{
      arduino.close();
      System.out.println("Fechado");
    }
  }
}
