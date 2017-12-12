package ejercicio_02_03.controlador;

import ejercicio_02_03.modelo.Carrera;
import ejercicio_02_03.modelo.Grupo;
import ejercicio_02_03.modelo.Materia;
import ejercicio_02_03.vista.VentanaPrincipal;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class GestionDato {

    private List<Carrera> carreraList;
    private List<Grupo> grupoList;
    private List<Materia> materiaList;
    private String[] partes;
    private String directorio;
    private VentanaPrincipal vPrincipal;

    public GestionDato(List<Carrera> carreraList, List<Grupo> grupoList, List<Materia> materiaList) {
        this.carreraList = carreraList;
        this.grupoList = grupoList;
        this.materiaList = materiaList;
    }

    public boolean addCarrera(Carrera c) {
        return this.carreraList.add(c);
    }

    public boolean addGrupo(Grupo g) {
        return this.grupoList.add(g);
    }

    public boolean addMateria(Materia m) {
        return this.materiaList.add(m);
    }

    public List<Carrera> getCarreraList() {
        return carreraList;
    }

    public void setCarreraList(List<Carrera> carreraList) {
        this.carreraList = carreraList;
    }

    public List<Grupo> getGrupoList() {
        return grupoList;
    }

    public void setGrupoList(List<Grupo> grupoList) {
        this.grupoList = grupoList;
    }

    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList(List<Materia> materiaList) {
        this.materiaList = materiaList;
    }

    public Carrera buscarCarrera(String txt) {
        Carrera retorno = null;
        int i = 0;
        for (Carrera c : this.carreraList) {
            if (c.getNombre().equals(txt)) {
                i++;
                return c;
            }
        }
        return retorno;
    }

    public Grupo buscarGrupo(String txt) {
        Grupo retorno = null;
        int i = 0;
        for (Grupo g : this.grupoList) {
            if (g.getNombre().equals(txt)) {
                i++;
                return g;
            }
        }
        return retorno;
    }

    public boolean persistirArchivoCarrera(List<Carrera> lista) {

        String directorio = JOptionPane.showInputDialog(vPrincipal, "Ingresar el directorio donde se guardará el archivo DatosCarrera");
        this.directorio = directorio;

        FileOutputStream fos = null;
        DataOutputStream salida = null;
        int n;

        try {
            JOptionPane.showMessageDialog(this.vPrincipal, "Se ha generado un archivo Binario DatosCarrera en: " + directorio, "Directorio", JOptionPane.PLAIN_MESSAGE);
            fos = new FileOutputStream(this.directorio + "/DatosCarrera.dat", true);
            salida = new DataOutputStream(fos);
            for (Carrera c : this.carreraList) {
                salida.writeUTF(c.getNombre() + " | " + c.getNomDirec() + " | " + c.getCapacidad());
                salida.close();
            }

            return true;
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(this.vPrincipal, "El Directorio esta creado ", "Listo", JOptionPane.CLOSED_OPTION);
            return false;
        }
    }

    public boolean persistirArchivoGrupo(List<Grupo> lista) {

        String directorio = JOptionPane.showInputDialog(vPrincipal, "Ingresar el directorio donde se guardará el archivo binario DatosGrupo");
        this.directorio = directorio;

        FileOutputStream fos = null;
        DataOutputStream salida = null;
        int n;

        try {
            JOptionPane.showMessageDialog(this.vPrincipal, "Se ha generado un archivo binario DatosGrupo en: " + directorio, "Directorio", JOptionPane.PLAIN_MESSAGE);
            fos = new FileOutputStream(this.directorio + "/DatosGrupo.dat", true);
            salida = new DataOutputStream(fos);
            for (Grupo g : this.grupoList) {
                salida.writeUTF(g.getNombre() + " | ");
                salida.close();
            }
            return true;
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(this.vPrincipal, "El Directorio esta creado ", "Listo", JOptionPane.CLOSED_OPTION);
            return false;
        }
    }

    public boolean persistirArchivoMateria(List<Materia> lista) {

        String directorio = JOptionPane.showInputDialog(vPrincipal, "Ingresar el directorio donde se guardará el archivo binario DatosMateria");
        this.directorio = directorio;

        FileOutputStream fos = null;
        DataOutputStream salida = null;
        int n;

        try {
            JOptionPane.showMessageDialog(this.vPrincipal, "Se ha generado un archivo binario DatosMateria en: " + directorio, "Directorio", JOptionPane.PLAIN_MESSAGE);
            fos = new FileOutputStream(this.directorio + "/DatosMateria.dat", true);
            salida = new DataOutputStream(fos);
            for (Materia m : this.materiaList) {
                salida.writeUTF("NOMBRE: " + m.getNombre() + " | DOCENTE: " + m.getNomDocente() + " | NOMBRE GRUPO" + m.getNomGrupo());
                salida.close();
            }
            return true;
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(this.vPrincipal, "El Directorio esta creado ", "Listo", JOptionPane.CLOSED_OPTION);
            return false;
        }
    }

}
