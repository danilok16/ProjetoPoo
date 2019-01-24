/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.factory;

import static com.projetoopoo.gerenciador.ManipuladorConfiguracoes.getProp;
import com.projetopoo.dao.*;
import com.projetopoo.interfaces.Item_dao;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrade
 */
public class ItemFactory {
    public static Item_dao create(){
        String tipo;
        
        Properties prop = null;
        try {
            prop = getProp();
        } catch (IOException ex) {
            Logger.getLogger(ItemFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        tipo=prop.getProperty("configItemDAO");
             
        if("0".equals(tipo)){
           return ItemDAOMem.getInstance();
        }else if ("1".equals(tipo)){            
            return ItemDAOArq.getInstace();
        }
        
        return null;
        
    }
}

