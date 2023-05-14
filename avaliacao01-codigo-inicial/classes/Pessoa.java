package classes;

import java.util.InputMismatchException;
public class Pessoa {
    private String nome; 
    private String cpf;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
        if (cpf.length() != 11) {
            
            throw new InputMismatchException("O CPF deve ter 11 caracteres.");
        }
    }
}
