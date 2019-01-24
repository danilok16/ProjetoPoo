/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.interfaces;

import com.projetopoo.model.FuncionarioModel;
import java.util.ArrayList;

/**
 *
 * @author Téo
 */
public interface Funcionario_dao {
    void salvar(FuncionarioModel compra);
    ArrayList<FuncionarioModel> recuperar();
    void alterar(ArrayList<FuncionarioModel> listp);
}
