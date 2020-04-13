package view;

import controller.PacientViewMostrarController;
import service.CitaService;
import service.ConsultorioService;
import service.PacientService;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.table.DefaultTableModel;

import java.awt.Image;


public class PacientViewMostrar extends JFrame {
    private JPanel contentPane;
    private JLabel titulo;
    private JButton buttonBuscar;
    private JTextField textField1;
    private JTable table1;
    private JButton button2;
    private JButton buttonModificar;
    private JButton buttonEliminar;
    DefaultTableModel tableModel = new DefaultTableModel();

    public PacientViewMostrar() {
        PacientViewMostrarController controller = new PacientViewMostrarController(table1,tableModel,textField1,
                button2,buttonBuscar,buttonEliminar,buttonModificar,this);
        buttonBuscar.addActionListener(controller);
        button2.addActionListener(controller);
        buttonEliminar.addActionListener(controller);
        buttonModificar.addActionListener(controller);
        setContentPane(contentPane);
        table1.setModel(tableModel);
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

    }



    public static void main(String[] args) {
        //PacientViewMostrar dialog = new PacientViewMostrar();
        //dialog.pack();
        //dialog.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        titulo=new JLabel();
        ImageIcon foto12345678 = new ImageIcon("tituloLeer.png");
        Icon icono123456789 = new ImageIcon(foto12345678.getImage().getScaledInstance
                (1400,35, Image.SCALE_DEFAULT));
        titulo.setIcon(icono123456789);

    }
}
