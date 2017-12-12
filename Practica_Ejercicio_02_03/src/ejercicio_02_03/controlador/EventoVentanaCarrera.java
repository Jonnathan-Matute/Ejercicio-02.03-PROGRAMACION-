package ejercicio_02_03.controlador;

import ejercicio_02_03.modelo.Carrera;
import ejercicio_02_03.vista.VentanaCarrera;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author jonnathan matute
 */
public class EventoVentanaCarrera implements ActionListener {

    private VentanaCarrera vCarrera;

    public EventoVentanaCarrera(VentanaCarrera vCarrera) {
        this.vCarrera = vCarrera;
    }

@Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.vCarrera.getbGuardar())) {

            try {
                String nom = this.vCarrera.getTxtList().get(0).getText();
                String dir = this.vCarrera.getTxtList().get(1).getText();
               String cap = this.vCarrera.getTxtList().get(2).getText();

                if (nom.isEmpty() && dir.isEmpty() && cap.isEmpty()) {
                    JOptionPane.showMessageDialog(vCarrera, "Todos los parámetros está vacíos", "Empty Parameter", JOptionPane.NO_OPTION);
                } else if (nom.isEmpty()) {
                    JOptionPane.showMessageDialog(vCarrera, "El parámetro Grupo esrá vacío", "Empty Parameter", JOptionPane.NO_OPTION);
                } else if (dir.isEmpty()) {
                    JOptionPane.showMessageDialog(vCarrera, "El parámetro Numero Alumnos está vacío", "Empty Parameter", JOptionPane.NO_OPTION);
               } else if (cap.isEmpty()) {
                    JOptionPane.showMessageDialog(vCarrera, "El parámetro Numero Alumnos está vacío", "Empty Parameter", JOptionPane.NO_OPTION);
                } else {//INICIO ELSE

                    int capacidad = Integer.parseInt(cap);

                    int a = 0;
                    boolean cent = true;
                    for (Carrera ca : this.vCarrera.getGd().getCarreraList()) {
                        if (nom.compareTo(this.vCarrera.getGd().getCarreraList().get(a).getNombre()) == 0) {
                            JOptionPane.showMessageDialog(vCarrera, "Ya se encuentra este dato en nuestra base de datos", "Parámetro Repetido", JOptionPane.ERROR_MESSAGE);
                            cent = false;
                            break;
                        } else {
                            cent = true;
                        }
                        a++;
                    }

                    if (cent == true) {//INICIO IF
                        this.vCarrera.getGd().addCarrera(new Carrera(nom, dir,capacidad));
                        this.vCarrera.getModeloTabla().setDataVector(this.cargaCarrera(this.vCarrera.getGd().getCarreraList().size(), 3), this.vCarrera.getEncabezado());
                    }//FIN IF
               }//FIN ELSE
            } catch (ArrayIndexOutOfBoundsException err) {
                JOptionPane.showInternalMessageDialog(vCarrera, "El parámetro docente está vacío. Ingrese un docente desde la ventana Nuevo Docente", "EmptyParameter", JOptionPane.ERROR_MESSAGE);
            }
            
            this.vCarrera.getTxtList().get(0).setText("");
            this.vCarrera.getTxtList().get(1).setText("");
            this.vCarrera.getTxtList().get(2).setText("");
        }
         if (e.getSource().equals(this.vCarrera.getbGenerar())) {

            this.vCarrera.getGd().persistirArchivoCarrera(this.vCarrera.getGd().getCarreraList());

        }
    }  
    private Object[][] cargaCarrera(int f, int c) {

        Object[][] retorno = new Object[f][c];
        int i = 0;
        for (Carrera ca : this.vCarrera.getGd().getCarreraList()) {
            retorno[i][0] = ca.getNombre();
            retorno[i][1] = ca.getNomDirec();
            retorno[i][2] = ca.getCapacidad();
            i++;
        }
        return retorno;
    }
}
