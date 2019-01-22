package com.ejemplo.mvc;

import com.ejemplo.controller.ClienteController;
import com.ejemplo.model.Cliente;
import com.ejemplo.view.ClienteView;

public class MvcDemo {
	public static void main(String[] args) {
		Cliente modelo = llenarDatosCliente();
		ClienteView vista = new ClienteView();

		ClienteController controlador = new ClienteController(modelo, vista);
		controlador.actualizarVista();
		controlador.setNombre("Luis");
		controlador.actualizarVista();
	}

	private static Cliente llenarDatosCliente() {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setNombre("Elivar");
		cliente.setApellido("Largo");
		return cliente;
	}
}
