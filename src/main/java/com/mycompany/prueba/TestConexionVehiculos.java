package com.mycompany.prueba;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestConexionVehiculos {
    
    
    public static void main(String[] args){
        // 1. Probar conexión
        Connection conn = ConexionBD.obtenerConexion();
          Menu_principal menu_principal = new Menu_principal();
        menu_principal.setVisible(true);
      /*  if (conn != null) {
            try {
                // 2. Crear tablas si no existen
                crearTablas(conn);
                
                // 3. Insertar datos de ejemplo
                int idCliente = insertarClienteEjemplo(conn);
                insertarVehiculoEjemplo(conn, idCliente);
                
                // 4. Consultar datos
                System.out.println("\nClientes registrados:");
                listarClientes(conn).forEach(System.out::println);
                
                System.out.println("\nVehículos registrados:");
                listarVehiculos(conn).forEach(System.out::println);
                
            } finally {
                ConexionBD.cerrarConexion(conn);
            }
        }*/
    }
    
    private static void crearTablas(Connection conn) throws SQLException {
        // Crear tabla clientes
        String sqlClientes = "CREATE TABLE IF NOT EXISTS clientes (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nombres VARCHAR(100) NOT NULL, " +
                "celular INT, " +
                "direccion VARCHAR(200), " +
                "ciudad VARCHAR(50), " +
                "fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
        
        // Crear tabla vehiculos
        String sqlVehiculos = "CREATE TABLE IF NOT EXISTS vehiculos (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "id_cliente INT, " +
                "serial VARCHAR(50), " +
                "marca VARCHAR(50), " +
                "motor VARCHAR(50), " +
                "chasis VARCHAR(50), " +
                "chasis_tipo VARCHAR(50), " +
                "tipo_vehiculo VARCHAR(50), " +
                "vin VARCHAR(50), " +
                "observaciones TEXT, " +
                "fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                "FOREIGN KEY (id_cliente) REFERENCES clientes(id))";
        
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sqlClientes);
            stmt.executeUpdate(sqlVehiculos);
            System.out.println("Tablas verificadas/creadas correctamente");
        }
    }
    
    private static int insertarClienteEjemplo(Connection conn) throws SQLException {
        String sql = "INSERT INTO clientes (nombres, celular, direccion, ciudad) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, "Juan Pérez");
            pstmt.setInt(2, 300123567);
            pstmt.setString(3, "Calle 123 #45-67");
            pstmt.setString(4, "Bogotá");
            
            int filas = pstmt.executeUpdate();
            System.out.println(filas + " cliente(s) insertado(s)");
            
            // Obtener el ID generado
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        }
        ConexionBD.cerrarConexion(conn);
        return -1;
    }
    
    public void insertarVehiculoEjemplo(Connection conn, int idCliente,String serial,String marca,String motor,String chasis,String tipo_chasis,String tipo_vehiculo,String vin,String obsevaciones) throws SQLException {
        String sql = "INSERT INTO vehiculos (id_cliente, serial, marca, motor, chasis, " +
                     "chasis_tipo, tipo_vehiculo, vin, observaciones) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idCliente);
            pstmt.setString(2, serial);
            pstmt.setString(3, marca);
            pstmt.setString(4, motor);
            pstmt.setString(5, chasis);
            pstmt.setString(6, tipo_chasis);
            pstmt.setString(7, tipo_vehiculo);
            pstmt.setString(8, vin);
            pstmt.setString(9, obsevaciones);
            
            int filas = pstmt.executeUpdate();
            System.out.println(filas + " vehículo(s) insertado(s)");
        }
        ConexionBD.cerrarConexion(conn);
    }
    
    private static List<String> listarClientes(Connection conn) throws SQLException {
        List<String> clientes = new ArrayList<>();
        String sql = "SELECT id, nombres, celular, direccion, ciudad, fecha_registro FROM clientes";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                String cliente = String.format("ID: %d, Nombre: %s, Celular: %d, Dirección: %s, Ciudad: %s, Fecha: %s",
                    rs.getInt("id"),
                    rs.getString("nombres"),
                    rs.getInt("celular"),
                    rs.getString("direccion"),
                    rs.getString("ciudad"),
                    rs.getTimestamp("fecha_registro"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }
    
    private static List<String> listarVehiculos(Connection conn) throws SQLException {
        List<String> vehiculos = new ArrayList<>();
        String sql = "SELECT v.id, v.serial, v.marca, v.tipo_vehiculo, c.nombres as cliente " +
                     "FROM vehiculos v JOIN clientes c ON v.id_cliente = c.id";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                String vehiculo = String.format("ID: %d, Serial: %s, Marca: %s, Tipo: %s, Cliente: %s",
                    rs.getInt("id"),
                    rs.getString("serial"),
                    rs.getString("marca"),
                    rs.getString("tipo_vehiculo"),
                    rs.getString("cliente"));
                vehiculos.add(vehiculo);
            }
        }
        return vehiculos;
    }
}