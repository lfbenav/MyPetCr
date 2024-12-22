package mypetcr;

import Notificaciones.Encriptar;
import Notificaciones.MandarCorreo;
import Notificaciones.Notificar;
import Productos.Producto;
import SQL.MascotasAccess;
import eCommerce.eCommerceScreen;
import java.util.ArrayList;

/**
 *
 * @author lfben
 */
public class Main {
    
    /*
    *
    *   Proyecto #2 de Bases de Datos
    *   Aplicación MyPetCr con conexión a base de datos MSSQL
    *
    */

    public static void main(String[] args) {
        //System.out.println(Encriptar.EncriptarString("123"));
        //Notificar.EnviarCorreo("lfbenav@gmail.com", "Thread test", "oi");
        new eCommerceScreen(null, new ArrayList<Producto>()).setVisible(true);
    }
}
