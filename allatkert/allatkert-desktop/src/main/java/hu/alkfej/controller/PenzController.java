package hu.alkfej.controller;

import hu.alkfej.App;
import hu.alkfej.dao.KonyvelesDAO;
import hu.alkfej.dao.KonyvelesDAOImpl;
import hu.alkfej.model.Konyveles;
import hu.alkfej.model.Orokbefogado;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PenzController implements Initializable {
    //penzosszeggel tamogatottak listája

    private KonyvelesDAO dao3 = new KonyvelesDAOImpl();

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        konyvelesTabla.getItems().setAll(dao3.penzTamogatok());

        mikorColumn.setCellValueFactory(new PropertyValueFactory<>("mikor"));
        tamogatColumn.setCellValueFactory(new PropertyValueFactory<>("tamogat"));
        ertelColumn.setCellValueFactory(new PropertyValueFactory<>("ertek"));
        gyakorisagColumn.setCellValueFactory(new PropertyValueFactory<>("gyakorisag"));
        emberColumn.setCellValueFactory(new PropertyValueFactory<>("orokbefogado"));
        allatColumn.setCellValueFactory(new PropertyValueFactory<>("orokbefogadoallatok"));


    }

    @FXML
    public void onExit(){
        Platform.exit();
    }

    @FXML
    public void onKonyveles(){
        FXMLLoader fxmlLoader = App.loadFXML(("/fxml/main_Konyveles.fxml"));
    }

    @FXML
    public void onBack(){
        FXMLLoader fxmlLoader = App.loadFXML(("/fxml/main.fxml"));
    }
}
