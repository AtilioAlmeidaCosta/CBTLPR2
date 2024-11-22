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
     private JRadioButton masculinoRadioButton; 
     private JRadioButton femininoRadioButton;  
     private ButtonGroup sexoButtonGroup;       
     private JTextField numeroField;
     private JButton okButton;
     private JButton mostrarButton;
     private JButton limparButton;
     private JButton sairButton;
 
     private Pessoa fulanoPessoa;
 
     public FormPessoa() {
         
         setTitle("Cadastro de pessoas");
         setLayout(new GridLayout(8, 2, 10, 10));
 
         add(new JLabel("Número:"));
         numeroField = new JTextField();
         numeroField.setEditable(false);
         add(numeroField);
 
         add(new JLabel("Nome:"));
         nomeField = new JTextField();
         add(nomeField);
 
         add(new JLabel("Sexo:"));
         masculinoRadioButton = new JRadioButton("Masculino");
         femininoRadioButton = new JRadioButton("Feminino");
         
         sexoButtonGroup = new ButtonGroup();
         sexoButtonGroup.add(masculinoRadioButton);
         sexoButtonGroup.add(femininoRadioButton);
 
         JPanel sexoPanel = new JPanel(new FlowLayout());
         sexoPanel.add(masculinoRadioButton);
         sexoPanel.add(femininoRadioButton);
         add(sexoPanel);
 
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
                 char sexo = ' ';
                 
                 if (masculinoRadioButton.isSelected()) {
                     sexo = 'M';
                 } else if (femininoRadioButton.isSelected()) {
                     sexo = 'F';
                 } else {
                     JOptionPane.showMessageDialog(null, "Selecione o sexo!", "Erro", JOptionPane.ERROR_MESSAGE);
                     return;
                 }
 
                 int idade = Integer.parseInt(idadeField.getText());
 
                 fulanoPessoa = new Pessoa(nome, sexo, idade);
                 numeroField.setText(String.valueOf(fulanoPessoa.getKp()));
 
                 nomeField.setText("");
                 sexoButtonGroup.clearSelection(); 
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
                 sexoButtonGroup.clearSelection(); 
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
         setSize(300, 350);
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
 