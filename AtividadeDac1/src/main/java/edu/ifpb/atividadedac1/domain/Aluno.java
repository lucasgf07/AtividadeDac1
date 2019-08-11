
package edu.ifpb.atividadedac1.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lucas
 */
@Entity
public class Aluno extends Pessoa implements Serializable{
    private String matricula;
    @Temporal(TemporalType.DATE)
    private Date dataIngrsso;
    private String turma;

    public Aluno(String matricula, Date dataIngrsso, String turma, String nome, String cpf, int idade, Date dataNascimento, Endereco endereco) {
        super(nome, cpf, idade, dataNascimento, endereco);
        this.matricula = matricula;
        this.dataIngrsso = dataIngrsso;
        this.turma = turma;
    }
  
    public Aluno() {
    }
    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDataIngrsso() {
        return dataIngrsso;
    }

    public void setDataIngrsso(Date dataIngrsso) {
        this.dataIngrsso = dataIngrsso;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

   
    
    
}
