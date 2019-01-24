/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.command;

import com.projetopoo.model.CompraModel;

/**
 *
 * @author Túlio
 */
public interface PagamentoCommand {
    boolean processarCompra (CompraModel compra);
}
