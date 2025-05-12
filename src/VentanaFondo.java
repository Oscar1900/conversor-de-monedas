import javax.swing.*;
import java.awt.*;

public class VentanaFondo extends JFrame {
    private Image imagenFondo;

    public VentanaFondo(String rutaImagen) {
        // Cargar la imagen
        ImageIcon icono = new ImageIcon(rutaImagen);
        imagenFondo = icono.getImage();

        // Configurar ventana
        setTitle("Conversor de Monedas");
        setSize(600, 400);
        setLocationRelativeTo(null); // Centrada
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crear un JPanel personalizado que pinte la imagen
        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelFondo.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("<html>Auspiciador ALURA LATAM<br>Creador Oscar Coloma P.</html>", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 15));
        titulo.setForeground(Color.WHITE);

        panelFondo.add(titulo, BorderLayout.SOUTH);
        setContentPane(panelFondo);
        setVisible(true);
    }
}


