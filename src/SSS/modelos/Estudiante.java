/**
 * Copyright (c) 2018-2019 LR
 * La venta de este archivo por cualquier medio está estrictamente prohibida.
 * Todos los derechos reservados.
 */
package SSS.modelos;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Luis Roberto Herrera Hernández
 */
public class Estudiante {
  
  private String matricula;
  private String nombre;
  private String telefono;
  private String correo;
  private String estado;

  public Estudiante(String matricula, String nombre, String telefono, String correo, String estado) {
    this.matricula = matricula;
    this.nombre = nombre;
    this.telefono = telefono;
    this.correo = correo;
    this.estado = estado;
  }

  public String getMatricula() {
    return matricula;
  }

  public SimpleStringProperty getMatriculaProperty() {
    return new SimpleStringProperty(matricula);
  }
  
  public String getNombre() {
    return nombre;
  }
  
  public SimpleStringProperty getNombreProperty() {
    return new SimpleStringProperty(nombre);
  }

  public String getTelefono() {
    return telefono;
  }
  
  public SimpleStringProperty getTelefonoProperty() {
    return new SimpleStringProperty(telefono);
  }

  public String getCorreo() {
    return correo;
  }
  
  public SimpleStringProperty getCorreoProperty() {
    return new SimpleStringProperty(correo);
  }

  public String getEstado() {
    return estado;
  }
  
  public SimpleStringProperty getEstadoProperty() {
    return new SimpleStringProperty(estado);
  }
  
}
