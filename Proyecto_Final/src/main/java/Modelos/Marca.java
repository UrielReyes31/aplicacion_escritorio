package Modelos;

public class Marca {
    private Integer IDmarca;
    private String Nombre_marca;

     public Marca(Integer IDmarca, String nombre_marca) {
        this.IDmarca = IDmarca;
        Nombre_marca = nombre_marca;
    }

    public Integer getIDmarca() {
        return IDmarca;
    }

    public void setIDmarca(Integer IDmarca) {
        this.IDmarca = IDmarca;
    }

    public String getNombre_marca() {
        return Nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        Nombre_marca = nombre_marca;
    }
}
