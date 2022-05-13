package Modelos;

import java.time.LocalDateTime;

public class Envios {
    private Integer idEnvio;
    private double precio;
    private String fecha_envio;
    private String fecha_entrega;
    private Integer idserv;
    private Integer idclien;

    public Envios(Integer idEnvio, double precio, String fecha_envio, String fecha_entrega, Integer idserv, Integer idclien) {
        this.idEnvio = idEnvio;
        this.precio = precio;
        this.fecha_envio = fecha_envio;
        this.fecha_entrega = fecha_entrega;
        this.idserv = idserv;
        this.idclien = idclien;
    }

    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(String fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Integer getIdserv() {
        return idserv;
    }

    public void setIdserv(Integer idserv) {
        this.idserv = idserv;
    }

    public Integer getIdclien() {
        return idclien;
    }

    public void setIdclien(Integer idclien) {
        this.idclien = idclien;
    }
}
