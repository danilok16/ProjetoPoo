package com.projetopoo.controler;

import com.projetopoo.factory.FuncionarioFactory;
import com.projetopoo.interfaces.Funcionario_dao;
import com.projetopoo.model.*;
import java.util.ArrayList;

/**
 *
 * @author Andrade
 */
public class CadastroFuncionarioController {

    public static ArrayList<FuncionarioModel> restaurarFuncionarios() {
        ArrayList<FuncionarioModel> c = new ArrayList();// c eh o array de compras
        Funcionario_dao cd = FuncionarioFactory.create();//cd onde está chamando os metodos do DAO
        c = cd.recuperar();
        return c;
    }

    public static String GeraIdFuncionario() {
        int novoId = 0;
        FuncionarioModel ultimo;
        ArrayList<FuncionarioModel> lista;
        lista = restaurarFuncionarios();

        if (!lista.isEmpty()) {
            ultimo = lista.get(lista.size() - 1);
            int i = Integer.parseInt(ultimo.getId());

            novoId = i + 1;

        }
        String t = String.valueOf(novoId);
        return t;
    }

    public void InserirFuncionario(FuncionarioModel funcionario) {
        Funcionario_dao fd = FuncionarioFactory.create();
        funcionario.setId(GeraIdFuncionario());
        funcionario.setNivelAcesso(4);
        fd.salvar(funcionario);
        fd.salvar(funcionario);
        System.out.println("Entrou pra salvar");
        //System.out.println(compra.getItens().get(0).getDescricao());

    }

    public FuncionarioModel ConsultaFuncionario(String cpf) {
        int tamanho;
        FuncionarioModel funcionario;
        ArrayList<FuncionarioModel> lista;
        lista = restaurarFuncionarios();
        tamanho = lista.size();
        if (!lista.isEmpty()) {
            for (int i = 0; i < tamanho; i++) {
                funcionario = lista.get(i);
                if (cpf.equals(funcionario.getCpf())) {
                    return lista.get(i);
                }
            }
        }
        return null;
    }

    public void removerFuncionario(String id) {
        int tamanho;
        FuncionarioModel funcionario;
        Funcionario_dao fd = FuncionarioFactory.create();
        ArrayList<FuncionarioModel> lista;
        lista = restaurarFuncionarios();
        tamanho = lista.size();
        if (!lista.isEmpty()) {
            for (int i = 0; i < tamanho; i++) {
                funcionario = lista.get(i);
                if (id.equals(funcionario.getCpf())) {
                    lista.remove(i);
                    fd.alterar(lista);
                    return;
                }
            }
        }
    }

    public void alterarFuncionario(FuncionarioModel funcionario) {
        int tamanho;
        Funcionario_dao fd = FuncionarioFactory.create();
        FuncionarioModel funcionarioAux;
        ArrayList<FuncionarioModel> lista;
        lista = restaurarFuncionarios();
        tamanho = lista.size();
        if (!lista.isEmpty()) {
            for (int i = 0; i < tamanho; i++) {
                funcionarioAux = lista.get(i);
                if (funcionarioAux.getCpf().equals(funcionario.getCpf())) {
                    lista.get(i).setSalario(funcionario.getSalario());
                    lista.get(i).setFuncao(funcionario.getFuncao());
                    lista.get(i).setNome(funcionario.getNome());
                    lista.get(i).setTel(funcionario.getTel());
                    fd.alterar(lista);
                    return;
                }
            }
        }

    }
}
