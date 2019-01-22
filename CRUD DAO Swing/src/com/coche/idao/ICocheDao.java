package com.coche.idao;

import java.util.List;

import com.coche.model.Coche;

public interface ICocheDao {
	public List<Coche> obtenerClientes();

	public Coche obtenerCliente(int id);

	public void actualizarCliente(Coche cliente);

	public void eliminarCliente(Coche cliente);
}
