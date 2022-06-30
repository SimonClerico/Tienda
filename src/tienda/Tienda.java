/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.util.Scanner;
import tienda.servicios.ServicioFabricante;
import tienda.servicios.ServicioProducto;

public class Tienda {

    public static void main(String[] args) throws Exception {

        ServicioFabricante serviciofabricante = new ServicioFabricante();
        ServicioProducto servicioproducto = new ServicioProducto();

        Scanner leer = new Scanner(System.in);

        System.out.println("1-Lista el nombre de todos los productos que hay en la tabla producto.");
        System.out.println("2-Lista los nombres y los precios de todos los productos de la tabla producto.");
        System.out.println("3-Listar aquellos productos que su precio esté entre 120 y 202.");
        System.out.println("4-Buscar y listar todos los Portátiles de la tabla producto.");
        System.out.println("5-Listar el nombre y el precio del producto más barato.");
        System.out.println("6-Ingresar un producto a la base de datos.");
        System.out.println("7-Ingresar un fabricante a la base de datos");
        System.out.println("8-Editar un producto con datos a elección.");
        System.out.println("");
        System.out.println("Elija una opcion");
        int opcion = leer.nextInt();

        switch (opcion) {
            case 1:
                servicioproducto.imprimirProductos();
                break;
            case 2:
                servicioproducto.imprimirProductosPorNombrePorCodigo();
                break;
                
            case 3: 
                servicioproducto.listarProductosEntrePrecio120122();
                break;
            case 4:
                servicioproducto.imprimirPortatilesProducto();
                break;
            case 5:
                servicioproducto.imprimirNombrePrecioBarats();
                break;
            case 6:
                servicioproducto.crearProducto("Ariel", 88.95, "Alonzo", 55);
                break;
        }
    }

}
