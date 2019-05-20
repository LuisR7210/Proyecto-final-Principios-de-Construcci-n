/**
 * Copyright (c) 2018-2019 LR
 * La venta de este archivo por cualquier medio está estrictamente prohibida.
 * Todos los derechos reservados.
 */
package SSS.modelos;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Luis Roberto Herrera Hernández
 */
public class Documento {
  
  private String nombre;
  private String estado;
  private LocalDate fecha_subida;
  private String comentarios;
  private String mes;
  private int horas;
  private File archivo;

  public Documento(String nombre, LocalDate fecha_subida, String comentarios, File archivo) {
    this.nombre = nombre;
    this.fecha_subida = fecha_subida;
    this.comentarios = comentarios;
    this.archivo = archivo;
    this.estado="Sin validar";
  }

  public Documento(String nombre, LocalDate fecha_subida, String comentarios, String mes, int horas, File archivo) {
    this.nombre = nombre;
    this.fecha_subida = fecha_subida;
    this.comentarios = comentarios;
    this.mes = mes;
    this.horas = horas;
    this.archivo = archivo;
    this.estado="Sin validar";
  }

  public String getNombre() {
    return nombre;
  }
  
  public SimpleStringProperty getNombreProperty(){
    return new SimpleStringProperty(nombre);
  }

  public void setEstado(String estado){
    this.estado=estado;
  }
  
  public String getEstado() {
    return estado;
  }
  
  public SimpleStringProperty getEstadoProperty(){
    return new SimpleStringProperty(estado);
  }

  public LocalDate getFecha_subida() {
    return fecha_subida;
  }
  
  public SimpleStringProperty getFechaSubidaProperty(){
    return new SimpleStringProperty(fecha_subida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
  }

  public String getComentarios() {
    return comentarios;
  }
  
  public SimpleStringProperty getComentariosProperty(){
    return new SimpleStringProperty(comentarios);
  }

  public String getMes() {
    return mes;
  }
  
  public SimpleStringProperty getMesProperty(){
    return new SimpleStringProperty(mes);
  }

  public int getHoras() {
    return horas;
  }
  
  public SimpleIntegerProperty getHorasProperty(){
    return new SimpleIntegerProperty(horas);
  }

  public File getArchivo() {
    return archivo;
  }
  
}
