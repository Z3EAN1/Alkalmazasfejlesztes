package hu.alkfej.controller;

import hu.alkfej.App;
import hu.alkfej.dao.OrokbefogadhatoAllatDAO;
import hu.alkfej.dao.OrokbefogadhatoAllatDAOImpl;
import hu.alkfej.model.OrokbefogadhatoAllat;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainwindowController implements Initializable {
    //orokbefohadhato allatok

    OrokbefogadhatoAllatDAO dao = new OrokbefogadhatoAllatDAOImpl();

    @FXML
    private TableView<OrokbefogadhatoAllat> allatTabla;

    @FXML
    private TableColumn<OrokbefogadhatoAllat, String> nevColumn;

    @FXML
    private TableColumn<OrokbefogadhatoAllat, String> fajColumn;

    @FXML
    private TableColumn<OrokbefogadhatoAllat, String> szovegColumn;

    @FXML
    private TableColumn<OrokbefogadhatoAllat, String> szuldatumColumn;

    @FXML
    private TableColumn<OrokbefogadhatoAllat, Void> muveletekColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        refreshTable();

        nevColumn.setCellValueFactory(new PropertyValueFactory<>("nev"));
        fajColumn.setCellValueFactory(new PropertyValueFactory<>("faj"));
        szovegColumn.setCellValueFactory(new PropertyValueFactory<>("szoveg"));
        szuldatumColumn.setCellValueFactory(new PropertyValueFactory<>("szuldatum"));

        muveletekColumn.setCellFactory(param -> new TableCell<>(){
            private final Button deleteBtn = new Button("Törlés");
            private final Button editBtn = new Button("Módosítás");

            {
                deleteBtn.setOnAction(event ->{
                    OrokbefogadhatoAllat c = getTableRow().getItem();
                    deleteOrokbefogadhatoAllat(c);
                    refreshTable();
                });
                editBtn.setOnAction(event -> {
                    OrokbefogadhatoAllat c = getTableRow().getItem();
                    editOrokbefogadhatoAllat(c);
                    refreshTable();
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if(empty){
                    setGraphic(null);
                }else{
                    HBox contanier = new HBox();
                    contanier.getChildren().addAll(editBtn, deleteBtn);
                    contanier.setSpacing(10.0);
                    setGraphic(contanier);
                }
            }
        });

    }

    private void editOrokbefogadhatoAllat(OrokbefogadhatoAllat c) {
        FXMLLoader fxmlLoader = App.loadFXML(("/fxml/add_edit_allat_form.fxml"));
        AddEditAllatController controller = fxmlLoader.getController();
        controller.setAllat(c);
    }

    private void deleteOrokbefogadhatoAllat(OrokbefogadhatoAllat c) {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Biztos törölni szeretnéd?", ButtonType.YES, ButtonType.NO);
        confirm.showAndWait().ifPresent(buttonType -> {
            if(buttonType.equals((ButtonType.YES))){
                dao.delete(c);
            }
        });
    }

    private void refreshTable() {

        allatTabla.getItems().setAll(dao.findAll());
    }

    @FXML
    public void onExit(){
        Platform.exit();
    }

    public void onAddNewAllat(){
        FXMLLoader fxmlLoader = App.loadFXML(("/fxml/add_edit_allat_form.fxml"));
        AddEditAllatController controller = fxmlLoader.getController();
        controller.setAllat(new OrokbefogadhatoAllat());

    }

    public void onBack(){
        FXMLLoader fxmlLoader = App.loadFXML(("/fxml/main.fxml"));
    }

}
