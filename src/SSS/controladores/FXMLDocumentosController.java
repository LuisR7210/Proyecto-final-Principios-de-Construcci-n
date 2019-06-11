/**
 * Copyright (c) 2018-2019 LR
 * La venta de este archivo por cualquier medio está estrictamente prohibida.
 * Todos los derechos reservados.
 */
package SSS.controladores;

import SSS.DAO.SQLDocumento;
import SSS.Main;
import SSS.modelos.Documento;
import SSS.modelos.Estudiante;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
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
  private Estudiante estudiante;
  private final SQLDocumento sql_documentos=new SQLDocumento();
  private ObservableList<Documento> documentos = FXCollections.observableArrayList();
  private ObservableList<Documento> reportes = FXCollections.observableArrayList();
  
  public void setPrincipal(Main principal) {
    this.principal=principal;
  }
  
  public void setEstudiante(Estudiante est){
    estudiante=est;
    label_estudiante.setText(estudiante.getMatricula()+" - "+estudiante.getNombre());
    documentos=sql_documentos.cargarDocumentos(estudiante);
    tabla_documentos.setItems(documentos);
  }
  
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    LocalDate fecha_subida=LocalDate.now();
    documentos.add(new Documento(1, "Carta de Aceptación", fecha_subida, "Luis Roberto Herrera Hernández", new File("Documentos Servicio Social/icono.png"), ""));
    inicializarTablaDocumentos();
    inicializarTablaReportes();
    reportes.add(new Documento(1, "Reporte Mensual", fecha_subida, "Luis Roberto Herrera Hernández", "Mayo", 80, new File("Documentos Servicio Social/icono.png")));
  }
  
  private void inicializarTablaDocumentos(){
    documentos_columna_nombre.setCellValueFactory(
            cellData -> cellData.getValue().getNombreProperty());
    documentos_columna_estado.setCellValueFactory(
            cellData -> cellData.getValue().getEstadoProperty());
    documentos_columna_fecha.setCellValueFactory(
            cellData -> cellData.getValue().getFechaSubidaProperty());
    documentos_columna_comentarios.setCellValueFactory(
            cellData -> cellData.getValue().getComentariosProperty());
    tabla_documentos.setPlaceholder(new Label(" No hay documentos registrados."));
  }
  
  private void inicializarTablaReportes(){
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
    tabla_reportes.setItems(reportes);
  }

  @FXML
  private void salir(ActionEvent event) {
    principal.salir();
  }

  @FXML
  private void abrirVentanaPrincipal(MouseEvent event) {
    principal.mostrarVentanaPrincipal();
  }

  @FXML
  private void subirDocumento(ActionEvent event) {
    mostrarVentanaSubirDocumento(false);
  }

  @FXML
  private void modificarDocumento(ActionEvent event) {
    if (tabla_documentos.getSelectionModel().isEmpty()) {
      alertaNoDocumentoSeleccionado("documento");
      return;
    }
    mostrarVentanaSubirDocumento(true);
  }

  @FXML
  private void descargarDocumento(ActionEvent event) {
    if (tabla_documentos.getSelectionModel().isEmpty()) {
      alertaNoDocumentoSeleccionado("documento");
      return;
    }
    DirectoryChooser directory_chooser = new DirectoryChooser();
    directory_chooser.setTitle("Seleccione la carpeta de destino");
    File destino = directory_chooser.showDialog(principal.getStage());
    if(destino==null){
      return;
    }
    destino=new File(destino.getAbsolutePath()+"/"+tabla_documentos.getSelectionModel().getSelectedItem().getArchivo().getName());
    try {
      Files.copy(tabla_documentos.getSelectionModel().getSelectedItem().getArchivo().toPath(), destino.toPath(), REPLACE_EXISTING);
    } catch (IOException ex) {
      System.out.println("Error al descargar");
    }
  }

  @FXML
  private void subirReporte(ActionEvent event) {
    mostrarVentanaSubirReporte(false);
  }

  @FXML
  private void modificarReporte(ActionEvent event) {
    if (tabla_reportes.getSelectionModel().isEmpty()) {
      alertaNoDocumentoSeleccionado("reporte");
      return;
    }
    mostrarVentanaSubirReporte(true);
  }

  @FXML
  private void descargarReporte(ActionEvent event) {
    if (tabla_reportes.getSelectionModel().isEmpty()) {
      alertaNoDocumentoSeleccionado("documento");
      return;
    }
    DirectoryChooser directory_chooser = new DirectoryChooser();
    directory_chooser.setTitle("Seleccione la carpeta de destino");
    File destino = directory_chooser.showDialog(principal.getStage());
    if(destino==null){
      return;
    }
    destino=new File(destino.getAbsolutePath()+"/"+tabla_reportes.getSelectionModel().getSelectedItem().getArchivo().getName());
    try {
      Files.copy(tabla_reportes.getSelectionModel().getSelectedItem().getArchivo().toPath(), destino.toPath(), REPLACE_EXISTING);
    } catch (IOException ex) {
      System.out.println("Error al descargar");
    }
  }
  
  private void mostrarVentanaSubirDocumento(boolean modificar) {
    try {
      FXMLLoader loader = new FXMLLoader(principal.getClass().getResource("interfaces/FXMLSubirDocumento.fxml"));
      Parent parent_subir_documento = loader.load();
      Scene scene = new Scene(parent_subir_documento);
      Stage ventana_subir_documento = new Stage();
      ventana_subir_documento.setScene(scene);
      ventana_subir_documento.initModality(Modality.WINDOW_MODAL);
      ventana_subir_documento.initOwner(principal.getStage());
      FXMLSubirDocumentoController controlador = loader.getController();
      controlador.setEstudiante(estudiante);
      if (modificar) {
        ventana_subir_documento.setTitle("Modificar documento");
        controlador.setDocumento(tabla_documentos.getSelectionModel().getSelectedItem());
      } else {
        ventana_subir_documento.setTitle("Subir documento"); 
      }
      ventana_subir_documento.showAndWait();
      documentos=sql_documentos.cargarDocumentos(estudiante);
      tabla_documentos.setItems(documentos);
    } catch (IOException e) {
      System.out.println("No se encuentra el archivo de la interfaz");
    }
  }
  
  private void mostrarVentanaSubirReporte(boolean modificar) {
    try {
      FXMLLoader loader = new FXMLLoader(principal.getClass().getResource("interfaces/FXMLSubirReporte.fxml"));
      Parent parent_subir_reporte = loader.load();
      Scene scene = new Scene(parent_subir_reporte);
      Stage ventana_subir_reporte = new Stage();
      ventana_subir_reporte.setScene(scene);
      ventana_subir_reporte.initModality(Modality.WINDOW_MODAL);
      ventana_subir_reporte.initOwner(principal.getStage());
      FXMLSubirReporteController controlador = loader.getController();
      controlador.setEstudiante(estudiante);
      if (modificar) {
        ventana_subir_reporte.setTitle("Modificar reporte");
        controlador.setReporte(tabla_reportes.getSelectionModel().getSelectedItem());
      } else {
        ventana_subir_reporte.setTitle("Subir reporte"); 
      }
      ventana_subir_reporte.showAndWait();
    } catch (IOException e) {
      System.out.println("No se encuentra el archivo de la interfaz");
    }
  }
  
  private void alertaNoDocumentoSeleccionado(String tipo_documento) {
    Alert alerta = new Alert(Alert.AlertType.WARNING);
    alerta.setTitle("Indicación");
    alerta.setHeaderText("Primero debes seleccionar un " + tipo_documento + " de la tabla");
    alerta.showAndWait();
  }
  
}
