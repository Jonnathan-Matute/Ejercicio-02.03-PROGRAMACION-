package ejercicio_02_03.controlador;

import ejercicio_02_03.modelo.Grupo;
import ejercicio_02_03.vista.VentanaGrupo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author jonnathan matute
 */
public class EventoVentanaGrupo implements ActionListener {

    private VentanaGrupo vGrupo;

    public EventoVentanaGrupo(VentanaGrupo vGrupo) {
        this.vGrupo = vGrupo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.vGrupo.getbGuardar())) {//INICIO IF
            try {
                try {
                    String nom = this.vGrupo.getTxtList().get(0).getText();
                    String numEs = this.vGrupo.getTxtList().get(1).getText();
                    String numMa = this.vGrupo.getTxtList().get(2).getText();
                    int comboCarrera = this.vGrupo.getComboBox().getSelectedIndex();

                    if (nom.isEmpty() && numEs.isEmpty() && numMa.isEmpty()) {
                        JOptionPane.showInternalMessageDialog(vGrupo, "Todos los parámetros estan vacíos", "Empty Parameter", JOptionPane.NO_OPTION);
                    } else if (nom.isEmpty()) {
                        JOptionPane.showInternalMessageDialog(vGrupo, "El parámetro Nombre Grupo esrá vacío", "Empty Parameter", JOptionPane.NO_OPTION);
                    } else if (numEs.isEmpty()) {
                        JOptionPane.showInternalMessageDialog(vGrupo, "El parámetro Numero Estudiantes está vacío", "Empty Parameter", JOptionPane.NO_OPTION);
                    } else if (numMa.isEmpty()) {
                        JOptionPane.showInternalMessageDialog(vGrupo, "El parámetro Numero Materias está vacío", "Empty Parameter", JOptionPane.NO_OPTION);
                    } else {//INICIO ELSE

                        int numEstudiantes = Integer.parseInt(numEs);
                        int numMaterias = Integer.parseInt(numMa);

                        int a = 0;
                        boolean cent = true;
                        for (Grupo gr : this.vGrupo.getGd().getGrupoList()) {
                            if (nom.compareTo(this.vGrupo.getGd().getGrupoList().get(a).getNombre()) == 0) {
                                JOptionPane.showInternalMessageDialog(vGrupo, "Ya se encuentra este dato en nuestra base de datos", "Parámetro Repetido", JOptionPane.ERROR_MESSAGE);
                                cent = false;
                                break;
                            } else {
                                cent = true;
                            }
                            a++;
                        }

                        if (cent == true) {//INICIO IF
                            this.vGrupo.getGd().addGrupo(new Grupo(nom, numEstudiantes, numMaterias, this.vGrupo.getGd().getCarreraList().get(comboCarrera)));
                            this.vGrupo.getModeloTabla().setDataVector(this.cargaGrupo(this.vGrupo.getGd().getGrupoList().size(), 4), this.vGrupo.getEncabezado());
                        }//FIN IF
                    }//FIN ELSE

                } catch (NumberFormatException error) {

                    JOptionPane.showInternalMessageDialog(vGrupo, "Ingresar solo números en los parámetros Numero Estudiantes o Numero Materias ", "NumberFormatException", JOptionPane.ERROR_MESSAGE);

                }

                this.vGrupo.getTxtList().get(0).setText("");
                this.vGrupo.getTxtList().get(1).setText("");
                this.vGrupo.getTxtList().get(2).setText("");
                this.vGrupo.getComboBox().setSelectedIndex(-1);

            } catch (ArrayIndexOutOfBoundsException err) {
                JOptionPane.showInternalMessageDialog(vGrupo, "El parámetro Carrera está vacío. Ingrese una carrera desde la ventana Nueva Carrera", "NumberFormatException", JOptionPane.ERROR_MESSAGE);

            }
        }//FIN IF
        if (e.getSource().equals(this.vGrupo.getbGenerar())) {
            JOptionPane.showInternalMessageDialog(vGrupo, "Se debe escribir una direccion existente en disco local, ejemplo: C:/Windows", "Ojo!", JOptionPane.INFORMATION_MESSAGE);
            this.vGrupo.getGd().persistirArchivoGrupo(this.vGrupo.getGd().getGrupoList());
        }
    }

    public Object[][] cargaGrupo(int f, int c) {
        Object[][] retorno = new Object[f][c];
        int i = 0;
        for (Grupo gr : this.vGrupo.getGd().getGrupoList()) {
            retorno[i][0] = gr.getNombre();
            retorno[i][1] = gr.getNumEstudiantes();
            retorno[i][2] = gr.getNumMaterias();
            retorno[i][3] = gr.getNomCarrera().getNombre();
            i++;
        }
        return retorno;
    }

}
