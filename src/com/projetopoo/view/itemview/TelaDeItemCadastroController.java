/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.itemview;

import static com.projetopoo.controler.FornecedorController.ConsultaFornecedor;
import com.projetopoo.controler.ItemController;
import com.projetopoo.model.FornecedorModel;
import com.projetopoo.model.ItemModel;
import com.projetopoo.model.ProdutoModel;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author dkaus
 */
public class TelaDeItemCadastroController implements Initializable {

    @FXML
    private Label lblTitulo;

    @FXML
    private TextField tfIdItem;

    @FXML
    private TextField tfDescricao;

    @FXML
    private DatePicker dpData;

    @FXML
    private TextField tfPreco;

    @FXML
    private TextField tfIdFornecedor;

    @FXML
    private Button btSalvar;

    @FXML
    private Button btVoltar;

    @FXML
    private TextField tfQuantidade;

    @FXML
    private TextField tfPosicao;

    ItemModel item;
    ArrayList<FornecedorModel> fornecedorList = new ArrayList<>();
    ItemController itemController = new ItemController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void salvarItem() {
        boolean flag = false;

        ProdutoModel i = itemController.consultarItem((tfIdItem.getText()));
        if (i != null) {
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("AVISO");
            dialogoInfo.setHeaderText("ITEM JÁ CADASTRADO");
            dialogoInfo.showAndWait();
            tfIdItem.clear();
            flag = true;
        }

        FornecedorModel fornecedor = ConsultaFornecedor(tfIdFornecedor.getText());
        if (fornecedor == null) {
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("AVISO");
            dialogoInfo.setHeaderText("FORCEDOR NÃO CADASTRADO");
            dialogoInfo.showAndWait();
            tfIdFornecedor.clear();
            flag = true;
        } else {
            this.fornecedorList.add(fornecedor);
        }

        if (tfDescricao.getText() != null && tfPreco.getText() != null && dpData.getValue() != null && tfQuantidade.getText() != null && tfPosicao.getText() != null && flag == false) {
            this.item = new ItemModel(tfIdItem.getText(), Integer.parseInt(tfQuantidade.getText()), Float.parseFloat(tfPreco.getText()), tfDescricao.getText(), dpData.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), tfPosicao.getText(), fornecedorList);
            itemController.salvar(item);
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setHeaderText("SALVO COM SUCESSO");
            dialogoInfo.showAndWait();
            MainItem.trocaTela("itemMenu");
        }
    }

    public void backToMenuItem() {
        MainItem.trocaTela("itemMenu");

    }
}
