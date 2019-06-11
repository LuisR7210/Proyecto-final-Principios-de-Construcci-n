/**
 * Copyright (c) 2018-2019 LR
 * La venta de este archivo por cualquier medio está estrictamente prohibida.
 * Todos los derechos reservados.
 */
package SSS;

import SSS.controladores.FXMLDocumentosController;
import SSS.controladores.FXMLEstudiantesController;
import SSS.controladores.FXMLPrincipalController;
import SSS.controladores.FXMLProyectosController;
import SSS.modelos.Estudiante;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Luis Roberto Herrera Hernández
 */
public class Main extends Application {
  
  private final Stage stage_principal=new Stage();
  
  public Main(){}
  
  public void mostrarVentanaPrincipal() {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaces/FXMLPrincipal.fxml"));
      Parent root = loader.load();
      Scene scene_principal = new Scene(root);
      stage_principal.setTitle("Sistema de Servicio Social");
      stage_principal.setScene(scene_principal);
      FXMLPrincipalController controlador = loader.getController();
      controlador.setPrincipal(this);
      stage_principal.show();
    } catch (IOException e) {
      System.out.println("No se encuentra el archivo de la interfaz");
    }
  }
  
  public void mostrarVentanaEstudiantes() {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaces/FXMLEstudiantes.fxml"));
      Parent parent_estudiantes = loader.load();
      Scene scene_estudiantes = new Scene(parent_estudiantes);
      stage_principal.setTitle("Estudiantes");
      stage_principal.setScene(scene_estudiantes);
      FXMLEstudiantesController controlador = loader.getController();
      controlador.setPrincipal(this);
      stage_principal.show();
    } catch (IOException e) {
      System.out.println(e);
      System.out.println("No se encuentra el archivo de la interfaz");
    }
  }
  
  public void mostrarVentanaDocumentos(Estudiante est) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaces/FXMLDocumentos.fxml"));
      Parent parent_documentos = loader.load();
      Scene scene_documentos = new Scene(parent_documentos);
      stage_principal.setTitle("Documentos");
      stage_principal.setScene(scene_documentos);
      FXMLDocumentosController controlador = loader.getController();
      controlador.setPrincipal(this);
      controlador.setEstudiante(est);
      stage_principal.show();
    } catch (IOException e) {
      System.out.println("No se encuentra el archivo de la interfaz");
    }
  }
  
  public void mostrarVentanaProyectos() {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaces/FXMLProyectos.fxml"));
      Parent parent_proyectos = loader.load();
      Scene scene_proyectos = new Scene(parent_proyectos);
      stage_principal.setTitle("Proyectos");
      stage_principal.setScene(scene_proyectos);
      FXMLProyectosController controlador = loader.getController();
      controlador.setPrincipal(this);
      stage_principal.show();
    } catch (IOException e) {
      System.out.println("No se encuentra el archivo de la interfaz");
    }
  }
  
  public void salir(){
    stage_principal.close();
  }
  
  public Stage getStage(){
    return stage_principal;
  }
  
  @Override
  public void start(Stage primaryStage) {
    stage_principal.getIcons().add(new Image(this.getClass().getResource("iconos/logo.png").toString()));
    mostrarVentanaPrincipal();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  
}
