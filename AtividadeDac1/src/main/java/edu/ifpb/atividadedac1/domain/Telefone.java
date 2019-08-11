/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.atividadedac1.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
/**
 *
 * @author Lucas
 */
@Embeddable
public class Telefone implements Serializable{
    
    private String numero;
    @Enumerated(EnumType.STRING)
    private TelefoneType tipo;

    public Telefone() {
    }

    public Telefone(String numero, TelefoneType tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TelefoneType getTipo() {
        return tipo;
    }

    public void setTypo(TelefoneType tipo) {
        this.tipo = tipo;
    }

    public void setTipo(TelefoneType tipo) {
        this.tipo = tipo;
    }
    }
