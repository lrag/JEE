package com.curso;


import java.awt.Rectangle;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.curso.modelo.negocio.ServicioPedidosRemoto;

public class VentanaPedidos extends JFrame {

	private ServicioPedidosRemoto gestorPedidos;
	
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton jBConectar = null;
	private JButton jBDesconectar = null;
	private JLabel jLabel = null;
	private JTextField jTFProducto = null;
	private JButton jBAdd = null;
	private JList jLCesta = null;

	public VentanaPedidos() {
		super();
		initialize();
	}

	private void initialize() {
		this.setSize(350, 319);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(8, 38, 69, 28));
			jLabel.setText("Producto");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJBConectar(), null);
			jContentPane.add(getJBDesconectar(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJTFProducto(), null);
			jContentPane.add(getJBAdd(), null);
			jContentPane.add(getJLCesta(), null);
		}
		return jContentPane;
	}

	private JButton getJBConectar() {
		if (jBConectar == null) {
			jBConectar = new JButton();
			jBConectar.setBounds(new Rectangle(10, 7, 119, 24));
			jBConectar.setText("Conectar");
			jBConectar.addActionListener(e -> conectar());
		}
		return jBConectar;
	}

	private JButton getJBDesconectar() {
		if (jBDesconectar == null) {
			jBDesconectar = new JButton();
			jBDesconectar.setBounds(new Rectangle(130, 7, 249, 24));
			jBDesconectar.setText("Desconectar");
			jBDesconectar.addActionListener(e -> desconectar());
		}
		return jBDesconectar;
	}	
	
	protected void desconectar() {		
		gestorPedidos.remove();
	}

	private JTextField getJTFProducto() {
		if (jTFProducto == null) {
			jTFProducto = new JTextField();
			jTFProducto.setBounds(new Rectangle(80, 41, 181, 26));
		}
		return jTFProducto;
	}

	private JButton getJBAdd() {
		if (jBAdd == null) {
			jBAdd = new JButton();
			jBAdd.setBounds(new Rectangle(263, 40, 71, 25));
			jBAdd.setText("Añadir");
			jBAdd.addActionListener(e -> add());
		}
		return jBAdd;
	}

	private JList getJLCesta() {
		if (jLCesta == null) {
			jLCesta = new JList();
			jLCesta.setBounds(new Rectangle(8, 71, 326, 206));
		}
		return jLCesta;
	}
	
	private void conectar(){
		
		final Hashtable<String, String> jndiProperties = new Hashtable<>();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");		
		
		Context ic = null;
		try {
			ic = new InitialContext(jndiProperties);
			gestorPedidos = (ServicioPedidosRemoto) ic.lookup("ejb:Ej09_EJB_EAR-0.0.1-SNAPSHOT/Ej09_EJB_Modelo/ServicioPedidos!com.curso.modelo.negocio.ServicioPedidosRemoto?stateful");
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				ic.close();
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void add(){
		
		String producto = jTFProducto.getText();		
		
		if(gestorPedidos.addProducto(producto)){
			jTFProducto.setText("");
			rellenarLista();
		} else {
			JOptionPane.showMessageDialog(this, "El nombre del producto no empieza por 'EJB'");
		}
	}
	
	private void rellenarLista(){	
		List<String> productos = gestorPedidos.listarCesta();
		jLCesta.setListData(productos.toArray());
		
	}
	
	public static void main(String[] args) {
		
		VentanaPedidos vp = new VentanaPedidos();
		vp.setVisible(true);
				
	}

}  













