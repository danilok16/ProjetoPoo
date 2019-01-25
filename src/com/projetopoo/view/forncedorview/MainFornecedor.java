/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.forncedorview;

import com.projetopoo.view.projetoPOO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author dkaus
 */
public class MainFornecedor extends projetoPOO {

    private static Stage stage;
    private static Stage popup;

    private static Scene menuFornecedor;
    private static Scene cadastrarFornecedor;
    private static Scene removerFornecedor;
    private static Scene alterarFornecedor;
    private static Scene consultarFornecedor;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        Parent fxmlMenuFornecedor = FXMLLoader.load(getClass().getResource("FXML.MenuFornecedor.fxml"));
        menuFornecedor = new Scene(fxmlMenuFornecedor);
        Parent fxmlTelaDeCadastroForncedores = FXMLLoader.load(getClass().getResource("FXML.TelaDeCadastroForncedores.fxml"));
        cadastrarFornecedor = new Scene(fxmlTelaDeCadastroForncedores);
        Parent fxmlRemoverFornecedor = FXMLLoader.load(getClass().getResource("FXML.RemoverFornecedor.fxml"));
        removerFornecedor = new Scene(fxmlRemoverFornecedor);
        Parent fxmlAlterarFornecedor = FXMLLoader.load(getClass().getResource("FXML.AlterarFornecedor.fxml"));
        alterarFornecedor = new Scene(fxmlAlterarFornecedor);
        Parent fxmlConsultarFornecedor = FXMLLoader.load(getClass().getResource("FXML.ConsultarFornecedor.fxml"));
        consultarFornecedor = new Scene(fxmlConsultarFornecedor);

        stage.setScene(menuFornecedor);
        stage.show();
    }

    public static void trocaTela(String scr) {
        MainFornecedor principalFornecedor = new MainFornecedor();
        switch (scr) {
            case "menuFornecedor":
                stage.setScene(menuFornecedor);
                break;
            case "cadastrarFornecedor":
                stage.setScene(cadastrarFornecedor);
                break;
            case "removerFornecedor":
                stage.setScene(removerFornecedor);
                break;
            case "alterarFornecedor":
                stage.setScene(alterarFornecedor);
                break;
            case "consultarFornecedor":
                stage.setScene(consultarFornecedor);
                break;
        }
    }
}
