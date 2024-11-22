/**
 *
 * @author João Victor Crivoi Cesar Souza
 *         Atilio Almeida Costa
 */

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 
 public class FormPessoa extends JFrame {
     private JTextField nomeField;
     private JTextField idadeField;
     private JComboBox<String> sexoComboBox;
     private JTextField numeroField;
     private JButton okButton;
     private JButton mostrarButton;
     private JButton limparButton;
     private JButton sairButton;
     
     private Pessoa fulanoPessoa;
     
     public FormPessoa() {
         
        setTitle("Cadastro de pessoas");
        setLayout(new GridLayout(7, 2, 10, 10));

         add(new JLabel("Número:"));
         numeroField = new JTextField();
         numeroField.setEditable(false);
         add(numeroField);
 
         add(new JLabel("Nome:"));
         nomeField = new JTextField();
         add(nomeField);
 
         add(new JLabel("Sexo:"));
         String[] sexos = {"M", "F"};
         sexoComboBox = new JComboBox<>(sexos);
         add(sexoComboBox);
 
         add(new JLabel("Idade:"));
         idadeField = new JTextField();
         add(idadeField);
 
         okButton = new JButton("OK");
         mostrarButton = new JButton("Mostrar");
         limparButton = new JButton("Limpar");
         sairButton = new JButton("Sair");
 
         add(okButton);
         add(mostrarButton);
         add(limparButton);
         add(sairButton); 
         
         okButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 String nome = nomeField.getText();
                 String sexo = (String) sexoComboBox.getSelectedItem(); 
                 int idade = Integer.parseInt(idadeField.getText());
 
                 if (sexo == null) {
                     JOptionPane.showMessageDialog(null, "Selecione o sexo!", "Erro", JOptionPane.ERROR_MESSAGE);
                     return;
                 }
 
                 fulanoPessoa = new Pessoa(nome, sexo.charAt(0), idade); 
                 numeroField.setText(String.valueOf(fulanoPessoa.getKp()));
 
                 nomeField.setText("");
                 sexoComboBox.setSelectedIndex(0); 
                 idadeField.setText("");
             }
         });
 
         mostrarButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 if (fulanoPessoa != null) {
                     JOptionPane.showMessageDialog(null, 
                         "Número: " + fulanoPessoa.getKp() + "\n" +
                         "Nome: " + fulanoPessoa.getNome() + "\n" +
                         "Sexo: " + fulanoPessoa.getSexo() + "\n" +
                         "Idade: " + fulanoPessoa.getIdade(),
                         "Dados da Pessoa", JOptionPane.INFORMATION_MESSAGE);
                 } else {
                     JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                 }
             }
         });
 
         limparButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 nomeField.setText("");
                 sexoComboBox.setSelectedIndex(0); 
                 idadeField.setText("");
                 numeroField.setText("");
             }
         });
 
         sairButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 System.exit(0);
             }
         });
 
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(300, 300);
         setLocationRelativeTo(null); 
     }
 
     public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 new FormPessoa().setVisible(true);
             }
         });
     }
 }
 