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
public class RequisicaoModel implements Serializable {

    private String dataDeEmissao;
    private String dataDeEntrega;
    private int status;
    private String descricao;
    private int qtdDesejada;
    private float valorTotal;
    private String idRequisicao;
    private FuncionarioModel requisitante;
    private FuncionarioModel aprovador;

    public void setStatus(StatusAprovacao statusAprovacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public enum StatusAprovacao {

        Z(0), N1(1), N2(2), N3(3), N4(4), APROVADO(5), REPROVADO(6), CANCELADO(7);

        public final int c;

        StatusAprovacao(int status) {
            c = status;
        }

        public int getValor() {
            return c;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getIdRequisicao() {
        return idRequisicao;
    }

    public void setIdRequisicao(String idRequisicao) {
        this.idRequisicao = idRequisicao;
    }

    public FuncionarioModel getRequisitante() {
        return requisitante;
    }

    public void setRequisitante(FuncionarioModel requisitante) {
        this.requisitante = requisitante;
    }

    public FuncionarioModel getAprovador() {
        return aprovador;
    }

    public void setAprovador(FuncionarioModel aprovador) {
        this.aprovador = aprovador;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdDesejada() {
        return qtdDesejada;
    }

    public void setQtdDesejada(int qtdDesejada) {
        this.qtdDesejada = qtdDesejada;
    }

    public String getDataDeEmissao() {
        return dataDeEmissao;
    }

    public void setDataDeEmissao(String dataDeEmissao) {
        this.dataDeEmissao = dataDeEmissao;
    }

    public String getDataDeEntrega() {
        return dataDeEntrega;
    }

    public void setDataDeEntrega(String dataDeEntrega) {
        this.dataDeEntrega = dataDeEntrega;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
