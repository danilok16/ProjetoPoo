/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.controler;

import com.projetopoo.factory.ItemFactory;
import com.projetopoo.interfaces.Item_dao;
import com.projetopoo.model.*;
import java.util.ArrayList;

/**
 *
 * @author Andrade
 */
public final class ItemController {

    private ArrayList<ProdutoModel> itemList = new ArrayList();
    private ArrayList<ProdutoModel> itemSpecificList = new ArrayList();

    public ArrayList<ProdutoModel> recuperarLista() {
        Item_dao dao = ItemFactory.create();
        itemList = dao.recuperar();
        return itemList;
    }

    public ArrayList<ProdutoModel> recuperarListaEspecifica(String item, String categoria) {//restorna uma lista especifica
        Item_dao dao = ItemFactory.create();
        itemList = dao.recuperar();

        switch (categoria) {
            case "ID":
                for (int i = 0; i < itemList.size(); i++) {
                    if (item.equals(itemList.get(i).getIdItem())) {
                        itemSpecificList.add(itemList.get(i));
                    }
                }
                break;
            case "POSIÇÃO":
                for (int i = 0; i < itemList.size(); i++) {
                    if (item.equals(itemList.get(i).getPosicaoEstoque())) {
                        itemSpecificList.add(itemList.get(i));
                    }
                }
                break;
            case "DESCRIÇÃO":
                for (int i = 0; i < itemList.size(); i++) {
                    if (item.equalsIgnoreCase(itemList.get(i).getDescricao())) {
                        itemSpecificList.add(itemList.get(i));
                    }
                }
                break;
        }
        return itemSpecificList;
    }

    public ProdutoModel consultarItem(String idItem) {
        Item_dao dao = ItemFactory.create();
        itemList = dao.recuperar();
        for (int i = 0; i < itemList.size(); i++) {
            if (idItem.equals(itemList.get(i).getIdItem())) {
                return itemList.get(i);
            }
        }
        return null;
    }

    public void salvar(ItemModel item) {
        if (item != null) {
            Item_dao dao = ItemFactory.create();
            dao.salvar(item);
        }
    }

    public void salvarAlteracao(ArrayList<ProdutoModel> listp) {
        if (listp != null) {
            Item_dao dao = ItemFactory.create();
            dao.alterar(listp);
        }
    }

}
