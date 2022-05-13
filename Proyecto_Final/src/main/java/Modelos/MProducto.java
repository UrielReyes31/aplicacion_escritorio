package Modelos;

public class MProducto {
    private Integer id_pro;
    private String nombre;
    private double precio;
    private String modelo;
    private String marca;
    private String categoria;

     public MProducto(Integer id_pro, String nombre, double precio, String modelo, String marca, String categoria) {
        this.id_pro = id_pro;
        this.nombre = nombre;
        this.precio = precio;
        this.modelo = modelo;
        this.marca = marca;
        this.categoria = categoria;
    }

    public Integer getId_pro() {
        return id_pro;
    }

    public void setId_pro(Integer id_pro) {
        this.id_pro = id_pro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
