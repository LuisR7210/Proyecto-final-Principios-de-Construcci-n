/**
 * Copyright (c) 2018-2019 LR
 * La venta de este archivo por cualquier medio está estrictamente prohibida.
 * Todos los derechos reservados.
 */
package SSS.controladores;

import SSS.DAO.SQLEstudiante;
import SSS.DAO.SQLServicioSocial;
import SSS.Main;
import SSS.modelos.Estudiante;
import SSS.modelos.ServicioSocial;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

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
  @FXML
  private ComboBox<String> comboBox_periodos;
  
  private Main principal;
  private Alert alerta;
  private final SQLEstudiante sql_estudiantes=new SQLEstudiante();
  private final SQLServicioSocial sql_servicios=new SQLServicioSocial();
  private ObservableList<Estudiante> estudiantes = FXCollections.observableArrayList();
  private ArrayList<ServicioSocial> servicios=new ArrayList<>();
  
  public void setPrincipal(Main principal) {
    this.principal=principal;
  }
  
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    cargarPeriodos();
    estudiantes=sql_estudiantes.cargarEstudiantes(servicios.get(servicios.size()-1).getId_servicio_social());
    inicializarTablaEstudiantes();
  }
  
  private void cargarPeriodos(){
    servicios=sql_servicios.cargarServiciosSociales();
    ObservableList<String> periodos= FXCollections.observableArrayList();
    for(int i=0;i<servicios.size();i++){
      periodos.add(servicios.get(i).getPeriodo());
    }
    comboBox_periodos.setItems(periodos);
    comboBox_periodos.setValue(periodos.get(periodos.size()-1));
  }
  
  private void inicializarTablaEstudiantes(){
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
    tabla_estudiantes.setItems(estudiantes);
  }

  @FXML
  private void abrirVentanaPrincipal(MouseEvent event) {
    principal.mostrarVentanaPrincipal();
  }

  @FXML
  private void salir(ActionEvent event) {
    principal.salir();
  }

  @FXML
  private void abrirVentanaDocumentos(ActionEvent event) {
    if (tabla_estudiantes.getSelectionModel().isEmpty()) {
      alertaNoEstudianteSeleccionado();
      return;
    }
    principal.mostrarVentanaDocumentos(tabla_estudiantes.getSelectionModel().getSelectedItem());
  }

  @FXML
  private void verInformacion(ActionEvent event) {
    if (tabla_estudiantes.getSelectionModel().isEmpty()) {
      alertaNoEstudianteSeleccionado();
      return;
    }
    
  }

  @FXML
  private void mostrarEstudiantesPeriodo(ActionEvent event) {
    for(int i=0;i<servicios.size();i++){
      if(servicios.get(i).getPeriodo().equals(comboBox_periodos.getValue())){
        estudiantes=sql_estudiantes.cargarEstudiantes(servicios.get(i).getId_servicio_social());
        tabla_estudiantes.setItems(estudiantes);
      }
    }
  }
  
  public void alertaNoEstudianteSeleccionado(){
    alerta = new Alert(Alert.AlertType.WARNING);
      alerta.setTitle("Indicación");
      alerta.setHeaderText("Primero debes seleccionar un estudiante de la tabla");
      alerta.showAndWait();
  }
  
}
