/**
 *
 * @author João Victor Crivoi Cesar Souza
 *         Atilio Almeida Costa
 */

public class Pessoa {
    
    private static int kp = 0;
    private String nome;
    private char sexo;
    private int idade;

    public Pessoa() {
        setKp();
    }

    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        setKp();
    }

    public void setKp() {
        kp++;  
    }
    public int getKp() {
        return kp;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public void setSexo(char sexo) {
        if (sexo == 'M' || sexo == 'F' ||sexo =='m' || sexo=='f') {
            this.sexo = sexo;
        } else {
            System.out.println("Sexo inválido. Use 'M','m' ,'F' ou 'f'.");
        }
    }
    
    public char getSexo() {
        return sexo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }
}