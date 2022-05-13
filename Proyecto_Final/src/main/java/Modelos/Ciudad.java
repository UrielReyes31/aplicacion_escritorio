package Modelos;

public class Ciudad {
    private Integer idciuad;
    private String Nombre_ciudad;

    public Ciudad(Integer idciuad, String nombre_ciudad) {
        this.idciuad = idciuad;
        Nombre_ciudad = nombre_ciudad;
    }

    public Integer getIdciuad() {
        return idciuad;
    }

    public void setIdciuad(Integer idcol) {
        this.idciuad = idcol;
    }

    public String getNombre_ciudad() {
        return Nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        Nombre_ciudad = nombre_ciudad;
    }
}
