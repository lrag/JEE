


import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EmisorCola {

	public static void main(String[] args) {
		
		//activemq start
		//http://127.0.0.1:8161/admin/
		//login:admin
		//pw   :admin
		
		
		Context ic = null;
		try {
			ic = new InitialContext();
			
			//Añadir el usuario con el rol guest			
			//Entries:
			//java:/jms/cola 
			//java:jboss/exported/jms/cola	
			
			QueueConnectionFactory queueConnFac = 
				(QueueConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
			
			QueueConnection qcx = queueConnFac.createQueueConnection("user", "useruser"); 
			//1er parámetro: si hay transaccion o no
			//2º  parámetro: Como se realiza el ACK del mensaje
			QueueSession sesion = qcx.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			//QueueSession sesion = qcx.createQueueSession(false, QueueSession.CLIENT_ACKNOWLEDGE);
			
			//Queue cola = (Queue) ic.lookup("jms/queue/pruebas");
			Queue cola = (Queue) ic.lookup("jms/cola");
			MessageProducer productor = sesion.createProducer(cola);

			//Arrancamos la conexón
			qcx.start();
			
			//Para enviar los mensajes necesitamos la sesion y el productor
			TextMessage txtMsg = sesion.createTextMessage("HOLA RADIOLA");
			productor.send(txtMsg);
			
			System.out.println("Mensaje enviado");
			
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
