package com.SpringDAO.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * el @Entity nos indica que esta clase es una entidad es una anotacion
 * de JPA para la persistencia de los datos y poder mapearlos en este caso usamos hibernate
 * 
 * @table esta anotacion es de JPA
 * nos permite mapear objetos a tablas en este caso nuestra tabla cliente en este caso por usar
 * hibernate se nos permite usar estas anotaciones
 */

@Entity
@Table(name="cliente")
public class Cliente 
{
	
	
	
	//Constructor por defecto
	public Cliente() 
	{
	}
	
	
	
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + "]";
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



	//el Id es auto Incemental y se define con @Id y para que sea autoIncrement
	//Utilizamos el GeneratedValue luego usamos @Column y nombrarla igual a como esta esa columna
	//en la base de gatos.
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="email")
	private String email;
	
	

}
