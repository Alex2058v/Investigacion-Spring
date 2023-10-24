package com.SpringDAO.controller;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringDAO.DAO.ClienteDAO;
import com.SpringDAO.entity.Cliente;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class Controlador 
{
	
	/*
	 * En el controlador tenemos todos los metodos que redirigen a las vistas
	 * A su vez tambien tenemos en cada metodo importante como: Insertar,
	 * Actualizar,Eliminar. Un Objeto clienteDAO que implementa de una interface
	 * clienteDAO el metodo insertarCliente(Este sirve para ambos insertar y actualizar),
	 * eliminarCliente. 
	 * 
	 * 
	 * El parametro Model elModelo nos sirve para pasar datos a la vista desde el controlador 
	 * en este caso fue utilizado para recuperar las listas de clientes
	 * la informacion de los text box en actualizar.se debe usar 
	 * addAtribute para mandar los datos a la vista
	 * 
	 * @RequestMapping  nos permite hacer la redireccion en el Url
	 * como haciamos con los servlets pero en este caso es mucho mas
	 * facil ya que solo es cuestion de agregar dicha sentencia y un nombre 
	 * como /cliente o el que gustes y ya podrias usar el controlador ayudado por
	 * las otras anotaciones como getMapping o PostMapping
	 * 
	 * 
	 * @GetMapping esta anotacion nos permite manejar datos por medio del Get
	 * es una variante de @RequestMapping por lo que aparte de esta funcionalidad
	 * tambien se le puede asignar un nombre para redirigir mediante el url
	 * 
	 * @PostMapping esta anotacion nos permite manejar datos por medio del POST
	 * es una variante de @RequestMapping por lo que aparte de esta funcionalidad
	 * tambien se le puede asignar un nombre para redirigir mediante el url
	 * 
	 * @Transactional es una anotacion que nos sirve para marcar clases como 
	 * transacciones esto quiere decir que los que son anotados con esta se gestionan
	 * dentro de una transaccion de base de datos, lo util de esto es que spring se encarga
	 * de forma automatica en administrar la transaccion una vez el metodo inicia
	 * 
	 * @AutoWired sin mas sirve para inyectar dependencias
	 * con esta anotacion spring inyectara las dependencias
	 * que una clase requiere de forma automatica
	 */
	
	@GetMapping("/eliminar")
	public String Eliminar(@RequestParam("clienteId") int Id) 
	{
		
		//Eliminando cliente
		
		clienteDAO.eliminarCliente(Id);
		
		// Redireccionar a la lista de clientes
		return "redirect:/cliente/lista";
	}
	
	
	@GetMapping("/muestraFormularioActualizar")	
	public String muestraFormularioActualizar(@RequestParam("clienteId") int Id,Model elModelo) 
	{
		//Obtener el cliente cuyo id le pasamos por el parametro
		
		Cliente elCliente = clienteDAO.getCliente(Id);
		
		//Establecer el cliente como atributo del modelo
		
		elModelo.addAttribute("cliente",elCliente);
		//Enviar al formulario
		
		
		return "Actualizar-Clientes";
	}
	
	
	
	
	@RequestMapping("/insertarClientes")
	public String insertarClientes(Model elModelo) 
	{
		//bind de datos de clientes
		Cliente elCliente = new Cliente();
		
		elModelo.addAttribute("cliente",elCliente);
		return "Insertar-Clientes";
	}
	
	@PostMapping("/insertarCliente")
	public String insertarCliente(@ModelAttribute("cliente") Cliente elCliente) 
	{
		
		//insertar cliente en base de gatos
		clienteDAO.insertarCliente(elCliente);
		
		return "redirect:/cliente/lista";
	}
	
	
	
	@RequestMapping("/lista")
	public String listaClientes(Model elModelo) 
	{
		//Obtener los clientes desde el DAO
		
		List<Cliente>losClientes = clienteDAO.getClientes();
		
		// Agregar los clientes al modelo
		
		elModelo.addAttribute("clientes",losClientes);
		
		
		return "lista-clientes";
	}
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	
	

}
