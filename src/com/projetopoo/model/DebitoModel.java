/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.model;

import java.io.Serializable;

/**
 *
 * @author dkaus
 */
public class DebitoModel implements Serializable {
    private String id;
    private String descricao;
     private float valor;
    private String data;

    public DebitoModel(String descricao, float valor, String data) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DebitoModel() {
    }
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
   
    
    
}
