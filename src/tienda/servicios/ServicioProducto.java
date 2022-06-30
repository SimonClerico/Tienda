/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.servicios;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

/**
 *
 * @author Usuario
 */
public class ServicioProducto {

    private ProductoDAO dao;

    public ServicioProducto() {
        this.dao = new ProductoDAO();
    }

    public void crearProducto(String nombre, double precio, String fabricante, int codigoFabricante) throws Exception {
        Scanner leer = new Scanner(System.in);
        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            
            //Creamos el producto
            Producto producto = new Producto();
            
            producto.setNombre(leer.next());
            producto.setPrecio(leer.nextDouble());
            producto.setFabricante(leer.next());
            producto.setCodigoFabricante(leer.nextInt());
            dao.guardarProducto(producto);

        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarProducto(String nombre) throws Exception {

        try {

            //Validamos 
            if (nombre == null) {
                throw new Exception("Debe indicar el nombre del producto");
            }
            dao.eliminarProducto(nombre);
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {

        try {

            //Validamos
            if (codigo < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            Producto producto = dao.buscarProductoPorId(codigo);
            //Verificamos
            if (codigo > 0) {
                throw new Exception("No se econtró el producto para el codigo indicado");
            }

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarProductos() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductos() throws Exception {

        try {

            //Listamos los mascotas
            Collection<Producto> productos = listarProductos();

            //Imprimimos los mascotas
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println(u.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarProductosEntrePrecio120122() throws Exception {
        try {
            Collection<Producto> productos = dao.listarProductosEntrePrecio120122();

            return productos;
        } catch (Exception e) {
            throw e;
        }

    }

    public void imprimirProductosEntrePrecio120122() throws Exception {
        try {
            Collection<Producto> productos = listarProductosEntrePrecio120122();

            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println(u.toString());
                    //                    System.out.println("Los productos son: " + u.getCodigo()+ u.getNombre() + u.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }
//    -------------------------
//            System.out.println("3-Listar aquellos productos que su precio esté entre 120 y 202.");

    public Collection<Producto> listarProductosPorNombrePorCodigo() throws Exception {

        try {

            Collection<Producto> productos = dao.listarNombrePrecioProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductosPorNombrePorCodigo() throws Exception {

        try {

            //Listamos los mascotas
            Collection<Producto> productos = listarProductosPorNombrePorCodigo();

            //Imprimimos los mascotas
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println("Nombre del producto: " + u.getNombre() + " Precio: " + u.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
//    System.out.println("4-Buscar y listar todos los Portátiles de la tabla producto.");

    public Collection<Producto> listarPortatilesProducto() throws Exception {
        try {

            Collection<Producto> productos = dao.listarPortatilesProducto();

            return productos;
        } catch (Exception e) {
            throw e;
        }

    }

    public void imprimirPortatilesProducto() throws Exception {
        try {

            //Listamos los mascotas
            Collection<Producto> productos = listarPortatilesProducto();

            //Imprimimos los mascotas
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println("Nombre del producto: " + u.getNombre() + " Precio: " + u.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

//            System.out.println("5-Listar el nombre y el precio del producto más barato.");
    public Collection<Producto> listarNombrePrecioBarats() throws Exception {
        try {

            Collection<Producto> productos = dao.listarNombrePrecioBarats();

            return productos;
        } catch (Exception e) {
            throw e;
        }

    }

    public void imprimirNombrePrecioBarats() throws Exception {
        try {

            //Listamos los mascotas
            Collection<Producto> productos = listarNombrePrecioBarats();

            //Imprimimos los mascotas
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                System.out.println("El Nombre del Producto mas BARATS es :");
                for (Producto u : productos) {
                    System.out.println(u.getNombre() + " Precio: " + u.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
