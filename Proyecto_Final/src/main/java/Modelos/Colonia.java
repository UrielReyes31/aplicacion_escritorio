package Modelos;

public class Colonia {
    private Integer idcol;
    private String Nombre_colonia;

    public Colonia(Integer idcol, String nombre_colonia) {
        this.idcol = idcol;
        Nombre_colonia = nombre_colonia;
    }

    public Integer getIdcol() {
        return idcol;
    }

    public void setIdcol(Integer idcol) {
        this.idcol = idcol;
    }

    public String getNombre_colonia() {
        return Nombre_colonia;
    }

    public void setNombre_colonia(String nombre_colonia) {
        Nombre_colonia = nombre_colonia;
    }
}
