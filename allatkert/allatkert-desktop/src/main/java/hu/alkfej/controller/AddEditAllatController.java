package hu.alkfej.controller;

import hu.alkfej.App;
import hu.alkfej.dao.OrokbefogadhatoAllatDAO;
import hu.alkfej.dao.OrokbefogadhatoAllatDAOImpl;
import hu.alkfej.model.OrokbefogadhatoAllat;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddEditAllatController implements Initializable{
    //állatok hozzáadása és módosítása

    private OrokbefogadhatoAllat orokbefogadhatoAllat;
    private OrokbefogadhatoAllatDAO orokbefogadhatoAllatDAO = new OrokbefogadhatoAllatDAOImpl();

    @FXML
    private Button saveBtn;

    @FXML
    private TextField nev;

    @FXML
    private TextField faj;

    @FXML
    private TextField fenykep;

    @FXML
    private TextField szoveg;

    @FXML
    private DatePicker szuldatum;


    public void setAllat(OrokbefogadhatoAllat c) {
        this.orokbefogadhatoAllat = c;

        nev.textProperty().bindBidirectional(orokbefogadhatoAllat.nevProperty());
        faj.textProperty().bindBidirectional(orokbefogadhatoAllat.fajProperty());
        fenykep.textProperty().bindBidirectional(orokbefogadhatoAllat.fenykepProperty());
        szoveg.textProperty().bindBidirectional(orokbefogadhatoAllat.szovegProperty());
        szuldatum.valueProperty().bindBidirectional(orokbefogadhatoAllat.szuldatumProperty());
    }

    @FXML
    public void onCancel(){
        App.loadFXML("/fxml/main_Window.fxml");
    }

    @FXML
    public void onSave(){
        orokbefogadhatoAllat = orokbefogadhatoAllatDAO.save(orokbefogadhatoAllat);

        App.loadFXML("/fxml/main_Window.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //megszorítások
        saveBtn.disableProperty().bind(faj.textProperty().isEmpty().or(szoveg.textProperty().isEmpty()).or(szuldatum.valueProperty().isNull()));

    }
}
