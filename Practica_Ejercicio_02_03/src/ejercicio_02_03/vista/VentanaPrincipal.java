package ejercicio_02_03.vista;

import ejercicio_02_03.controlador.EventoVentanaPrincipal;
import ejercicio_02_03.controlador.GestionDato;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author jonnathan matute
 */
public class VentanaPrincipal extends JFrame{
    
    private JDesktopPane escritorio;
    private JMenuBar barraMenu;
    private List<JMenu> menuList;
    private List<JMenuItem> itemMenuList;
    private GestionDato gd;
    
    private VentanaCarrera vCarrera;
    private VentanaGrupo vGrupo;
    private VentanaMateria vMateria;
    
    public VentanaPrincipal(String title, GestionDato gd){
        super(title);
        this.setSize(820, 710);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(3);
        this.gd = gd;
        this.iniciaComponentes();
    }
    
    public void iniciaComponentes(){
        
        this.escritorio = new JDesktopPane();
        this.escritorio.setBackground(Color.lightGray);
        this.barraMenu = new JMenuBar();
        
        this.menuList = new ArrayList();
        this.menuList.add(new JMenu("Carrera"));
        this.menuList.add(new JMenu("Grupo"));
        this.menuList.add(new JMenu("Materia"));
        
        this.itemMenuList = new ArrayList();
        this.itemMenuList.add(new JMenuItem("Nueva Carrera"));
        this.itemMenuList.add(new JMenuItem("Nuevo Grupo"));
        this.itemMenuList.add(new JMenuItem("Nuevo Materia"));

 
        this.add(this.escritorio);
        this.setJMenuBar(this.barraMenu);
        
        this.barraMenu.add(this.menuList.get(0));
        this.barraMenu.add(this.menuList.get(1));
        this.barraMenu.add(this.menuList.get(2));

        
        this.menuList.get(0).add(this.itemMenuList.get(0));
        this.menuList.get(1).add(this.itemMenuList.get(1));
        this.menuList.get(2).add(this.itemMenuList.get(2));

        
        this.itemMenuList.get(0).addActionListener(new EventoVentanaPrincipal(this));
        this.itemMenuList.get(1).addActionListener(new EventoVentanaPrincipal(this));
        this.itemMenuList.get(2).addActionListener(new EventoVentanaPrincipal(this));
       
        
    }

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JMenuBar getBarraMenu() {
        return barraMenu;
    }

    public void setBarraMenu(JMenuBar barraMenu) {
        this.barraMenu = barraMenu;
    }

    public List<JMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<JMenu> menuList) {
        this.menuList = menuList;
    }

    public List<JMenuItem> getItemMenuList() {
        return itemMenuList;
    }

    public void setItemMenuList(List<JMenuItem> itemMenuList) {
        this.itemMenuList = itemMenuList;
    }

    public GestionDato getGd() {
        return gd;
    }

    public void setGd(GestionDato gd) {
        this.gd = gd;
    }

    public VentanaCarrera getvCarrera() {
        return vCarrera;
    }

    public void setvCarrera(VentanaCarrera vCarrera) {
        this.vCarrera = vCarrera;
    }

    public VentanaGrupo getvGrupo() {
        return vGrupo;
    }

    public void setvGrupo(VentanaGrupo vGrupo) {
        this.vGrupo = vGrupo;
    }

    public VentanaMateria getvMateria() {
        return vMateria;
    }

    public void setvMateria(VentanaMateria vMateria) {
        this.vMateria = vMateria;
    }

}
