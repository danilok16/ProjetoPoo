package com.projetopoo.view.requisicaocompraview;

import com.projetopoo.controler.CadastroFuncionarioController;
import com.projetopoo.controler.RequisicaoController;
import com.projetopoo.model.FuncionarioModel;
import com.projetopoo.model.RequisicaoModel;
import com.projetopoo.view.projetoPOO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class RequisicaoControllerView {

    @FXML
    private Button btCancelar;

    @FXML
    private Button btConcluir;

    @FXML
    private TextField tfQtd;

    @FXML
    private DatePicker dpDataDeEntrega;

    @FXML
    private TextField tfDescricao;

    @FXML
    private DatePicker dpDataDeSolicitacao;

    @FXML
    private TextField tfIdRequisitante;

    @FXML
    private TextField tfValorTotal;

    RequisicaoModel requisicao = new RequisicaoModel();
    CadastroFuncionarioController f = new CadastroFuncionarioController();

    @FXML
    void btCancelar() {
        tfDescricao.setText("");
        tfQtd.setText("");
        dpDataDeEntrega.setValue(null);
        projetoPOO.trocaTela("estoqueMenu");
    }

    @FXML
    void btConcluir() {
        RequisicaoController controller = new RequisicaoController();
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        selecionarData();
        selecionarDescricao();
        selecionarQuantidade();
        selicionarRequisitante();
        requisicao.setValorTotal(Float.parseFloat(tfValorTotal.getText()));
        requisicao.setDataDeEmissao(dpDataDeSolicitacao.getValue().toString());
        requisicao.setIdRequisicao(controller.GeraIdRequisicao());
        System.out.println(requisicao.getIdRequisicao());
        FuncionarioModel requisitante = f.ConsultaFuncionario(tfIdRequisitante.getText());
        requisicao.setRequisitante(requisitante);
        requisicao.setAprovador(requisitante);
        controller.Aprovar(requisicao);
        controller.cadastrar(requisicao);
        dialogoInfo.setTitle("AVISO");
        dialogoInfo.setHeaderText("Requisição realizada!");
        dialogoInfo.showAndWait();
        tfDescricao.setText("");
        tfQtd.setText("");
        dpDataDeEntrega.setValue(null);
    }

    @FXML
    void selecionarData() {
        String data;
        data = dpDataDeEntrega.getValue().toString();
        requisicao.setDataDeEntrega(data);
    }

    @FXML
    void selecionarDescricao() {
        String descricao;
        descricao = tfDescricao.getText();
        requisicao.setDescricao(descricao);
    }

    @FXML
    void selecionarQuantidade() {
        int quantidade;
        quantidade = Integer.parseInt(tfQtd.getText());
        requisicao.setQtdDesejada(quantidade);
    }

    private void selicionarRequisitante() {//loop
        FuncionarioModel requisitante = f.ConsultaFuncionario(tfIdRequisitante.getText());
        if (requisitante == null) {
            //testar
        } else {
            requisicao.setRequisitante(requisitante);
        }
    }
}
