package com.example.shoestore.model;

import com.example.shoestore.excepcion.ErrorExcepcion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "cliente")
public class cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente", nullable = false, length = 36)
    private String idCliente;

    @Column(name = "tipo_de_identificacion", nullable = false, length = 2)
    private String tipoDeIdentificacion;

    @Column(name = "numero_de_identificacion", nullable = false, length = 10)
    private String numeroDeIdentificacion;

    @Column(name = "nombre_cliente", nullable = false, length = 45)
    private String nombreCliente;

    @Column(name = "apellido_cliente", nullable = false, length = 45)
    private String apellidoCliente;

    @Column(name = "telefono", nullable = false, length = 13)
    private String telefono;

    @Column(name = "direccion", nullable = false, length = 45)
    private String direccion;

    @Column(name = "ciudad", nullable = false, length = 45)
    private String ciudad;

    @Column(name = "correo_electronico", nullable = false, length = 100)
    private String correoElectronico;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private EstadoCliente estado;

	public cliente() {
		super();
	}

	
	public void agregarCliente() {
	    if (tipoDeIdentificacion == null || tipoDeIdentificacion.isEmpty()) {
	        throw new ErrorExcepcion("El campo tipo de identificación no debe estar vacío");
	    }
	    if (numeroDeIdentificacion == null || numeroDeIdentificacion.length() < 5 || numeroDeIdentificacion.length() > 11) {
	        throw new ErrorExcepcion("El campo número de identificación debe tener de 5 a 11 caracteres");
	    }
	    if (nombreCliente == null || nombreCliente.length() < 3 || nombreCliente.length() > 30) {
	        throw new ErrorExcepcion("El campo nombre cliente debe tener de 3 a 30 caracteres");
	    }
	    if (apellidoCliente == null || apellidoCliente.length() < 3 || apellidoCliente.length() > 30) {
	        throw new ErrorExcepcion("El campo apellido cliente debe tener de 3 a 30 caracteres");
	    }
	    if (telefono == null || telefono.length() != 10) {
	        throw new ErrorExcepcion("El campo teléfono debe tener 10 caracteres");
	    }
	    if (estado == null) {
	        throw new ErrorExcepcion("El campo estado no debe ser nulo");
	    }
	}
	
	
	public cliente(String idCliente, String tipoDeIdentificacion, String numeroDeIdentificacion, String nombreCliente,
			String apellidoCliente, String telefono, String direccion, String ciudad, String correoElectronico,
			EstadoCliente estado) {
		super();
		this.idCliente = idCliente;
		this.tipoDeIdentificacion = tipoDeIdentificacion;
		this.numeroDeIdentificacion = numeroDeIdentificacion;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.telefono = telefono;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.correoElectronico = correoElectronico;
		this.estado = estado;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getTipoDeIdentificacion() {
		return tipoDeIdentificacion;
	}

	public void setTipoDeIdentificacion(String tipoDeIdentificacion) {
		this.tipoDeIdentificacion = tipoDeIdentificacion;
	}

	public String getNumeroDeIdentificacion() {
		return numeroDeIdentificacion;
	}

	public void setNumeroDeIdentificacion(String numeroDeIdentificacion) {
		this.numeroDeIdentificacion = numeroDeIdentificacion;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public EstadoCliente getEstado() {
		return estado;
	}

	public void setEstado(EstadoCliente estado) {
		this.estado = estado;
	}


	public void validarCliente() {
		// TODO Auto-generated method stub
		
	}
}
