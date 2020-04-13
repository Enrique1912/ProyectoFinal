package view;

import controller.PaginaPrincipal2Controller;
import service.CitaService;
import service.ConsultorioService;
import service.PacientService;

import javax.swing.*;
import java.awt.*;

public class PaginaPrincipal2 extends JFrame {
    private JPanel contentPane;
    private JButton JButtonPacient;
    private JButton JButtonConsul;
    private JButton JButtonCitas;
    private JLabel encabezado;
    private JButton JButtonSalir;


    public PaginaPrincipal2() {
        PaginaPrincipal2Controller a1=new PaginaPrincipal2Controller(JButtonPacient,JButtonConsul, JButtonCitas,this);
        JButtonPacient.addActionListener(a1);
        JButtonConsul.addActionListener(a1);
        JButtonCitas.addActionListener(a1);
        JButtonSalir.addActionListener(a1);
        setContentPane(contentPane);
        this.setExtendedState(MAXIMIZED_BOTH);

      //  JLabelBienvenida.setFont(tipoFuente.fuente(tipoFuente.RIO,1,20));
      //  JLabelNomUsuario.setFont((tipoFuente.fuente(tipoFuente.BPR,0,14)));
      //  JButtonPacient.setFont(tipoFuente.fuente(tipoFuente.RIO,1,14));
        this.setTitle("VENTANA ADMINISTRATIVO");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }


    public static void main(String[] args) {
        PacientService a1= PacientService.getSingletonInstance();
        ConsultorioService a2=ConsultorioService.getSingletonInstance();
        CitaService a3=CitaService.getSingletonInstance();
        PaginaPrincipal2 dialog = new PaginaPrincipal2();
        dialog.pack();
        dialog.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        //Establece el tamano de la imagen

        encabezado=new JLabel();
        ImageIcon fot = new ImageIcon("PaginaPrincipal2.png");
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(1920,98, Image.SCALE_DEFAULT));
        encabezado.setIcon(icono);

        /**---------------------------------------------------------------------------------*/
        JButtonPacient=new JButton();
        ImageIcon foto = new ImageIcon("1.png");
        Icon icono1 = new ImageIcon(foto.getImage().getScaledInstance(894,156, Image.SCALE_AREA_AVERAGING));
        JButtonPacient.setIcon(icono1);
        JButtonPacient.setFocusable(false);
        JButtonPacient.setFocusPainted(false);
        /**-------------------------------------------------------------------------------*/
        JButtonConsul=new JButton();
        ImageIcon foto1 = new ImageIcon("2.png");
        Icon icono12 = new ImageIcon(foto1.getImage().getScaledInstance(894,156, Image.SCALE_AREA_AVERAGING));
        JButtonConsul.setIcon(icono12);
        JButtonConsul.setFocusable(false);
        JButtonConsul.setFocusPainted(false);
        /**-------------------------------------------------------------------------------*/
        JButtonCitas=new JButton();
        ImageIcon foto12 = new ImageIcon("3.png");
        Icon icono123 = new ImageIcon(foto12.getImage().getScaledInstance(894,156, Image.SCALE_DEFAULT));
        JButtonCitas.setIcon(icono123);
        JButtonCitas.setFocusable(true);
        JButtonCitas.setFocusPainted(true);

        JButtonSalir=new JButton();
        ImageIcon foto123 = new ImageIcon("4.png");
        Icon icono1234 = new ImageIcon(foto123.getImage().getScaledInstance(894,156, Image.SCALE_DEFAULT));
        JButtonSalir.setIcon(icono1234);
        JButtonSalir.setFocusable(true);
        JButtonSalir.setFocusPainted(true);
    }
}
