/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.fluxodecaixaview;

import com.projetopoo.controler.DebitoController;
import com.projetopoo.model.DebitoModel;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dkaus
 */
public class TelaDeDebitosControllerView implements Initializable {

    @FXML
    private TextField tfDescricao;
    @FXML
    private DatePicker dpData;
    @FXML
    private TextField tfValor;
    @FXML
    private Button btSalvar;
    @FXML
    private Button btInserir;
    @FXML
    private Button btRemover;
    @FXML
    private Button btVoltar;
    @FXML
    private TableView<DebitoModel> tableViewDebitos;
    @FXML
    private TableColumn<DebitoModel, String> tableColumnData;
    @FXML
    private TableColumn<DebitoModel, String> tableColumnDescricao;
    @FXML
    private TableColumn<DebitoModel, String> tableColumnValor;

    ArrayList<DebitoModel> list = new ArrayList<>();
    private ObservableList<DebitoModel> ObservableListDebitos;
    DebitoController debitoController = new DebitoController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarTableViewDebitos(this.list);
        tableViewDebitos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewDebitos(newValue));
    }

    public void inserirTableViewDebitos() {
        if (tfDescricao.getText() != null && tfValor.getText() != null && dpData.getValue() != null) {
            DebitoModel debito = new DebitoModel(tfDescricao.getText(), Float.parseFloat(tfValor.getText()), dpData.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            list.add(debito);
            carregarTableViewDebitos(this.list);
        }
    }

    public void carregarTableViewDebitos(ArrayList<DebitoModel> listp) {

        tableColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tableColumnData.setCellValueFactory(new PropertyValueFactory<>("data"));
        tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        ObservableListDebitos = FXCollections.observableArrayList(listp);
        tableViewDebitos.setItems(ObservableListDebitos);

    }

    public void removerItemTableViewDebitos() {
        DebitoModel debito = tableViewDebitos.getSelectionModel().getSelectedItem();
        tableViewDebitos.getItems().remove(debito);
        this.list.remove(debito);
    }

    public void salvarTableViewDebitos() {
        if (this.list.isEmpty() == false) {
            debitoController.salvarArrayList(list);
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setHeaderText("SALVO COM SUCESSO");
            dialogoInfo.showAndWait();
            this.list.clear();
            this.ObservableListDebitos.clear();
            tfDescricao.clear();
            tfValor.clear();
        }
    }

    public void selecionarItemTableViewDebitos(DebitoModel debitop) {

    }

    public void backToMenuDespesa() {
        MainFluxoDeCaixa.trocaTela("DespesasMenuView");
    }
}
