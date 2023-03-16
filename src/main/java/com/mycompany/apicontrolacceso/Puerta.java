/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apicontrolacceso;

public class Puerta {

    private int id;
    private String nombre;
    private String door_pin;

    public Puerta(String nombre, String door_pin) {
        this.nombre = nombre;
        this.door_pin = door_pin;
    }

    public Puerta(int id, String nombre, String door_pin) {
        this.id = id;
        this.nombre = nombre;
        this.door_pin = door_pin;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDoor_pin() {
        return door_pin;
    }

    public void setDoor_pin(String door_pin) {
        this.door_pin = door_pin;
    }

    @Override
    public String toString() {
        return "Puerta{" + "id=" + id + ", nombre=" + nombre + ", door_pin=" + door_pin + '}';
    }

}
