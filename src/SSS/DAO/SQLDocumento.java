/**
 * Copyright (c) 2018-2019 LR
 * La venta de este archivo por cualquier medio está estrictamente prohibida.
 * Todos los derechos reservados.
 */
package SSS.DAO;

import SSS.modelos.Documento;
import SSS.modelos.Estudiante;
import SSS.servicios.Conexion;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Luis Roberto Herrera Hernández
 */
public class SQLDocumento{
  
  private Conexion conn = null;
  private final String tabla = "documento";
  PreparedStatement query;

  public SQLDocumento() {
  }  
  
  public ObservableList<Documento> cargarDocumentos(Estudiante estudiante) {
    conn = new Conexion();
    int id_inscripcion=buscarIdInscripcion(estudiante);
    ObservableList<Documento> documentos=FXCollections.observableArrayList();
    try {
      PreparedStatement consulta = conn.getConexion().prepareStatement("SELECT* FROM " 
              + this.tabla + " WHERE inscripcion_inscripcionid="
              +id_inscripcion+" AND mes is null;");
      ResultSet resultado = consulta.executeQuery();
      while (resultado.next()) {
        documentos.add(new Documento(resultado.getInt("iddocumento"), 
                resultado.getString("tipo_documento"),
                LocalDate.parse(resultado.getString("fecha_subida")), 
                resultado.getString("comentario"), 
                new File(resultado.getString("url")),
                resultado.getString("estatus")
                ));
      }
    } catch (SQLException ex) {
      System.out.println("Error al cargar los datos de la tabla");
      System.out.print(ex);
    }
    conn.desconectar();
    return documentos;
  }
  
  public void registrarDocumento(Documento documento, Estudiante estudiante){
    conn = new Conexion();
    int id_inscripcion=buscarIdInscripcion(estudiante);
    try {
      query = conn.getConexion().prepareStatement(
              "insert into " + this.tabla +" (comentario,tipo_documento, fecha_subida, url, "
                      + "estatus, inscripcion_inscripcionid)"
              + " values (?, ?, ?, ?, ?, ?);");
      query.setString(1, documento.getComentarios());
      query.setString(2, documento.getNombre());
      query.setString(3, documento.getFecha_subida().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
      query.setString(4, documento.getArchivo().getAbsolutePath());
      query.setString(5, documento.getEstado());
      query.setInt(6, id_inscripcion);
      query.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(SQLDocumento.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void modificarDocumento(Documento documento, Documento temporal, Estudiante estudiante){
    conn = new Conexion();
    try {
      query = conn.getConexion().prepareStatement(
              "UPDATE " + this.tabla +" SET comentario=?,tipo_documento=?, url=?, "
                      + "estatus=? WHERE iddocumento="+documento.getId_documento()+";");
      query.setString(1, temporal.getComentarios());
      query.setString(2, temporal.getNombre());
      query.setString(3, temporal.getArchivo().getAbsolutePath());
      query.setString(4, temporal.getEstado());
      query.executeUpdate();
    } catch (SQLException ex) {
      Logger.getLogger(SQLDocumento.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
 
  private int buscarIdInscripcion(Estudiante estudiante) {
    try {
      query = conn.getConexion().prepareStatement(
              "SELECT i.inscripcionid from inscripcion i inner join estudiante e "
              + "ON e.matricula=i.estudiante_matricula "
              + "AND e.matricula=?;");
      query.setString(1, estudiante.getMatricula());
      ResultSet resultado = query.executeQuery();
      resultado.next();
      return resultado.getInt("inscripcionid");
    } catch (SQLException ex) {
      System.out.println(ex);
      return 0;
    }
  }

}
