
package model;

import java.math.BigDecimal;


public class Casa { private String id;
    private String codigoReferencia;
    private String ubicacion;
    private double metrosCuadrados;
    private int habitaciones;
    private int banos;
    private BigDecimal precioAlquilerMensual;
    
    // Constructores
    public Casa() {}
    
    public Casa(String id, String codigoReferencia, String ubicacion, 
                   double metrosCuadrados, int habitaciones, int banos, 
                   BigDecimal precioAlquilerMensual) {
        this.id = id;
        this.codigoReferencia = codigoReferencia;
        this.ubicacion = ubicacion;
        this.metrosCuadrados = metrosCuadrados;
        this.habitaciones = habitaciones;
        this.banos = banos;
        this.precioAlquilerMensual = precioAlquilerMensual;
    }
    
    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getCodigoReferencia() { return codigoReferencia; }
    public void setCodigoReferencia(String codigoReferencia) { this.codigoReferencia = codigoReferencia; }
    
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    
    public double getMetrosCuadrados() { return metrosCuadrados; }
    public void setMetrosCuadrados(double metrosCuadrados) { this.metrosCuadrados = metrosCuadrados; }
    
    public int getHabitaciones() { return habitaciones; }
    public void setHabitaciones(int habitaciones) { this.habitaciones = habitaciones; }
    
    public int getBanos() { return banos; }
    public void setBanos(int banos) { this.banos = banos; }
    
    public BigDecimal getPrecioAlquilerMensual() { return precioAlquilerMensual; }
    public void setPrecioAlquilerMensual(BigDecimal precioAlquilerMensual) { 
        this.precioAlquilerMensual = precioAlquilerMensual; 
    }
    
    @Override
    public String toString() {
        return codigoReferencia + " - " + ubicacion + " (" + precioAlquilerMensual + "€/mes)";
    }
}
