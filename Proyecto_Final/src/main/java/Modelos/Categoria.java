package Modelos;

public class Categoria {
    private Integer IDcategoria;
    private String nombre_categoria;

    public Categoria(Integer IDcategoria, String nombre_categoria) {
        this.IDcategoria = IDcategoria;
        this.nombre_categoria = nombre_categoria;
    }

    public Integer getIDcategoria() {
        return IDcategoria;
    }

    public void setIDcategoria(Integer IDcategoria) {
        this.IDcategoria = IDcategoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }
}
