package com.projetopoo.view;

import com.projetopoo.view.fluxodecaixaview.MainFluxoDeCaixa;
import com.projetopoo.view.forncedorview.MainFornecedor;
import com.projetopoo.view.itemview.MainItem;
import com.projetopoo.view.requisicaocompraview.MainRequisicaoDeCompra;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Naira Gasai
 */
public class projetoPOO extends Application implements Initializable {

    private static Stage stage;
    private static Stage popup;

    private static Scene principalScene;
    private static Scene cadastroScene;
    private static Scene loginCaixaScene;
    private static Scene caixaScene;
    private static Scene consultarProdutoScene;
    private static Scene telaTroco;
    private static Scene telaAdmin;
    private static Scene estoqueMenu;
    private static Scene gerenciadorFuncionario;
    private static Scene cadastroFuncionario;
    private static Scene alterarFuncionario;
    private static Scene exibirFuncionario;
    private static Scene removerFuncionario;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent fxmlPrincipal = FXMLLoader.load(getClass().getResource("FXML.Telainicial.fxml"));
        principalScene = new Scene(fxmlPrincipal);
        Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("FXML.CadastroFuncionario.fxml"));
        cadastroScene = new Scene(fxmlCadastro);
        Parent fxmlLoginCaixa = FXMLLoader.load(getClass().getResource("FXML.LoginCaixa.fxml"));
        loginCaixaScene = new Scene(fxmlLoginCaixa);
        Parent fxmlCaixa = FXMLLoader.load(getClass().getResource("FXML.CaixaTela.fxml"));
        caixaScene = new Scene(fxmlCaixa);
        Parent fxmlConsultarProduto = FXMLLoader.load(getClass().getResource("FXML.ConsultarProduto.fxml"));
        consultarProdutoScene = new Scene(fxmlConsultarProduto);
        /* Parent fxmlTelaTroco = FXMLLoader.load(getClass().getResource("FXML.TelaTroco.fxml"));
         telaTroco = new Scene(fxmlTelaTroco);*/
        Parent fxmlTelaAdmin = FXMLLoader.load(getClass().getResource("FXML.TelaAdmin.fxml"));
        telaAdmin = new Scene(fxmlTelaAdmin);
        Parent fxmlTelaEstoque = FXMLLoader.load(getClass().getResource("FXML.EstoqueMenu.fxml"));
        estoqueMenu = new Scene(fxmlTelaEstoque);
        Parent fxmlGerenciadorFuncionario = FXMLLoader.load(getClass().getResource("FXML.GerenciadorFuncionarios.fxml"));
        gerenciadorFuncionario = new Scene(fxmlGerenciadorFuncionario);
        Parent fxmlCadastroFuncionario = FXMLLoader.load(getClass().getResource("FXML.CadastroFuncionario.fxml"));
        cadastroFuncionario = new Scene(fxmlCadastroFuncionario);
        Parent fxmlAlterarFuncionario = FXMLLoader.load(getClass().getResource("FXML.AlterarFuncionario.fxml"));
        alterarFuncionario = new Scene(fxmlAlterarFuncionario);
        Parent fxmlExibirFuncionario = FXMLLoader.load(getClass().getResource("FXML.ExibirFuncionario.fxml"));
        exibirFuncionario = new Scene(fxmlExibirFuncionario);
        Parent fxmlRemoverFuncionario = FXMLLoader.load(getClass().getResource("FXML.RemoverFuncionario.fxml"));
        removerFuncionario = new Scene(fxmlRemoverFuncionario);
        stage.setScene(principalScene);
        stage.show();
    }

    public static void trocaTela(String scr) {
        switch (scr) {
            case "principal":
                stage.setScene(principalScene);
                break;
            case "cadastro":
                stage.setScene(cadastroScene);
                break;
            case "loginCaixa":
                stage.setScene(loginCaixaScene);
                break;
            case "caixa":
                stage.setScene(caixaScene);
                break;
            case "consultarProduto":
                stage.setScene(consultarProdutoScene);
                break;
            case "telaTroco":
                stage.setScene(telaTroco);
                break;
            case "estoqueMenu":
                stage.setScene(estoqueMenu);
                break;
            case "telaAdmin":
                stage.setScene(telaAdmin);
                break;
            case "fluxoDeCaixa":
                MainFluxoDeCaixa fluxoDeCaixa = new MainFluxoDeCaixa();
                 {
                    try {
                        fluxoDeCaixa.start(stage);
                    } catch (Exception ex) {
                        Logger.getLogger(projetoPOO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case "ItemMenu":
                MainItem menuItem = new MainItem();

                 {
                    try {
                        menuItem.start(stage);
                    } catch (Exception ex) {
                        Logger.getLogger(projetoPOO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case "menuFornecedor":
                MainFornecedor menuFornecedor = new MainFornecedor();
                 {
                    try {
                        menuFornecedor.start(stage);
                    } catch (Exception ex) {
                        Logger.getLogger(projetoPOO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case "requisicao":
                MainRequisicaoDeCompra principalRequisicaoCompra = new MainRequisicaoDeCompra();
                 {
                    try {
                        principalRequisicaoCompra.start(stage);
                    } catch (Exception ex) {
                        Logger.getLogger(projetoPOO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

            case "gerenciadorFuncionario":
                stage.setScene(gerenciadorFuncionario);
                break;
            case "cadastroFuncionario":
                stage.setScene(cadastroFuncionario);
                break;
            case "alterarFuncionario":
                stage.setScene(alterarFuncionario);
                break;
            case "exibirFuncionario":
                stage.setScene(exibirFuncionario);
                break;
            case "removerFuncionario":
                stage.setScene(removerFuncionario);
                break;

        }
    }

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
