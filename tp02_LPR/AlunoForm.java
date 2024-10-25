import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Atilio Almeida Costa & João Victor Crivoi
public class AlunoForm extends JFrame {

    private JTextField campoNome;
    private JTextField campoIdade;
    private JTextField campoEndereco;
    private List<Aluno> alunos;

    public AlunoForm() {
        alunos = new ArrayList<>();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Nome:"), gbc);
        campoNome = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 0;
        add(campoNome, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Idade:"), gbc);
        campoIdade = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 1;
        add(campoIdade, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Endereço:"), gbc);
        campoEndereco = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 2;
        add(campoEndereco, gbc);

        JPanel panelBotoes = new JPanel(new GridLayout());
        JButton botaoOk = new JButton("Ok");
        botaoOk.addActionListener(e -> adicionarAluno());
        panelBotoes.add(botaoOk);

        JButton botaoLimpar = new JButton("Limpar");
        botaoLimpar.addActionListener(e -> limparCampos());
        panelBotoes.add(botaoLimpar);

        JButton botaoMostrar = new JButton("Mostrar");
        botaoMostrar.addActionListener(e -> mostrarAlunos());
        panelBotoes.add(botaoMostrar);

        JButton botaoSair = new JButton("Sair");
        botaoSair.addActionListener(e -> System.exit(0));
        panelBotoes.add(botaoSair);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        add(panelBotoes, gbc);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 180);
        setVisible(true);
    }

    private void adicionarAluno() {
        String nome = campoNome.getText();
        int idade = Integer.parseInt(campoIdade.getText());
        String endereco = campoEndereco.getText();

        alunos.add(new Aluno(endereco, idade, nome));
        limparCampos();
    }

    private void limparCampos() {
        campoNome.setText("");
        campoIdade.setText("");
        campoEndereco.setText("");
    }

    private void mostrarAlunos() {
        StringBuilder listaAlunos = new StringBuilder("Lista de Alunos:\n");
        for (Aluno aluno : alunos) {
            listaAlunos.append("Id: ").append(aluno.getUuid()).append(" Nome: ").append(aluno.getNome()).append("\n");
        }
        JOptionPane.showMessageDialog(this, listaAlunos.toString());
    }

    public static void main(String[] args) {
        new AlunoForm();
    }
}
