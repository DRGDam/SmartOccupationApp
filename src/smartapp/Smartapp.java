
package smartapp;

import Gui.VentanaPrincipal;
import Util.BDconfig;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Smartapp {
    public static void main(String[] args) {

        if (!BDconfig.testConnection()) {
            JOptionPane.showMessageDialog(null, 
                "No se pudo establecer conexión con el servidor MariaDB.\nVerifique los servicios del sistema.",
                "Error de Sistema", 
                JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}