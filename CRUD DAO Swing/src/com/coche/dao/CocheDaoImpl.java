package com.coche.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CocheDaoImpl {
	public static Connection conectarbd() {
		try {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				System.out.println("Error al registrar el driver de MySQL: " + ex);
			}
			Connection connection = null;

			connection = DriverManager.getConnection("jdbc:mysql://localhost/usuarios", "root", "rootroot");

			return connection;
		} catch (java.sql.SQLException sqle) {
			return null;

		}

	}

	public static void insertarCoche(String nombre, int precio, String fecha) throws ParseException, SQLException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date date = dateFormat.parse(fecha);
		long time = date.getTime();

		Statement statement = conectarbd().createStatement();

		statement.executeUpdate("INSERT INTO COCHE (Nombre,Precio,Fecha) VALUES('" + nombre + "'," + precio + "," + "'"
				+ new Timestamp(time) + "')");
	}

	public static void actualizarRegistro(Connection conn, String nombre_antiguo, String nombre_nuevo)
			throws SQLException {
		Statement statement = conn.createStatement();

		statement.executeUpdate("UPDATE coche SET Nombre='" + nombre_nuevo + "' WHERE nombre='" + nombre_antiguo + "'");
	}

	public static void eliminarRegistro(Connection conn, String nombre) throws SQLException {
		Statement statement = conn.createStatement();

		statement.executeUpdate("DELETE FROM coche WHERE Nombre='" + nombre + "'");

	}

	public static void verRegistro(Connection conn) throws SQLException {
		System.out.println("Nombre - Precio - Fecha\n");
		System.out.println("////////////////////////////////\n");
		String sql = "SELECT * FROM coche";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			System.out.println(result.getString(2) + " - " + result.getString(3) + " - " + result.getString(4));
		}
		System.out.println("\n////////////////////////////////\n");
	}

}
