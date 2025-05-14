package com.curso.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.negocio.ServicioClientes;

@WebServlet("/SVClientes")
public class SVClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ServicioClientes servicioClientes = new ServicioClientes();
	
    public SVClientes() {
        super();
    }
    
    //GET usado para lo sigiente
    //Cancelar (verListado)
    //Nuevo, Vaciar (verFormulario)
    //Seleccionar.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accion = request.getParameter("accion");
		
		String siguienteVista = "listadoClientes.jsp";
		//Si pulsamos el boton nuevo
		if("verFormulario".equals(accion)){			
			siguienteVista = "formularioClientes.jsp";
		} else if("seleccionar".equals(accion)){	
			Cliente clienteSel = servicioClientes.buscar(Integer.parseInt(request.getParameter("idCliente")));
			request.setAttribute("clienteSel", clienteSel);			
			siguienteVista = "formularioClientes.jsp";
		} 	
		
		//Si lo que tenemos que mostrar es la lista de clientes, habrá que acceder a la base de datos para buscarlos
		if(siguienteVista.equals("listadoClientes.jsp")){
			List<Cliente> clientes = servicioClientes.listar(0,20);
			request.setAttribute("listadoClientes", clientes);
			
		} else if(siguienteVista.equals("formularioClientes.jsp")){
			//
		}		
		
		request.getRequestDispatcher(siguienteVista).
			forward(request,response);		
	}
	
	//POST usado para lo siguiente
	//Insertar
	//Modificar
	//Borrar
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Recoger los parámetros y hacer una primera conversion
		//de String al tipo adecuado		
		Integer id = null;
		try {
			//El id del cliente a insertar, modificar o borrar nos vendra informado en idCliente
			id = Integer.parseInt(request.getParameter("idCliente"));
		} catch (NumberFormatException e) {
			//e.printStackTrace();
		}		
		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		
		//Construir objetos del modelo con los parametros recibidos
		Cliente c = new Cliente(id, nombre, direccion, telefono);
		
		//Validar los objetos
		//...
		
		//Averiguar que nos están pidiendo
		String accion = request.getParameter("accion");
		//Llamar al método de negocio adecuado segun la acción
		switch(accion) {
		case "insertar" : 
				servicioClientes.insertar(c);
				break;
			case "modificar" :
				servicioClientes.modificar(c);
				break;
			case "borrar" :
				servicioClientes.borrar(c);
				break;			
		}

		//Despues de una petición post se hace un redirect.
		//Si se está usando MVC no se puede hacer un redirect a una vista
		//Se hace un redirect al controlador que muestre la vista que nos 
		//interesa
		//GET SVClientes
		response.sendRedirect("SVClientes");
	
	}

}





