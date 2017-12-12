package ejercicio_02_03.modelo;

/**
 *
 * @author jonnathan matute
 */
public class Carrera {
    
    private String nombre;
    private String nomDirec;
    private int capacidad;

    public Carrera(String nombre, String nomDirec, int capacidad) {
        this.nombre = nombre;
        this.nomDirec = nomDirec;
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomDirec() {
        return nomDirec;
    }

    public void setNomDirec(String nomDirec) {
        this.nomDirec = nomDirec;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Carrera{" + "nombre=" + nombre + ", nomDirec=" + nomDirec + ", capacidad=" + capacidad + '}';
    }
}
