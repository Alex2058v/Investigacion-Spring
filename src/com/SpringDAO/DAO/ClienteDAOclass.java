package com.SpringDAO.DAO;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.query.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringDAO.entity.Cliente;

/*
 * La anotacion @Repository es lo que nos define que este es un DAO
 * (Objeto de acceso a Datos) e indica que este objeto va a interactuar 
 * con nuestra fuente de datos en este caso la base de datos
 */
@Repository
public class ClienteDAOclass implements ClienteDAO
{

	@Override
	@Transactional
	public List<Cliente> getClientes() {
		
		//Obtenemos la session
		
		Session miSession = sessionFactory.getCurrentSession();
		
		//Creamos la consulta a la base de datos usando la clase Cliente
		
		Query<Cliente> miQuery=miSession.createQuery("from Cliente",Cliente.class);
		
		//Ejecutamos la Query y guardamos el resultado en la lista Cliente
		
		List<Cliente>clientes=miQuery.getResultList();
		
		//Retornamos la lista clientes
		return clientes;
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void insertarCliente(Cliente elCliente) 
	{
		//Obtener la session
		
		Session miSession = sessionFactory.getCurrentSession();
		
		
		//Insertar el cliente alfin
	  //Usar el metodo saveOrUpdate para que actualice si esta cargado el id
		// y que inserte si no esta cargado
		miSession.saveOrUpdate(elCliente);
		
	}

	@Override
	@Transactional
	public Cliente getCliente(int id) 
	{
	     //Obtener la sesion
		
		Session miSession = sessionFactory.getCurrentSession();
		
		//Obtener la info del cliente seleccionado
	    
		Cliente elCliente=miSession.get(Cliente.class,id);
		
		return elCliente;
	}

	@Override
	@Transactional
	public void eliminarCliente(int id) 
	{
		//Obtener la sesion
		Session miSession = sessionFactory.getCurrentSession();
		
		//Borrar el cliente de la base de gatos utilizando su Id como criterio
		
		Query consulta = miSession.createQuery("delete from Cliente where id=:IdDelCliente");
		
		consulta.setParameter("IdDelCliente",id);
		consulta.executeUpdate();
	}
}
