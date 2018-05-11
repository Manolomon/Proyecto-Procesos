/*
 * FXMLVistaCursoIndividualController.java
 *
 * Copyright (c) 2018, Royal Mango Developers
 * All rights reserved.
 */

package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.pojos.Curso;


/**
 * @author Manolo Pérez
 * @since Thu May 10 2018
 * @version 0.1
 */

public class FXMLVistaCursoIndividualController implements Initializable {

  @FXML
  private StackPane rootPane;

  @FXML
  private Label lblNombre;

  @FXML
  private JFXButton btnInscribirse;

  @FXML
  private Label lblPrecio;

  @FXML
  private Label lblFechaInicio;

  @FXML
  private Label lblFechaFin;

  @FXML
  private Label lblLugaresDisponibles;

  @FXML
  private Label lblProfesor;

  @FXML
  private ImageView imageCurso;

  @FXML
  private JFXButton btnBack;

  @FXML
  private JFXTextArea lblDescripcion;

  @FXML
  private JFXTextArea lblRequisitos;

  @FXML
  private Label lblCategoria;

  /**
  * Inicialización de la escena, carga de datos y animación
  * 
  * @param url URL de inicialización
  * @param rb ResourceBundle de inicialización
  */
  @Override
  public void initialize(URL url, ResourceBundle rb) {

  }

  /**
  * Carga de la pantalla de Vista General de Cursos
  */
  public void cargarEscenaVistaCursos() {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/view/FXMLVistaCursos.fxml"));
    try {
    loader.load();
    } catch (IOException ex) {
    Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
    }
    FXMLVistaCursosController display = loader.getController();
    //display.cargarUsuario(user);
    StackPane vistaCursos = loader.getRoot();
    Scene newScene = new Scene(vistaCursos);
    Stage curStage = (Stage) rootPane.getScene().getWindow();
    curStage.setScene(newScene);
    curStage.show();
  }

  public void asignarDatos(Curso curso) {
    lblNombre.setText(curso.getNombre());
    Image image = new Image(getClass().getResource(curso.getImagen()).toExternalForm());
    imageCurso.setImage(image);
    // TODO: lblProfesor.setText(curso.getProfesor());
    lblProfesor.setText("Manolo Pérez");
    lblPrecio.setText("$ " + curso.getPrecio().toString() + " MXN");
  }

  @FXML
  void clickInscribirse(ActionEvent event) {

  }

  @FXML
  void clickBack(ActionEvent event) {
    cargarEscenaVistaCursos();
  }
	
}