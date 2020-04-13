import javax.swing.*;
import java.io.IOException;



public class Source {


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {//
                    createAndShowGUI();

                } catch (IOException e) {
                    System.err.println(e);
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        });
    }


    public static void createAndShowGUI() throws Exception {
       /** PacientView dialog = new PacientView();
        dialog.pack();
        dialog.setVisible(true);*/
    }
}