/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.model;

import java.io.Serializable;

/**
 *
 * @author Túlio
 */
public abstract class PessoaModel implements Serializable{
    protected String nome;
    protected String tel;
    protected String id;
    protected String cpf;

    public PessoaModel(String nome, String tel, String cpf) {
        this.nome = nome;
        this.tel = tel;
        this.id = "-1";
        this.cpf = cpf;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
