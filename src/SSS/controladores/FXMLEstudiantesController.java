/**
 * Copyright (c) 2018-2019 LR
 * La venta de este archivo por cualquier medio está estrictamente prohibida.
 * Todos los derechos reservados.
 */
package SSS.controladores;

import SSS.Main;
import SSS.modelos.Estudiante;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Luis Roberto Herrera Hernández
 */
public class FXMLEstudiantesController implements Initializable {

  @FXML
  private ImageView logo;
  @FXML
  private Button boton_salir;
  @FXML
  private Font x1;
  @FXML
  private Button boton_documentos;
  @FXML
  private TableView<Estudiante> tabla_estudiantes;
  @FXML
  private TableColumn<Estudiante, String> estudiantes_columna_matricula;
  @FXML
  private TableColumn<Estudiante, String> estudiantes_columna_nombre;
  @FXML
  private TableColumn<Estudiante, String> estudiantes_columna_telefono;
  @FXML
  private TableColumn<Estudiante, String> estudiantes_columna_correo;
  @FXML
  private TableColumn<Estudiante, String> estudiantes_columna_cuenta;
  @FXML
  private Button boton_informacion;
  
  private Main principal;
  private Stage stage;
  private Alert alerta;
  private ObservableList<Estudiante> estudiantes = FXCollections.observableArrayList();
  
  public void setPrincipal(Main principal) {
    this.principal=principal;
  }
  
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    tabla_estudiantes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    estudiantes_columna_nombre.setCellValueFactory(
            cellData -> cellData.getValue().getNombreProperty());
    estudiantes_columna_matricula.setCellValueFactory(
            cellData -> cellData.getValue().getMatriculaProperty());
    estudiantes_columna_telefono.setCellValueFactory(
            cellData -> cellData.getValue().getTelefonoProperty());
    estudiantes_columna_correo.setCellValueFactory(
            cellData -> cellData.getValue().getCorreoProperty());
    estudiantes_columna_cuenta.setCellValueFactory(
            cellData -> cellData.getValue().getEstadoProperty());
    tabla_estudiantes.setPlaceholder(new Label(" No hay estudiantes registrados."));
    estudiantes.add(new Estudiante("S17012936", "Luis Roberto Herrera Hernández", "2281196008", "lr_gtx000hh@outlook.com", "Sin validar"));
    tabla_estudiantes.setItems(estudiantes);
  }  

  @FXML
  private void abrirVentanaPrincipal(MouseEvent event) {
    principal.mostrarVentanaPrincipal();
    stage = (Stage) ((ImageView) event.getSource()).getScene().getWindow();
    stage.close();
  }

  @FXML
  private void salir(ActionEvent event) {
    stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    stage.close();
  }

  @FXML
  private void abrirVentanaDocumentos(ActionEvent event) {
    if (tabla_estudiantes.getSelectionModel().isEmpty()) {
      alertaNoEstudianteSeleccionado();
      return;
    }
    principal.mostrarVentanaDocumentos();
    stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    stage.close();
  }

  @FXML
  private void verInformacion(ActionEvent event) {
    if (tabla_estudiantes.getSelectionModel().isEmpty()) {
      alertaNoEstudianteSeleccionado();
      return;
    }
    
  }
  
  public void alertaNoEstudianteSeleccionado(){
    alerta = new Alert(Alert.AlertType.WARNING);
      alerta.setTitle("Indicación");
      alerta.setHeaderText("Primero debes seleccionar un estudiante de la tabla");
      alerta.showAndWait();
  }
}
