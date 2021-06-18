package hu.alkfej.controller;

import hu.alkfej.App;

import hu.alkfej.dao.OrokbefogadoDAO;
import hu.alkfej.dao.OrokbefogadoDAOImpl;
import hu.alkfej.model.Orokbefogado;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainOrokbefogadoController implements Initializable {
    //örökbefogadó oldala

    OrokbefogadoDAO dao2 = new OrokbefogadoDAOImpl();

    @FXML
    private TableView<Orokbefogado> emberTabla;

    @FXML
    private TableColumn<Orokbefogado, String> nevColumn;

    @FXML
    private TableColumn<Orokbefogado, String> emailColumn;

    @FXML
    private TableColumn<Orokbefogado, Void> muveletekColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       refreshTable();

        nevColumn.setCellValueFactory(new PropertyValueFactory<>("nev"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        muveletekColumn.setCellFactory(param -> new TableCell<>() {
                    private final Button deleteBtn = new Button("Törlés");
                    private final Button editBtn = new Button("Módosítás");

                    {
                        deleteBtn.setOnAction(event ->{
                            Orokbefogado em = getTableRow().getItem();
                            deleteOrokbefogado(em);
                            refreshTable();
                        });
                        editBtn.setOnAction(event -> {
                            Orokbefogado em = getTableRow().getItem();
                            editOrokbefogado(em);
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


            private void deleteOrokbefogado(Orokbefogado em) {
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Biztos törölni szeretnéd?", ButtonType.YES, ButtonType.NO);
                confirm.showAndWait().ifPresent(buttonType -> {
                    if(buttonType.equals((ButtonType.YES))){
                        dao2.delete(em);
                    }
                });
            }

         private void editOrokbefogado(Orokbefogado em) {
                FXMLLoader fxmlLoader = App.loadFXML(("/fxml/edit_ember.fxml"));
                EditEmberController controller = fxmlLoader.getController();
                controller.setEmber(em);
            }


    private void refreshTable() {
        emberTabla.getItems().setAll(dao2.findAll());
    }

    @FXML
    public void onExit(){
        Platform.exit();
    }

    public void onBack(){
        FXMLLoader fxmlLoader = App.loadFXML(("/fxml/main.fxml"));
    }


}
