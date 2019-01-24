package com.projetopoo.view;

import com.projetopoo.controler.*;
import com.projetopoo.model.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CaixaControllerView implements Initializable{

    @FXML private TableView <ProdutoModel> tvItens;
    @FXML private TableColumn<?, ?> TCVDescricao;
    @FXML private TableColumn<?, ?> TVCidItem;
    @FXML private TableColumn<?, ?> TVCQtd;
    @FXML private TableColumn<?, ?> TVCPreco;
    @FXML private Label lbTotal;
    @FXML
    private TextField tfCodigoProduto;

    @FXML
    private TextField tfQtd;
    @FXML private Button btInserir;
    @FXML private Button btFcharCaixa;
    @FXML private Button btFinalizar;
    @FXML private Button btConsultar;
    @FXML private Button btRemover;
    @FXML private Label lbOperador;
    @FXML private Label lblAdicionado;
    
    private float tot = 0;//??
    
    CompraModel compraA = new CompraModel(CompraController.GeraIdCompra());
    ItemController itemCon = new ItemController();
    private ArrayList<ProdutoModel> listaItensTV = new ArrayList<>();
    
    private ObservableList<ProdutoModel> observableListaItensTV;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        tvItens.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarItem(newValue));
        btInserir.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                verificaEntradasItem();
            }});
        TVCidItem.setCellValueFactory(new PropertyValueFactory<>("idItem"));
        TVCQtd.setCellValueFactory(new PropertyValueFactory<>("qtdDesejada"));
        TVCPreco.setCellValueFactory(new PropertyValueFactory("preco"));
        TCVDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        
    }
    
        
   
    @FXML
    public void verificaEntradasItem(){
        
        try{
            if(tfCodigoProduto.getText() != null && tfQtd.getText() != null){
                ProdutoModel b = new ItemModel(tfCodigoProduto.getText(), Integer.parseInt(tfQtd.getText()));
                System.out.println(b.getIdItem()+" "+ b.getQtdDesejada());
                if(itemCon.consultarItem(tfCodigoProduto.getText()).getIdItem().equals(b.getIdItem())){
                    b.setPreco(itemCon.consultarItem(tfCodigoProduto.getText()).getPreco());
                    b.setDescricao(itemCon.consultarItem(tfCodigoProduto.getText()).getDescricao());
                    CaixaController.somaItemCaixa(b, listaItensTV, compraA);
                    itemCon.CalcularDesconto(b);
                    System.out.println(b.getDesconto());
                }else{
                    lblAdicionado.setText("Acabou o Estoque!");
                }
                tot = calculaTot(listaItensTV);
                lbTotal.setText(Float.toString(tot));
                lblAdicionado.setText("Item Adicionado!");    
                refresh(tot);
            }
        }catch(NumberFormatException e){
            lblAdicionado.setText("Campo Vazio!");
        }
    }
    
    public void ChamaConsultar(){
        projetoPOO.trocaTela("consultarProduto");
    }
    
    public void chamaTelaTroco(){
        projetoPOO.trocaTela("telaTroco");
    }
    
    public void FecharCaixa(){
        listaItensTV.clear();
        //lbTotal.setText("0.0");
        tvItens.setItems(null);
        tfCodigoProduto.setText("");
        tfQtd.setText("");
        projetoPOO.trocaTela("principal");
    }
    
    private void selecionarItem(ProdutoModel a){
        if(a != null){
            System.out.println("Selecionado: " + a.getIdItem());
        }
    }
    
    @FXML
    public void removerItemCaixa(){
        ProdutoModel itemRe = tvItens.getSelectionModel().getSelectedItem();
        if(itemRe != null){
            tot -= (itemRe.getQtdDesejada() * itemRe.getPreco());
            tvItens.getItems().remove(itemRe);
            listaItensTV.remove(itemRe);
            refresh(tot);
        }
    }
    
    public void refresh(float tot){
        String s;
        this.compraA.setItens(listaItensTV);
        this.compraA.setValorTot(tot);
        lbTotal.setText(Float.toString(tot));
        observableListaItensTV = FXCollections.observableArrayList(listaItensTV);
        tvItens.setItems(observableListaItensTV);
    }
    public float getValorCompra(){
        float valor;
        valor = compraA.getValorTot();
        return valor;
    }
    
    public void finalizaCompra(){
        chamaTelaTroco();
        compraA.setFechada(true);
        CompraController.inserirCompra(compraA);
    }
    
    public float calculaTot(List<ProdutoModel> lista){
        float tot = 0;
        for(ProdutoModel s:lista){
            tot += (s.getPreco() * s.getQtdDesejada());
        }
        return tot;
    }
}
