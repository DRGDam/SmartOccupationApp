
package model;


public class Cliente {
      private int id;
    private String nombre;
    private String dni;
    private String email;
    private String telefono;
    private String direccionFacturacion;
    
    // Constructores
    public Cliente(int aInt, String string, String string1) {}
    
    public Cliente(String nombre, String dni, String email, String telefono, String direccionFacturacion) {
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.direccionFacturacion = direccionFacturacion;
    }
    
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public String getDireccionFacturacion() { return direccionFacturacion; }
    public void setDireccionFacturacion(String direccionFacturacion) { 
        this.direccionFacturacion = direccionFacturacion; 
    }
    
    @Override
    public String toString() {
        return nombre + " (" + dni + ")";
    }
}
    

