/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apicontrolacceso;

public class Usuario {
    private int id;
    private String dni;
    private String nombre;
    private String correo;
    private String password;
    private String phone;

    public Usuario(String dni, String nombre, String correo, String password, String phone) {
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.phone = phone;
    }

    public Usuario(int id, String dni, String nombre, String correo, String password, String phone) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", correo=" + correo + ", password=" + password + ", phone=" + phone + '}';
    }
    
}
