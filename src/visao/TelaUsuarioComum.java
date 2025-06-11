package visao;

import java.awt.FlowLayout;
import javax.swing.*;

import controle.BibliotecaManager;
import modelo.Livro;

public class TelaUsuarioComum {

    public TelaUsuarioComum() {
        JFrame frame = new JFrame("sistemBiblioteca");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton botaoPesquisa = new JButton("Buscar");
        JTextField campoPesquisa = new JTextField(20);

        frame.add(botaoPesquisa);
        frame.add(campoPesquisa);
        frame.setVisible(true);

        botaoPesquisa.addActionListener(e -> {
            String tituloBusca = campoPesquisa.getText(); // Captura o texto digitado
            BibliotecaManager bibliotecaManager = new BibliotecaManager();
            Livro livroEncontrado = bibliotecaManager.buscarLivro(tituloBusca); // Usa o texto como argumento

            if (livroEncontrado != null) {
                JOptionPane.showMessageDialog(frame, "Livro encontrado: " + livroEncontrado.getTitulo());
            } else {
                JOptionPane.showMessageDialog(frame, "Livro não encontrado.");
            }
        });
    }
}
