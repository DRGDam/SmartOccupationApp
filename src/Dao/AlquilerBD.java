package Dao;

import model.*;
import Util.BDconfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlquilerBD {
    public List<Alquiler> buscarAlquileresPorFecha(java.util.Date desde, java.util.Date hasta) {
        List<Alquiler> lista = new ArrayList<>();
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
        Cliente cl = new Cliente(rs.getInt("c.id"), rs.getString("c.nombre"), rs.getString("c.dni"));
        
        Casa ca = new Casa();
        ca.setId(rs.getString("v.id"));
        ca.setCodigoReferencia(rs.getString("v.codigo_referencia"));
        ca.setPrecioAlquilerMensual(rs.getBigDecimal("v.precio_alquiler_mensual"));

        Alquiler al = new Alquiler();
        al.setNumeroExpediente(rs.getString("a.numero_expediente"));
        al.setFechaEntrada(rs.getDate("a.fecha_entrada"));
        al.setCliente(cl);
        al.setCasa(ca);
        al.setEstado(rs.getString("a.estado"));
        return al;
    }
}