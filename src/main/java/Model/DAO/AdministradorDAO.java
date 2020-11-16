/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Alumno;
import Model.Asignatura;
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
public class AdministradorDAO extends conexion{
    
    String Altadeusuario = "INSERT INTO ALUMNOS (id,id_nivel,login,contrasenya,nombre,apellido) VALUES (?,?,?,?,?,?)";
    String Altadeasignatura = "INSERT INTO ASGINATURA (id,id_profesor,id_nivel,nombre) VALUES (?,?,?,?)";
    String MatricularAlumnoenAsignatura = "INSERT INTO ASGINATURA (id_alumno,nombre_alumno,apellido_alumno) VALUES (?,?,?)";
    String Bajadeusuario = "DELETE FROM ALUMNOS WHERE id = ?";
    String Bajadeasignatura = "DELETE FROM ASIGNATURA WHERE id = ?";
    String Modificarusuario = "UPDATE ALUMNOS SET id=?,id_nivel=?,login=?,contrasenya=?,nombre=?,apellido=? WHERE id = ?";
    String Modificarasignatura = "UPDATE ASIGNATURA SET id=?,id_profesor=?,id_nivel=?,nombre=? WHERE id=?";
    
    PreparedStatement ps = null;
    Connection con = getConexion();
    ResultSet rs = null;
    
    public boolean Altadeusuario(Alumno a) {        
        try {
            ps = con.prepareStatement(Altadeusuario);
            ps.setInt(1, a.getId());
            ps.setInt(2, a.getIdnivel());
            ps.setString(3, a.getLogin());
            ps.setString(4, a.getContrasenya());
            ps.setString(5, a.getNombre());
            ps.setString(6, a.getApellido());
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
    public boolean Altadeasignatura(Asignatura as) {        
        try {
            ps = con.prepareStatement(Altadeasignatura);
            ps.setInt(1, as.getId());
            ps.setInt(2, as.getIdProfesor());
            ps.setInt(3, as.getIdNivel());
            ps.setString(4, as.getNombre());
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
    public boolean MatricularAlumnoenAsignatura(Asignatura as) {        
        try {
            ps = con.prepareStatement(MatricularAlumnoenAsignatura);
            ps.setInt(1, as.getIdAlumno());
            ps.setString(2, as.getNombreA());
            ps.setString(3, as.getApellidoA());
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
    public boolean Bajadeusuario(Alumno a){
        try {
            ps = con.prepareStatement(Bajadeusuario);
            ps.setInt(1, a.getId());
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
    public boolean Bajadeasignatura(Asignatura as){
        try {
            ps = con.prepareStatement(Bajadeasignatura);
            ps.setInt(1, as.getId());
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
    public boolean Modificarusuario(Alumno a){
        try {
            ps = con.prepareStatement(Modificarusuario);
            ps.setInt(1, a.getId());
            ps.setInt(2, a.getIdnivel());
            ps.setString(3, a.getLogin());
            ps.setString(4, a.getContrasenya());
            ps.setString(5, a.getNombre());
            ps.setString(6, a.getApellido());
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
    public boolean Modificarasignatura(Asignatura as){
        try {
            ps = con.prepareStatement(Modificarasignatura);
            ps.setInt(1, as.getId());
            ps.setInt(2, as.getIdProfesor());
            ps.setInt(3, as.getIdNivel());
            ps.setString(4, as.getNombre());
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
}
