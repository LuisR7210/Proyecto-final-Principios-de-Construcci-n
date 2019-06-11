/**
 * Copyright (c) 2018-2019 LR
 * La venta de este archivo por cualquier medio está estrictamente prohibida.
 * Todos los derechos reservados.
 */
package SSS.controladores;

import SSS.modelos.Documento;
import SSS.modelos.Estudiante;
import java.io.File;
import java.net.URL;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Luis Roberto Herrera Hernández
 */
public class FXMLSubirReporteController implements Initializable {

  @FXML
  private Label label_titulo;
  @FXML
  private Font x1;
  @FXML
  private TextArea ta_comentarios;
  @FXML
  private ComboBox<String> comboBox_tipos;
  @FXML
  private Label label_archivo;
  @FXML
  private Button boton_archivo;
  @FXML
  private Button boton_cancelar;
  @FXML
  private Font x2;
  @FXML
  private Button boton_subir;
  @FXML
  private ComboBox<String> comboBox_meses;
  @FXML
  private TextField tf_horas;
  @FXML
  private ComboBox<String> comboBox_estados;
  @FXML
  private Pane pane_estado;
  
  private Stage stage;
  private Alert alerta;
  private Documento documento;
  private File destino;
  private Estudiante estudiante;
  
  public void setEstudiante(Estudiante est){
    estudiante=est;
  }
  
  public void setReporte(Documento doc) {
    this.documento = doc;
    label_titulo.setText("Modificar reporte");
    comboBox_tipos.setValue(documento.getNombre());
    ta_comentarios.setText(documento.getComentarios());
    label_archivo.setText(documento.getArchivo().getName());
    comboBox_estados.setValue(documento.getEstado());
    comboBox_meses.setValue(documento.getMes());
    tf_horas.setText(Integer.toString(documento.getHoras()));
    pane_estado.setVisible(true);
  }
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    ObservableList<String> meses = FXCollections.observableArrayList();
    ObservableList<String> estados = FXCollections.observableArrayList();
    ObservableList<String> reportes = FXCollections.observableArrayList();
    meses.addAll("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
    comboBox_meses.setItems(meses);
    comboBox_meses.setValue("Enero");
    estados.addAll("Validado", "Sin validar", "NO válido");
    comboBox_estados.setItems(estados);
    comboBox_estados.setValue("Sin validar");
    reportes.addAll("Reporte Mensual", "Reporte Final");
    comboBox_tipos.setItems(reportes);
    comboBox_tipos.setValue("Reporte Mensual");
    pane_estado.setVisible(false);
  }  

  @FXML
  private void subirArchivo(ActionEvent event) {
  }

  @FXML
  private void cancelar(ActionEvent event) {
  }

  @FXML
  private void subir(ActionEvent event) {
  }
  
}
