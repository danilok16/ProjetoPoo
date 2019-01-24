/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.fluxodecaixaview;

import com.projetopoo.view.projetoPOO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author dkaus
 */
public class TelaReceitaOpcoesControllerView implements Initializable {

    @FXML
    private Button btListarVendas;

    @FXML
    private Button btConsultarVendas;

    @FXML
    private Button btAlterarRegistroVendas;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void startListarVendas(){
        MainFluxoDeCaixa.trocaTela("ListarReceitaLsView");
    }
     
    public void chamaFluxoDeCaixa(){
        projetoPOO.trocaTela("fluxoDeCaixa");
    }
    
}
