package com.projetopoo.view.forncedorview;

import com.projetopoo.controler.FornecedorController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class RemoverFornecedorControllerView {

    @FXML
    private TextField tfId;

    @FXML
    public void voltarTelaMenu() {
        tfId.setText("");
        MainFornecedor.trocaTela("menuFornecedor");
    }

    @FXML
    public void removerFornecedor() {
        if (tfId.getText() != null) {  //Precisa alterar a validação de entrada vazia, só isso não funciona

            if (FornecedorController.removerFornecedor(tfId.getText())) {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("AVISO");
                dialogoInfo.setHeaderText("Fornecedor removido com sucesso!");
                dialogoInfo.showAndWait();
            } else {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("AVISO");
                dialogoInfo.setHeaderText("Fornecedor não cadastrado!");
                dialogoInfo.showAndWait();
            }

            MainFornecedor.trocaTela("menuFornecedor");
        } else {
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("AVISO");
            dialogoInfo.setHeaderText("Por favor preencha todas as informações.");
            dialogoInfo.showAndWait();
        }
        tfId.setText("");
    }

}
