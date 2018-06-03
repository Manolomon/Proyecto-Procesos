/*
 * FXMLPago.java
 *
 * Copyright (c) 2018, Royal Mango Developers
 * All rights reserved.
 */

package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.dao.CursoDAO;
import model.pojos.Curso;
import model.pojos.Grupo;
import model.pojos.Maestro;
import model.pojos.Pago;
import model.pojos.Usuario;

/**
 * @author Manolo Pérez
 * @since Tue May 22 2018
 * @version 0.1
 */

public class FXMLPagoController implements Initializable {
 
    @FXML
    private StackPane rootPane;

    @FXML
    private JFXButton btnUser;

    @FXML
    private JFXRadioButton radioBtnTarjeta;

    @FXML
    private ToggleGroup metodopago;

    @FXML
    private JFXRadioButton radioBtnPaypal;

    @FXML
    private JFXButton btnPagar;

    @FXML
    private JFXTextField txtReferencia;

    @FXML
    private JFXTextField txtFolio;

    @FXML
    private ImageView imageCurso;

    @FXML
    private Label lblFechaInicio;

    @FXML
    private Label lblFechaFin;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblProfesor;

    @FXML
    private Label lblPrecio;
    
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
  
  public void asignarDatos(Usuario usr, Curso curso) {
    this.user = usr;
    this.curso = curso;
    btnUser.setText(user.getNombre() + " " + user.getApellidoPaterno());
    lblNombre.setText(curso.getNombre());
    Image image = new Image(getClass().getResource(curso.getImagen()).toExternalForm());
    imageCurso.setImage(image);
    Maestro maestro = CursoDAO.obtenerMaestroCurso(curso.getIdMaestro());
    lblProfesor.setText(maestro.getNombre());
    SimpleDateFormat formatoEsMX = new SimpleDateFormat(
            "d 'de' MMMM 'de' yyyy", new Locale("ES", "MX"));
    lblFechaInicio.setText(formatoEsMX.format(curso.getFechaInicio()));
    lblFechaFin.setText(formatoEsMX.format(curso.getFechaFin()));
    DecimalFormat df = new DecimalFormat("#.00");
    lblPrecio.setText("$ " + df.format(curso.getPrecio()) + " MXN");
  }
  
  public void cargarVistaIndividual() {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("/view/FXMLVistaCursoIndividual.fxml"));
    try {
      loader.load();
    } catch (IOException ex) {
      Logger.getLogger(FXMLVistaCursosController.class.getName()).log(Level.SEVERE, null, ex);
    }
    FXMLVistaCursoIndividualController display = loader.getController();
    display.asignarDatos(user, curso);
    StackPane agregarView = loader.getRoot();
    Scene newScene = new Scene(agregarView);
    Stage curStage = (Stage) rootPane.getScene().getWindow();
    curStage.setScene(newScene);
    curStage.show();
  }
  
  public boolean camposIncompletos() {
      return metodopago.getSelectedToggle() == null || txtReferencia.getText().isEmpty() || txtFolio.getText().isEmpty();
  }
  
  @FXML
  void clickUser(ActionEvent event) {
    cargarEscenaLogin();
  }

  @FXML
  void clickBack(ActionEvent event) {
    cargarVistaIndividual();
  }
  
  @FXML
  void clickMetodo(ActionEvent event) {
    txtReferencia.setDisable(false);
    txtFolio.setDisable(false);
  }
  
  @FXML
  void clickPagar(ActionEvent event) {
    if(!camposIncompletos()) {
        List<Grupo> grupos = CursoDAO.obtenerGrupoDeCurso(curso.getIdCurso());
       boolean agregado = false;
       Pago pago = new Pago();
       for(Grupo group : grupos) {
           if(group.getAlumnos() < 30) {
               pago = new Pago("Pago del curso: " + curso.getNombre() + " Folio: " + txtFolio.getText(), "pendiente", user.getIdUsuario(), group.getIdGrupo());
               agregado = true;
               break;
           }
       }
       if(!agregado) {
           CursoDAO.registrarGrupo(new Grupo(curso.getIdCurso()));
           grupos = CursoDAO.obtenerGrupoDeCurso(curso.getIdCurso());
           Grupo nuevoGrupo = grupos.get(grupos.size() - 1);
           CursoDAO.nuevoEstudianteGrupo(nuevoGrupo);
           pago = new Pago("Pago del curso: " + curso.getNombre() + " Folio: " + txtFolio.getText(), "pendiente", user.getIdUsuario(), nuevoGrupo.getIdGrupo());
       }
        Grupo ultimoGrupoDeCurso = grupos.get(grupos.size() - 1);
        if (ultimoGrupoDeCurso.getAlumnos() < 30) {
            pago = new Pago("Pago del curso: " + curso.getNombre() + " Folio: " + txtFolio.getText(), "pendiente", user.getIdUsuario(), ultimoGrupoDeCurso.getIdGrupo());
        } else {
            CursoDAO.registrarGrupo(new Grupo(curso.getIdCurso()));
            grupos = CursoDAO.obtenerGrupoDeCurso(curso.getIdCurso());
            ultimoGrupoDeCurso = grupos.get(grupos.size() - 1);
            pago = new Pago("Pago del curso: " + curso.getNombre() + " Folio: " + txtFolio.getText(), "pendiente", user.getIdUsuario(), ultimoGrupoDeCurso.getIdGrupo());
        }
        CursoDAO.nuevoEstudianteGrupo(ultimoGrupoDeCurso);
        if(CursoDAO.registrarPago(pago)) {
            showDialog("Transacción Exitosa", "Se ha guardado su compra");
        } else {
            showDialog("Error", "Ha habido un error con la Base de Datos");
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
