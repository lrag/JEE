import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthOptionPaneUI;


public class ReceptorMessageListener implements MessageListener {
	
	public void conectar(){
		
		Context ic = null;
		try {
			ic = new InitialContext();

			QueueConnectionFactory queueConnFac = (QueueConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
			QueueConnection qcx = queueConnFac.createQueueConnection("user","useruser"); 
			//1er parámetro: si hay transaccion o no
			//2º parámetro: Como se realiza el ACK del mensaje
			QueueSession sesion = qcx.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			
			//Queue cola = (Queue) ic.lookup("jms/queue/pruebas");
			Queue cola = (Queue) ic.lookup("jms/cola");
			MessageConsumer receptor = sesion.createConsumer(cola);

			receptor.setMessageListener(this);
			
			//Arrancamos la conexón
			qcx.start(); 

			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void onMessage(Message msg) {

		TextMessage txtMsg = (TextMessage) msg;
		try {
			System.out.println("Mensaje recibido:"+txtMsg.getText());
			System.out.println("Hilo onMessage: "+Thread.currentThread().getName());
			Thread.sleep(1_000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Hilo main: "+Thread.currentThread().getName());
		ReceptorMessageListener rml = new ReceptorMessageListener();
		rml.conectar();
		
		JOptionPane.showMessageDialog(null, ".oOo.oOo.oOo.");
		
	}

}
