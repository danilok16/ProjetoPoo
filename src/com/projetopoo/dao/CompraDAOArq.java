package com.projetopoo.dao;

import com.projetopoo.factory.CompraFactory;
import com.projetopoo.interfaces.Compra_dao;
import com.projetopoo.model.CompraModel;
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
public class CompraDAOArq implements Compra_dao {

    ArrayList<CompraModel> list = new ArrayList();

    private static CompraDAOArq instance;

    private CompraDAOArq() {
    }

    public static CompraDAOArq getInstace() {
        if (instance == null) {
            instance = new CompraDAOArq();
        }
        return instance;
    }

    @Override
    public void salvar(CompraModel compra) {//Inseri um novo funcionario na lista
        Compra_dao dao = CompraFactory.create();
        list = dao.recuperar();
        list.add(compra);

        try {
            FileOutputStream saveFile = new FileOutputStream("RegistroCompra.txt");
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
            stream.writeObject(list);//salva a lista no arquivo
            stream.close();//fecha objeto de gravação
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(CompraDAOArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void alterar(ArrayList<CompraModel> listp) {
        try {
            FileOutputStream saveFile = new FileOutputStream("RegistroCompra.txt");
            ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
            stream.writeObject(listp);//salva a lista no arquivo
            stream.close();//fecha objeto de gravação
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(CompraDAOArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<CompraModel> recuperar() {
        if (new File("RegistroCompra.txt").canRead() == true) {
            try {
                FileInputStream restFile = new FileInputStream("RegistroCompra.txt");
                ObjectInputStream stream = new ObjectInputStream(restFile);
                ArrayList<CompraModel> novo = (ArrayList) stream.readObject();
                stream.close();
                return novo;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(CompraDAOArq.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CompraDAOArq.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                FileOutputStream saveFile = new FileOutputStream("RegistroCompra.txt");
                ObjectOutputStream stream = new ObjectOutputStream(saveFile);//instancia o objeto de gravação
                stream.close();//fecha objeto de gravação
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CompraDAOArq.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CompraDAOArq.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
}
