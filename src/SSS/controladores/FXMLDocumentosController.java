/**
 * Copyright (c) 2018-2019 LR
 * La venta de este archivo por cualquier medio está estrictamente prohibida.
 * Todos los derechos reservados.
 */
package SSS.controladores;

import SSS.Main;
import SSS.modelos.Documento;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
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
  private TableView<Documento> tabla_documentos;
  @FXML
  private TableColumn<Documento, String> documentos_columna_nombre;
  @FXML
  private TableColumn<Documento, String> documentos_columna_estado;
  @FXML
  private TableColumn<Documento, String> documentos_columna_fecha;
  @FXML
  private TableColumn<Documento, String> documentos_columna_comentarios;
  @FXML
  private TableView<Documento> tabla_reportes;
  @FXML
  private TableColumn<Documento, String> reportes_columna_nombre;
  @FXML
  private TableColumn<Documento, String> reportes_columna_mes;
  @FXML
  private TableColumn<Documento, Number> reportes_columna_horas;
  @FXML
  private TableColumn<Documento, String> reportes_columna_estado;
  @FXML
  private TableColumn<Documento, String> reportes_columna_fecha;
  @FXML
  private TableColumn<Documento, String> reportes_columna_comentarios;
  @FXML
  private Label label_estudiante;
  @FXML
  private ImageView logo;
  @FXML
  private Button boton_subir_documento;
  @FXML
  private Color x2;
  @FXML
  private Button boton_modificar_documento;
  @FXML
  private Button boton_descargar_documento;
  @FXML
  private Button boton_subir_reporte;
  @FXML
  private Button boton_modificar_reporte;
  @FXML
  private Button boton_descargar_reporte;
  
  private Main principal;
  private Stage stage;
  private Alert alerta;
  private ObservableList<Documento> documentos = FXCollections.observableArrayList();
  private ObservableList<Documento> reportes = FXCollections.observableArrayList();
  
  public void setPrincipal(Main principal) {
    this.principal=principal;
  }
  
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    tabla_documentos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    documentos_columna_nombre.setCellValueFactory(
            cellData -> cellData.getValue().getNombreProperty());
    documentos_columna_estado.setCellValueFactory(
            cellData -> cellData.getValue().getEstadoProperty());
    documentos_columna_fecha.setCellValueFactory(
            cellData -> cellData.getValue().getFechaSubidaProperty());
    documentos_columna_comentarios.setCellValueFactory(
            cellData -> cellData.getValue().getComentariosProperty());
    tabla_documentos.setPlaceholder(new Label(" No hay documentos registrados."));
    
    LocalDate fecha_subida=LocalDate.now();
    documentos.add(new Documento("Carta de Aceptación", fecha_subida, "Luis Roberto Herrera Hernández", new File("Aqui va la dirección", "ejemplo.png")));
    tabla_documentos.setItems(documentos);
    
    tabla_reportes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    reportes_columna_nombre.setCellValueFactory(
            cellData -> cellData.getValue().getNombreProperty());
    reportes_columna_mes.setCellValueFactory(
            cellData -> cellData.getValue().getMesProperty());
    reportes_columna_horas.setCellValueFactory(
            cellData -> cellData.getValue().getHorasProperty());
    reportes_columna_estado.setCellValueFactory(
            cellData -> cellData.getValue().getEstadoProperty());
    reportes_columna_fecha.setCellValueFactory(
            cellData -> cellData.getValue().getFechaSubidaProperty());
    reportes_columna_comentarios.setCellValueFactory(
            cellData -> cellData.getValue().getComentariosProperty());
    tabla_reportes.setPlaceholder(new Label(" No hay reportes registrados."));
    
    reportes.add(new Documento("Reporte Mensual", fecha_subida, "Luis Roberto Herrera Hernández", "Mayo", 80, new File("Aqui va la dirección", "ejemplo.png")));
    tabla_reportes.setItems(reportes);
  }  

  @FXML
  private void salir(ActionEvent event) {
    stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    stage.close();
  }


  @FXML
  private void abrirVentanaPrincipal(MouseEvent event) {
    principal.mostrarVentanaPrincipal();
    stage = (Stage) ((ImageView) event.getSource()).getScene().getWindow();
    stage.close();
  }

  @FXML
  private void subirDocumento(ActionEvent event) {
    stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    mostrarVentanaSubirDocumento(false, "documento");
  }

  @FXML
  private void modificarDocumento(ActionEvent event) {
    if (tabla_documentos.getSelectionModel().isEmpty()) {
      alertaNoDocumentoSeleccionado("documento");
      return;
    }
    stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    mostrarVentanaSubirDocumento(true, "documento");
  }

  @FXML
  private void descargarDocumento(ActionEvent event) {
  }

  @FXML
  private void subirReporte(ActionEvent event) {
    stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    mostrarVentanaSubirDocumento(false, "reporte");
  }

  @FXML
  private void modificarReporte(ActionEvent event) {
    if (tabla_reportes.getSelectionModel().isEmpty()) {
      alertaNoDocumentoSeleccionado("reporte");
      return;
    }
    stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    mostrarVentanaSubirDocumento(true, "reporte");
  }

  @FXML
  private void descargarReporte(ActionEvent event) {
  }
  
  public void mostrarVentanaSubirDocumento(boolean modificar, String tipo_documento) {
    try {
      FXMLLoader loader = new FXMLLoader(principal.getClass().getResource("interfaces/FXMLSubirDocumento.fxml"));
      Parent parent_subir_documento = loader.load();
      Scene scene = new Scene(parent_subir_documento);
      Stage ventana_subir_documento = new Stage();
      ventana_subir_documento.setScene(scene);
      ventana_subir_documento.initModality(Modality.WINDOW_MODAL);
      ventana_subir_documento.initOwner(stage);
      FXMLSubirDocumentoController controlador = loader.getController();
      if (modificar) {
        ventana_subir_documento.setTitle("Modificar " + tipo_documento);
        if ("documento".equals(tipo_documento)) {
          controlador.setBooleanReporte(false);
          controlador.setDocumento(tabla_documentos.getSelectionModel().getSelectedItem());
        } else {
          controlador.setDocumento(tabla_reportes.getSelectionModel().getSelectedItem());
        }
      } else {
        ventana_subir_documento.setTitle("Subir " + tipo_documento);
        if (tipo_documento.equals("documento")) {
          controlador.setBooleanReporte(false);
        }
      }
      ventana_subir_documento.showAndWait();
    } catch (IOException e) {
      System.out.println("No se encuentra el archivo de la interfaz");
    }
  }
  
  public void alertaNoDocumentoSeleccionado(String tipo_documento) {
    alerta = new Alert(Alert.AlertType.WARNING);
    alerta.setTitle("Indicación");
    alerta.setHeaderText("Primero debes seleccionar un " + tipo_documento + " de la tabla");
    alerta.showAndWait();
  }
}
