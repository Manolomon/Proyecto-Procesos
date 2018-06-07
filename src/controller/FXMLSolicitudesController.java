/*
 * FXMLDatosCursoController.java
 *
 * Copyright (c) 2018, Royal Mango Developers
 * All rights reserved.
 */

package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.dao.CursoDAO;
import model.dao.UsuarioDAO;
import model.pojos.Curso;
import model.pojos.Pago;
import model.pojos.Usuario;

public class FXMLSolicitudesController implements Initializable {

    @FXML
    private StackPane rootPane;

    @FXML
    private Label lblNombre;

    @FXML
    private JFXButton buttonAceptar;

    @FXML
    private Label labelNombre;

    @FXML
    private ImageView imageCurso;

    @FXML
    private JFXButton buttonRechazar;

    @FXML
    private Label labelApellidoPaterno;

    @FXML
    private Label labelApellidoMaterno;

    @FXML
    private Label lblNombre1;

    @FXML
    private Label lblPrecio3;

    @FXML
    private Label labelNombreCurso;

    @FXML
    private Label lblPrecio31;

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXListView<Label> listPagosPendientes;

    private List<Pago> pagosPendientes;

    @FXML
    void clickAceptar(ActionEvent event) {
        if (CursoDAO.aprobarPago(
                (pagosPendientes.get(listPagosPendientes.getSelectionModel().getSelectedIndex())).getIdPago())) {
            showDialog("Aceptado", "Se ha aceptado el pago");
        } else{
            showDialog("Error", "Error con la conexion a la Base de Datos");
        }
        cargarPagosPendientes();
    }

    @FXML
    void clickBack(ActionEvent event) {
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

    @FXML
    void clickListPagos(MouseEvent event) {
        mostrarDatos(pagosPendientes.get(listPagosPendientes.getSelectionModel().getSelectedIndex()));
    }

    @FXML
    void clickRechazar(ActionEvent event) {
        if (CursoDAO.rechazarPago(
                (pagosPendientes.get(listPagosPendientes.getSelectionModel().getSelectedIndex())).getIdPago())) {
            showDialog("Rechazado", "Se ha rechazado el pago");
        } else{
            showDialog("Error", "Error con la conexion a la Base de Datos");
        }
        cargarPagosPendientes();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargarPagosPendientes();
    }

    public void cargarPagosPendientes() {
        listPagosPendientes.getItems().clear();
        pagosPendientes = CursoDAO.obtenerPagosPendientes();
        if (pagosPendientes != null) {
            for (Pago p : pagosPendientes) {
                try {
                    Label lbl = new Label(p.getInformacionDePago());
                    listPagosPendientes.getItems().add(lbl);
                } catch (Exception ex) {
                    System.err.println("Error: " + ex);
                }
            }
        }
    }

    public void mostrarDatos(Pago pago) {
        Curso curso = CursoDAO.obtenerCursoId(pago.getIdGrupo());
        Usuario usuario = UsuarioDAO.obtenerUsuarioId(pago.getIdUsuario());
        labelNombreCurso.setText(curso.getNombre());
        labelNombre.setText(usuario.getNombre());
        labelApellidoPaterno.setText(usuario.getApellidoPaterno());
        labelApellidoMaterno.setText(usuario.getApellidoMaterno());
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
