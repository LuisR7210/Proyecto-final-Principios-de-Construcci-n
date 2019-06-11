/**
 * Copyright (c) 2018-2019 LR
 * La venta de este archivo por cualquier medio está estrictamente prohibida.
 * Todos los derechos reservados.
 */
package SSS.DAO;

import SSS.modelos.Estudiante;
import SSS.servicios.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Luis Roberto Herrera Hernández
 */
public class SQLEstudiante{
  
  private Conexion conn = null;
  private final String tabla = "estudiante";

  public SQLEstudiante() {
  }  
  
  public ObservableList<Estudiante> cargarEstudiantes(int id_servicio_social) {
    conn = new Conexion();
    ObservableList<Estudiante> estudiantes=FXCollections.observableArrayList();
    try {
      PreparedStatement consulta = conn.getConexion().prepareStatement(
              "SELECT e.* FROM ("+tabla+" e INNER JOIN "
                      + "inscripcion i ON e.matricula = i.estudiante_matricula) "
                      + "INNER JOIN servicio_social ss ON i.servicio_social_idservicio_social "
                      + "= ss.idservicio_social and ss.idservicio_social="+id_servicio_social+";");
      ResultSet resultado = consulta.executeQuery();
      while (resultado.next()) {
        estudiantes.add(new Estudiante(resultado.getString("matricula"), 
                resultado.getString("nombre"),
                resultado.getString("telefono"),
                resultado.getString("correo"),
                resultado.getString("estatus"),
                resultado.getInt("contacto_idcontacto")
                ));
      }
    } catch (SQLException ex) {
      System.out.println("Error al cargar los datos de la tabla");
      System.out.print(ex);
    }
    conn.desconectar();
    return estudiantes;
  }
}
