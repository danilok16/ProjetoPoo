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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dkaus
 */
public class TelaFluxoDeCaixaControllerView implements Initializable {

    private static Stage stage;
    private static Scene debitoScene;

    @FXML
    private Button btDespesas;

    @FXML
    private Button btFaturamento;

    @FXML
    private Button btRelatorio;

    @FXML
    private Button btReceitas;

    @FXML
    private Button btVoltarFluxoCaixa;

    @FXML
    private ImageView imLogoFluxoCaixa;
    @FXML
    private Button btVoltarReceita;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image imagem = new Image("/com/projetopoo/view/fluxodecaixaview/icons/fluxo_caixa.png");
        imLogoFluxoCaixa.setImage(imagem);
        // TODO
    }

    public void startDespesasMenu() {
        MainFluxoDeCaixa.trocaTela("DespesasMenuView");
    }

    public void startReceitasMenu() {
        MainFluxoDeCaixa.trocaTela("receitasMenuView");
    }

    public void chamaAdmin() {
        projetoPOO.trocaTela("telaAdmin");
    }

    public void startFaturamento() {
        MainFluxoDeCaixa.trocaTela("faturamentoView");
    }

}
