/**
 * Copyright (c) 2018-2019 LR
 * La venta de este archivo por cualquier medio está estrictamente prohibida.
 * Todos los derechos reservados.
 */
package SSS.controladores;

import SSS.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Luis Roberto Herrera Hernández
 */
public class FXMLPrincipalController{

  @FXML
  private Button boton_salir;
  @FXML
  private Button boton_proyectos;
  @FXML
  private Font x1;
  @FXML
  private Button boton_estudiantes;
  
  private Main principal;

  public void setPrincipal(Main principal) {
    this.principal=principal;
  }
  
  /**
   * Initializes the controller class.
   */

  @FXML
  private void salir(ActionEvent event) {
    principal.salir();
  }

  @FXML
  private void abrirVentanaProyectos(ActionEvent event) {
    principal.mostrarVentanaProyectos();
  }

  @FXML
  private void abrirVentanaEstudiantes(ActionEvent event) {
    principal.mostrarVentanaEstudiantes();
  }
  
}
