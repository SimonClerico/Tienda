/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.servicios;

import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

/**
 *
 * @author Usuario
 */
public class ServicioFabricante {

    private FabricanteDAO dao;

    public ServicioFabricante() {
        this.dao = new FabricanteDAO();
    }

    public void crearFabricante(int codigo, String nombre) throws Exception {

        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del fabricante");
            }

            if (codigo > 0) {
                throw new Exception("Debe indicar el codigo");
            }

            //Creamos el mascota
            Fabricante fabricante = new Fabricante();
            fabricante.setNombre(nombre);
            fabricante.setCodigo(codigo);

            dao.guardarFabricante(fabricante);

        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarFabricante(String nombre) throws Exception {

        try {

            //Validamos 
            if (nombre == null) {
                throw new Exception("Debe indicar el Nombre");
            }
            dao.eliminarFabricante(nombre);
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante buscarFabricantePorCodigo(int codigo) throws Exception {

        try {

            //Validamos
            if (codigo < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            Fabricante fabricante = dao.buscarFabricantePorCodigo(codigo);
            //Verificamos
            if (fabricante == null) {
                throw new Exception("No se econtró fabricante para el codigo indicado");
            }

            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Fabricante> listarFabricantes() throws Exception {

        try {

            Collection<Fabricante> fabricantes = dao.listarFabricante();

            return fabricantes;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirFabricantes() throws Exception {

        try {

            //Listamos los mascotas
            Collection<Fabricante> fabricantes = listarFabricantes();

            //Imprimimos los mascotas
            if (fabricantes.isEmpty()) {
                throw new Exception("No existen fabricantes para imprimir");
            } else {
                for (Fabricante u : fabricantes) {
                    System.out.println(u.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
