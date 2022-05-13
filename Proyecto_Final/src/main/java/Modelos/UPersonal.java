package Modelos;

public class UPersonal {
    private String nombre;
    private Integer edad;
    private String sexo;
    private String tipo_emp;
    private String calle;
    private String colonia;
    private String ciudad;
    private Integer idper;

    public UPersonal(String nombre, Integer edad, String sexo, String tipo_emp, String calle, String colonia, String ciudad, Integer idper) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.tipo_emp = tipo_emp;
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.idper = idper;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getTipo_emp() {
        return tipo_emp;
    }

    public void setTipo_emp(String tipo_emp) {
        this.tipo_emp = tipo_emp;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getIdper() {
        return idper;
    }

    public void setIdper(Integer idper) {
        this.idper = idper;
    }
}
