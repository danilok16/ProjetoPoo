package com.projetopoo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CaixaModel implements Serializable{
    private String idFuncionario;
    private int qtdItemReg;
    private float somaCaixa;
    private String idCaixa;
    private boolean aberto;
    private boolean pagamentoRec;
    private final List<CompraModel> lc;
    private CompraModel novaCompra;
    private EstoqueModel e;

    public CaixaModel(String idFuncionario, String idCaixa, CompraModel novaCompra, EstoqueModel e) {
        this.idFuncionario = idFuncionario;
        this.novaCompra = novaCompra;
        this.somaCaixa = 0;
        this.idCaixa = idCaixa;
        this.aberto = false;
        this.pagamentoRec = false;
        this.e = e;
        this.qtdItemReg = 0;
        this.lc = new ArrayList<>();
    }


    public CompraModel getNovaCompra() {
        return novaCompra;
    }

    public void setNovaCompra(CompraModel novaCompra) {
        this.novaCompra = novaCompra;
    }

    public EstoqueModel getE() {
        return e;
    }

    public void setE(EstoqueModel e) {
        this.e = e;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getQtdItemReg() {
        return qtdItemReg;
    }

    public void setQtdItemReg(int qtdItemReg) {
        for (CompraModel s:lc){
            this.qtdItemReg += s.getQtdItenCompra();
        }
    }

    public String getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(String idCaixa) {
        this.idCaixa = idCaixa;
    }

    public boolean getAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public boolean getPagamentoRec() {
        return pagamentoRec;
    }

    public void setPagamentoRec(boolean pagamentoRec) {
        this.pagamentoRec = pagamentoRec;
    }

    public float getSomaCaixa() {
        return somaCaixa;
    }

    public void setSomaCaixa(float somaCaixa) {
        this.somaCaixa = somaCaixa;
    }

   /* public String getC(int id) {
        for (CompraModel s:lc){
            if(s.getIdCompra() == id){
                return s.toString();
            }
        }
        return null;
    }*/

    public void setlistaC() {
        this.lc.add(novaCompra);
    }

    public void abrirCaixa(){
        this.setAberto(true);
    }

    public void fecharCaixa(){
        this.setAberto(false);
    }

   /* public float consultaPreco(int id){
        return e.consultaPreco(id);
    }

    public void verificaNoEstoque(){
        for (ItemModel s:this.novaCompra.getItens()){
            this.e.removeItemEst(s);
        }*/
    }

