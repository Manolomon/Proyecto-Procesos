/*
 * FXMLVistaCursoIndividualController.java
 *
 * Copyright (c) 2018, Royal Mango Developers
 * All rights reserved.
 */

package controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
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
import model.dao.CursoDAO;
import model.pojos.Categoria;
import model.pojos.Curso;
import model.pojos.Maestro;
import model.pojos.Usuario;


/**
 * @author Manolo Pérez
 * @since Thu May 10 2018
 * @version 0.1
 */

public class FXMLVistaCursoIndividualController implements Initializable {

  @FXML
    private StackPane rootPane;

    @FXML
    private JFXButton btnUser;

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
    private Label lblCategoria;

    @FXML
    private Label lblDescripcion;

    @FXML
    private Label lblRequisitos;
  
    private Usuario user;
    
    private Curso curso;

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
    display.cargarUsuario(user);
    StackPane vistaCursos = loader.getRoot();
    Scene newScene = new Scene(vistaCursos);
    Stage curStage = (Stage) rootPane.getScene().getWindow();
    curStage.setScene(newScene);
    curStage.show();
  }
  
  /**
   * Carga de la pantalla de Login
   */
  public void cargarEscenaLogin() {
    try {
      StackPane registroView;
      registroView = FXMLLoader.load(getClass().getResource("/view/FXMLLogin.fxml"));
      Scene newScene = new Scene(registroView);
      Stage curStage = (Stage) rootPane.getScene().getWindow();
      curStage.setScene(newScene);
      curStage.show();
    } catch (IOException e) {
      System.out.println("No se enecontró: " + e);
    }
  }
  
  /**
  * Carga de la pantalla de Vista General de Cursos
  */
  public void cargarEscenaPago() {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/view/FXMLPago.fxml"));
    try {
    loader.load();
    } catch (IOException ex) {
    Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
    }
    FXMLPagoController display = loader.getController();
    display.asignarDatos(user, curso);
    StackPane vistaCursos = loader.getRoot();
    Scene newScene = new Scene(vistaCursos);
    Stage curStage = (Stage) rootPane.getScene().getWindow();
    curStage.setScene(newScene);
    curStage.show();
  }

  public void asignarDatos(Usuario usr, Curso curso) {
    this.user = usr;
    this.curso = curso;
    btnUser.setText(user.getNombre() + " " + user.getApellidoPaterno());
    Categoria cat = CursoDAO.obtenerCategoriaCurso(curso.getIdCategoria());
    lblCategoria.setText(cat.getNombre());
    lblNombre.setText(curso.getNombre());
    Image image = new Image(getClass().getResource(curso.getImagen()).toExternalForm());
    imageCurso.setImage(image);
    lblDescripcion.setText("Esta es una simple y genérica versión de una descripción para el curso de " + curso.getNombre());
    lblRequisitos.setText("Si el curso " + curso.getNombre() + " tuviera más requerimientos que el de ser bonito, estarían listados aquí");
    Maestro maestro = CursoDAO.obtenerMaestroCurso(curso.getIdMaestro());
    lblProfesor.setText(maestro.getNombre());
    SimpleDateFormat formatoEsMX = new SimpleDateFormat(
            "d 'de' MMMM 'de' yyyy", new Locale("ES", "MX"));
    lblFechaInicio.setText(formatoEsMX.format(curso.getFechaInicio()));
    lblFechaFin.setText(formatoEsMX.format(curso.getFechaFin()));
    DecimalFormat df = new DecimalFormat("#.00");
    lblPrecio.setText("$ " + df.format(curso.getPrecio()) + " MXN");
  }

  @FXML
  void clickUser(ActionEvent event) {
    //btnNotifCount.setVisible(true);
    cargarEscenaLogin();
  }
  
  @FXML
  void clickInscribirse(ActionEvent event) {
      cargarEscenaPago();
  }

  @FXML
  void clickBack(ActionEvent event) {
    cargarEscenaVistaCursos();
  }
	
}