/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Citas;

/**
 *
 * @author lfben
 */
public class Medicamento {
    
    public String nombre;
    public int costo;

    public Medicamento(String nombre, int costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Medicamento{" + "nombre=" + nombre + ", costo=" + costo + '}';
    }
    
    
    
}
