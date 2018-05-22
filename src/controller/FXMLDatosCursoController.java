/*
 * FXMLDatosCursoController.java
 *
 * Copyright (c) 2018, Royal Mango Developers
 * All rights reserved.
 */

package controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.dao.CursoDAO;
import model.pojos.Curso;
import model.pojos.Maestro;

/**
 * @author Manolo Pérez
 * @since Thu May 10 2018
 * @version 0.1
 */

public class FXMLDatosCursoController implements Initializable {
  
  @FXML
  private ImageView imageCurso;

  @FXML
  private Label lblNombre;

  @FXML
  private Label lblProfesor;

  @FXML
  private Label lblPrecio;

  /**
   * Inicialización de la escena, carga de datos y animación
   * 
   * @param url URL de inicialización
   * @param rb  ResourceBundle de inicialización
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {

  }

  public void asignarDatos(Curso curso) {
    lblNombre.setText(curso.getNombre());
    Image image = new Image(getClass().getResource(curso.getImagen()).toExternalForm());
    imageCurso.setImage(image);
    Maestro maestro = CursoDAO.obtenerMaestroCurso(curso.getIdMaestro());
    lblProfesor.setText(maestro.getNombre());
    DecimalFormat df = new DecimalFormat("#.00");
    lblPrecio.setText("$ " + df.format(curso.getPrecio()) + " MXN");
  }
  
}