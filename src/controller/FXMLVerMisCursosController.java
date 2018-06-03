/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.dao.CursoDAO;
import model.dao.UsuarioDAO;
import model.pojos.Curso;
import model.pojos.Maestro;
import model.pojos.Usuario;

/**
 * 
 * @author Manolo Perez
 */
public class FXMLVerMisCursosController implements Initializable {

    @FXML
    private StackPane rootPane;

    @FXML
    private JFXButton btnUser;

    @FXML
    private JFXButton btnHamburger;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblFechaInicio;

    @FXML
    private Label lblFechaFin;

    @FXML
    private Label lblProfesor;

    @FXML
    private ImageView imageCurso;

    @FXML
    private JFXButton btnInscribirse;

    @FXML
    private JFXListView<AnchorPane> listCourses;

    @FXML
    private JFXDrawer drawer;

    private Usuario user;

    private List<Curso> cursosDelUsuario;

    public void asignarDatos(Usuario usr) {
        this.user = usr;
        btnUser.setText(user.getNombre() + " " + user.getApellidoPaterno());
        cursosDelUsuario = UsuarioDAO.obtenerCursosDeUsuario(user.getIdUsuario());
        btnUser.setText(user.getNombre() + " " + user.getApellidoPaterno());
        if (!cursosDelUsuario.isEmpty()) {
            cargarCursos();
            Curso curso = cursosDelUsuario.get(0);
            limpiarEtiquetas();
            llenarInfoCurso(curso);
        }
    }

    public void limpiarEtiquetas() {
        btnInscribirse.setVisible(true);
        imageCurso.setVisible(true);
        lblNombre.setVisible(true);
        lblProfesor.setVisible(true);
        lblFechaInicio.setVisible(true);
        lblFechaFin.setVisible(true);
    }

    public void llenarInfoCurso(Curso curso) {
        lblNombre.setText(curso.getNombre());
        Image image = new Image(getClass().getResource(curso.getImagen()).toExternalForm());
        imageCurso.setImage(image);
        Maestro maestro = CursoDAO.obtenerMaestroCurso(curso.getIdMaestro());
        lblProfesor.setText(maestro.getNombre());
        SimpleDateFormat formatoEsMX = new SimpleDateFormat("d 'de' MMMM 'de' yyyy", new Locale("ES", "MX"));
        lblFechaInicio.setText(formatoEsMX.format(curso.getFechaInicio()));
        lblFechaFin.setText(formatoEsMX.format(curso.getFechaFin()));
    }

    public void cargarCursos() {
        listCourses.getItems().clear();
        cursosDelUsuario = UsuarioDAO.obtenerCursosDeUsuario(user.getIdUsuario());
        for (Curso curso : cursosDelUsuario) {
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
    public void cargarEscenaVistaCursos() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/FXMLVistaCursos.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FXMLVistaCursosController display = loader.getController();
        display.cargarUsuario(this.user);
        StackPane vistaCursos = loader.getRoot();
        Scene newScene = new Scene(vistaCursos);
        Stage curStage = (Stage) rootPane.getScene().getWindow();
        curStage.setScene(newScene);
        curStage.show();
    }

    @FXML
    void clickHamburger(ActionEvent event) {
        try {
            VBox box;
            box = FXMLLoader.load(getClass().getResource("/view/FXMLDrawerEstudiante.fxml"));
            for (Node node : box.getChildren()) {
                node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                    if (node.getAccessibleText() != null) {
                        switch (node.getAccessibleText()) {
                        case "Ver catálogo":
                            cargarEscenaVistaCursos();
                            break;
                        case "Ver mis cursos":
                            drawer.close();
                            drawer.setMouseTransparent(true);
                            break;
                        case "Configurar cuenta":
                            break;
                        }
                        drawer.close();
                        drawer.setMouseTransparent(true);
                    }
                });
            }
            drawer.setSidePane(box);
            drawer.setEffect(new DropShadow());
            drawer.open();
            drawer.setMouseTransparent(false);
        } catch (IOException e) {

        }
    }

    @FXML
    void cerrarDrawer(MouseEvent event) {
        drawer.close();
        drawer.setMouseTransparent(true);
    }

    @FXML
    void clickInscribirse(ActionEvent event) {

    }

    @FXML
    void clickUser(ActionEvent event) {
        cargarEscenaLogin();
    }

    @FXML
    void clickListCourses(MouseEvent event) {
        llenarInfoCurso(cursosDelUsuario.get(listCourses.getSelectionModel().getSelectedIndex()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        drawer.setResizeContent(true);
        drawer.setOverLayVisible(false);
        drawer.setResizableOnDrag(true);
    }

}
