package com.curso.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.curso.modelo.negocio.GestorPedidos;


@MessageDriven(
			/*
			activationConfig = {
					@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:jms/topic"),
					@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic") 
			},*/ 
			activationConfig = {
					@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:jms/cola"),
					@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") 
			}/*, 
			mappedName = "jms/queue/pruebas"
			*/
		)
public class ReceptorPedidos implements MessageListener {

	@EJB
	private GestorPedidos gestorPedidos;

	public ReceptorPedidos() {
	}

	public void onMessage(Message message) {

		TextMessage txtMsg = (TextMessage) message;

		try {
			gestorPedidos.procesarPedido(txtMsg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	

}
