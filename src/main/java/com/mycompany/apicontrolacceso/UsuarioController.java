package com.mycompany.apicontrolacceso;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {   
   private Connection con=new MiConexion().getConnection();
    
    /*@GetMapping(path="/addUsuario", produces=MediaType.APPLICATION_JSON_VALUE)
    public boolean addUsuario(@RequestParam(name = "dni") String dni, @RequestParam(name="nombre") String nombre,@RequestParam(name="correo") String correo,@RequestParam(name="passw") String passw) {
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO usuarios(dni,nombre,correo,password) VALUES(?,?,?,?)");
            pstmt.setString(1,dni);
            pstmt.setString(2, nombre);
            pstmt.setString(3, correo);
            pstmt.setString(4, passw);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al insertar el usuario: "+ex);
            return false;
        }
    }
    
    @GetMapping(path="/updateUsuario", produces=MediaType.APPLICATION_JSON_VALUE)
    public boolean updateUsuario(@RequestParam(name = "dni") String dni, @RequestParam(name="nombre") String nombre,@RequestParam(name="correo") String correo,@RequestParam(name="passw") String passw, @RequestParam(name="id") int id) {
            
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE usuarios SET dni = ?, nombre = ?, correo = ?, password = ? WHERE id = ?");
            pstmt.setString(1,dni);
            pstmt.setString(2, nombre);
            pstmt.setString(3, correo);
            pstmt.setString(4, passw);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al insertar un administrador: "+ex);
            return false;
        }
    }
    
    @GetMapping(path="/deleteUsuario", produces=MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteUsuario(@RequestParam(name = "id") int id) {
            
        PreparedStatement ps = null;
        boolean eliminado = false;

        try {
            ps = con.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            ps.setInt(1, id);

            if(ps.executeUpdate()!=0) eliminado = true;

        } catch (SQLException ex) {
            System.out.println("Ha habido un error al eliminar el alumno: " + ex);
        }
        return eliminado;
    }
    
    @GetMapping(path = "/usuarios", produces=MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Usuario> usuarios() {
        try {
            ArrayList<Usuario> usuarios=new ArrayList();
            PreparedStatement pstmt = con.prepareStatement("select * from usuarios");
            ResultSet res=pstmt.executeQuery();
           
            while(res.next()){
                Usuario u=new Usuario(res.getInt("id"),res.getString("dni"),res.getString("nombre"),res.getString("correo"),res.getString("password"));
                usuarios.add(u);
            }
            return usuarios;
        } catch (SQLException ex) {
            System.out.println("Error al obtener usuarios: "+ex);
            return null;
        }
    }*/
   
    @GetMapping(path = "/login", produces=MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Usuario> login(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {
        try {
            ArrayList<Usuario> usuarios=new ArrayList();
            PreparedStatement pstmt = con.prepareStatement("select * from users WHERE email = ? AND password = ?");
            ResultSet res=pstmt.executeQuery();
           
            while(res.next()){
                Usuario u=new Usuario(res.getInt("id"),res.getString("dni"),res.getString("nombre"),res.getString("correo"),res.getString("password"), res.getString("phone"));
                usuarios.add(u);
            }
            return usuarios;
        } catch (SQLException ex) {
            System.out.println("Error al obtener usuarios: "+ex);
            return null;
        }
    }
}
