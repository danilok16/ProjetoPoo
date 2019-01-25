/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.dao;

import com.projetopoo.factory.RequisicaoFactory;
import com.projetopoo.interfaces.*;
import com.projetopoo.model.RequisicaoModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dkaus
 */
public class RequisicaoDAO implements Requisicao_dao {

    ArrayList<RequisicaoModel> list = new ArrayList();

    private static RequisicaoDAO instance;

    private RequisicaoDAO() {
    }

    public static RequisicaoDAO getInstance() {
        if (instance == null) {
            instance = new RequisicaoDAO();
        }
        return instance;
    }

    @Override
    public void salvar(RequisicaoModel requisicao) {//Inseri um novo funcionario na lista
        Requisicao_dao dao = RequisicaoFactory.create();
        list = dao.recuperar();//recupera a lista do arquivo
        list.add(requisicao);
        try {
            FileOutputStream saveFile = new FileOutputStream("CadastroRequisicaoDeCompras.txt");
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
            stream.writeObject(list);//salva a lista no arquivo
            stream.close();//fecha objeto de gravação      
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(RequisicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<RequisicaoModel> recuperar() {//Recupera lista
        if (new File("CadastroRequisicaoDeCompras.txt").canRead() == true) { // se o arrquivo existir
            try {
                FileInputStream restFile = new FileInputStream("CadastroRequisicaoDeCompras.txt");
                ObjectInputStream stream = new ObjectInputStream(restFile);
                ArrayList<RequisicaoModel> novo = (ArrayList) stream.readObject();
                stream.close();
                return novo;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(RequisicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RequisicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {// se o arquivo não existir
            try {
                FileOutputStream saveFile = new FileOutputStream("CadastroRequisicaoDeCompras.txt");
                ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
                stream.close();//fecha objeto de gravação
            } catch (FileNotFoundException ex) {
                Logger.getLogger(RequisicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RequisicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public void alterar(ArrayList<RequisicaoModel> listp) {
        try {
            FileOutputStream saveFile = new FileOutputStream("CadastroRequisicaoDeCompras.txt");
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
            stream.writeObject(listp);//salva a lista no arquivo
            stream.close();//fecha objeto de gravação
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(RequisicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
