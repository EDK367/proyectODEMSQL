package controlSemantico;

public class createDataBase {

    private String tipo;

    private String nombre;

    public createDataBase() {

    }
    public createDataBase(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Tipo = " + tipo + ": Nombre de la Base de Datos: " + nombre;
    }
}
