/**
 * Copyright (c) 2018-2019 LR
 * La venta de este archivo por cualquier medio está estrictamente prohibida.
 * Todos los derechos reservados.
 */
package SSS.DAO;

import SSS.modelos.ServicioSocial;
import SSS.servicios.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luis Roberto Herrera Hernández
 */
public class SQLServicioSocial{
  
  private Conexion conn = null;
  private final String tabla = "servicio_social";

  public SQLServicioSocial() {
  }  
  
  public ArrayList<ServicioSocial> cargarServiciosSociales() {
    conn = new Conexion();
    ArrayList<ServicioSocial> servicios=new ArrayList<>();
    try {
      PreparedStatement consulta = conn.getConexion().prepareStatement("SELECT* FROM " + this.tabla + ";");
      ResultSet resultado = consulta.executeQuery();
      while (resultado.next()) {
        servicios.add(new ServicioSocial(resultado.getInt("idservicio_social"), resultado.getString("bloque"),
                resultado.getString("seccion"), resultado.getString("periodo"), resultado.getString("NRC")));
      }
    } catch (SQLException ex) {
      System.out.println("Error al cargar los datos de la tabla");
      System.out.print(ex);
    }
    conn.desconectar();
    return servicios;
  }
}
