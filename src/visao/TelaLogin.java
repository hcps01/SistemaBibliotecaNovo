package visao;

import javax.swing.*;
import java.awt.*;

public class TelaLogin {

    public TelaLogin() {
        // Criação da janela
        JFrame frame = new JFrame("Sistema de Biblioteca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);

        // Painel com GridBagLayout
        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Componentes
        JLabel labelUsuario = new JLabel("Usuário:");
        JTextField campoUsuario = new JTextField(15);

        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField campoSenha = new JPasswordField(15);

        JButton botaoLogin = new JButton("Login");

        // Espaçamento entre os componentes
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Linha 1 - Label de usuário
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(labelUsuario, gbc);

        // Campo de usuário
        gbc.gridx = 1;
        painel.add(campoUsuario, gbc);

        // Linha 2 - Label de senha
        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(labelSenha, gbc);

        // Campo de senha
        gbc.gridx = 1;
        painel.add(campoSenha, gbc);

        // Linha 3 - Botão
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // O botão ocupa duas colunas
        gbc.anchor = GridBagConstraints.CENTER;
        painel.add(botaoLogin, gbc);

        // Adiciona o painel à janela
        frame.add(painel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Inicializa a tela de login
        SwingUtilities.invokeLater(() -> new TelaLogin());
    }
}


