package ejercicio_02_03.controlador;

import ejercicio_02_03.vista.VentanaCarrera;
import ejercicio_02_03.vista.VentanaGrupo;
import ejercicio_02_03.vista.VentanaMateria;
import ejercicio_02_03.vista.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Administrador
 */
public class EventoVentanaPrincipal implements ActionListener {

    private VentanaPrincipal vPrincipal;

    public EventoVentanaPrincipal(VentanaPrincipal vPrincipal) {
        this.vPrincipal = vPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(0))) {
            this.vPrincipal.setvCarrera(new VentanaCarrera("Nueva Carrera", true, true, true, true, this.vPrincipal.getGd()));
            this.vPrincipal.getEscritorio().add(this.vPrincipal.getvCarrera());
        }

        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(1))) {
            this.vPrincipal.setvGrupo(new VentanaGrupo("Nuevo Grupo", true, true, true, true, this.vPrincipal.getGd()));
            this.vPrincipal.getEscritorio().add(this.vPrincipal.getvGrupo());
        }

        if (e.getSource().equals(this.vPrincipal.getItemMenuList().get(2))) {
            this.vPrincipal.setvMateria(new VentanaMateria("Nueva Materia", true, true, true, true, this.vPrincipal.getGd()));
            this.vPrincipal.getEscritorio().add(this.vPrincipal.getvMateria());
        }
    }

}
