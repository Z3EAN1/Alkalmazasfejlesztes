package hu.alkfej.controller;

import hu.alkfej.App;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class MainController {
    //főoldal

    @FXML
    public void onExit(){
        Platform.exit();
    }

    public void onAllatok(){
        FXMLLoader fxmlLoader = App.loadFXML(("/fxml/main_Window.fxml"));
    }
    public void onOrokbefogadok(){ FXMLLoader fxmlLoader = App.loadFXML(("/fxml/main_Orokbefogadok.fxml")); }
    public void onKonyveles(){ FXMLLoader fxmlLoader = App.loadFXML(("/fxml/main_Konyveles.fxml"));}
}
