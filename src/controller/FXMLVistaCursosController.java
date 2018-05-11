/*
 * FXMLVistaCursosController.java
 *
 * Copyright (c) 2018, Royal Mango Developers
 * All rights reserved.
 */

package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.dao.CursoDAO;
import model.pojos.Curso;
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

  private Usuario user;

  private ArrayList<String> categorias = new ArrayList<>();

  private List<Curso> cursos;

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
    cargarCategorias();
    //cargarCursos(null);
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

  public void cargarVistaIndividual(Curso curso) {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/view/FXMLVistaCursoIndividual.fxml"));
    try {
      loader.load();
    } catch (IOException ex) {
      Logger.getLogger(FXMLVistaCursosController.class.getName()).log(Level.SEVERE, null, ex);
    }
    FXMLVistaCursoIndividualController display = loader.getController();
    display.asignarDatos(curso);
    StackPane agregarView = loader.getRoot();
    Scene newScene = new Scene(agregarView);
    Stage curStage = (Stage) rootPane.getScene().getWindow();
    curStage.setScene(newScene);
    curStage.show();
  }

  public void cargarUsuario(Usuario user) {
    btnUser.setText(user.getNombre() + " " + user.getApellidoPaterno());
    this.user = user;
  }

  public void cargarCategorias() {
    listCategories.getItems().clear();
    cursos = CursoDAO.obtenerAllCursosOrdenados();
    if (cursos != null) {
      String categoria = cursos.get(0).getCategoria();
      String iteracion = categoria;
      for (Curso curso : cursos) {
        iteracion = curso.getCategoria();
        if (!categoria.equals(iteracion)) {
          categoria = curso.getCategoria();
        } else {
          categorias.add(curso.getCategoria());
          try {
            Label lbl = new Label(curso.getCategoria());
            lbl.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/Book.png"))));
            listCategories.getItems().add(lbl);
          } catch (Exception ex) {
            System.err.println("Error: " + ex);
          }
        }
      }
    }
  }

  public void cargarCursos(String categoria) {
    listCourses.getItems().clear();
    cursos = CursoDAO.obtenerAllCursosDeCategoria(categoria);
    for(Curso curso : cursos) {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("/view/FXMLDatosCurso.fxml"));
      try {
        loader.load();
      } catch (IOException ex) {
        Logger.getLogger(FXMLVistaCursosController.class.getName()).log(Level.SEVERE, null, ex);
      }
      FXMLDatosCursoController display = loader.getController();
      AnchorPane p = loader.getRoot();
      display.asignarDatos(curso);
      listCourses.getItems().add(p);
    }
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
    //btnNotifCount.setVisible(true);
    cargarEscenaLogin();
  }

  @FXML
  void clickListCategories(MouseEvent event) {
    cargarCursos(categorias.get(listCategories.getSelectionModel().getSelectedIndex()));
  }

  @FXML
  void clickListCourses(MouseEvent event) {
    cargarVistaIndividual(cursos.get(listCourses.getSelectionModel().getSelectedIndex()));
  }

}