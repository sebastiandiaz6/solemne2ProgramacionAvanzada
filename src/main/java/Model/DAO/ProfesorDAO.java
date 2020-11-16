/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Alumno;
import Model.Asignatura;
import Model.Nota;
import Model.Profesor;
import Model.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author camil
 */
public class ProfesorDAO extends conexion{
   
    String listarProfesor = "SELECT nombre, apellido FROM PROFESOR";
    String buscarAsignatura = "SELECT a.nombre, a.id FROM ASIGNATURA a WHERE id_profesor = ?";
    String listarAlumnos = "SELECT b.nombre, b.apellido, b.id FROM ALUMNOS b, ASIGNATURA a WHERE a.id = ?";
    String registrarNota = "INSERT INTO NOTA (id,trimestre, nota) VALUES (?,?,?) WHERE id_alumno=?"; 
    PreparedStatement ps = null;
    Connection con = getConexion();
    ResultSet rs = null;
    
    public List<Asignatura> listarAsignaturas(Asignatura as){
        List<Asignatura> listado = null;
        try {
            ps = con.prepareStatement(buscarAsignatura);
            ps.setInt(1, as.getIdProfesor());
            rs = ps.executeQuery();
            if (rs.next())
            {
               as.setNombre(rs.getString("nombre"));
               as.setId(rs.getInt("id"));
               listado.add(as);
               return listado;
        } 
        } catch (SQLException e) {
            System.err.println(e);
            return listado;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return listado;
    }
    
    public List<Asignatura> listarAlumnos (Asignatura as){
        List<Asignatura> listado = null;
        try {
            ps = con.prepareStatement(listarAlumnos);
            ps.setInt(1, as.getId());
            rs = ps.executeQuery();
            if (rs.next())
            {
               as.setNombreA(rs.getString("nombre_alumno"));
               as.setApellidoA(rs.getString("apellido_alumno"));
               as.setIdAlumno(rs.getInt("id_alumno"));
               listado.add(as);
               return listado;
        } 
        } catch (SQLException e) {
            System.err.println(e);
            return listado;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return listado;
    }
    
    public boolean registrarNota (Nota n){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        try {
            ps = con.prepareStatement(registrarNota);
            ps.setInt(1, n.getId());
            ps.setString(2, n.getTrimestre());
            ps.setFloat(3, n.getNota());
            ps.setInt(4, n.getIdAlumno());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    
    public List<Profesor> listarProfesor(Profesor pro){
        List<Profesor> listado = null;
        try {
            ps = con.prepareStatement(listarProfesor);
            ps.setInt(1, pro.getId());
            rs = ps.executeQuery();
            if (rs.next())
            {
               pro.setNombre(rs.getString("nombre"));
               pro.setApellido(rs.getString("apellido"));
               listado.add(pro);
               return listado;
        } 
        } catch (SQLException e) {
            System.err.println(e);
            return listado;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return listado;
    }
   
}
