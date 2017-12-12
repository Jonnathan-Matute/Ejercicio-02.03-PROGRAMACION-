package ejercicio_02_03.vista;

import ejercicio_02_03.controlador.GestionDato;
import ejercicio_02_03.modelo.Carrera;
import ejercicio_02_03.modelo.Grupo;
import ejercicio_02_03.modelo.Materia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonnathan matute
 */
public class Principal {
    
     public static void main(String[] args) {

        List<Carrera> carreraList = new ArrayList();
        List<Grupo> grupoList = new ArrayList();
        List<Materia> materiaList = new ArrayList();

        GestionDato gd = new GestionDato(carreraList, grupoList, materiaList);
        
        VentanaPrincipal v = new VentanaPrincipal("Menu Principal",gd);
        v.setVisible(true);  
    }
}
