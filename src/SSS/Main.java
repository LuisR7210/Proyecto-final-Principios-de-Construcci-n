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
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Luis Roberto Herrera Hernández
 */
public class Main extends Application {
  
  private Stage stage_principal;
  private Parent root;
  
  public Main(){}
  
  public void mostrarVentanaPrincipal() {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaces/FXMLPrincipal.fxml"));
      root = loader.load();
      Scene scene = new Scene(root);
      Stage principal = new Stage();
      principal.setTitle("Sistema de Servicio Social");
      principal.setScene(scene);
      FXMLPrincipalController controlador = loader.getController();
      controlador.setPrincipal(this);
      this.stage_principal = principal;
      this.stage_principal.show();
    } catch (IOException e) {
      System.out.println("No se encuentra el archivo de la interfaz");
    }
  }
  
  public void mostrarVentanaEstudiantes() {
    try {
      stage_principal.hide();
      FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaces/FXMLEstudiantes.fxml"));
      Parent parent_estudiantes = loader.load();
      Scene scene = new Scene(parent_estudiantes);
      Stage ventana_estudiantes = new Stage();
      ventana_estudiantes.setTitle("Estudiantes");
      ventana_estudiantes.setScene(scene);
      FXMLEstudiantesController controlador = loader.getController();
      controlador.setPrincipal(this);
      ventana_estudiantes.show();
    } catch (IOException e) {
      System.out.println(e);
      System.out.println("No se encuentra el archivo de la interfaz");
    }
  }
  
  public void mostrarVentanaDocumentos() {
    try {
      stage_principal.hide();
      FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaces/FXMLDocumentos.fxml"));
      Parent parent_documentos = loader.load();
      Scene scene = new Scene(parent_documentos);
      Stage ventana_documentos = new Stage();
      ventana_documentos.setTitle("Documentos");
      ventana_documentos.setScene(scene);
      FXMLDocumentosController controlador = loader.getController();
      controlador.setPrincipal(this);
      ventana_documentos.show();
    } catch (IOException e) {
      System.out.println("No se encuentra el archivo de la interfaz");
    }
  }
  
  public void mostrarVentanaProyectos() {
    try {
      stage_principal.hide();
      FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaces/FXMLProyectos.fxml"));
      Parent parent_proyectos = loader.load();
      Scene scene = new Scene(parent_proyectos);
      Stage ventana_proyectos = new Stage();
      ventana_proyectos.setTitle("Proyectos");
      ventana_proyectos.setScene(scene);
      FXMLProyectosController controlador = loader.getController();
      controlador.setPrincipal(this);
      ventana_proyectos.show();
    } catch (IOException e) {
      System.out.println("No se encuentra el archivo de la interfaz");
    }
  }
  
  @Override
  public void start(Stage primaryStage) {
    mostrarVentanaPrincipal();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  
}
