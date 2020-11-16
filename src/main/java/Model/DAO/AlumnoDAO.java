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
public class AlumnoDAO extends conexion{
    
    String listarAlumnos = "SELECT nombre, apellido FROM ALUMNOS WHERE id_nivel = ?";
    String listarProfesor = "SELECT p.nombre, p.apellido, p.asignatura FROM PROFESOR p, ASIGNATURA a, ALUMNOS b WHERE p.id = a.id_profesor and a.id_alumno = ? and a.id_alumno = b.id";
    String listarAsignaturas = "SELECT a.nombre FROM ASIGNATURA a, ALUMNOS b WHERE b.id = ? and b.id = a.id_alumno";
    String listarNotas = "SELECT b.nota FROM ASIGNATURA a, NOTA b WHERE a.id_alumno = ? and a.id_nota = b.id";
    
    PreparedStatement ps = null;
    Connection con = getConexion();
    ResultSet rs = null;
    public List<Alumno> listarAlumno(Alumno al){
        List<Alumno> listado = null;
        try {
            ps = con.prepareStatement(listarAlumnos);
            ps.setInt(1, al.getId());
            rs = ps.executeQuery();
            if (rs.next())
            {
               al.setNombre(rs.getString("nombre"));
               al.setApellido(rs.getString("apellido"));
               listado.add(al);
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
               pro.setEspecialista(rs.getString("especialista"));
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
    
    public List<Asignatura> listarAsignaturas(Asignatura as){
        List<Asignatura> listado = null;
        try {
            ps = con.prepareStatement(listarAsignaturas);
            ps.setInt(1, as.getIdAlumno());
            rs = ps.executeQuery();
            if (rs.next())
            {
               as.setNombre(rs.getString("nombre"));
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
    
    public List<Nota> listarNotas(Nota no){
        List<Nota> listado = null;
        try {
            ps = con.prepareStatement(listarNotas);
            ps.setInt(1, no.getId());
            rs = ps.executeQuery();
            if (rs.next())
            {
               no.setNota(rs.getFloat("nota"));
               listado.add(no);
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
