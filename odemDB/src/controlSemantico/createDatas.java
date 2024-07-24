package controlSemantico;

public class createDatas {

    private int id;

    private String tipo;

    private String nombre;

    private String tipoDato;

    private boolean isNulo;

    private int idTable;

    private int idDataBase;

    private int key;

    public createDatas() {

    }
    public createDatas(int id, String tipo, String nombre, String tipoDato, boolean isNulo, int idTable, int idDataBase, int key) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.tipoDato = tipoDato;
        this.isNulo = isNulo;
        this.idTable = idTable;
        this.idDataBase = idDataBase;
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public void setId(int id) {
        this.id = id;
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

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public boolean isNulo() {
        return isNulo;
    }

    public void setNulo(boolean nulo) {
        isNulo = nulo;
    }

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public int getIdDataBase() {
        return idDataBase;
    }

    public void setIdDataBase(int idDataBase) {
        this.idDataBase = idDataBase;
    }

    @Override
    public String toString() {
        return "createDatas{" +
                "Identificador = " + id + " Tipo = " + tipo +" Nombre Dato = " + nombre +" Tipo de Dato = " + tipoDato
                 + " Dato Nulo = " + isNulo + " Tabla = " + idTable + " Base de Datos = " + idDataBase;
    }
}
