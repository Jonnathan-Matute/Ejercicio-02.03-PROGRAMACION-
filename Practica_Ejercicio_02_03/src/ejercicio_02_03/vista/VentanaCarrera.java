package ejercicio_02_03.vista;

import ejercicio_02_03.controlador.EventoVentanaCarrera;
import ejercicio_02_03.controlador.GestionDato;
import ejercicio_02_03.modelo.Carrera;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jonnathan matute
 */
public class VentanaCarrera extends JInternalFrame {

    private JPanel panel;
    private List<JLabel> lblList;
    private List<JTextField> txtList;
    private JButton bGuardar, bGenerar;
    private DefaultTableModel modeloTabla;
    private JScrollPane scroll;
    private JTable tabla;
    private Object[] encabezado;
    private Object[][] datos;
    private GestionDato gd;

    public VentanaCarrera(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable, GestionDato gd) {
        super(title, resizable, closable, maximizable, iconifiable);
        this.setBounds(0, 0, 350, 300);
        this.gd = gd;
        this.setVisible(true);
        this.iniciaComponentes();
    }

    public void iniciaComponentes() {
        this.panel = new JPanel(new BorderLayout(3,2));
        JPanel pBotones = new JPanel(new BorderLayout());
        JPanel panelCampos = new JPanel(new GridLayout(3, 2));

        this.lblList = new ArrayList();
        this.lblList.add(new JLabel("Nombre:"));
        this.lblList.add(new JLabel("Director:"));
        this.lblList.add(new JLabel("Cupos:"));

        this.txtList = new ArrayList();
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        this.txtList.add(new JTextField(15));
        this.bGuardar = new JButton("Guardar");
        this.bGenerar = new JButton("Generar Archivo");
        this.bGenerar.setBackground(Color.cyan);

        this.bGuardar.addActionListener(new EventoVentanaCarrera(this));
        this.bGenerar.addActionListener(new EventoVentanaCarrera(this));
        this.encabezado = new Object[3];
        this.encabezado[0] = "Nombre";
        this.encabezado[1] = "Director";
        this.encabezado[2] = "Cupos";

        this.datos = this.cargaCarrera(this.gd.getCarreraList().size(),3);

        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);

        panelCampos.add(this.lblList.get(0));
        panelCampos.add(this.txtList.get(0));
        panelCampos.add(this.lblList.get(1));
        panelCampos.add(this.txtList.get(1));
        panelCampos.add(this.lblList.get(2));
        panelCampos.add(this.txtList.get(2));
        

        this.panel.add(panelCampos, BorderLayout.NORTH);
        this.panel.add(pBotones, BorderLayout.SOUTH);
        pBotones.add(this.bGuardar, BorderLayout.WEST);
        pBotones.add(this.bGenerar, BorderLayout.EAST);
        this.panel.add(this.scroll);
        this.add(this.panel);
    }   

   public Object[][] cargaCarrera(int f, int c) {
        Object[][] retorno = new Object[f][c];
        this.gd.getCarreraList().forEach((ca) -> {
            int i = 0;
            retorno[i][0] = ca.getNombre();
            retorno[i][1] = ca.getNomDirec();
            retorno[i][2] = ca.getCapacidad();
        });
        return retorno;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public List<JLabel> getLblList() {
        return lblList;
    }

    public void setLblList(List<JLabel> lblList) {
        this.lblList = lblList;
    }

    public List<JTextField> getTxtList() {
        return txtList;
    }

    public void setTxtList(List<JTextField> txtList) {
        this.txtList = txtList;
    }

    public JButton getbGuardar() {
        return bGuardar;
    }

    public void setbGuardar(JButton bGuardar) {
        this.bGuardar = bGuardar;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public GestionDato getGd() {
        return gd;
    }

    public void setGd(GestionDato gd) {
        this.gd = gd;
    }

    public JButton getbGenerar() {
        return bGenerar;
    }

    public void setbGenerar(JButton bGenerar) {
        this.bGenerar = bGenerar;
    }

    
}
