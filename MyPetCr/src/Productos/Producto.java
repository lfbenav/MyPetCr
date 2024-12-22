package Productos;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author lfben
 */
public class Producto {
    
    public String codigo;
    public String nombre;
    public String descripcion;
    public String imagen;
    public int precio;
    public int stock;
    public Icon icono;

    public Producto(String nombre, String descripcion, int precio, int stock, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.stock = stock;
        this.codigo = "-1";
        
        try{
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/imagenes/" + this.imagen));
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); 
            imageIcon = new ImageIcon(newimg);
            this.icono = imageIcon;
        }catch(Exception e){
            System.out.println("La imagen no es valida");
        }
    }
    
    public Producto(String codigo, String nombre, String descripcion, int precio, int stock, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.stock = stock;
        this.codigo = codigo;
        
        try{
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/imagenes/" + this.imagen));
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); 
            imageIcon = new ImageIcon(newimg);
            this.icono = imageIcon;
        }catch(Exception e){
            System.out.println("La imagen no es valida");
        }
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen + ", precio=" + precio + ", stock=" + stock + '}';
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
