/*
 * FXMLRegistroController.java
 *
 * Copyright (c) 2018, Royal Mango Developers
 * All rights reserved.
 */

package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.dao.UsuarioDAO;
import model.pojos.Usuario;

/**
 * @author Manolo Pérez
 * @since Mon May 07 2018
 * @version 0.1
 */

public class FXMLRegistroController implements Initializable {

  @FXML
  private StackPane rootPane;

  @FXML
  private JFXPasswordField txtPassword;

  @FXML
  private JFXPasswordField txtConfirmacion;

  @FXML
  private JFXTextField txtNombre;

  @FXML
  private JFXTextField txtApPaterno;

  @FXML
  private JFXTextField txtApMaterno;

  @FXML
  private JFXTextField txtCurp;

  @FXML
  private JFXDatePicker dateFechaNacimiento;

  @FXML
  private JFXTextField txtUsuario;

  @FXML
  private JFXButton btnSignUp;

  @FXML
  private JFXRadioButton rbtnHombre;

  @FXML
  private ToggleGroup grupoGenero;

  @FXML
  private JFXRadioButton rbtnMujer;

  @FXML
  private JFXButton btnBack;

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

  public boolean camposIncompletos() {
    return txtNombre.getText().isEmpty() || txtApPaterno.getText().isEmpty() || txtApMaterno.getText().isEmpty()
        || txtCurp.getText().isEmpty() || dateFechaNacimiento.getValue() == null
        || grupoGenero.getSelectedToggle() == null || txtUsuario.getText().isEmpty() || txtPassword.getText().isEmpty()
        || txtConfirmacion.getText().isEmpty();
  }

  @FXML
  void clickBack(ActionEvent event) {
    cargarEscenaLogin();
  }

  @FXML
  void clickSignUp(ActionEvent event) {
    if (!camposIncompletos()) {
      String password = txtPassword.getText();
      String confirmacion = txtConfirmacion.getText();
      System.out.println("Password: " + password + "\n" + "Confirmation: " + confirmacion);
      if (password.equals(confirmacion)) {
        String nombre = txtNombre.getText();
        String apPaterno = txtApPaterno.getText();
        String apMaterno = txtApMaterno.getText();
        String curp = txtCurp.getText();
        Date fechaNacimiento = Date.valueOf(dateFechaNacimiento.getValue());
        String genero = ((JFXRadioButton) grupoGenero.getSelectedToggle()).getText();
        String matricula = txtUsuario.getText();
        Usuario user = new Usuario(curp, nombre, apPaterno, apMaterno, fechaNacimiento, genero, matricula, password);
        if (UsuarioDAO.registrarUsuario(user)) {
          cargarEscenaVistaCursos(user);
        } else {
          showDialog("Error de conexión", "Se perdió la conexión con la base de datos");
        }
      } else {
        showDialog("Confirmar", "La contraseña y su confirmación no coinciden");
      }

    } else {
      showDialog("Campos incompletos", "Por favor llene todos los campos necesarios");
    }
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