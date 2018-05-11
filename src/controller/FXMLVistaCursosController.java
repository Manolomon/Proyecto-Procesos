/*
 * FXMLVistaCursosController.java
 *
 * Copyright (c) 2018, Royal Mango Developers
 * All rights reserved.
 */

package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import model.pojos.Usuario;

/**
 * 
 * Clase controlador de la escena Vista General de Cursos
 * 
 * @author Manolo Pérez
 * @since Mon May 07 2018
 * @version 0.2
 */

public class FXMLVistaCursosController implements Initializable {

  // ==================================================================================================================
  // Elementos de la Interfaz FXML

  @FXML
  private StackPane rootPane;

  @FXML
  private JFXButton btnUser;

  @FXML
  private JFXButton btnNotifCount;

  @FXML
  private JFXButton btnInbox;

  @FXML
  private JFXButton btnHamburger;

  @FXML
  private JFXListView<AnchorPane> listCourses;

  @FXML
  private JFXListView<Label> listCategories;

  // ==================================================================================================================
  // Recursos de la Base de Datos

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

  public void cargarUsuario(Usuario user) {
    btnUser.setText(user.getNombre() + " " + user.getApellidoPaterno());
  }

  // ==================================================================================================================
  // Eventos FXML

  /**
   * Evento de click en el botón de Inbox
   * 
   * @param event Evento de click en btnNotifCount
   */
  @FXML
  void clickInbox(ActionEvent event) {
    btnNotifCount.setVisible(false);
  }

  /**
   * Evento de click en el botón de Cuenta
   * 
   * @param event Evento de click en btnUser
   */
  @FXML
  void clickUser(ActionEvent event) {
    btnNotifCount.setVisible(true);
  }

}