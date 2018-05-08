/**
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
import javafx.scene.layout.StackPane;

/**
 * @author Manolo Pérez
 * @since Mon May 07 2018
 * @version 0.1
 */

public class FXMLVistaCursosController implements Initializable {

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
  private JFXListView<?> listCourses;

  @FXML
  private JFXListView<?> listCategories;

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

  // ==================================================================================================================
  // Eventos FXML

  @FXML
  void clickInbox(ActionEvent event) {
    btnNotifCount.setVisible(false);
  }

  @FXML
  void clickUser(ActionEvent event) {
    btnNotifCount.setVisible(true);
  }
	
}