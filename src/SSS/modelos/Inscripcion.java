/**
 * Copyright (c) 2018-2019 LR
 * La venta de este archivo por cualquier medio está estrictamente prohibida.
 * Todos los derechos reservados.
 */
package SSS.modelos;

import java.time.LocalDate;

/**
 *
 * @author Luis Roberto Herrera Hernández
 */
public class Inscripcion {
  
  private int id_inscripcion;
  private LocalDate fecha;
  private String tipo;
  private int avance_horas;

  public Inscripcion(int id_inscripcion, LocalDate fecha, String tipo, int avance_horas) {
    this.id_inscripcion = id_inscripcion;
    this.fecha = fecha;
    this.tipo = tipo;
    this.avance_horas = avance_horas;
  }

  public int getId_inscripcion() {
    return id_inscripcion;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public String getTipo() {
    return tipo;
  }

  public int getAvance_horas() {
    return avance_horas;
  }
  
}
