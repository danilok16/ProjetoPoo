package com.projetopoo.view.forncedorview;

import com.projetopoo.controler.FornecedorController;
import com.projetopoo.model.FornecedorModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AlterarFornecedorControllerView {

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfCNPJ;

    @FXML
    private TextField tfRazaoS;

    @FXML
    public void voltarTelaMenu() {
        MainFornecedor.trocaTela("menuFornecedor");
    }

    @FXML
    public void alterar() {

        if (tfCNPJ.getText() != null && tfRazaoS.getText() != null && tfId.getText() != null) {  //Precisa alterar a validação de entrada vazia, só isso não funciona
            int id = Integer.parseInt(tfId.getText());
            FornecedorModel forn = new FornecedorModel(tfCNPJ.getText(), id, tfRazaoS.getText());
            if (FornecedorController.alterarFornecedor(forn)) {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("AVISO");
                dialogoInfo.setHeaderText("Alteração realizada com sucesso!");
                dialogoInfo.showAndWait();
            } else {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("AVISO");
                dialogoInfo.setHeaderText("Fornecedor nao encontrado no sistema!");
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
        tfCNPJ.setText("");
        tfRazaoS.setText("");
    }
}
