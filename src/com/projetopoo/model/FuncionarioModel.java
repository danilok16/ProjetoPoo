package com.projetopoo.model;

import java.io.Serializable;


public class FuncionarioModel extends PessoaModel implements Serializable {
    private String funcao;
    private float salario;
    private String senha;
     private int nivelAcesso;

    
    public FuncionarioModel(String funcao, String senha, float salario, String nome, String tel, String cpf) {
        super(nome, tel, cpf);
        
        this.senha= senha;
        this.funcao = funcao;
        this.salario = salario;
        
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getTel() {
        return tel;
    }

    @Override
    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
   
    
}
