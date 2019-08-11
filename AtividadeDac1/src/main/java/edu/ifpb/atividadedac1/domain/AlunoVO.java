package edu.ifpb.atividadedac1.domain;

import java.io.Serializable;

/**
 *
 * @author Lucas
 */
public class AlunoVO implements Serializable {

    private String nome;
    private String cpf;
    private int idade;

    public AlunoVO(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public AlunoVO() {
    }

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
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "AlunoVO{" + "nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + '}';
    }

}
