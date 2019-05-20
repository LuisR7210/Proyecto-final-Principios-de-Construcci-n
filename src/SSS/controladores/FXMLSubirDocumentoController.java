/**
 * Copyright (c) 2018-2019 LR
 * La venta de este archivo por cualquier medio está estrictamente prohibida.
 * Todos los derechos reservados.
 */
package SSS.controladores;

import SSS.modelos.Documento;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Luis Roberto Herrera Hernández
 */
public class FXMLSubirDocumentoController implements Initializable {

  @FXML
  private Font x1;
  @FXML
  private Label label_archivo;
  @FXML
  private Button boton_cancelar;
  @FXML
  private Font x2;
  @FXML
  private Button boton_subir;
  @FXML
  private Button boton_archivo;
  @FXML
  private Label label_titulo;
  @FXML
  private TextArea ta_comentarios;
  @FXML
  private ComboBox<String> comboBox_documentos;
  @FXML
  private Pane pane_reporte;
  @FXML
  private ComboBox<String> comboBox_meses;
  @FXML
  private TextField tf_horas;
  @FXML
  private ComboBox<String> comboBox_estados;
  
  private Stage stage;
  private Alert alerta;
  private Documento documento;
  private boolean es_reporte=true;
  
  public void setDocumento(Documento doc) {
    this.documento = doc;
    label_titulo.setText("Modificar documento");
    comboBox_documentos.setValue(documento.getNombre());
    ta_comentarios.setText(documento.getComentarios());
    label_archivo.setText(documento.getArchivo().getName());
    comboBox_estados.setValue(documento.getEstado());
    if (es_reporte) {
      comboBox_meses.setValue(documento.getMes());
      tf_horas.setText(Integer.toString(documento.getHoras()));
    }
  }
  
  public void setBooleanReporte(boolean es_reporte){
    this.es_reporte=es_reporte;
    if(!es_reporte){
      pane_reporte.setVisible(false);
    }
  }

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    ObservableList<String> meses = FXCollections.observableArrayList();
    ObservableList<String> estados = FXCollections.observableArrayList();
    ObservableList<String> documentos = FXCollections.observableArrayList();
    ObservableList<String> reportes = FXCollections.observableArrayList();
    meses.addAll("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
    comboBox_meses.setItems(meses);
    comboBox_meses.setValue("Enero");
    estados.addAll("Validado", "Sin validar", "NO válido");
    comboBox_estados.setItems(estados);
    comboBox_estados.setValue("Sin validar");
    documentos.addAll("Oficio de Presentación", "Horario de Clases", "Carta de Aceptación",
            "Formato de Registro y Plan de Actividades de Servicio Social",
            "Carta de Terminación", "Memoria");
    comboBox_documentos.setItems(documentos);
    comboBox_documentos.setValue("Oficio de presentación");
    reportes.addAll("Reporte Mensual", "Reporte Final");
  }  

  @FXML
  private void cancelar(ActionEvent event) {
    stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    stage.close();
  }

  @FXML
  private void subir(ActionEvent event) {
    stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    stage.close();
  }

  @FXML
  private void subirArchivo(ActionEvent event) {
    FileChooser file_chooser = new FileChooser();
    file_chooser.setTitle("Escoja el documento");
    file_chooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Archivos de imágen", "*.jpg", "*.png"),
            new FileChooser.ExtensionFilter("Archivos PDF", "*.pdf")
    );
    
    File archivo = file_chooser.showOpenDialog(stage);
    label_archivo.setText(archivo.getName());
  }
  
}
