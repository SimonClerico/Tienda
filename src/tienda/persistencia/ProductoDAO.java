/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;

/**
 *
 * @author Usuario
 */
public final class ProductoDAO extends DAO {

    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto");
            }

            String sql = "INSERT INTO Producto (nombre, precio, fabricante, codigo_fabricante)"
                    + "VALUES ( '" + producto.getNombre()+ "' , '" + producto.getPrecio() + "' , '" + producto.getFabricante()+ "' , '" + producto.getCodigoFabricante()+ "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }

            String sql = "UPDATE Producto SET "
                    + "nombre = '" + producto.getNombre() + "' WHERE precio = '" + producto.getPrecio() + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarProducto(String nombre) throws Exception {
        try {

            String sql = "DELETE FROM Producto WHERE nombre = '" + nombre + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Producto buscarProductoPorNombre(String nombre) throws Exception {
        try {

            String sql = "SELECT * FROM Producto "
                    + " WHERE nombre = '" + nombre + "'";

            consultarBase(sql);

            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Producto buscarProductoPorId(Integer codigo) throws Exception {
        try {

            String sql = "SELECT * FROM Producto "
                    + " WHERE codigo = '" + codigo + "'";

            consultarBase(sql);

            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Producto> listarProductos() throws Exception {
        try {
            String sql = "SELECT * FROM Producto";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setPrecio(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
//            System.out.println("2-Lista los nombres y los precios de todos los productos de la tabla producto.");

    public Collection<Producto> listarNombrePrecioProductos() throws Exception {

        try {
            String sql = "SELECT nombre, precio FROM Producto";

            consultarBase(sql);

            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            System.out.println("El precio y nombre  del producto es");
            while (resultado.next()) {
                producto = new Producto();

                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));

                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }

//    "SELECT codigo, nombre, precio FROM Producto WHERE precio BETWEEN 120 AND 122 ";
    public Collection<Producto> listarProductosEntrePrecio120122() throws Exception {
        try {
            String sql = "SELECT * FROM Producto";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            System.out.println("Los productos que se encuentran entre esos precios son: ");
            while (resultado.next()) {
                producto = new Producto();

                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));

                productos.add(producto);

            }
            desconectarBase();

            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }

    //    System.out.println("4-Buscar y listar todos los Portátiles de la tabla producto.");
    public Collection<Producto> listarPortatilesProducto() throws Exception {
        try {
            String sql = "SELECT * FROM Producto WHERE nombre like '%Por%' ";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            System.out.println("Los portatiles que se encuentran son: ");
            while (resultado.next()) {
                producto = new Producto();

                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));

                productos.add(producto);

            }
            desconectarBase();

            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }

//            System.out.println("5-Listar el nombre y el precio del producto más barato.");
    public Collection<Producto> listarNombrePrecioBarats() throws Exception {
        try {
            String sql = "SELECT nombre,precio FROM Producto ORDER BY precio LIMIT 1" ;

            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            

            while (resultado.next()) {
                producto = new Producto();
           
               
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));

                productos.add(producto);

            }
            desconectarBase();
            
            return productos;

        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }

    }

}
