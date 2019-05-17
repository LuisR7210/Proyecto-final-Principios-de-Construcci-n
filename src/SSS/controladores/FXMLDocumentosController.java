/**
 * Copyright (c) 2018-2019 LR
 * La venta de este archivo por cualquier medio está estrictamente prohibida.
 * Todos los derechos reservados.
 */
package SSS.controladores;

import SSS.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class FXMLDocumentosController implements Initializable {

  @FXML
  private Button boton_salir;
  @FXML
  private Font x1;
  @FXML
  private TableView<?> tabla_documentos;
  @FXML
  private TableColumn<?, ?> documentos_columna_nombre;
  @FXML
  private TableColumn<?, ?> documentos_columna_estado;
  @FXML
  private TableColumn<?, ?> documentos_columna_fecha;
  @FXML
  private TableColumn<?, ?> documentos_columna_comentarios;
  @FXML
  private TableView<?> tabla_reportes;
  @FXML
  private TableColumn<?, ?> reportes_columna_mes;
  @FXML
  private TableColumn<?, ?> reportes_columna_horas;
  @FXML
  private TableColumn<?, ?> reportes_columna_estado;
  @FXML
  private TableColumn<?, ?> reportes_columna_fecha;
  @FXML
  private TableColumn<?, ?> reportes_columna_comentarios;
  @FXML
  private Label label_estudiante;
  @FXML
  private Button boton_subir;
  @FXML
  private Button boton_modificar;
  @FXML
  private Button boton_descargar;
  @FXML
  private ImageView logo;
  
  private Main principal;
  private Stage stage;
  
  public void setPrincipal(Main principal) {
    this.principal=principal;
  }
  
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  

  @FXML
  private void salir(ActionEvent event) {
    stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    stage.close();
  }

  @FXML
  private void subir(ActionEvent event) {
  }

  @FXML
  private void modificar(ActionEvent event) {
  }

  @FXML
  private void descargar(ActionEvent event) {
  }

  @FXML
  private void abrirVentanaPrincipal(MouseEvent event) {
    principal.mostrarVentanaPrincipal();
    stage = (Stage) ((ImageView) event.getSource()).getScene().getWindow();
    stage.close();
  }
  
}
