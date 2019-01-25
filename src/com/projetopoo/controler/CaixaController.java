/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.controler;

import com.projetopoo.model.*;
import java.util.ArrayList;

/**
 *
 * @author Andrade
 */
public class CaixaController {

    public static void somaItemCaixa(ProdutoModel a, ArrayList<ProdutoModel> itens, CompraModel compraA) {
        itens.add(a);
        compraA.setQtdItenCompra(compraA.getQtdItenCompra() + a.getQtdDesejada());
        compraA.setValorTot(compraA.getValorTot() + (a.getPreco() * a.getQtdDesejada()));
        compraA.setItens(itens);
    }

    public static int findItem(ProdutoModel a, ArrayList<ProdutoModel> itens) {
        for (ProdutoModel s : itens) {
            if (s.getIdItem().equals(a.getIdItem())) {
                return 1;
            }
        }
        return 0;
    }

    public static void modificaQtdItem(ProdutoModel a, ArrayList<ProdutoModel> itens, CompraModel compraA) {
        for (ProdutoModel s : itens) {
            if (s.getIdItem() == a.getIdItem()) {
                s.setQtdDesejada(s.getQtdDesejada() + a.getQtdDesejada());
                compraA.setItens(itens);
            }
        }
    }

    public static void subValorTot(ProdutoModel a, CompraModel compraA) {
        compraA.setValorTot(compraA.getValorTot() - (a.getQtdDesejada() * a.getPreco()));
    }

    public static void removerItemCaixaController(ProdutoModel itemRe, CompraModel compraA) {
        System.out.println("Item removido: " + itemRe.getIdItem());
        subValorTot(itemRe, compraA);
    }
}
