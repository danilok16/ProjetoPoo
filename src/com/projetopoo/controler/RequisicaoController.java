/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.controler;

import com.projetopoo.chainofresponsibility.aprovarrequisicao.AprovadorNivel1;
import com.projetopoo.chainofresponsibility.aprovarrequisicao.AprovadorNivel2;
import com.projetopoo.chainofresponsibility.aprovarrequisicao.AprovadorNivel3;
import com.projetopoo.chainofresponsibility.aprovarrequisicao.AprovadorNivel4;
import com.projetopoo.chainofresponsibility.aprovarrequisicao.AprovarRequisicao;
import com.projetopoo.factory.RequisicaoFactory;
import com.projetopoo.interfaces.Requisicao_dao;
import com.projetopoo.model.FuncionarioModel;
import com.projetopoo.model.RequisicaoModel;
import java.util.ArrayList;

/**
 *
 * @author Túlio
 */
public class RequisicaoController {
    
    public void cadastrar(RequisicaoModel requisicao){
        Requisicao_dao dao = RequisicaoFactory.create();        
        dao.salvar(requisicao);
    }
    
    public ArrayList<RequisicaoModel> recuperar(){
        Requisicao_dao dao = RequisicaoFactory.create();
        return dao.recuperar();
    }
    
    public void atualizarLista(ArrayList<RequisicaoModel> lista){
        Requisicao_dao dao = RequisicaoFactory.create();
        dao.alterar(lista);
    }   
    public void alterar(RequisicaoModel requisicao){
      Requisicao_dao dao = RequisicaoFactory.create();   
        ArrayList<RequisicaoModel> list = new ArrayList<>();
        list = dao.recuperar();
         for(int i = 0; i< list.size(); i++){
            if(requisicao.getIdRequisicao() == list.get(i).getIdRequisicao()){
                list.get(i).setAprovador(requisicao.getAprovador());
                list.get(i).setStatus(requisicao.getStatus());
            }
        }
    }
    
    public ArrayList<RequisicaoModel> requisicoesPendentes(String idFuncionario){
        ArrayList<RequisicaoModel> pendentes = new ArrayList<>();
        ArrayList<RequisicaoModel> requisicoes = recuperar();
        CadastroFuncionarioController c = new CadastroFuncionarioController();
        FuncionarioModel f = c.ConsultaFuncionario(idFuncionario);
       for(int i = 0; i < requisicoes.size(); i++){
           if(requisicoes.get(i).getStatus() == f.getNivelAcesso()){
               pendentes.add(requisicoes.get(i));
           }
       }
       if(!pendentes.isEmpty()){
           return pendentes;
       }
       return null;
    }
    
     public RequisicaoModel consultar(String idRequisicao){
        Requisicao_dao dao = RequisicaoFactory.create();   
        ArrayList<RequisicaoModel> list = new ArrayList<>();
        list = dao.recuperar();
         for(int i = 0; i< list.size(); i++){
            if(idRequisicao.equals(list.get(i).getIdRequisicao())){
                return list.get(i);
            }
        }
        return null;
    }
    
    
    public String GeraIdRequisicao(){
        int novoId= 0;
       RequisicaoModel ultimo;
      Requisicao_dao dao = RequisicaoFactory.create();   
        ArrayList<RequisicaoModel> lista;
        lista = dao.recuperar(); 
        if(!lista.isEmpty()){
            ultimo = lista.get(lista.size()-1);
            int i = Integer.parseInt(ultimo.getIdRequisicao());
            novoId= i +1;
            
        }
        String t = String.valueOf(novoId);
        return t;
    }
    
    public void Aprovar(RequisicaoModel requisicao){
        AprovarRequisicao ap1 = new AprovadorNivel1 ();
        AprovarRequisicao ap2 = new AprovadorNivel2 ();
        AprovarRequisicao ap3 = new AprovadorNivel3 ();
        AprovarRequisicao ap4 = new AprovadorNivel4 ();
      
       ap1.setProximoNivel(ap2);
       ap2.setProximoNivel(ap3);
       ap3.setProximoNivel(ap4);
           
       ap1.aprovar(requisicao);
    }
}

    
