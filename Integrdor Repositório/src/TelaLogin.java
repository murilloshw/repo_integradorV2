import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class TelaLogin extends JFrame {

    public TelaLogin() {
        setTitle("Arcade Space");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 1. REMOVE BORDAS E DEIXA EM TELA CHEIA SEM BARRA DE TAREFAS
        setUndecorated(true);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if (gd.isFullScreenSupported()) {
            gd.setFullScreenWindow(this);
        } else {
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        // Tecla ESC para sair do programa
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }
        });
        setFocusable(true);

        // Carrega a imagem de fundo
        ImageIcon fundo = null;
        try {
            fundo = new ImageIcon(getClass().getResource("/imagens/fundo-login.png"));
        } catch (Exception e) {
            // Caso a imagem não exista no caminho especificado
        }

        JLabel background = new JLabel();
        if (fundo != null && fundo.getImage() != null) {
            background.setIcon(fundo);
        } else {
            background.setBackground(new Color(10, 12, 34));
            background.setOpaque(true);
        }

        background.setLayout(new GridBagLayout());

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setOpaque(false);
        loginPanel.setPreferredSize(new Dimension(500, 520));

        // Logo / titulo
        JLabel titulo = new JLabel("ARCADE SPACE");
        titulo.setFont(new Font("Arial", Font.BOLD, 42));
        titulo.setForeground(new Color(255, 255, 255));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Campo e-mail
        JLabel emailLabel = new JLabel("E-MAIL");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 22));
        emailLabel.setForeground(Color.WHITE);

        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(400, 55));
        emailField.setFont(new Font("Arial", Font.PLAIN, 24));
        emailField.setBackground(new Color(18, 24, 58));
        emailField.setForeground(Color.WHITE);
        emailField.setCaretColor(Color.WHITE);
        emailField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(116, 89, 255), 2),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));

        // Campo senha
        JLabel senhaLabel = new JLabel("SENHA");
        senhaLabel.setFont(new Font("Arial", Font.BOLD, 22));
        senhaLabel.setForeground(Color.WHITE);

        JPasswordField senhaField = new JPasswordField();
        senhaField.setPreferredSize(new Dimension(400, 55));
        senhaField.setFont(new Font("Arial", Font.PLAIN, 24));
        senhaField.setBackground(new Color(18, 24, 58));
        senhaField.setForeground(Color.WHITE);
        senhaField.setCaretColor(Color.WHITE);
        senhaField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(116, 89, 255), 2),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));

        // Botão entrar
        JButton entrarBtn = new JButton("ENTRAR");
        entrarBtn.setPreferredSize(new Dimension(400, 60));
        entrarBtn.setFont(new Font("Arial", Font.BOLD, 26));
        entrarBtn.setBackground(new Color(146, 84, 255));
        entrarBtn.setForeground(Color.WHITE);
        entrarBtn.setBorder(BorderFactory.createLineBorder(new Color(146, 84, 255), 1));
        entrarBtn.setFocusPainted(false);
        entrarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        // 2. AÇÃO PARA NAVEGAR PARA O APP PRINCIPAL
        entrarBtn.addActionListener(e -> abrirAppPrincipal());

        // Texto inferior
        JPanel rodape = new JPanel(new BorderLayout());
        rodape.setOpaque(false);
        rodape.setMaximumSize(new Dimension(420, 30));

        JLabel esqueceu = new JLabel("Esqueceu a senha?");
        esqueceu.setForeground(new Color(255, 255, 255));
        esqueceu.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel criar = new JLabel("Criar conta");
        criar.setForeground(new Color(255, 255, 255));
        criar.setHorizontalAlignment(SwingConstants.RIGHT);

        rodape.add(esqueceu, BorderLayout.WEST);
        rodape.add(criar, BorderLayout.EAST);

        // Container central
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setOpaque(false);
        form.setPreferredSize(new Dimension(450, 400));
        form.setAlignmentX(Component.CENTER_ALIGNMENT);

        form.add(Box.createVerticalStrut(20));
        form.add(emailLabel);
        form.add(Box.createVerticalStrut(10));
        form.add(emailField);
        form.add(Box.createVerticalStrut(25));
        form.add(senhaLabel);
        form.add(Box.createVerticalStrut(10));
        form.add(senhaField);
        form.add(Box.createVerticalStrut(25));
        form.add(entrarBtn);
        form.add(Box.createVerticalStrut(20));
        form.add(rodape);

        loginPanel.add(Box.createVerticalStrut(20));
        loginPanel.add(titulo);
        loginPanel.add(Box.createVerticalStrut(35));
        loginPanel.add(form);

        background.add(loginPanel);

        setContentPane(background);
        setVisible(true);
    }

    private void abrirAppPrincipal() {
        // Abre a tela principal App
        new App().setVisible(true);
        // Fecha a tela de login
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaLogin();
        });
    }
}