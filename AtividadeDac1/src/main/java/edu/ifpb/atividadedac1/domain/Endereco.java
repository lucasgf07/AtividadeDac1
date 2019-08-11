/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.atividadedac1.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
/**
 *
 * @author Lucas
 */
@Embeddable
public class Endereco implements Serializable{
    private String rua;
    private String bairo;
    private String cidade;
    private String CEP;

    public Endereco(String rua, String bairo, String cidade, String CEP) {
        this.rua = rua;
        this.bairo = bairo;
        this.cidade = cidade;
        this.CEP = CEP;
    }

    public Endereco() {
    }
    
     public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairo() {
        return bairo;
    }

    public void setBairrro(String bairo) {
        this.bairo = bairo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    @Override
    public String toString() {
        return "Endereco{" + "rua=" + rua + ", bairrro=" + bairo + ", cidade=" + cidade + ", CEP=" + CEP + '}';
    }  
    
}
