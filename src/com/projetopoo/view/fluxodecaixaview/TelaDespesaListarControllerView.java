/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.fluxodecaixaview;

import com.projetopoo.controler.DebitoController;
import com.projetopoo.model.DebitoModel;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dkaus
 */
public class TelaDespesaListarControllerView implements Initializable {

    @FXML
    private TableView<DebitoModel> tableViewDebitos;
    @FXML
    private TableColumn<DebitoModel, String> tableColumnData;
    @FXML
    private TableColumn<DebitoModel, String> tableColumnDescricao;
    @FXML
    private TableColumn<DebitoModel, String> tableColumnValor;
    @FXML
    private Button btVoltar;
    @FXML
    private Button btAlterar;
    @FXML
    private Button btRemover;
    @FXML
    private Button btSalvar;
    @FXML
    private TextField tfDescricao;
    @FXML
    private DatePicker dpData;
    @FXML
    private TextField tfValor;
    @FXML
    private Label lblTitulo;

    private ArrayList<DebitoModel> list = new ArrayList<>();
    private ObservableList<DebitoModel> ObservableListDebitos;
    DebitoController debitoController = new DebitoController();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.list = debitoController.recuperarLista();
        carregarTableViewDebitos(this.list);//carrega a tabela com os objetos do a lista
        tableViewDebitos.getSelectionModel().selectedItemProperty().addListener(//utilizado para seleceionar um objeto na lista
                (observable, oldValue, newValue) -> selecionarItemTableViewDebitos(newValue));
    }

    public void carregarTableViewDebitos(ArrayList<DebitoModel> listp) {
        tableViewDebitos.refresh();
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
        carregarTableViewDebitos(this.list);
    }

    public void inserirTableViewDebitos() {
        carregarTableViewDebitos(this.list);
    }

    public void alterarItemTableViewDebitosDescricao() {//altera se o usuario pressionar enter
        DebitoModel debito = tableViewDebitos.getSelectionModel().getSelectedItem();

        for (int i = 0; i < list.size(); i++) {
            if (debito.getId().equals(list.get(i).getId())) {
                list.get(i).setDescricao(tfDescricao.getText());
            }
        }

        carregarTableViewDebitos(this.list);
    }

    public void alterarItemTableViewDebitosValor() {//altera se o usuario pressionar enter
        DebitoModel debito = tableViewDebitos.getSelectionModel().getSelectedItem();

        for (int i = 0; i < list.size(); i++) {
            if (debito.getId().equals(list.get(i).getId())) {
                list.get(i).setValor(Float.parseFloat(tfValor.getText()));
            }
        }

        carregarTableViewDebitos(this.list);
    }

    public void alterarItemTableViewDebitoData() {//altera se o usuario pressionar enter
        DebitoModel debito = tableViewDebitos.getSelectionModel().getSelectedItem();

        for (int i = 0; i < list.size(); i++) {
            if (debito.getId().equals(list.get(i).getId())) {
                list.get(i).setData(dpData.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            }
        }

        carregarTableViewDebitos(this.list);
    }

    public void salvarTableViewDebitos() {
        debitoController.salvarAlteracao(list);
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setHeaderText("SALVO COM SUCESSO");
        dialogoInfo.showAndWait();
        tfDescricao.clear();
        tfValor.clear();
    }

    public static final LocalDate LOCAL_DATE(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate;
    }

    public void selecionarItemTableViewDebitos(DebitoModel debitop) {
        tfDescricao.setText(debitop.getDescricao());
        tfValor.setText(Float.toString(debitop.getValor()));
        dpData.setValue(LOCAL_DATE(debitop.getData()));
    }

    public void startListarDespesas() {
        MainFluxoDeCaixa.trocaTela("ListarDespesaView");
    }

    public void backToMenuDespesa() {
        MainFluxoDeCaixa.trocaTela("DespesasMenuView");
    }
}
