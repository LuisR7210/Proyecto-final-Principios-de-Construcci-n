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
import javafx.scene.control.ComboBox;
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
  private Button boton_modificar;
  @FXML
  private TableView<?> tabla_proyectos;
  @FXML
  private TableColumn<?, ?> proyectos_columna_proyecto;
  @FXML
  private TableColumn<?, ?> proyectos_columna_unidad;
  @FXML
  private TableColumn<?, ?> proyectos_columna_jefe;
  @FXML
  private TableColumn<?, ?> proyectos_columna_estudiante;
  @FXML
  private Button boton_registrar;
  @FXML
  private Button boton_detalles;
  @FXML
  private ComboBox<?> comboBox_periodos;
  
  private Main principal;
  
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
  }

  @FXML
  private void salir(ActionEvent event) {
    principal.salir();
  }


  @FXML
  private void modificar(ActionEvent event) {
  }

  @FXML
  private void registrarProyecto(ActionEvent event) {
  }

  @FXML
  private void verDetalles(ActionEvent event) {
  }

  @FXML
  private void mostrarProyectosPeriodo(ActionEvent event) {
  }
  
}
