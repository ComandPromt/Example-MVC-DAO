package com.ejemplo.idao;

import java.util.List;

import com.ejemplo.model.Cliente;

public interface IClienteDao {
	public List<Cliente> obtenerClientes();

	public Cliente obtenerCliente(int id);

	public void actualizarCliente(Cliente cliente);

	public void eliminarCliente(Cliente cliente);
}
