/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetopoo.view.fluxodecaixaview;

import com.projetopoo.controler.CompraController;
import com.projetopoo.controler.DebitoController;
import com.projetopoo.controler.FluxoDeCaixaController;
import com.projetopoo.model.FluxoDeCaixaModel;
import com.projetopoo.view.projetoPOO;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dkaus
 */
public class TelaFaturamentoControllerView implements Initializable {

    @FXML
    private Button btVoltarFluxoCaixa;
    @FXML
    private TableView<FluxoDeCaixaModel> tableViewFluxoDeCaixa;
    @FXML
    private TableColumn<FluxoDeCaixaModel, String> tableColumnData;
    @FXML
    private TableColumn<FluxoDeCaixaModel, String> tableColumnDescricao;
    @FXML
    private TableColumn<FluxoDeCaixaModel, String> tableColumnTipo;
    @FXML
    private TableColumn<FluxoDeCaixaModel, String> tableColumnValor;
    @FXML
    private DatePicker dpData;
    @FXML
    private Button btnListar;

    private ArrayList<FluxoDeCaixaModel> list = new ArrayList<>();
    private ObservableList<FluxoDeCaixaModel> ObservableListFluxoDeCaixa;
    FluxoDeCaixaController fluxoController = new FluxoDeCaixaController();

    DebitoController despesa = new DebitoController();
    CompraController receita = new CompraController();

    /* @FXML
     private PieChart pcFaturamento;*/
    @Override

    public void initialize(URL url, ResourceBundle rb) {
    }

    public void exibirFluxoDeCaixa() {
        if (dpData.getValue() != null) {
            FluxoDeCaixaModel fluxoDespesa = fluxoController.criarFluxoDeCaixa(dpData.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), "DESPESAS VARIÁVEIS", "SAIDA");
            FluxoDeCaixaModel fluxoReceita = fluxoController.criarFluxoDeCaixa(dpData.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), "VENDAS", "ENTRADA");
            FluxoDeCaixaModel fluxoLucro = fluxoController.criarFluxoDeCaixa(dpData.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), "LUCRO", "ENTRADA");
            list.add(fluxoDespesa);
            list.add(fluxoReceita);
            list.add(fluxoLucro);
            carregarTableViewFluxoDeCaixa(list);
            list.clear();
        }
    }

    public static final LocalDate LOCAL_DATE(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate;
    }

    public void carregarTableViewFluxoDeCaixa(ArrayList<FluxoDeCaixaModel> listp) {

        tableViewFluxoDeCaixa.refresh();
        tableColumnDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tableColumnData.setCellValueFactory(new PropertyValueFactory<>("data"));
        tableColumnTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("total"));
        ObservableListFluxoDeCaixa = FXCollections.observableArrayList(listp);
        tableViewFluxoDeCaixa.setItems(ObservableListFluxoDeCaixa);

    }

    public void chamaFluxoDeCaixa() {
        projetoPOO.trocaTela("fluxoDeCaixa");
    }

}
