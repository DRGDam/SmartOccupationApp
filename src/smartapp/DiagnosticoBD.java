package smartapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DiagnosticoBD {
    public static void main(String[] args) {
        System.out.println("=== DIAGNÓSTICO DE CONEXIÓN MARIADB ===\n");
        
        // 1. Probar driver de MariaDB
        System.out.println("1. Probando driver MariaDB...");
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("   ✅ Driver cargado correctamente");
        } catch (ClassNotFoundException e) {
            System.out.println("   ❌ ERROR Driver no encontrado: " + e.getMessage());
            System.out.println("   SOLUCIÓN: Agrega mariadb-java-client.jar a las librerías del proyecto.");
            return;
        }
        
        // 2. Probar conexión básica al servidor
        System.out.println("\n2. Probando conexión al servidor (Puerto 3306)...");
        // Usamos el puerto 3307 y el usuario que configuramos en BDconfig
        String urlBasica = "jdbc:mariadb://localhost:3306/";
        String user = "root";
        String password = "root123"; 
        
        try (Connection conn = DriverManager.getConnection(urlBasica, user, password)) {
            System.out.println("   ✅ Conexión al servidor EXITOSA");
            System.out.println("   Usuario: " + user);
            System.out.println("   Versión DB: " + conn.getMetaData().getDatabaseProductVersion());
        } catch (SQLException e) {
            System.out.println("   ❌ ERROR de conexión: " + e.getMessage());
            System.out.println("   Código error: " + e.getErrorCode());
            return;
        }
        
        // 3. Verificar base de datos específica
        System.out.println("\n3. Verificando base de datos 'smart_occupation'...");
        String urlConBD = "jdbc:mariadb://localhost:3306/smart_occupation";
        
        try (Connection conn = DriverManager.getConnection(urlConBD, user, password)) {
            System.out.println("   ✅ Base de datos 'smart_occupation' accesible");
            
            // Verificar tablas existentes
            ResultSet rs = conn.getMetaData().getTables(null, null, "%", new String[]{"TABLE"});
            System.out.println("   Tablas encontradas:");
            boolean hayTablas = false;
            while (rs.next()) {
                hayTablas = true;
                System.out.println("   - " + rs.getString("TABLE_NAME"));
            }
            
            if (!hayTablas) {
                System.out.println("   ⚠️ No hay tablas creadas aún.");
            }
            
        } catch (SQLException e) {
            if (e.getMessage().contains("Unknown database")) {
                System.out.println("   ❌ La base de datos 'smart_occupation' NO existe.");
                System.out.println("   SOLUCIÓN: Ejecuta el script SQL 'CREATE DATABASE smart_occupation;'");
            } else {
                System.out.println("   ❌ Error: " + e.getMessage());
            }
        }
        
        System.out.println("\n=== DIAGNÓSTICO COMPLETADO ===");
    }
}