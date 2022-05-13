package Modelos;

public class UCliente {
    private String Nombre;
    private Integer edad;
    private String sexo;
    private String calle;
    private String Nom_col;
    private String Nom_ciu;

     public UCliente(String nombre, Integer edad, String sexo, String calle, String nom_col, String nom_ciu) {
        Nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.calle = calle;
        Nom_col = nom_col;
        Nom_ciu = nom_ciu;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNom_col() {
        return Nom_col;
    }

    public void setNom_col(String nom_col) {
        Nom_col = nom_col;
    }

    public String getNom_ciu() {
        return Nom_ciu;
    }

    public void setNom_ciu(String nom_ciu) {
        Nom_ciu = nom_ciu;
    }
}
