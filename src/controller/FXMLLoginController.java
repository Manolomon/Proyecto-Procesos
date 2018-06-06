/*
 * FXMLLoginController.java
 *
 * Copyright (c) 2018, Royal Mango Developers
 * All rights reserved.
 */

package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.dao.UsuarioDAO;
import model.pojos.Login;
import model.pojos.Usuario;

/**
 * 
 * Clase controlador de la escena del Login
 * 
 * @author Manolo Pérez
 * @since Mon May 07 2018
 * @version 0.1
 */

public class FXMLLoginController implements Initializable {

  // ==================================================================================================================
  // Elementos de la Interfaz FXML

  @FXML
  private StackPane rootPane;

  @FXML
  private JFXButton btnSignIn;

  @FXML
  private JFXButton btnSignUp;

  @FXML
  private JFXTextField txtUsuario;

  @FXML
  private JFXPasswordField txtPassword;

  // ==================================================================================================================
  // Recursos de la Base de Datos

  private Usuario usuario;

  private Login datosIngresados;

  // ==================================================================================================================
  // Carga de GUI

  /**
   * Inicialización de la escena, carga de datos y animación
   * 
   * @param url URL de inicialización
   * @param rb  ResourceBundle de inicialización
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {

  }

  /**
   * Carga de la pantalla de Registrar Cuenta
   */
  public void cargarEscenaRegistro() {
    try {
      StackPane registroView;
      registroView = FXMLLoader.load(getClass().getResource("/view/FXMLRegistro.fxml"));
      Scene newScene = new Scene(registroView);
      Stage curStage = (Stage) rootPane.getScene().getWindow();
      curStage.setScene(newScene);
      curStage.show();
    } catch (IOException e) {
      System.out.println("No se enecontró: " + e);
    }
  }

  /**
   * Carga de la pantalla del modo Administrador
   */
  public void cargarEscenaAdmin() {
    try {
      StackPane registroView;
      registroView = FXMLLoader.load(getClass().getResource("/view/FXMLSolicitudes.fxml"));
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
  public void cargarEscenaVistaCursos(Usuario user) {
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

  // ==================================================================================================================
  // Eventos FXML

  /**
   * Evento de click en el botón de Iniciar Sesión
   * 
   * @param event Evento de click en btnSignIn
   */
  @FXML
  void clickSignIn(ActionEvent event) {
    iniciarSesion();
  }

  /**
   * Evento de ENTER en la caja de Texto de Contraseña
   * 
   * @param event Evento de click en txtPassword
   */
  @FXML
  void enterPassword(ActionEvent event) {
    iniciarSesion();
  }

  /**
   * Evento de click en el botón de Registrar
   * 
   * @param event Evento de click en btnSignUp
   */
  @FXML
  void clickSignUp(ActionEvent event) {
    cargarEscenaRegistro();
  }

  // ==================================================================================================================
  // Validación y Mensajes

  /**
   * Método de Inicio de Sesión, con validación de datos
   */
  public void iniciarSesion() {
    if (!camposIncompletos()) {
      if("admin".equals(txtUsuario.getText()) && "admin".equals(txtPassword.getText())) {
        cargarEscenaAdmin();
      }else {
        datosIngresados = new Login(txtUsuario.getText(), txtPassword.getText());
        usuario = UsuarioDAO.obtenerUsuario(datosIngresados);
        if (usuario != null) {
          cargarEscenaVistaCursos(usuario);
        } else {
          showDialog("Usuario no registrado", "Revise su matrícula y su contraseña");
        }
      }  
    } else {
      showDialog("Campos incompletos", "Por favor llene todos los campos necesarios");
    }
  }

  /**
   * Verificación de que todos los campos necesarios esten llenos
   * 
   * @return Confirmación si los campos están vacíos
   */
  public boolean camposIncompletos() {
    return txtUsuario.getText().isEmpty() || txtPassword.getText().isEmpty();
  }

  /**
   * Inicialización y muestra de un JFXDialog al centro de la pantalla, mandando
   * una advertencia a alguna operación
   * 
   * @param head Título del dialog
   * @param body Texto principal del dialog
   */
  public void showDialog(String head, String body) {
    JFXDialogLayout content = new JFXDialogLayout();
    content.setHeading(new Text(head));
    content.setBody(new Text(body));
    JFXDialog dialog = new JFXDialog(rootPane, content, JFXDialog.DialogTransition.CENTER);
    JFXButton aceptar = new JFXButton("ACEPTAR");
    aceptar.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
        dialog.close();
      }
    });
    content.setActions(aceptar);
    dialog.show();
  }

}