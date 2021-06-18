package hu.alkfej.controller;

import hu.alkfej.App;
import hu.alkfej.dao.KonyvelesDAO;
import hu.alkfej.dao.KonyvelesDAOImpl;

import hu.alkfej.model.Konyveles;

import hu.alkfej.model.Orokbefogado;
import hu.alkfej.model.enums.TamogatasTipusa;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;

import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class MainKonyvelesController implements Initializable {
    //konyveles oldala

     private KonyvelesDAO dao3 = new KonyvelesDAOImpl();

     private List<Konyveles> all;


    @FXML
    private TableView<Konyveles> konyvelesTabla;

    @FXML
    private TableColumn<Konyveles, String> mikorColumn;

    @FXML
    private TableColumn<Konyveles, String> tamogatColumn;

    @FXML
    private TableColumn<Konyveles, Double> ertelColumn;

    @FXML
    private TableColumn<Konyveles, String> gyakorisagColumn;

    @FXML
    private TableColumn<Orokbefogado, Object> emberColumn;

    @FXML
    private TableColumn<Orokbefogado, Object> allatColumn;


    @FXML
    private TextField emberNeve;

    @FXML
    private TextField allatNeve;


    @FXML
    public void onKereses(){
        List<Konyveles> filtered = all.stream().filter(konyveles -> konyveles.getOrokbefogado().getNev().contains(emberNeve.getText())
                && konyveles.getOrokbefogadoallatok().getNev().contains(allatNeve.getText())).collect(Collectors.toList());
        konyvelesTabla.getItems().setAll(filtered);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      refreshTable();

        mikorColumn.setCellValueFactory(new PropertyValueFactory<>("mikor"));
        tamogatColumn.setCellValueFactory(new PropertyValueFactory<>("tamogat"));
        ertelColumn.setCellValueFactory(new PropertyValueFactory<>("ertek"));
        gyakorisagColumn.setCellValueFactory(new PropertyValueFactory<>("gyakorisag"));
        emberColumn.setCellValueFactory(new PropertyValueFactory<>("orokbefogado"));
        allatColumn.setCellValueFactory(new PropertyValueFactory<>("orokbefogadoallatok"));


    }

    private void refreshTable(){
        all = dao3.findAll();
        konyvelesTabla.getItems().setAll(all);
    }



    @FXML
    public void onExit(){
        Platform.exit();
    }

    public void onBack(){
        FXMLLoader fxmlLoader = App.loadFXML(("/fxml/main.fxml"));
    }

    public void onLastyear(){
        FXMLLoader fxmlLoader = App.loadFXML(("/fxml/tavalyikonyveles.fxml"));
    }

    public void onPenz(){
        FXMLLoader fxmlLoader = App.loadFXML(("/fxml/penz.fxml"));
    }

    public void onEledel(){
        FXMLLoader fxmlLoader = App.loadFXML(("/fxml/eledel.fxml"));
    }

}
