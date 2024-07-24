package controlSemantico;

public class createTable {

    private int id;

    private String tipo;

    private String nombre;

    private int dataBase;

    public createTable() {

    }

    public createTable(int ID, String tipo, String nombre, int dataBase) {
        this.id = ID;
        this.tipo = tipo;
        this.nombre = nombre;
        this.dataBase = dataBase;
    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
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

    public int getDataBase() {
        return dataBase;
    }

    public void setDataBase(int dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String toString() {
        return "createTable{" +
                "Identificador = " + id + " Tipo = " + tipo + " Nombre = " + nombre + " De la Base de Datos = " + dataBase;
    }

}
