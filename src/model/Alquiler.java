
package model;

import java.util.Date;


public class Alquiler {
    private String numeroExpediente;
    private Date fechaEntrada;
    private int tiempoEstimadoMeses;
    private Cliente cliente;
    private Casa casa;
    private String estado;
    private Date fechaCreacion;
    
    // Constructores
    public Alquiler() {}
    
  
    public Alquiler(String numeroExpediente, Date fechaEntrada, int tiempoEstimadoMeses, 
                   Cliente cliente, Casa casa) {
        this.numeroExpediente = numeroExpediente;
        this.fechaEntrada = fechaEntrada;
        this.tiempoEstimadoMeses = tiempoEstimadoMeses;
        this.cliente = cliente;
        this.casa = casa;
        this.estado = "ACTIVO";
        this.fechaCreacion = new Date();
    }

 
    // Getters y Setters
    public String getNumeroExpediente() { return numeroExpediente; }
    public void setNumeroExpediente(String numeroExpediente) { this.numeroExpediente = numeroExpediente; }
    
    public Date getFechaEntrada() { return fechaEntrada; }
    public void setFechaEntrada(Date fechaEntrada) { this.fechaEntrada = fechaEntrada; }
    
    public int getTiempoEstimadoMeses() { return tiempoEstimadoMeses; }
    public void setTiempoEstimadoMeses(int tiempoEstimadoMeses) { this.tiempoEstimadoMeses = tiempoEstimadoMeses; }
    
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    
    public Casa getCasa() { return casa; }
    public void setCasa(Casa casa) { this.casa = casa; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    public Date getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    
    @Override
    public String toString() {
        return "Expediente: " + numeroExpediente + " - " + cliente.getNombre() + " - " + casa.getCodigoReferencia();
    }
}