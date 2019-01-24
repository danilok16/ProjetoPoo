/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.requisicaocompraview;
import com.projetopoo.view.projetoPOO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author dkaus
 */
public class MainRequisicaoDeCompra  extends projetoPOO {
    
   private static Stage stage;
    private static Stage popup;
    
   private static Scene menuRequisicao;
 private static Scene requisicaocompra;
   private static Scene alterarRequisicao;
   private static Scene consultarRequisicao;
   private static Scene aprovarRequisicao;
  
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage= primaryStage;
        
          Parent fxmlMenuRequisicaoCompra = FXMLLoader.load(getClass().getResource("MenuRequisicaoCompra.fxml"));
          menuRequisicao = new Scene(fxmlMenuRequisicaoCompra);
          Parent fxmlRequisicaoCompra = FXMLLoader.load(getClass().getResource("FXML.Requisicao.fxml"));
           requisicaocompra= new Scene(fxmlRequisicaoCompra);
           Parent fxmlAlterarRequisicao = FXMLLoader.load(getClass().getResource("FXML.AlterarRequisicao.fxml"));
            alterarRequisicao= new Scene(fxmlAlterarRequisicao);
            Parent fxmlConsultarRequisicao = FXMLLoader.load(getClass().getResource("ConsultarRequisicao.fxml"));
            consultarRequisicao = new Scene(fxmlConsultarRequisicao);
               Parent fxmlAprovarRequisicao = FXMLLoader.load(getClass().getResource("AprovarRequisicao.fxml"));
            aprovarRequisicao = new Scene(fxmlAprovarRequisicao);
            
    
         stage.setScene  (menuRequisicao);
           stage.show();
    }
    
    public static void trocaTela(String scr){
      MainRequisicaoDeCompra  principalRequisicaoCompra = new  MainRequisicaoDeCompra();
        switch (scr){
                case"menuRequisicao":
                    stage.setScene(menuRequisicao);
                    break;
                case"requisicao":
                     stage.setScene(requisicaocompra);
                     break;
                case"alterarRequisicao":
                     stage.setScene(alterarRequisicao);
                     break;
                case"consultarRequisicao":
                    stage.setScene(consultarRequisicao);
                    break;
                case"aprovarRequisicao":
                     stage.setScene(aprovarRequisicao);
                     break;
        }
    }
}

    
    
    
