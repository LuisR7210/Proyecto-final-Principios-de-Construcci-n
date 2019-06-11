/**
 * Copyright (c) 2018-2019 LR
 * La venta de este archivo por cualquier medio está estrictamente prohibida.
 * Todos los derechos reservados.
 */
package SSS.modelos;

/**
 *
 * @author Luis Roberto Herrera Hernández
 */
public class ServicioSocial {
  private int id_servicio_social;
  private String bloque;
  private String seccion;
  private String nrc;
  private String periodo;

  public ServicioSocial(int id_servicio_social, String bloque, String seccion, String periodo, String nrc) {
    this.id_servicio_social = id_servicio_social;
    this.bloque = bloque;
    this.seccion = seccion;
    this.nrc = nrc;
    this.periodo = periodo;
  }

  public int getId_servicio_social() {
    return id_servicio_social;
  }

  public String getBloque() {
    return bloque;
  }

  public String getSeccion() {
    return seccion;
  }

  public String getNrc() {
    return nrc;
  }

  public String getPeriodo() {
    return periodo;
  }
  
  
}
