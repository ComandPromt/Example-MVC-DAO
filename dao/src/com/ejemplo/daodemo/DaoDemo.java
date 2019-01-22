package com.ejemplo.daodemo;

import com.ejemplo.dao.ClienteDaoImpl;
import com.ejemplo.idao.IClienteDao;
import com.ejemplo.model.Cliente;

public class DaoDemo {
	public static void main(String[] args) {
		IClienteDao clienteDao = new ClienteDaoImpl();
		clienteDao.obtenerClientes().forEach(System.out::println);

		Cliente cliente = clienteDao.obtenerCliente(0);
		cliente.setApellido("Pardo");
		clienteDao.actualizarCliente(cliente);

		System.out.println("***********");
		clienteDao.obtenerClientes().forEach(System.out::println);
	}
}
