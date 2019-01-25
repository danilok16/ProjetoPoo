package com.projetopoo.controler;

import com.projetopoo.factory.FornecedorFactory;
import com.projetopoo.interfaces.Fornecedor_dao;
import com.projetopoo.model.FornecedorModel;
import java.util.ArrayList;

public class FornecedorController {

    public static ArrayList<FornecedorModel> restaurarFornecedor() {
        ArrayList<FornecedorModel> c;// c eh o array de fornecedor
        Fornecedor_dao fd = FornecedorFactory.create();//cd onde está chamando os metodos do DAO
        c = fd.recuperar();
        return c;
    }

    public static boolean removerFornecedor(String idString) {
        int tamanho, id = Integer.parseInt(idString);
        Fornecedor_dao dao = FornecedorFactory.create();
        FornecedorModel fornecedor;
        ArrayList<FornecedorModel> lista;
        lista = restaurarFornecedor();
        tamanho = lista.size();
        if (!lista.isEmpty()) {
            for (int i = 0; i < tamanho; i++) {
                fornecedor = lista.get(i);
                if (id == fornecedor.getIdForn()) {
                    lista.remove(i);
                    dao.alterar(lista);
                    return true;
                }
            }
        }
        return false;
    }

    public static int inserirFornecedor(FornecedorModel fornecedor) {
        Fornecedor_dao fd = FornecedorFactory.create();
        fornecedor.setIdForn(Integer.parseInt(GeraIdFornecedor()));
        fd.salvar(fornecedor);
        return fornecedor.getIdForn();

    }

    public static String GeraIdFornecedor() {
        int novoId = 0;
        FornecedorModel ultimo;
        ArrayList<FornecedorModel> lista;
        lista = restaurarFornecedor();

        if (!lista.isEmpty()) {
            ultimo = lista.get(lista.size() - 1);
            int i = Integer.parseInt(Integer.toString(ultimo.getIdForn()));
            novoId = i + 1;
        }
        String t = String.valueOf(novoId);
        return t;
    }

    public static FornecedorModel ConsultaFornecedor(String idString) {
        int tamanho, id = Integer.parseInt(idString);
        FornecedorModel fornecedor;
        ArrayList<FornecedorModel> lista;
        lista = restaurarFornecedor();
        tamanho = lista.size();
        if (!lista.isEmpty()) {
            for (int i = 0; i < tamanho; i++) {
                fornecedor = lista.get(i);
                if (id == fornecedor.getIdForn()) {
                    return lista.get(i);
                }
            }
        }
        return null;
    }

    public static boolean alterarFornecedor(FornecedorModel fornecedor) {
        int tamanho;
        ArrayList<FornecedorModel> lista;
        lista = restaurarFornecedor();
        Fornecedor_dao dao = FornecedorFactory.create();
        tamanho = lista.size();
        if (!lista.isEmpty()) {
            for (int i = 0; i < tamanho; i++) {
                if (fornecedor.getIdForn() == lista.get(i).getIdForn()) {
                    lista.get(i).setCnpj(fornecedor.getCnpj());
                    lista.get(i).setRazaoSocial(fornecedor.getRazaoSocial());
                    dao.alterar(lista);
                    return true;
                }
            }
        }
        return false;
    }
}
