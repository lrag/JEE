import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ReceptorCola {

	public static void main(String[] args) {
		
		Context ic = null;
		
		try {
			ic = new InitialContext();

			QueueConnectionFactory queueConnFac = (QueueConnectionFactory) ic.lookup("jms/RemoteConnectionFactory"); 

			QueueConnection qcx = queueConnFac.createQueueConnection("user","useruser"); 
			//1er par�metro: si hay transaccion o no
			//2� par�metro: Como se realiza el ACK del mensaje
			QueueSession sesion = qcx.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			//QueueSession sesion = qcx.createQueueSession(false, QueueSession.CLIENT_ACKNOWLEDGE);
			
			Queue cola = (Queue) ic.lookup("jms/queue/pruebas");
			MessageConsumer receptor = sesion.createConsumer(cola);

			//Arrancamos la conexi�n
			qcx.start(); 
			
			//Para recibir los mensajes:
			TextMessage txtMsg = (TextMessage) receptor.receive(); //Sincrono
			System.out.println("Mensaje recibido:"+txtMsg.getText());
			
			//txtMsg.acknowledge();
			
			sesion.close();
			qcx.close();
						
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				ic.close();
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	}
}
