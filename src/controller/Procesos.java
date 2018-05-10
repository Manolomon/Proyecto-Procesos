/*
 * Procesos.java
 *
 * Copyright (c) 2018, Royal Mango Developers
 * All rights reserved.
 */

package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * Clase principal de ejecución del sistema
 * @author Manolo Pérez
 * @since Mon May 07 2018
 * @version 1.0
 */
public class Procesos extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLLogin.fxml"));
        stage.setTitle("Plataforma de Gstión del Aprendizaje");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/view/styles.css").toExternalForm());
        
        
        stage.setResizable(false);
        stage.sizeToScene();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
