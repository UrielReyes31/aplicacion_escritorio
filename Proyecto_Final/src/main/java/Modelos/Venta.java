package Modelos;

public class Venta {
    private Integer id_cliente;
    private String nombre;
    private String fecha_venta;
    private String nom_prod;
    private String nom_cat;
    private String nom_marca;
    private String Mpago;

    public Venta(Integer id_cliente, String nombre, String fecha_venta, String nom_prod, String nom_cat, String nom_marca, String mpago) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.fecha_venta = fecha_venta;
        this.nom_prod = nom_prod;
        this.nom_cat = nom_cat;
        this.nom_marca = nom_marca;
        Mpago = mpago;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    public String getNom_cat() {
        return nom_cat;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }

    public String getNom_marca() {
        return nom_marca;
    }

    public void setNom_marca(String nom_marca) {
        this.nom_marca = nom_marca;
    }

    public String getMpago() {
        return Mpago;
    }

    public void setMpago(String mpago) {
        Mpago = mpago;
    }
}
