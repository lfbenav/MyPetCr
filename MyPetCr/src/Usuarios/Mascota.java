/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

/**
 *
 * @author lfben
 */
public class Mascota {
    
    public int id;
    public int idUsuario;
    public String nombre;
    public String especie;
    public String nombreUsuario;

    public Mascota(int id, int idUsuario, String nombre, String especie) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.especie = especie;
        this.nombreUsuario = "n/a";
    }
    
    public Mascota(int id, int idUsuario, String nombre, String especie, String nombreUsuario) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.especie = especie;
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        return "Mascota{" + "id=" + id + ", idUsuario=" + idUsuario + ", nombre=" + nombre + ", especie=" + especie + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    
    
}
