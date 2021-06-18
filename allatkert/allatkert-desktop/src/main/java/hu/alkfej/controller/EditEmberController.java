package hu.alkfej.controller;

import hu.alkfej.App;
import hu.alkfej.dao.OrokbefogadoDAO;
import hu.alkfej.dao.OrokbefogadoDAOImpl;
import hu.alkfej.model.Orokbefogado;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditEmberController {

    private Orokbefogado orokbefogado;
    private OrokbefogadoDAO orokbefogadoDAO = new OrokbefogadoDAOImpl();

    @FXML
    private Button saveBtn;

   @FXML
    private TextField nev;

   @FXML
    private TextField email;

    public void setEmber(Orokbefogado em){
        this.orokbefogado = em;

        nev.textProperty().bindBidirectional(orokbefogado.nevProperty());
        email.textProperty().bindBidirectional(orokbefogado.emailProperty());
    }

    @FXML
    public void onKilep(){
        App.loadFXML("/fxml/main_Orokbefogadok.fxml");
    }

    @FXML
    public void onMentes(){
        orokbefogado = orokbefogadoDAO.save(orokbefogado);

        App.loadFXML("/fxml/main_Orokbefogadok.fxml");
    }


}
