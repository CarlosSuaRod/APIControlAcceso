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

public class PuertasController {
    private Connection con=new MiConexion().getConnection();
    
    /*@GetMapping(path="/addPuerta", produces=MediaType.APPLICATION_JSON_VALUE)
    public boolean addPuerta(@RequestParam(name = "nombre") String nombre) {
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO usuarios (nombre) VALUES(?)");
            pstmt.setString(1,nombre);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al insertar la puerta: "+ex);
            return false;
        }
    }
    
    @GetMapping(path="/updatePuerta", produces=MediaType.APPLICATION_JSON_VALUE)
    public boolean updatePuerta(@RequestParam(name = "nombre") String nombre) {
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE puertas SET nombre = ? WHERE id = ?");
            pstmt.setString(1,nombre);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al modificar la puerta: "+ex);
            return false;
        }
    }
    
    @GetMapping(path="/deletePuerta", produces=MediaType.APPLICATION_JSON_VALUE)
    public boolean deletePuerta(@RequestParam(name = "id") int id) {
        try {
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el usuario: "+ex);
            return false;
        }
    }*/
    
    @GetMapping(path = "/puertas", produces=MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Puerta> puertas(@RequestParam(name = "id") int id) {
        try {
            ArrayList<Puerta> puertas=new ArrayList();
            PreparedStatement pstmt = con.prepareStatement("select doors.* from doors, permissions where user_id=? group by door_id");
            pstmt.setInt(1, id);
            ResultSet res=pstmt.executeQuery();
           
            while(res.next()){
                Puerta p=new Puerta(res.getInt("door_id"),res.getString("name"),res.getString("door_pin"));
                puertas.add(p);
            }
            return puertas;
        } catch (SQLException ex) {
            System.out.println("Error al obtener puertas: "+ex);
            return null;
        }
    }
}
