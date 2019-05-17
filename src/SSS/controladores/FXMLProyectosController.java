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
public class FXMLProyectosController implements Initializable {

  @FXML
  private ImageView logo;
  @FXML
  private Button boton_salir;
  @FXML
  private Font x1;
  @FXML
  private TableView<?> tabla_estudiantes;
  @FXML
  private TableColumn<?, ?> estudiantes_columna_matricula;
  @FXML
  private TableColumn<?, ?> estudiantes_columna_nombre;
  @FXML
  private TableColumn<?, ?> documentos_columna_telefono;
  @FXML
  private TableColumn<?, ?> estudiantes_columna_correo;
  @FXML
  private TableColumn<?, ?> estudiantes_columna_cuenta;
  @FXML
  private Button boton_documentos;
  @FXML
  private Button boton_modificar;

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
  }

  @FXML
  private void modificar(ActionEvent event) {
  }
  
}
