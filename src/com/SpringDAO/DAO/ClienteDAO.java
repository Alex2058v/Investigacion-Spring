package com.SpringDAO.DAO;

import java.util.List;

import com.SpringDAO.entity.Cliente;

/* ¿porque usamos una interface para el DAO?
 * 
 * Las interfaces son utiles en este caso ya que sirven para
 * definir cierto comportamiento que deben cumplir varios componentes
 * en este caso el controlador al nosotros definir esta interfaz
 * establecemos un estandar que la clase clienteDAOclase debe seguir para implementar
 * sus metodos en especial a la hora de reutilizar el codigo
 */


public interface ClienteDAO 
{
	
	// Lista del objeto Cliente para obtener los clientes que se mostraran
   public List<Cliente> getClientes();

   // Metodo que se encarga de insertar el cliente posee un parametro
   //de tipo cliente llamado elCliente que nos sirve cuando se implementa
   // en el controlador para insertar al cliente
public void insertarCliente(Cliente elCliente);

// Nos sirve para obtener un cliente unico usando solo su Id
// luego se debe actualizar pero esa funcionalidad se encuentra
//en la clase clienteDAOclase
public Cliente getCliente(int id);

//Metodo que sirve para eliminar usando el id del cliente
public void eliminarCliente(int id);

//todos estos metodos solo estan definidos en esta interfaz
//se deben implementar desde la clase ClienteDAOclase y luego 
//en el controlador
}
