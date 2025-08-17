package com.droneapp.view;

import com.droneapp.model.Drone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DroneView extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private int currentIndex = 0;
    private List<Drone> drones;

    // Cores para a interface
    private static final Color BACKGROUND_COLOR = new Color(120, 130, 140); // Cinza-esverdeado
    private static final Color TEXT_COLOR = Color.BLACK;  // Preto
    private static final Color PANEL_COLOR = Color.WHITE; // Branco

    public DroneView(List<Drone> drones) {
        this.drones = drones;
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        setTitle("Drone Sales App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Configuração do painel principal (fundo cinza-esverdeado)
        getContentPane().setBackground(BACKGROUND_COLOR);

        // Menu superior
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem homeItem = new JMenuItem("Página Inicial");
        JMenuItem contactsItem = new JMenuItem("Contatos");
        JMenuItem salesItem = new JMenuItem("Vendas");

        // Ação para "Página Inicial"
        homeItem.addActionListener(e -> {
            // Se necessário, implemente aqui o código para voltar para a página inicial
        });

        // Ação para "Contatos"
        contactsItem.addActionListener(e -> {
            // Código para exibir informações de contato
        });

        // Ação para "Vendas"
        salesItem.addActionListener(e -> {
            // Exibe a página de vendas
            showSalesPage(drones.get(currentIndex));
        });

        menu.add(homeItem);
        menu.add(contactsItem);
        menu.add(salesItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Configuração do painel de navegação
        JPanel navPanel = new JPanel();
        navPanel.setBackground(BACKGROUND_COLOR);  // Fundo cinza-esverdeado

        // Botões de navegação
        JButton prevButton = new JButton("<");
        prevButton.setBackground(PANEL_COLOR);  // Branco para os botões
        prevButton.setForeground(TEXT_COLOR);   // Texto preto
        JButton nextButton = new JButton(">");

        nextButton.setBackground(PANEL_COLOR);
        nextButton.setForeground(TEXT_COLOR);

        prevButton.addActionListener(e -> {
            if (currentIndex > 0) {
                currentIndex--;
                animateTransition(); // Suaviza a troca
            }
        });

        nextButton.addActionListener(e -> {
            if (currentIndex < drones.size() - 1) {
                currentIndex++;
                animateTransition(); // Suaviza a troca
            }
        });

        navPanel.add(prevButton);
        navPanel.add(nextButton);

        // Adicionando os drones no carrossel
        for (int i = 0; i < drones.size(); i++) {
            Drone drone = drones.get(i);
            JPanel dronePanel = new JPanel();
            dronePanel.setLayout(new BoxLayout(dronePanel, BoxLayout.Y_AXIS));
            dronePanel.setBackground(BACKGROUND_COLOR);

            // Centralizando a imagem
            JLabel imageLabel = new JLabel(new ImageIcon(drone.getImagePath()));
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);  // Centraliza a imagem

            // Descrição do drone
            JLabel descLabel = new JLabel(drone.getShortDescription());
            descLabel.setAlignmentX(Component.CENTER_ALIGNMENT);  // Centraliza a descrição
            descLabel.setForeground(TEXT_COLOR);  // Texto preto

            // Adiciona ação ao clicar na imagem do drone
            imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    // Exibe a página de vendas ao clicar na imagem do drone
                    showSalesPage(drone);
                }
            });

            dronePanel.add(imageLabel);
            dronePanel.add(descLabel);

            cardPanel.add(dronePanel, Integer.toString(i));
        }

        // Layout geral
        add(navPanel, BorderLayout.SOUTH);
        add(cardPanel, BorderLayout.CENTER);
    }

    // Método para mostrar a tela
    public void display() {
        setVisible(true);
    }

    // Método para animar a transição (fade in/fade out)
    private void animateTransition() {
        final int transitionDuration = 300; // 300ms de animação

        // 1. Criando o efeito de Fade Out (escondendo a imagem)
        Timer fadeOutTimer = new Timer(10, e -> {
            float opacity = 1.0f; // Começa com opacidade total
            while (opacity > 0.0f) {
                opacity -= 0.05f; // Diminui a opacidade
                // Muda a transparência do painel
                cardPanel.setOpaque(false);
                repaint();
                try { Thread.sleep(10); } catch (InterruptedException ignored) {} // Pausa para animação
            }
        });
        fadeOutTimer.setRepeats(false);
        fadeOutTimer.start();

        // 2. Depois da transição, faz o fade in (torna a imagem visível)
        Timer fadeInTimer = new Timer(transitionDuration, e -> {
            cardLayout.show(cardPanel, Integer.toString(currentIndex)); // Muda para a próxima imagem
            cardPanel.setOpaque(true);  // Torna o painel opaco novamente
            repaint();  // Atualiza a interface
        });
        fadeInTimer.setRepeats(false);
        fadeInTimer.start();
    }

    // Método para exibir a página de vendas
    private void showSalesPage(Drone drone) {
        // Cria uma nova tela ou painel para exibir as informações de vendas
        JFrame salesFrame = new JFrame("Vendas - " + drone.getName());
        salesFrame.setSize(800, 600);
        salesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        salesFrame.setLocationRelativeTo(null); // Centraliza a janela na tela

        // Layout do painel de vendas
        JPanel salesPanel = new JPanel();
        salesPanel.setLayout(new BorderLayout());

        // Parte direita - Informações detalhadas do drone
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(5, 1)); // Organiza as informações verticalmente
        infoPanel.setBackground(BACKGROUND_COLOR);
        infoPanel.add(new JLabel("Peso: " + drone.getWeight()));
        infoPanel.add(new JLabel("Altura máxima: " + drone.getMaxAltitude()));
        infoPanel.add(new JLabel("Velocidade máxima: " + drone.getMaxSpeed()));
        infoPanel.add(new JLabel("Tempo de recarga: " + drone.getRechargeTime()));

        // Formulário de coleta de dados do cliente
        JPanel customerInfoPanel = new JPanel();
        customerInfoPanel.setLayout(new GridLayout(4, 2));  // 4 linhas, 2 colunas

        JLabel nameLabel = new JLabel("Nome Completo:");
        JTextField nameField = new JTextField();

        JLabel cpfLabel = new JLabel("CPF:");
        JTextField cpfField = new JTextField();

        JLabel cepLabel = new JLabel("CEP:");
        JTextField cepField = new JTextField();

        customerInfoPanel.add(nameLabel);
        customerInfoPanel.add(nameField);
        customerInfoPanel.add(cpfLabel);
        customerInfoPanel.add(cpfField);
        customerInfoPanel.add(cepLabel);
        customerInfoPanel.add(cepField);

        JButton finalizeButton = new JButton("Finalizar Compra");
        finalizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String cpf = cpfField.getText();
                String cep = cepField.getText();

                // Validando se todos os campos foram preenchidos
                if (name.isEmpty() || cpf.isEmpty() || cep.isEmpty()) {
                    JOptionPane.showMessageDialog(salesFrame, "Por favor, preencha todos os campos.");
                    return;
                }

                // Mensagem de confirmação de compra
                JOptionPane.showMessageDialog(salesFrame, "Compra realizada com sucesso! \n" +
                        "Nome: " + name + "\nCPF: " + cpf + "\nCEP: " + cep);

                // Fecha a janela de vendas após a compra
                salesFrame.dispose();
            }
        });

        infoPanel.add(finalizeButton);

        // Parte esquerda - Imagem do drone
        JPanel imagePanel = new JPanel();
        JLabel imageLabel = new JLabel(new ImageIcon(drone.getImagePath()));
        imagePanel.add(imageLabel);

        // Adiciona os dois painéis ao painel principal
        salesPanel.add(imagePanel, BorderLayout.WEST);
        salesPanel.add(infoPanel, BorderLayout.CENTER);
        salesPanel.add(customerInfoPanel, BorderLayout.NORTH); // Coloca o formulário na parte superior

        salesFrame.add(salesPanel);
        salesFrame.setVisible(true);
    }
}