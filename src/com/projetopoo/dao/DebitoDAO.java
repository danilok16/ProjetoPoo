/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.dao;

import com.projetopoo.factory.DebitoFactory;
import com.projetopoo.interfaces.Debito_dao;
import com.projetopoo.model.DebitoModel;
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
public class DebitoDAO implements Debito_dao{
    
    ArrayList<DebitoModel> list = new ArrayList();
    private static DebitoDAO instance;
    private DebitoDAO() {}
    
    public static DebitoDAO getInstance(){
        if (instance == null){
            instance = new DebitoDAO();
        }
        return instance;
    }
    
    @Override
    public void salvar(DebitoModel debito){//Inseri um novo funcionario na lista
        Debito_dao dao = DebitoFactory.create();
        list = dao.recuperar();//recupera a lista do arquivo
        list.add(debito);
        try{
            FileOutputStream saveFile = new FileOutputStream("DebitoRegistro.txt");
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
            stream.writeObject(list);//salva a lista no arquivo
            stream.close();//fecha objeto de gravação      
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException ex) {
            Logger.getLogger(DebitoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }    
    
    @Override
    public ArrayList<DebitoModel> recuperar(){//Restaura lista
        if(new File("DebitoRegistro.txt").canRead() == true){
            try{
                FileInputStream restFile = new FileInputStream("DebitoRegistro.txt");
                ObjectInputStream stream = new ObjectInputStream(restFile);            
                ArrayList<DebitoModel> novo = (ArrayList) stream.readObject();
                stream.close();
                return novo;
            }catch(FileNotFoundException e){
                e.printStackTrace(); 
            }catch (IOException ex) {
                Logger.getLogger(DebitoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }catch (ClassNotFoundException ex) {
                Logger.getLogger(DebitoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try{
            FileOutputStream saveFile = new FileOutputStream("DebitoRegistro.txt");
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
            stream.close();//fecha objeto de gravação
            }catch (FileNotFoundException ex) {
                Logger.getLogger(DebitoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }catch (IOException ex) {
            Logger.getLogger(DebitoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    @Override
    public void alterar(ArrayList<DebitoModel> listp ){
        try{
            FileOutputStream saveFile = new FileOutputStream("DebitoRegistro.txt");
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
            stream.writeObject(listp);//salva a lista no arquivo
            stream.close();//fecha objeto de gravação
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException ex) {
            Logger.getLogger(DebitoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
