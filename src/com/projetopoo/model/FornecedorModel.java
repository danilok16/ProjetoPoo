package com.projetopoo.model;

import java.io.Serializable;

public class FornecedorModel implements Serializable{
    private String cnpj;
    private int idForn;
    private String razaoSocial;

    public FornecedorModel(String cnpj, int idForn, String razaoSocial) {
        this.cnpj = cnpj;
        this.idForn = idForn;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getIdForn() {
        return idForn;
    }

    public void setIdForn(int idForn) {
        this.idForn = idForn;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
