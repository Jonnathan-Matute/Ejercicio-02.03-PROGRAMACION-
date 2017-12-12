package ejercicio_02_03.modelo;

/**
 *
 * @author jonnathan matute
 */
public class Grupo {
    private String nombre;
    private int numEstudiantes;
    private int numMaterias;
    private Carrera nomCarrera;

    public Grupo(String nombre, int numEstudiantes, int numMaterias, Carrera nomCarrera) {
        this.nombre = nombre;
        this.numEstudiantes = numEstudiantes;
        this.numMaterias = numMaterias;
        this.nomCarrera = nomCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumEstudiantes() {
        return numEstudiantes;
    }

    public void setNumEstudiantes(int numEstudiantes) {
        this.numEstudiantes = numEstudiantes;
    }

    public int getNumMaterias() {
        return numMaterias;
    }

    public void setNumMaterias(int numMaterias) {
        this.numMaterias = numMaterias;
    }

    public Carrera getNomCarrera() {
        return nomCarrera;
    }

    public void setNomCarrera(Carrera nomCarrera) {
        this.nomCarrera = nomCarrera;
    }

    @Override
    public String toString() {
        return "Grupo{" + "nombre=" + nombre + ", numEstudiantes=" + numEstudiantes + ", numMaterias=" + numMaterias + ", nomCarrera=" + nomCarrera + '}';
    }
}
