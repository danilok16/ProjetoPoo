/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.dao;

import com.projetopoo.interfaces.Funcionario_dao;
import java.util.ArrayList;
import com.projetopoo.model.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Túlio
 */
public class FuncionarioDAO implements Funcionario_dao {

    ArrayList<FuncionarioModel> list = new ArrayList();
    private static FuncionarioDAO instance;

    private FuncionarioDAO() {
    }

    public static FuncionarioDAO getInstace() {
        if (instance == null) {
            instance = new FuncionarioDAO();
        }
        return instance;
    }

    @Override
    public void salvar(FuncionarioModel funcionario) {//Inseri um novo funcionario na lista
        FuncionarioDAO dao = new FuncionarioDAO();
        list = dao.recuperar();//recupera a lista do arquivo
        list.add(funcionario);
        try {
            FileOutputStream saveFile = new FileOutputStream("CadastroFuncionarios.txt");
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
            stream.writeObject(list);//salva a lista no arquivo
            stream.close();//fecha objeto de gravação      
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<FuncionarioModel> recuperar() {//Restaura lista
        if (new File("CadastroFuncionarios.txt").canRead() == true) {
            try {
                FileInputStream restFile = new FileInputStream("CadastroFuncionarios.txt");
                ObjectInputStream stream = new ObjectInputStream(restFile);
                ArrayList<FuncionarioModel> novo = (ArrayList) stream.readObject();
                stream.close();
                return novo;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                FileOutputStream saveFile = new FileOutputStream("CadastroFuncionarios.txt");
                ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
                stream.close();//fecha objeto de gravação
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public void alterar(ArrayList<FuncionarioModel> listp) {
        try {
            FileOutputStream saveFile = new FileOutputStream("CadastroFuncionarios.txt");
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
            stream.writeObject(listp);//salva a lista no arquivo
            stream.close();//fecha objeto de gravação
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
