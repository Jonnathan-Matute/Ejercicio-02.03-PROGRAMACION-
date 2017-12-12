package ejercicio_02_03.modelo;

/**
 *
 * @author jonnathan matute
 */
public class Materia {
     private String nombre;
     private String nomDocente;
     private Grupo nomGrupo;

    public Materia(String nombre, String nomDocente, Grupo nomGrupo) {
        this.nombre = nombre;
        this.nomDocente = nomDocente;
        this.nomGrupo = nomGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomDocente() {
        return nomDocente;
    }

    public void setNomDocente(String nomDocente) {
        this.nomDocente = nomDocente;
    }

    public Grupo getNomGrupo() {
        return nomGrupo;
    }

    public void setNomGrupo(Grupo nomGrupo) {
        this.nomGrupo = nomGrupo;
    }

    @Override
    public String toString() {
        return "Materia{" + "nombre=" + nombre + ", nomDocente=" + nomDocente + ", nomGrupo=" + nomGrupo + '}';
    }    
}
