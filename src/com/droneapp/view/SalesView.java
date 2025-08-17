

import com.droneapp.model.Drone;

import javax.swing.*;
import java.awt.*;

public class SalesView extends JFrame {

    private static final Color BACKGROUND_COLOR = new Color(120, 130, 140); // Cinza-esverdeado
    private static final Color TEXT_COLOR = Color.BLACK;  // Preto
    private static final Color PANEL_COLOR = Color.WHITE; // Branco

    public SalesView(Drone drone) {
        setTitle("Venda de " + drone.getName());
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configuração do painel de vendas (fundo cinza-esverdeado)
        getContentPane().setBackground(BACKGROUND_COLOR);

        // Painel esquerdo (imagem do drone)
        JPanel imagePanel = new JPanel();
        JLabel imageLabel = new JLabel(new ImageIcon(drone.getImagePath()));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagePanel.add(imageLabel);

        // Painel direito (informações do drone)
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(PANEL_COLOR);

        // Informações do drone
        JLabel weightLabel = new JLabel("Peso: " + drone.getWeight() + " kg");
        JLabel altitudeLabel = new JLabel("Altura Máxima: " + drone.getMaxAltitude() + " m");
        JLabel speedLabel = new JLabel("Velocidade Máxima: " + drone.getMaxSpeed() + " km/h");
        JLabel batteryLabel = new JLabel("Tempo de Recarga: " + drone.getRechargeTime() + " horas");

        weightLabel.setForeground(TEXT_COLOR);
        altitudeLabel.setForeground(TEXT_COLOR);
        speedLabel.setForeground(TEXT_COLOR);
        batteryLabel.setForeground(TEXT_COLOR);

        infoPanel.add(weightLabel);
        infoPanel.add(altitudeLabel);
        infoPanel.add(speedLabel);
        infoPanel.add(batteryLabel);

        // Descrição do drone
        JLabel descriptionLabel = new JLabel("<html>" + drone.getDescription() + "</html>");
        descriptionLabel.setForeground(TEXT_COLOR);
        descriptionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Botão "Comprar"
        JButton buyButton = new JButton("Comprar");
        buyButton.setBackground(PANEL_COLOR);
        buyButton.setForeground(TEXT_COLOR);
        buyButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Compra realizada com sucesso!");
        });

        // Layout da página de vendas
        JPanel salesPanel = new JPanel();
        salesPanel.setLayout(new BorderLayout());
        salesPanel.setBackground(BACKGROUND_COLOR);
        salesPanel.add(imagePanel, BorderLayout.WEST);
        salesPanel.add(infoPanel, BorderLayout.CENTER);
        salesPanel.add(descriptionLabel, BorderLayout.SOUTH);
        salesPanel.add(buyButton, BorderLayout.SOUTH);

        // Adicionando o painel de vendas
        add(salesPanel);

        // Exibir a tela de vendas
        setVisible(true);
    }

    // Método para mostrar a tela
    public void display() {
        setVisible(true);
    }
}