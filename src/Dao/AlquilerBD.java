package Dao;

import model.*;
import Util.BDconfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlquilerBD {
    public List<Alquiler> buscarAlquileresPorFecha(java.util.Date desde, java.util.Date hasta) {
        List<Alquiler> lista = new ArrayList<>();
        // Usamos * para traer todas las columnas y evitar el error de "email"
        String sql = "SELECT a.*, c.*, v.* FROM alquileres a " +
                     "JOIN clientes c ON a.id_cliente = c.id " +
                     "JOIN viviendas v ON a.id_vivienda = v.id " +
                     "WHERE a.fecha_entrada BETWEEN ? AND ? ORDER BY a.fecha_entrada DESC";

        try (Connection conn = BDconfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setDate(1, new java.sql.Date(desde.getTime()));
            stmt.setDate(2, new java.sql.Date(hasta.getTime()));

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearAlquiler(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    private Alquiler mapearAlquiler(ResultSet rs) throws SQLException {
        // Usamos los nombres exactos de las columnas de tu base de datos
        // He añadido valores por defecto ("N/A") por si alguna columna estuviera vacía
        Cliente cl = new Cliente(
            rs.getString("nombre"), 
            rs.getString("dni"), 
            rs.getString("email") != null ? rs.getString("email") : "N/A", 
            rs.getString("telefono") != null ? rs.getString("telefono") : "N/A", 
            rs.getString("direccion_facturacion") != null ? rs.getString("direccion_facturacion") : "N/A"
        );
        
        Casa ca = new Casa();
        ca.setCodigoReferencia(rs.getString("codigo_referencia"));
        ca.setPrecioAlquilerMensual(rs.getBigDecimal("precio_alquiler_mensual"));
        ca.setUbicacion(rs.getString("ubicacion")); 

        Alquiler al = new Alquiler();
        al.setNumeroExpediente(rs.getString("numero_expediente"));
        al.setFechaEntrada(rs.getDate("fecha_entrada"));
        al.setCliente(cl); 
        
        al.setTiempoEstimadoMeses(rs.getInt("tiempo_estimado_meses"));
        
        al.setCasa(ca);
        al.setEstado(rs.getString("estado"));
        
        return al;
    }
}