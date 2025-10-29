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
			//1er parámetro: si hay transaccion o no
			//2º parámetro: Como se realiza el ACK del mensaje
			QueueSession sesion = qcx.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			//QueueSession sesion = qcx.createQueueSession(false, QueueSession.CLIENT_ACKNOWLEDGE);
			
			//Queue cola = (Queue) ic.lookup("jms/queue/pruebas");
			Queue cola = (Queue) ic.lookup("jms/cola");
			MessageConsumer receptor = sesion.createConsumer(cola);

			//Arrancamos la conexión
			qcx.start(); 
			
			//Para recibir los mensajes:
			System.out.println("Esperando un mensaje...");
			//TextMessage txtMsg = (TextMessage) receptor.receiveNoWait(); //Si no hay mensaje ahora mismo devuelve nulo
			//TextMessage txtMsg = (TextMessage) receptor.receive(10_000); //Sincrono, pero solo esperará 10 segundos. Si no llega un mensaje devuelve nulo
			TextMessage txtMsg = (TextMessage) receptor.receive(); //Sincrono. 
			System.out.println("Mensaje recibido:"+txtMsg.getText());
			
			
			/*
			//Aquí estaríamos procesando los mensajes de uno en uno porque utilizamos un hilo para todo el proceso
			ProcesadorMensaje pm = new ProcesadorMensaje();
			while(true) {
				txtMsg = (TextMessage) receptor.receive(); //Sincrono.
				pm.procesarMensaje(txtMsg.getText());
			}
			*/

			/*
			ProcesadorMensaje pm = new ProcesadorMensaje();
			while(true) {
				if (hay hilo en el pool) {
					txtMsg = (TextMessage) receptor.receive(); //Sincrono.
					//Obtener un hilo del pool para ejecutar la llamada
					pm.procesarMensaje(txtMsg.getText());
				}
			}
			*/
			
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

class ProcesadorMensaje {
	public void procesarMensaje(String texto) {
	}
}




