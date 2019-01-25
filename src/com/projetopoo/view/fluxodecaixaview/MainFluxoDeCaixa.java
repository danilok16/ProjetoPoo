/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.fluxodecaixaview;

import com.projetopoo.view.projetoPOO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author dkaus
 */
public class MainFluxoDeCaixa extends projetoPOO {

    private static Stage stage;
    private static Stage popup;
    private static Scene debitoScene;
    private static Scene fluxoDeCaixaScene;
    private static Scene despesaScene;
    private static Scene listarDespesaScene;
    private static Scene receitasOpcoesScene;
    private static Scene listarReceitaScene;
    private static Scene faturamentoScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        Parent fxmlFluxoDeCaixa = FXMLLoader.load(getClass().getResource("FXML.TelaFluxoDeCaixa.fxml"));
        fluxoDeCaixaScene = new Scene(fxmlFluxoDeCaixa);
        Parent fxmlDespesas = FXMLLoader.load(getClass().getResource("FXML.TelaDeDespesas.fxml"));
        despesaScene = new Scene(fxmlDespesas);
        Parent fxmlListarDespesas = FXMLLoader.load(getClass().getResource("FXML.TelaDespesaListar.fxml")); //listar
        listarDespesaScene = new Scene(fxmlListarDespesas);
        Parent fxmlTelaDebitos = FXMLLoader.load(getClass().getResource("FXML.TelaDeDebitos.fxml")); //inserir
        debitoScene = new Scene(fxmlTelaDebitos);
        Parent fxmlReceitaOpcoes = FXMLLoader.load(getClass().getResource("FXML.TelaReceitaOpcoes.fxml")); //inserir
        receitasOpcoesScene = new Scene(fxmlReceitaOpcoes);
        Parent fxmlListarReceitas = FXMLLoader.load(getClass().getResource("FXML.TelaDeReceitasListar.fxml")); //listar
        listarReceitaScene = new Scene(fxmlListarReceitas);
        Parent fxmlFaturamento = FXMLLoader.load(getClass().getResource("FXML.TelaFaturamento.fxml")); //listar
        faturamentoScene = new Scene(fxmlFaturamento);

        stage.setScene(fluxoDeCaixaScene);
        stage.show();
    }

    public static void trocaTela(String scr) {
        MainFluxoDeCaixa fluxoDeCaixa = new MainFluxoDeCaixa();

        switch (scr) {
            case "caixa":
                stage.setScene(fluxoDeCaixaScene);
                break;
            case "faturamentoView":
                stage.setScene(faturamentoScene);
                break;
            case "DespesasMenuView":
                stage.setScene(despesaScene);
                break;
            case "InserirDespesaView": {
                try {
                    fluxoDeCaixa.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(MainFluxoDeCaixa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            stage.setScene(debitoScene);
            break;
            case "ListarDespesaView": {
                try {
                    fluxoDeCaixa.start(stage);
                } catch (Exception ex) {
                    Logger.getLogger(MainFluxoDeCaixa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            stage.setScene(listarDespesaScene);
            break;
            case "receitasMenuView":
                stage.setScene(receitasOpcoesScene);
                break;
            case "ListarReceitaLsView":
                stage.setScene(listarReceitaScene);
                break;

        }

    }

 // é possivel chamar apenas essa tela   
 /*   public static void main(String[] args) {
     System.out.println("oi");
     launch(args);
        
     }
     */
}
