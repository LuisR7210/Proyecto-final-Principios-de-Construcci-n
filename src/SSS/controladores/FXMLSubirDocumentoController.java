/**
 * Copyright (c) 2018-2019 LR
 * La venta de este archivo por cualquier medio está estrictamente prohibida.
 * Todos los derechos reservados.
 */
package SSS.controladores;

import SSS.DAO.SQLDocumento;
import SSS.modelos.Documento;
import SSS.modelos.Estudiante;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.time.LocalDate;
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
  private ComboBox<String> comboBox_estados;
  @FXML
  private Pane pane_estado;
  
  private Alert alerta;
  private Documento documento;
  private File archivo;
  private File destino;
  private Estudiante estudiante;
  
  public void setEstudiante(Estudiante est){
    estudiante=est;
  }
  
  public void setDocumento(Documento doc) {
    this.documento = doc;
    label_titulo.setText("Modificar documento");
    comboBox_documentos.setValue(documento.getNombre());
    ta_comentarios.setText(documento.getComentarios());
    label_archivo.setText(documento.getArchivo().getName());
    comboBox_estados.setValue(documento.getEstado());
    archivo=documento.getArchivo();
    pane_estado.setVisible(true);
  }

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    pane_estado.setVisible(false);
    ObservableList<String> estados = FXCollections.observableArrayList();
    ObservableList<String> documentos = FXCollections.observableArrayList();
    estados.addAll("Validado", "Sin validar", "NO válido");
    comboBox_estados.setItems(estados);
    comboBox_estados.setValue("Sin validar");
    documentos.addAll("Oficio de Presentación", "Horario de Clases", "Carta de Aceptación",
            "Formato de registro y plan de actividades", "Carta de Terminación", "Memoria");
    comboBox_documentos.setItems(documentos);
    comboBox_documentos.setValue("Oficio de presentación");
  }  

  @FXML
  private void cancelar(ActionEvent event) {
    Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    stage.close();
  }

  @FXML
  private void subir(ActionEvent event) {
    if (archivo == null) {
      alerta = new Alert(Alert.AlertType.WARNING);
      alerta.setTitle("Indicación");
      alerta.setHeaderText("NO se ingresaron todos los datos obligatorios (*)");
      alerta.showAndWait();
      return;
    }
    SQLDocumento sql_documento=new SQLDocumento();
    Documento temporal=new Documento(0, 
              comboBox_documentos.getValue(),
              LocalDate.now(),
              ta_comentarios.getText(),
              archivo,
              comboBox_estados.getValue()
      );
    if(documento==null){
      sql_documento.registrarDocumento(temporal, estudiante);
    }
    else {
      sql_documento.modificarDocumento(documento, temporal, estudiante);
    }
    Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    stage.close();
  }

  @FXML
  private void subirArchivo(ActionEvent event) {
    Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    FileChooser file_chooser = new FileChooser();
    file_chooser.setTitle("Seleccione el documento escaneado");
    file_chooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Archivos de imágen (*.jpg *.png)", "*.jpg", "*.png"),
            new FileChooser.ExtensionFilter("Archivos PDF", "*.pdf")
    );
    archivo = file_chooser.showOpenDialog(stage);
    if(archivo!=null){
      label_archivo.setText(archivo.getName());
      destino=new File("Documentos Servicio Social/"+archivo.getName());
      try {
        Files.copy(Paths.get(archivo.getAbsolutePath()), Paths.get(destino.getAbsolutePath()), REPLACE_EXISTING);
        archivo=destino;
      } catch (IOException ex) {
        System.out.println("Error al cargar el archivo");
      }
    }
  }
  
}
